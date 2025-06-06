package Main.ServiceImpl;

import Main.Model.User;
import Main.Service.ReportGenerator;
import Main.db.AddressBook;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String REPORT_HEADER = "Name, Second name, Address, Phone number";
    private static final String REPORT_SEPARATION_COMA = ",";

    @Override
    public String getReport() {
        StringBuilder reportBuilder = new StringBuilder();
        reportBuilder.append(REPORT_HEADER)
                .append(System.lineSeparator());

        for (Map.Entry<String, User> entry : AddressBook.contacts.entrySet()) {
            if (entry.getKey().isEmpty()) {
                throw new RuntimeException("Error create report. Username is empty." + entry);
            }
            reportBuilder.append(entry.getValue().getName())
                    .append(REPORT_SEPARATION_COMA)
                    .append(entry.getValue().getSecondName())
                    .append(REPORT_SEPARATION_COMA)
                    .append(entry.getValue().getAddress())
                    .append(REPORT_SEPARATION_COMA)
                    .append(entry.getValue().getPhoneNumber())
                    .append(System.lineSeparator());
        }
        return reportBuilder.toString();
    }
}
