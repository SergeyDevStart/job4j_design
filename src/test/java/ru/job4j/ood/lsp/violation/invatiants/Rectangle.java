package ru.job4j.ood.lsp.violation.invatiants;

public class Rectangle {
    public int height;
    public int width;

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int area() {
        return this.height * this.width;
    }
}
