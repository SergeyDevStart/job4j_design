package ru.job4j.template;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

@Disabled
class GeneratorUtilTest {
    private Map<String, String> map;
    private Generator generator;

    @BeforeEach
    public void init() {
        generator = new GeneratorUtil();
        map = new HashMap<>();
        map.put("name", "Sergey");
        map.put("subject", "you");
    }

    @Test
    public void whenGeneratorThenSuccess() {
        String template = "I am ${name}, Who are ${subject}? ";
        assertThat(generator.produce(template, map))
                .isEqualTo("I am Sergey, Who are you? ");
    }

    @Test
    public void whenExcessKeyThenException() {
        String template = "Hello, my name is ${name}. ";
        assertThatThrownBy(() -> generator.produce(template, map))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void whenAbsentKeyThenException() {
        String template = "My name is ${name}, I'm ${age} years old, who are ${subject}? ";
        assertThatThrownBy(() -> generator.produce(template, map))
                .isInstanceOf(IllegalArgumentException.class);
    }
}