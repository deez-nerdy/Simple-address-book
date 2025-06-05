package Strategy;

import db.AddressBook;
import java.util.Scanner;

public class DeleteOperation implements Operation {
    private AddressBook addressBook;
    private Scanner scanner;

    public DeleteOperation(AddressBook addressBook, Scanner scanner) {
        this.addressBook = addressBook;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.println("Enter username to delete user: ");
        String name = scanner.next();
        addressBook.getContacts().remove(name);
    }
}
