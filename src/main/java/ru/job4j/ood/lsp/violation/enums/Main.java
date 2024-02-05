package ru.job4j.ood.lsp.violation.enums;

public class Main {
    public String getArea(Figures figure) {
        if (figure == Figures.SQUARE) {
            return "a * a";
        } else if (figure == Figures.CIRCLE) {
            return "pi * r * r";
        } else if (figure == Figures.RECTANGLE) {
            return "a * b";
        } else {
            return null;
        }
    }
    /**
     * В данном методе необходимо каждый раз проверять к
     * какому типу относится объект, что нарушает LSP.
     */
}
