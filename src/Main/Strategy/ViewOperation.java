package Main.Strategy;

import Main.Model.User;
import Main.db.AddressBook;
import java.util.Map;

public class ViewOperation implements Operation {

    @Override
    public void execute() {
        if (AddressBook.contacts.isEmpty()) {
            System.out.println("There is no contacts yet.");
        }

        for (Map.Entry<String, User> contact : AddressBook.contacts.entrySet()) {
            System.out.println(contact.getValue().toString());
        }
    }
}
