package Main.Strategy;

import Main.Service.FileWriter;
import Main.Service.ReportGenerator;
import Main.ServiceImpl.FIleWriterImpl;
import Main.ServiceImpl.ReportGeneratorImpl;
import java.util.Scanner;

public class SaveToFileOperation implements Operation {
    private ReportGenerator reportGenerator = new ReportGeneratorImpl();
    private FileWriter fileWriter = new FIleWriterImpl();
    Scanner scanner;

    public SaveToFileOperation(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.println("Enter file name: ");
        String fileName = scanner.next();

        if (fileName == null) {
            System.out.println("File name can't be empty. Enter file name.");
            scanner.next();
        }

        fileWriter.write(reportGenerator.getReport(), filePathCreator(fileName));
    }

    private String filePathCreator(String fileName) {
        return "src/resources/" + fileName + ".csv";
    }
}
