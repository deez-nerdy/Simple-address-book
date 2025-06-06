package Main.Service;

import Main.Model.User;
import java.util.Map;

public interface DataImport {
    void importData(Map<String, User> data);
}
