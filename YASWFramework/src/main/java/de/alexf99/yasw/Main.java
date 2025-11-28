package de.alexf99.yasw;

import de.alexf99.yasw.data.database.Mysql;
import de.alexf99.yasw.data.files.Yaml;

import java.nio.file.Path;
import java.sql.Connection;
import java.util.ArrayList;

public class Main {
    public static String folderNameFiles = "YaswFiles";
    public static void main(String[] args) throws Exception {

        Mysql.Connection("gateway01.eu-central-1.prod.aws.tidbcloud.com",4000,"test","3v4dZJogrjAu2p2.root" , "UEyGHOVU6KZM46pG", "DROP TABLE Employees;");

    }
}