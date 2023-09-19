package ru.job4j.io;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ConfigTest {
    @Test
    void whenPairWithoutComment() {
        String path = "./data/pair_without_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("two")).isEqualTo("2");
    }

    @Test
    void whenPairWithCommentAndEmptyLine() {
        String path = "./data/pair_with_comment_and_emptyLine.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("three")).isEqualTo("3");
    }

    @Test
    void whenPairWithoutKey() {
        String path = "./data/pair_contains_invalid_template.properties";
        Config config = new Config(path);
        assertThatThrownBy(config::load)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void whenPairWithoutValue() {
        String path = "./data/pair_contains_invalid_template.properties";
        Config config = new Config(path);
        assertThatThrownBy(config::load)
                .isInstanceOf(IllegalArgumentException.class);
    }
}