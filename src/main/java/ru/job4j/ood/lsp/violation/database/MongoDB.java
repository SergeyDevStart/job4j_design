package ru.job4j.ood.lsp.violation.database;

public class MongoDB extends Database {
    @Override
    public void joinTable() {
        throw new UnsupportedOperationException("В MongoDB нет таблиц");
    }
    /**
     * Данный класс переопределил метод родительского класса, метод бросает
     * исключение, которое не описано в родительском классе. Это приведёт
     * к нарушению LSP. Необходимо выделить интерфейс, который будет описывать
     * нереляционные БД.
     */
}
