package Main;

import Main.Service.RunAddressBookService;
import Main.ServiceImpl.RunAddressBookServiceImpl;

public class Main {
    public static void main(String[] args) {
        RunAddressBookService runAddressBookService = new RunAddressBookServiceImpl();
        runAddressBookService.runAddressBook();
    }
}