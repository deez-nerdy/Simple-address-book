package Main.Service;

import Main.Model.User;

import java.util.List;
import java.util.Map;

public interface DataConverter {
    Map<String, User> convert(List<String> report);
}
