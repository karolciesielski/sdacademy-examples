package pl.sdacademy.io;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class IoExample {
    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileSource()))) {
            String line = bufferedReader.readLine();
            while(line != null){
                System.out.println(line);
                line = bufferedReader.readLine();
            }
        }
    }

    private static InputStream fileSource() throws FileNotFoundException {
        Path path = Paths.get("files", "sourceFile.txt");
        return new FileInputStream(path.toFile());
    }

    private static InputStream inMemorySource() {
        return new ByteArrayInputStream("hello".getBytes());
    }

}
