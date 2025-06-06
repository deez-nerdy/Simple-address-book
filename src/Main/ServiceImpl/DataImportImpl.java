package Main.ServiceImpl;

import Main.Model.User;
import Main.Service.DataImport;
import Main.db.AddressBook;
import java.util.Map;

public class DataImportImpl implements DataImport {
    @Override
    public void importData(Map<String, User> data) {
        AddressBook.contacts.putAll(data);
    }
}
