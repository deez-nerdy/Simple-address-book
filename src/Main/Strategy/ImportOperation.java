package Main.Strategy;

import Main.Service.DataConverter;
import Main.Service.DataImport;
import Main.Service.FileReader;
import Main.ServiceImpl.DataConverterImpl;
import Main.ServiceImpl.DataImportImpl;
import Main.ServiceImpl.FileReaderImpl;
import Main.db.AddressBook;
import java.io.File;
import java.util.Scanner;

public class ImportOperation implements Operation {
    DataImport dataImportToBook = new DataImportImpl();
    private FileReader fileReader = new FileReaderImpl();
    private DataConverter dataConverter = new DataConverterImpl();
    private Scanner scanner;

    public ImportOperation(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        if (!AddressBook.contacts.isEmpty()) {
            System.out.println("YOUR ADDRESS BOOK IS ALREADY HAVE CONTACTS:");
            System.out.println("1. Merge exist contacts with file.");
            System.out.println("2. Delete exist contacts.");

            int choice = scanner.nextInt();
            if (choice == 1) {
                System.out.println("Adding new contacts from file...");
            } else if (choice == 2) {
                System.out.println("Clear exist contacts");
                AddressBook.contacts.clear();
            }
        }

        System.out.println("Enter file name: ");
        String fileName = scanner.next();

        if (fileName == null) {
            System.out.println("File name can't be empty. Please enter correct name.");
            scanner.next();
        }

        String filePath = "src/resources/" + fileName + ".csv";
        File file = new File(filePath);

        if (!file.exists()) {
            do {
                System.out.println("File doesn't exist. Enter name of exist file.");
                scanner.next();
            } while (file.exists());
        }

        dataImportToBook.importData(dataConverter.convert(fileReader.read(filePath)));
    }
}
