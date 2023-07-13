package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class NameLoadTest {

    @Test
    void checkEmpty() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(nameLoad::getMap)
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("no data");
    }

    @Test
    void checkLength() {
        NameLoad nameLoad = new NameLoad();
        String[] args = new String[0];
        assertThatThrownBy(() -> nameLoad.parse(args))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("is empty");
    }

    @Test
    void checkNotContainSymbol() {
        NameLoad nameLoad = new NameLoad();
        String[] args = {"one=name1", "two:name2"};
        assertThatThrownBy(() -> nameLoad.parse(args))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("two:name2");
    }

    @Test
    void checkNotContainKey() {
        NameLoad nameLoad = new NameLoad();
        String[] args = {"one=name1", "=name2"};
        assertThatThrownBy(() -> nameLoad.parse(args))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("=name2");
    }

    @Test
    void checkNotContainValue() {
        NameLoad nameLoad = new NameLoad();
        String[] args = {"one=name1", "two="};
        assertThatThrownBy(() -> nameLoad.parse(args))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("two=");
    }
}