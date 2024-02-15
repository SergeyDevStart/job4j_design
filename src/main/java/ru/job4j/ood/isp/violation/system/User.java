package ru.job4j.ood.isp.violation.system;

public class User implements Action {
    /**
     * В данном примере нарушен ISP т.к класс юзер не должен
     * иметь доступ к методам create, delete, replace - это
     * методы администратора. Необходимо разделить интерфейс на 2.
     */
    @Override
    public boolean create(String name) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean delete(String name) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean replace(String name) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String findByName(String name) {
        return null;
    }

    @Override
    public String findById() {
        return null;
    }
}
