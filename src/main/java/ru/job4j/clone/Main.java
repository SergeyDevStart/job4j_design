package ru.job4j.clone;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        CloneByConstr obj = new CloneByConstr(5, 10);
        CloneByConstr clonedObj = new CloneByConstr(obj);
        clonedObj.setX(15);
        clonedObj.setY(20);
        System.out.println(obj);
        System.out.println(clonedObj);
    }
}