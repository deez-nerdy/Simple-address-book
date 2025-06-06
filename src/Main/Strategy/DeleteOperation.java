package Main.Strategy;

import Main.db.AddressBook;
import java.util.Scanner;

public class DeleteOperation implements Operation {
    private Scanner scanner;

    public DeleteOperation(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.println("Enter username to delete user: ");
        String name = scanner.next();
        AddressBook.contacts.remove(name);
    }
}
