package Strategy;

import Model.User;
import db.AddressBook;

import java.util.Map;

public class ViewOperation implements Operation {
    private AddressBook addressBook;

    public ViewOperation(AddressBook addressBook) {
        this.addressBook = addressBook;
    }

    @Override
    public void execute() {
        for (Map.Entry<String, User> contact : addressBook.getContacts().entrySet()) {
            System.out.println(contact.getValue().toString());
        }
    }
}
