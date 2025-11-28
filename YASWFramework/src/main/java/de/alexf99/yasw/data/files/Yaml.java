package de.alexf99.yasw.data.files;

import de.alexf99.yasw.Main;
import de.alexf99.yasw.SystemOutputManager;
import de.alexf99.yasw.data.YaswStringBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Yaml {


    private static String getAbsolutePath() throws IOException {
        File tmpFile = new File(Main.folderNameFiles + "/temp.txt");
        String absolutePath = tmpFile.getAbsolutePath();
        tmpFile.delete();
        return absolutePath;
    }

    public static void create(Path path) throws IOException {
        Path absolutePath = Path.of(getAbsolutePath()).getParent();
        Path createFilePath = Paths.get(Main.folderNameFiles, String.valueOf(path));
        File file = new File(String.valueOf(createFilePath));




        if (file.getAbsolutePath().startsWith(String.valueOf(absolutePath)) && !createFilePath.getParent().toString().contains("..")){
            if (!createFilePath.getFileName().toString().endsWith(".yml")) {
                SystemOutputManager.writeDataYaml(true, "File has to end with .yml");
            }else {
                Files.createDirectories(createFilePath.getParent());
                Files.createFile(createFilePath);
                FileWriter configWriter = new FileWriter(String.valueOf(createFilePath));
                configWriter.close();
            }
        }else {

            SystemOutputManager.writeDataYaml(true, "Security | Path is outside the secure Directory");
        }
    }
    public static String readRaw(Path path) throws IOException {
        Path absolutePath = Path.of(getAbsolutePath()).getParent();
        Path createFilePath = Paths.get(Main.folderNameFiles, String.valueOf(path));
        File file = new File(String.valueOf(createFilePath));


        if (file.getAbsolutePath().startsWith(String.valueOf(absolutePath)) && !createFilePath.getParent().toString().contains("..")){
            if (!createFilePath.getFileName().toString().endsWith(".yml")) {
                SystemOutputManager.writeDataYaml(true, "File has to end with .yml");
            }else {
                Scanner scanner = new Scanner(createFilePath);
                YaswStringBuilder rawText = new YaswStringBuilder();
                while (scanner.hasNextLine()){
                    rawText.appendNewLine(scanner.nextLine());
                }
                scanner.close();
                return rawText.toString();
            }
        }else {

            SystemOutputManager.writeDataYaml(true, "Security | Path is outside the secure Directory");

        }

        return "";
    }

    public static Object getKey(Path path, String key) throws IOException {
        Path absolutePath = Path.of(getAbsolutePath()).getParent();
        Path createFilePath = Paths.get(Main.folderNameFiles, String.valueOf(path));
        File file = new File(String.valueOf(createFilePath));


        if (file.getAbsolutePath().startsWith(String.valueOf(absolutePath)) && !createFilePath.getParent().toString().contains("..")){
            if (!createFilePath.getFileName().toString().endsWith(".yml")) {
                SystemOutputManager.writeDataYaml(true, "File has to end with .yml");
            }else {
                Scanner scanner = new Scanner(createFilePath);
                YaswStringBuilder rawText = new YaswStringBuilder();
                while (scanner.hasNextLine()){
                    String nextLine = scanner.nextLine();
                    if (nextLine.contains(":")){
                        String[]lineValue = nextLine.split(": ");
                        if (lineValue[0].contains(key)){
                            if (lineValue.length >= 2){
                                return lineValue[1];

                            }else {
                                ArrayList<String> sequence = new ArrayList<String>();

                                while (scanner.hasNextLine()){
                                    System.out.println("test");
                                    String nextLineScanner = scanner.nextLine().trim();

                                    if (nextLineScanner.startsWith("-")){
                                        String[] item = nextLineScanner.split("- ");
                                        sequence.add(item[1]);
                                    }
                                }
                                Object[] returnValue = sequence.toArray();
                                return returnValue;
                            }
                        }
                    }
                }
                scanner.close();
                return rawText.toString();
            }
        }else {

            SystemOutputManager.writeDataYaml(true, "Security | Path is outside the secure Directory");

        }

        return "test";
    }


    public static void addKeyValue(Path path, String key, String value) throws IOException {
        Path absolutePath = Path.of(getAbsolutePath()).getParent();
        Path createFilePath = Paths.get(Main.folderNameFiles, String.valueOf(path));
        File file = new File(String.valueOf(createFilePath));


        if (file.getAbsolutePath().startsWith(String.valueOf(absolutePath)) && !createFilePath.getParent().toString().contains("..")){
            if (!createFilePath.getFileName().toString().endsWith(".yml")) {
                SystemOutputManager.writeDataYaml(true, "File has to end with .yml");
            }else {
                String raw = readRaw(path);

                String newContent = raw + System.lineSeparator() + key + ": " + value;
                try (FileWriter ymlFile = new FileWriter(String.valueOf(createFilePath))) {
                    System.out.println("TEST" + raw);

                    ymlFile.write(newContent);
                }
            }
        }else {

            SystemOutputManager.writeDataYaml(true, "Security | Path is outside the secure Directory");

        }

    }

}

