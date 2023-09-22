package ru.job4j.io;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.*;
import java.nio.file.Path;
import java.util.StringJoiner;

import static org.assertj.core.api.Assertions.*;

class AnalysisTest {
    @Test
    void unavailable(@TempDir Path tempDir) throws IOException {
        File source = tempDir.resolve("server.log").toFile();
        try (var out = new PrintWriter(source)) {
            out.println("200 10:56:01");
            out.println("500 10:57:01");
            out.println("400 10:58:01");
            out.println("300 10:59:01");
            out.println("500 11:01:02");
            out.println("200 11:02:02");
        }
        File target = tempDir.resolve("target.csv").toFile();
        Analysis analysis = new Analysis();
        analysis.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        StringJoiner sj = new StringJoiner(System.lineSeparator());
        try (var in = new BufferedReader(new FileReader(target.getAbsolutePath()))) {
            in.lines()
                    .forEach(sj::add);
        }
        assertThat(sj.toString()).isEqualTo(
                "10:57:01;10:59:01"
                        + System.lineSeparator()
                        + "11:01:02;11:02:02");
    }
}