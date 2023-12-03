package ru.job4j.jdbc;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import java.util.StringJoiner;

public class TableEditor implements AutoCloseable {

    private Connection connection;
    private final Properties properties;

    public TableEditor(Properties properties) throws Exception {
        this.properties = properties;
        initConnection();
    }

    public static void main(String[] args) throws Exception {
        try (TableEditor editor = new TableEditor(new Properties())) {
            editor.createTable("book");
            System.out.println(editor.getTableScheme("book"));
            editor.addColumn("book", "price", "int");
            System.out.println(editor.getTableScheme("book"));
            editor.renameColumn("book", "price", "count");
            System.out.println(editor.getTableScheme("book"));
            editor.dropColumn("book", "count");
            System.out.println(editor.getTableScheme("book"));
            editor.dropTable("book");
        }
    }

    private void initConnection() throws Exception {
            InputStream input = TableEditor.class.getClassLoader().getResourceAsStream("app.properties");
            properties.load(input);
            Class.forName(properties.getProperty("driver_class"));
            connection = DriverManager.getConnection(
                    properties.getProperty("url"),
                    properties.getProperty("username"),
                    properties.getProperty("password"));
    }

    private void useStatement(String sql) throws SQLException {
        connection.createStatement().execute(sql);
    }

    public void createTable(String tableName) throws SQLException {
        useStatement(String.format("CREATE TABLE IF NOT EXISTS %s(%s);",
                tableName,
                "id serial PRIMARY KEY")
        );
    }

    public void dropTable(String tableName) throws SQLException {
        useStatement(String.format("DROP TABLE %s;", tableName));
    }

    public void addColumn(String tableName, String columnName, String type) throws SQLException {
        useStatement(String.format("ALTER TABLE %s ADD %s %s;",
                tableName, columnName, type));
    }

    public void dropColumn(String tableName, String columnName) throws SQLException {
        useStatement(String.format("ALTER TABLE %s DROP COLUMN %s;",
                tableName, columnName));
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) throws SQLException {
        useStatement(String.format("ALTER TABLE %s RENAME COLUMN %s TO %s;",
                tableName, columnName, newColumnName));
    }

    public String getTableScheme(String tableName) throws Exception {
        var rowSeparator = "-".repeat(30).concat(System.lineSeparator());
        var header = String.format("%-15s|%-15s%n", "NAME", "TYPE");
        var buffer = new StringJoiner(rowSeparator, rowSeparator, rowSeparator);
        buffer.add(header);
        try (var statement = connection.createStatement()) {
            var selection = statement.executeQuery(String.format(
                    "SELECT * FROM %s LIMIT 1", tableName
            ));
            var metaData = selection.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                buffer.add(String.format("%-15s|%-15s%n",
                        metaData.getColumnName(i), metaData.getColumnTypeName(i))
                );
            }
        }
        return buffer.toString();
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }
}