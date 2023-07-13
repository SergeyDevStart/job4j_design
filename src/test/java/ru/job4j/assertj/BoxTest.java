package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BoxTest {
    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Sphere");
    }

    @Test
    void isThisUnknown() {
        Box box = new Box(3, 3);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Unknown object");
    }

    @Test
    void getNumberOfVertices4() {
        Box box = new Box(4, 6);
        int value = box.getNumberOfVertices();
        assertThat(value).isNotZero()
                .isPositive()
                .isEqualTo(4);
    }

    @Test
    void getNumberOfVerticesMinus1() {
        Box box = new Box(5, 8);
        int value = box.getNumberOfVertices();
        assertThat(value).isEqualTo(-1);
    }

    @Test
    void isExistTrue() {
        Box box = new Box(4, 6);
        boolean result = box.isExist();
        assertThat(result).isTrue();
    }

    @Test
    void isExistFalse() {
        Box box = new Box(3, 3);
        boolean result = box.isExist();
        assertThat(result).isFalse();
    }

    @Test
    void getAreaTetrahedron() {
        Box box = new Box(4, 3);
        double result = box.getArea();
        assertThat(result).isEqualTo(15.59d, withPrecision(0.01d))
                .isLessThan(15.75d);
    }

    @Test
    void getArea0() {
        Box box = new Box(3, 3);
        double result = box.getArea();
        assertThat(result).isEqualTo(0);
    }
}