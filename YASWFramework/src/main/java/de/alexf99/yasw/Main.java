package de.alexf99.yasw;

import de.alexf99.yasw.httpServer.SetView;
import de.alexf99.yasw.httpServer.YaswHttpServer;

import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception {
        YaswHttpServer.init(8000);
        YaswHttpServer.server.createContext("/", new SetView("index.html"));
        YaswHttpServer.server.start();

    }




}