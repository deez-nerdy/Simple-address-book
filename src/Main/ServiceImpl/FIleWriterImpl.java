package Main.ServiceImpl;

import Main.Service.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FIleWriterImpl implements FileWriter {
    @Override
    public void write(String data, String filePath) {
        if (data.isEmpty() || filePath.isEmpty()) {
            throw new RuntimeException("Error writing data to file. Data/File path line is empty");
        }

        try {
            if (Files.exists(Paths.get(filePath))) {
                Files.delete(Paths.get(filePath));
            }
        } catch (IOException e) {
            throw new RuntimeException("Error clear previous file" + filePath, e);
        }

        try {
            Files.write(Paths.get(filePath), data.getBytes(), StandardOpenOption.CREATE);
        } catch (IOException e) {
            throw new RuntimeException("Error writing data to file " + filePath, e);
        }
    }
}
