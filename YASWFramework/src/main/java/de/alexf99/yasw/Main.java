package de.alexf99.yasw;

import de.alexf99.yasw.data.files.Yaml;

import java.nio.file.Path;
import java.util.ArrayList;

public class Main {
    public static String folderNameFiles = "YaswFiles";
    public static void main(String[] args) throws Exception {
        Object[] testArray = (Object[]) Yaml.getKey(Path.of("test/test.yml"),"userRoles");

        //System.out.println(Yaml.getKey(Path.of("test/test.yml"),"version"));
        //assert testArray != null;
        for (Object ta : testArray){
            System.out.println(ta);
        }

    }
}