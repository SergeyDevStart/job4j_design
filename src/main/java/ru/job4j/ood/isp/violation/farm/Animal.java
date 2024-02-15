package ru.job4j.ood.isp.violation.farm;

public interface Animal {
    /**
     * Данный интерфейс нарушает ISP, т.к не каждый класс, который будет
     * его реализовывать, нуждается во всех методах.
     * Не каждое животное умеет ползать и летать.
     */
    void fly();

    void crawl();
}
