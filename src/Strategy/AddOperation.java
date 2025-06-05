package Strategy;

import Model.User;
import db.AddressBook;
import java.util.Scanner;

public class AddOperation implements Operation {
    private AddressBook addressBook;
    private Scanner scanner;

    public AddOperation(AddressBook addressBook, Scanner scanner) {
        this.addressBook = addressBook;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.println("Enter name: ");
        String name = scanner.next();
        exceptionMessage(name);

        System.out.println("Enter second name: ");
        String secondName = scanner.next();
        exceptionMessage(secondName);

        System.out.println("Enter address: ");
        String address = scanner.next();
        exceptionMessage(address);

        System.out.println("Enter phone number: ");
        String phone = scanner.next();
        exceptionMessage(phone);

        User user = new User(name, secondName, address, phone);
        addressBook.getContacts().put(name, user);
    }

    private void exceptionMessage(String input) {
        if (input == null) {
            throw new RuntimeException("User information can't be empty!");
        }
    }
}
