package Main.ServiceImpl;

import Main.Model.User;
import Main.Service.DataImportToBook;
import Main.db.AddressBook;
import java.util.Map;

public class DataImportToBookImpl implements DataImportToBook {
    @Override
    public void importData(Map<String, User> data) {
        AddressBook.contacts.putAll(data);
    }
}
