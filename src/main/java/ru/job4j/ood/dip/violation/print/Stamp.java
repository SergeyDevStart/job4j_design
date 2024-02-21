package ru.job4j.ood.dip.violation.print;

public class Stamp {
    /**
     * Этот пример также нарушает DIP. Stamp Зависит от Printer.
     * Если возникнет делать печать в файл, принтер и т.д, то придется
     * модифицировать класс.
     * Нужно выделить интерфейс, тогда появиться возможность отделить
     * Stamp от Printer.
     */
    Printer printer;

    public Stamp(Printer printer) {
        this.printer = printer;
    }

    public void print(String string) {
        printer.print(string);
    }
}
