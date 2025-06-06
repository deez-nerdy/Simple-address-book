package Main.Strategy;

import Main.Model.User;
import Main.db.AddressBook;
import java.util.Scanner;

public class RenameOperation implements Operation {
    private Scanner scanner;

    public RenameOperation(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.println("Enter username to find user");
        String nameToChange = scanner.next();

        if (nameToChange == null) {
            System.out.println("User information can't be empty!");
            scanner.next();
        }

        if (!AddressBook.contacts.containsKey(nameToChange)) {
            do {
                System.out.println("Incorrect username or this user doesn't exist!");
                scanner.next();
            } while (AddressBook.contacts.containsKey(nameToChange));
        }

        System.out.println("Enter new name: ");
        String newName = scanner.next();

        User userToChange = AddressBook.contacts.get(nameToChange);
        User newUser = new User(newName,
                userToChange.getSecondName(),
                userToChange.getAddress(),
                userToChange.getPhoneNumber());

        AddressBook.contacts.remove(nameToChange);
        AddressBook.contacts.put(newName, newUser);
    }
}
