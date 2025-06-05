package db;

import Model.User;
import java.util.Map;
import java.util.HashMap;

public class AddressBook {
    Map<String, User> contacts = new HashMap<>();

    public Map<String, User> getContacts() {
        return contacts;
    }
}
