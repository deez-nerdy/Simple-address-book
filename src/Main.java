import Service.RunAddressBookService;
import ServiceImpl.RunAddressBookServiceImpl;

public class Main {
    public static void main(String[] args) {
        RunAddressBookService runAddressBookService = new RunAddressBookServiceImpl();
        runAddressBookService.runAddressBook();
    }
}