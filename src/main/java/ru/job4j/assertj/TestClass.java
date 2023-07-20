package ru.job4j.assertj;

import java.util.Objects;

public class TestClass {
    String name;
    int age;

    public TestClass(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "TestClass{"
                + "name=" + name + '\''
                + ", age=" + age
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TestClass testClass = (TestClass) o;
        return age == testClass.age && Objects.equals(name, testClass.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    public static void main(String[] args) {
        TestClass test = new TestClass("Sergey Vasenev", 23);
        System.out.println(test);
    }
}
