package pl.sdacademy.downloader;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

public class FileDownloader implements UrlDownloader{

    @Override
    public void download(String url) {
        try {
            System.out.println(String.format("Download file %s", url));
            Thread.sleep(10_000);
            URL urlObject = new URL(url);
            InputStream input = urlObject.openConnection().getInputStream();
            Path file = Paths.get("D:\\Nowy folder", filename(url));
            Files.copy(input, file);
            System.out.println(String.format("Saved Url %s to file %s", url, file));
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private String filename(String url) {
        return String.format("file-%s.png", new Random().nextInt(1000));
    }
}
