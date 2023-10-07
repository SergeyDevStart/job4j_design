package ru.job4j.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {
    public void packFiles(List<Path> sources, File target) {
        try (var zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (Path path : sources) {
                zip.putNextEntry(new ZipEntry(path.toString()));
                try (var in = new BufferedInputStream(new FileInputStream(path.toAbsolutePath().toString()))) {
                    zip.write(in.readAllBytes());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void packSingleFile(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getName()));
            try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(source))) {
                zip.write(in.readAllBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void verification(ArgsName argsName, String[] args) {
        if (args.length != 3) {
            throw new IllegalArgumentException("Actual and formal argument lists differ in length");
        }
        Path directory = Path.of(argsName.get("d"));
        if (!Files.exists(directory) || !Files.isDirectory(directory)) {
            throw new IllegalArgumentException("The path is not exist");
        }
        String fileExtension = argsName.get("e");
        if (fileExtension.lastIndexOf(".") != 0 || fileExtension.length() < 2) {
            throw new IllegalArgumentException("use this format: \\\".FILE_EXTENSION\\\"\"");
        }
        String outputFile = argsName.get("o");
        if (!outputFile.endsWith(".zip")) {
            throw new IllegalArgumentException("The target file must have a zip extension");
        }
    }

    public List<Path> search(String root, String extension) throws IOException {
        return Search.search(Path.of(root), p -> !p.getFileName().toString().endsWith(extension));
    }

    public static void main(String[] args) throws IOException {
        ArgsName argsName = ArgsName.of(args);
        Zip.verification(argsName, args);
        Zip zip = new Zip();
        List<Path> paths = zip.search(argsName.get("d"), argsName.get("e"));
        zip.packFiles(paths, new File(argsName.get("o")));
    }
}
