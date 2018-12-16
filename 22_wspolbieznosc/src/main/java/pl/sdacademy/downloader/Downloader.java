package pl.sdacademy.downloader;

public class Downloader {
    public static void main(String[] args) {
        CommandLineRunner commandLine = new CommandLineRunner(new FileDownloader(), new NewThreadExecutor());
        commandLine.run(System.in);
    }
}
