package Strategy;

import db.AddressBook;
import java.util.Scanner;

public class SearchOperation implements Operation {
    private AddressBook addressBook;
    private Scanner scanner;

    public SearchOperation(AddressBook addressBook, Scanner scanner) {
        this.addressBook = addressBook;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.println("Enter name to search ");
        String name = scanner.next();

        if (name == null) {
            throw new RuntimeException("User information can't be empty!");
        }

        if (!addressBook.getContacts().containsKey(name)) {
            throw new RuntimeException("User not found!");
        }
        System.out.println(addressBook.getContacts().get(name).toString());
    }
}
