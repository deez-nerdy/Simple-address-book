package Strategy;

import Model.User;
import db.AddressBook;
import java.util.Scanner;

public class RenameOperation implements Operation {
    private AddressBook addressBook;
    private Scanner scanner;

    public RenameOperation(AddressBook addressBook, Scanner scanner) {
        this.addressBook = addressBook;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.println("Enter username to find user");
        String nameToChange = scanner.next();

        if (nameToChange == null) {
            throw new RuntimeException("User information can't be empty!");
        }

        if (!addressBook.getContacts().containsKey(nameToChange)) {
            throw new RuntimeException("Incorrect username or this user doesn't exist!");
        }

        System.out.println("Enter new name: ");
        String newName = scanner.next();

        User userToChange = addressBook.getContacts().get(nameToChange);
        User newUser = new User(newName,
                userToChange.getSecondName(),
                userToChange.getAddress(),
                userToChange.getPhoneNumber());

        addressBook.getContacts().remove(nameToChange);
        addressBook.getContacts().put(newName, newUser);
    }
}
