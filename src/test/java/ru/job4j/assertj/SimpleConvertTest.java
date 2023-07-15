package ru.job4j.assertj;

import org.junit.jupiter.api.Test;
import org.assertj.core.data.Index;
import static org.assertj.core.api.Assertions.*;
import java.util.*;

class SimpleConvertTest {
    @Test
    void checkArray() {
        SimpleConvert simpleConvert = new SimpleConvert();
        String[] array = simpleConvert.toArray("first", "second", "three", "four", "five");
        assertThat(array).hasSize(5)
                .contains("second")
                .contains("first", Index.atIndex(0))
                .containsAnyOf("zero", "second", "six")
                .doesNotContain("first", Index.atIndex(1));
    }

    @Test
    void checkList() {
        SimpleConvert simpleConvert = new SimpleConvert();
        List<String> list = simpleConvert.toList("1", "2", "3", "4", "5");
        assertThat(list).isNotEmpty()
                .contains("1", "3")
                .startsWith("1")
                .endsWith("5")
                .element(2).isEqualTo("3");
    }

    @Test
    void checkSet() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Set<String> set = simpleConvert.toSet("1", "1", "2", "3", "2");
        assertThat(set).hasSize(3)
                .containsExactly("1", "2", "3");
    }

    @Test
    void checkMap() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Map<String, Integer> map = simpleConvert.toMap("zero", "one", "two", "three");
        assertThat(map).isNotEmpty()
                .hasSize(4)
                .containsKeys("zero", "one", "two", "three")
                .containsValues(0, 1, 2, 3)
                .containsEntry("two", 2);
    }
}