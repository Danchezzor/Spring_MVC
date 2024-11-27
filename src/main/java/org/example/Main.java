package org.example;

import com.sun.jdi.connect.Connector;
import com.sun.jdi.connect.Transport;

import java.io.IOException;
import java.nio.file.Files;
import java.util.Map;


public class Main {
    public static final int PORT = 9999;

    public static void main(String[] args) throws LifecycleException, IOException {
        final var tomcat = new Tomcat();
        final var baseDir = Files.createTempDirectory("tomcat");
        baseDir.toFile().deleteOnExit();
        tomcat.setBaseDir(baseDir.toAbsolutePath().toString());
        final var connector = new Connector();
        connector.setPort(PORT);
        tomcat.setConnector(connector);
        tomcat.getHost().setAppBase(".");
        tomcat.addWebapp("", ".");
        tomcat.start();
        tomcat.getServer().await();
    }
}

