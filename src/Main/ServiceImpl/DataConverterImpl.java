package Main.ServiceImpl;

import Main.Model.User;
import Main.Service.DataConverter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataConverterImpl implements DataConverter {
    private static final String ARRAY_SPLIT_POINT = ",";
    private static final int VALID_ARRAY_LENGTH = 4;
    private static final int FIRST_SPLIT_PART = 0;
    private static final int SECOND_SPLIT_PART = 1;
    private static final int THIRD_SPLIT_PART = 2;
    private static final int FOURTH_SPLIT_PART = 3;

    @Override
    public Map<String, User> convert(List<String> report) {
        Map<String, User> importAddressBook = new HashMap<>();
        for (String line : report.subList(1, report.size())) {
            String[] parts = line.split(ARRAY_SPLIT_POINT);
            if (parts.length < VALID_ARRAY_LENGTH) {
                throw new RuntimeException("Invalid data format: " + line);
            }
            String name = parts[FIRST_SPLIT_PART].trim();
            String secondName = parts[SECOND_SPLIT_PART].trim();
            String address = parts[THIRD_SPLIT_PART].trim();
            String phoneNumber = parts[FOURTH_SPLIT_PART].trim();
            User user = new User(name, secondName, address, phoneNumber);
            importAddressBook.put(name, user);
        }
        return importAddressBook;
    }
}
