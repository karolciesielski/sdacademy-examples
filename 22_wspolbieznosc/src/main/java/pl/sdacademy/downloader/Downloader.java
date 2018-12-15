package pl.sdacademy.downloader;

import java.io.InputStream;

public class Downloader {
    public static void main(String[] args) {
        CommandLineRunner commandLine = new CommandLineRunner(new FileDownloader());
        commandLine.run(System.in);
    }
}
