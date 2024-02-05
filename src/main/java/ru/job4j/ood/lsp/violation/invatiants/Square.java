package ru.job4j.ood.lsp.violation.invatiants;

public class Square extends Rectangle {

    @Override
    public void setHeight(int size) {
        this.width = size;
        this.height = size;
    }

    @Override
    public void setWidth(int size) {
        this.width = size;
        this.height = size;
    }
}
