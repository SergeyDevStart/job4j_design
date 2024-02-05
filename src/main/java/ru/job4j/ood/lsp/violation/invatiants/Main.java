package ru.job4j.ood.lsp.violation.invatiants;

public class Main {
    public static void main(String[] args) {
        Rectangle figure = new Square();
        figure.setHeight(10);
        figure.setWidth(20);
        System.out.println(figure.area() == 200);
    }
    /**
     * Квадрат является наследником прямоугольника,
     * но в отличие от прямогольника у квадрата 2 одинаковых стороны.
     * Данный пример демонстрирует нарушение LSP, т.к при замене
     * базового типа на субтип мы получим неожиданный результат.
     */
}
