package com.company.view;

import com.company.controller.Console;
import com.company.controller.WebKioskApp;
import com.company.interfaces.AuthManager;
import com.company.interfaces.GetObjectDAO;
import com.company.interfaces.UpdateObjectDAO;
import com.company.model.AccountInfo;
import com.company.model.AccountTypes;
import com.company.model.Person;

public class WebKioskView {

    public static AccountInfo login(AuthManager authManager){
        var errorMessage = "";
        while (true){
            System.out.println("\t\t********** LOGIN: WEB KIOSK MANAGEMENT SYSTEM **********");
            System.out.println("\t\t" + errorMessage);
            System.out.println("\tAccount Types : [0] student, [1] parent, [2] faculty");
            var type = Console.get_int("\tLogin As: ", 2);
            var identification = Console.get_string("\tAccount ID: ");
            var password = Console.get_string("\tPassword: ");

            var value = AccountTypes.values()[type];

            if(authManager.authenticate(identification, value.toString(), password))
               return new AccountInfo(identification, value);
            else
                errorMessage = "<Invalid Credentials>\n";

            Console.clear();
        }
    }

    public static <T extends GetObjectDAO<P, String> & UpdateObjectDAO<P>, P extends Person>
    void dashboard(AccountInfo accountInfo, T personDAO){
        P person = personDAO.get(accountInfo.getAccountId());
        while (true){
            System.out.println("\t\t********** DASHBOARD: WEB KIOSK MANAGEMENT SYSTEM **********\n");

            System.out.println("\t\t * PRIMARY INFORMATION");

            System.out.println("\tID: " + accountInfo.getAccountId() + "-" + accountInfo.getAccountType().toString().toUpperCase());
            System.out.println("\tFull Name: " + formatName(person.getFirstName(), person.getLastName()));

            System.out.println("\t\t * OTHER INFORMATION");
        }
    }

    private static String formatName(String firstName, String lastName){
        return lastName.toUpperCase() + ", " + firstName.toUpperCase();
    }
}
