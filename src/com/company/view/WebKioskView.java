package com.company.view;

import com.company.controller.Console;
import com.company.helpers.EmailValidator;
import com.company.helpers.PasswordValidator;
import com.company.interfaces.AuthManager;
import com.company.interfaces.GetObjectDAO;
import com.company.interfaces.UpdateObjectDAO;
import com.company.interfaces.UpdatePasswordDAO;
import com.company.model.*;

public class WebKioskView {

    public static AccountInfo login(AuthManager authManager){
        var errorMessage = "";
        while (true){
            Console.clear();
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

    public static <T extends GetObjectDAO<? extends Person, String> & UpdateObjectDAO<? extends Person>>
    void dashboard(AccountInfo accountInfo,  UpdatePasswordDAO accountDAO, T personDAO, AuthManager authenticator){

        Person person = personDAO.get(accountInfo.getAccountId());
        while (true){
            System.out.println("\t\t********** DASHBOARD: WEB KIOSK MANAGEMENT SYSTEM **********\n");

            System.out.println("\t\t * PRIMARY INFORMATION\n");

            System.out.println("\tID: " + accountInfo.getAccountId() + "-" + accountInfo.getAccountType().toString().toUpperCase());
            System.out.println("\tFull Name: " + nameWrapper(person.getFirstName(), person.getLastName()));
            System.out.println("\tAge: " + person.getAge());
            System.out.println("\tBirthdate: " + person.getBirthDate());
            System.out.println("\tGender: " + genderWrapper(person.getGender()));
            System.out.println("\tAddress: " + person.getAddress());
            System.out.println("\tContact No.: " + person.getContact());
            System.out.println("\tEmail:" + person.getEmail());

            System.out.println("\t\t * OTHER INFORMATION\n");
            otherInfo(accountInfo, person);

            System.out.println("\t\t************************************************************\n");
            System.out.println("\tActions : [0] Logout, [1] Change Email, [2] Change Password");
            var action = Console.get_int("\tAction: ", 2);

            Console.clear();
            switch (action){
                case 0: return;
                case 1: changeEmail(personDAO, person); break;
                case 2: changePassword(accountInfo, authenticator, accountDAO); break;
            }
            Console.clear();
        }
    }

    public static boolean isRunning(){
        System.out.println("\t\t********** LOGIN: WEB KIOSK MANAGEMENT SYSTEM **********");
        System.out.println("\t(0) Login");
        System.out.println("\t(1) Exit");
        return Console.get_int("Action: ", 1) == 0;
    }

    private static String nameWrapper(String firstName, String lastName){
        return lastName.toUpperCase() + ", " + firstName.toUpperCase();
    }

    private static String genderWrapper(boolean gender){
        return (gender) ? "MALE" : "FEMALE";
    }

    private static void otherInfo(AccountInfo info, Person person){
        if(info.getAccountType().equals(AccountTypes.STUDENT))
            studentInfo((StudentPerson) person);
        if(info.getAccountType().equals(AccountTypes.PARENT))
            parentInfo((ParentPerson) person);
        if(info.getAccountType().equals(AccountTypes.FACULTY))
            facultyInfo((FacultyPerson) person);
    }

    private static void studentInfo(StudentPerson person){
        System.out.println("\tCollege: " + person.getCollege());
        System.out.println("\tCourse: " + person.getCourse());
        System.out.println("\tYearLevel: " + person.getYearLevel());
    }

    private static void parentInfo(ParentPerson person){
        System.out.println("\t" + person.getOccupation());
        System.out.println("\t" + person.getDegree());
        System.out.println("\t" + person.getLastSchool());
        System.out.println("\t" + person.getCivilStatus());
    }
    private static void facultyInfo(FacultyPerson person){
        System.out.println("\t" + person.getDepartment());
        System.out.println("\t" + person.getDegree());
        System.out.println("\t" + person.getLastSchool());
        System.out.println("\t" + person.getCivilStatus());
    }

    private static  void changeEmail(UpdateObjectDAO personDAO, Person person){

        //CHANGE EMAIL
        String newEmail = "";
        while (true){
            System.out.println("\t\t********** EMAIL SETTINGS **********\n");
            newEmail = Console.get_string("\tNew Email: ");

            if(!EmailValidator.validate(newEmail)){
                int choice = Console.get_int("Do you want to try again?[0-yes, 1-no]: ", 1);
                if(choice == 1)
                    return;
            }
            else break;
        }

        person.setEmail(newEmail);
        System.out.println("\t<Changes Saved!>");
        personDAO.update(person);
        Console.get_string("\n\tType any key to back: ");
    }

    private static void changePassword(AccountInfo info, AuthManager manager, UpdatePasswordDAO dao){
        while (true){
            System.out.println("\t\t********** ACCOUNT SETTINGS **********\n");
            var currentPassword = Console.get_string("\tCurrent Password: ");
            var newPassword = Console.get_string("\tNew Password: ");

            if(manager.authenticate(info.getAccountId(), info.getAccountType().toString(), currentPassword)){
                if(PasswordValidator.validate(newPassword)){
                    dao.update(newPassword);
                    System.out.println("\n\t<Changes Saved!>");
                    Console.get_string("\n\tType any key to back: ");
                    return;
                }

                System.out.println("\n\t<Incorrect Password Format!");
                System.out.println("\n\t* Password length is at least 6 characters");
                System.out.println("\n\t*  The characters shall be a combination of Alphabet Letters \n\t" +
                        "(Uppercase and Lowercase), Digits, and Punctuations >");

                int choice = Console.get_int("\n\tDo you want to try again?[0-yes, 1-no]: ", 1);
                if(choice == 1)
                    return;
                Console.clear();
                continue;
            }

            System.out.println("\n\t<Incorrect Current Password!>");
            int choice = Console.get_int("\n\tDo you want to try again?[0-yes, 1-no]: ", 1);
            if(choice == 1)
                return;

            Console.clear();
        }
    }
}
