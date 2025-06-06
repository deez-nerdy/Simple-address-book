package Main.Service;

import Main.Model.User;
import java.util.Map;

public interface DataImportToBook {
    void importData(Map<String, User> data);
}
