package de.alexf99.yasw;

import de.alexf99.yasw.data.files.Yaml;

import java.nio.file.Path;

public class Main {
    public static String folderNameFiles = "YaswFiles";
    public static void main(String[] args) throws Exception {
        System.out.println(Yaml.readRaw(Path.of("test.yml")));
    }
}