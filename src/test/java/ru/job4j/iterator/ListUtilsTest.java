package ru.job4j.iterator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

class ListUtilsTest {

    private List<Integer> input;

    @BeforeEach
    void setUp() {
        input = new ArrayList<>(Arrays.asList(1, 3));
    }

    @Test
    void whenAddBefore() {
        ListUtils.addBefore(input, 1, 2);
        assertThat(input).hasSize(3).containsSequence(1, 2, 3);
    }

    @Test
    void whenAddBeforeWithInvalidIndex() {
        assertThatThrownBy(() -> ListUtils.addBefore(input, 3, 2))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    void whenAddAfter() {
        ListUtils.addAfter(input, 0, 2);
        assertThat(input).hasSize(3).containsSequence(1, 2, 3);
    }

    @Test
    void whenRemoveIf() {
        input.addAll(new ArrayList<>(Arrays.asList(5, 6, 7)));
        ListUtils.removeIf(input, p -> p % 2 == 0);
        assertThat(input).hasSize(4)
                .containsExactly(1, 3, 5, 7);
    }

    @Test
    void whenReplaceIf() {
        input.addAll(new ArrayList<>(Arrays.asList(5, 6, 9)));
        ListUtils.replaceIf(input, p -> p % 2 == 0, 7);
        assertThat(input).hasSize(5)
                .containsExactly(1, 3, 5, 7, 9);
    }

    @Test
    void whenRemoveAll() {
        input.addAll(new ArrayList<>(Arrays.asList(5, 6, 7, 8, 9, 10, 11)));
        ListUtils.removeAll(input, new ArrayList<>(Arrays.asList(6, 8, 10)));
        assertThat(input).hasSize(6)
                .containsExactly(1, 3, 5, 7, 9, 11);
    }

    @Test
    void whenRemoveAllThenNotChanges() {
        input.addAll(new ArrayList<>(Arrays.asList(5, 6, 7)));
        ListUtils.removeAll(input, new ArrayList<>(Arrays.asList(8, 9, 10, 11)));
        assertThat(input).hasSize(5)
                .containsExactly(1, 3, 5, 6, 7);
    }
}