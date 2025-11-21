package de.alexf99.yasw;

public class SystemOutputManager {
    private static final String errorColor = "\\u001B[31m";
    private static final String httpManagerPrefix = "[HttpManager] ";
    private static final String configManagerPrefix = "[ConfigManager] ";
    private static final String dataPrefix = "[Data] ";
    private static final String dataYamlPrefix = "[Data.Yaml] ";

    public static void writeHttpManager(boolean error, String message){
        if (error) System.out.println(errorColor+ httpManagerPrefix + message);
        else System.out.println(httpManagerPrefix + message);
    }

    public static void writeConfigManager(boolean error, String message){
        if (error) System.out.println(errorColor+ configManagerPrefix + message);
        else System.out.println(configManagerPrefix + message);
    }

    public static void writeData(boolean error, String message){
        if (error) System.out.println(errorColor+ dataPrefix + message);
        else System.out.println(dataPrefix + message);
    }

    public static void writeDataYaml(boolean error, String message){
        if (error) System.out.println(errorColor+ dataYamlPrefix + message);
        else System.out.println(dataYamlPrefix + message);
    }
}
