package de.alexf99.yasw.config;

import java.io.File;
import java.nio.file.Path;

public class ConfigManager {

    public File confFile;
    public void createConfig(File file){
        confFile = file;
    }
    public void editFile(File file){
        confFile = file;
    }
    public void deleteFile(File file){

    }
}
