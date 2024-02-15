package ru.job4j.ood.isp.violation.system;

public class Admin implements Action {
    @Override
    public boolean create(String name) {
        return false;
    }

    @Override
    public boolean delete(String name) {
        return false;
    }

    @Override
    public boolean replace(String name) {
        return false;
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
