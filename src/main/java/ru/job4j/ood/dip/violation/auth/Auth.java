package ru.job4j.ood.dip.violation.auth;

public class Auth {
    /**
     * Данный пример нарушает DIP, т.к модуль Auth напрямую зависит от модуля PSQLConnection.
     * Если мы сменим БД, то не сможем использовать класс. Нужно создать интерфейс, в нём
     * определить метод connect(). Так мы отделим Auth он конкретной БД.
     */
    PSQLConnection connection;

    public Auth(PSQLConnection connection) {
        this.connection = connection;
    }

    public boolean authenticate(String login, String password) {
        return connection.connect(login, password);
    }
}

class PSQLConnection {
    public boolean connect(String login, String password) {
        return false;
    }
}
