package Main.Strategy;

import Main.db.AddressBook;
import java.util.Scanner;

public class SearchOperation implements Operation {
    private Scanner scanner;

    public SearchOperation(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.println("Enter name to search ");
        String name = scanner.next();

        if ((name == null)) {
            System.out.println("User information can't be empty! Please enter the name.");
            scanner.next();
        }

        if (!AddressBook.contacts.containsKey(name)) {
            System.out.println("User not found!");
            scanner.next();
        }
        System.out.println(AddressBook.contacts.get(name).toString());
    }
}
