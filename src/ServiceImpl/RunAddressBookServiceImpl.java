package ServiceImpl;

import Service.RunAddressBookService;
import Strategy.Operation;
import Strategy.AddOperation;
import Strategy.ViewOperation;
import Strategy.SearchOperation;
import Strategy.DeleteOperation;
import Strategy.RenameOperation;
import db.AddressBook;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RunAddressBookServiceImpl extends AddressBook implements RunAddressBookService {
    private Map<Integer, Operation> operations = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);

    public RunAddressBookServiceImpl() {
        operations.put(1, new AddOperation(this, scanner));
        operations.put(2, new ViewOperation(this));
        operations.put(3, new SearchOperation(this, scanner));
        operations.put(4, new DeleteOperation(this, scanner));
        operations.put(5, new RenameOperation(this, scanner));
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
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            Operation operation = operations.get(choice);
            switch (choice) {
                case 1, 2, 3, 4, 5:
                    operation.execute();
                    break;
                case 6:
                    System.out.println("Exiting address book...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 6);
    }
}
