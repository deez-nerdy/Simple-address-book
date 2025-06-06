package Main.ServiceImpl;

import Main.Service.RunAddressBookService;
import Main.Strategy.*;
import Main.db.AddressBook;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RunAddressBookServiceImpl extends AddressBook implements RunAddressBookService {;
    private final Map<Integer, Operation> operations = new HashMap<>();
    private final Scanner scanner = new Scanner(System.in);

    public RunAddressBookServiceImpl() {
        operations.put(1, new AddOperation(scanner));
        operations.put(2, new ViewOperation());
        operations.put(3, new SearchOperation(scanner));
        operations.put(4, new DeleteOperation(scanner));
        operations.put(5, new RenameOperation(scanner));
        operations.put(6, new ImportOperation(scanner));
        operations.put(7, new SaveToFileOperation(scanner));
    }

    @Override
    public void runAddressBook() {
        int choice = 0;

        do {
            System.out.println("ADDRESS BOOK");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Search Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Rename contact");
            System.out.println("6. Import contacts from file");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
            } else {
                System.out.println("Invalid choice! Please enter a number from menu.");
                scanner.next();
                continue;
            }

            Operation operation = operations.get(choice);

            if (operation != null) {
                if (choice >= 1 && choice <= 6) {
                    operation.execute();
                } else if (choice == 7) {
                    System.out.println("Saving contacts. Exiting address book...");
                    operation.execute();
                }
            } else {
                System.out.println("Invalid choice! Please enter a number from menu.");
            }
        } while (choice != 7);
    }
}
