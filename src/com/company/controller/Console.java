package com.company.controller;

import java.util.Scanner;

public class Console {
    private static final Scanner scan = new Scanner(System.in);

    public static int get_int(String prompt){

        System.out.print(prompt);
        while (!scan.hasNextInt()){
            System.out.print(prompt);
            scan.nextLine();
        }
        int ret = scan.nextInt();
        scan.nextLine();
        return ret;
    }

    public static int get_int(String prompt, int min, int max){
        while (true){
            int ret = get_int(prompt);
            if(ret >= min && ret <= max)
                return ret;
        }
    }

    public static int get_int(String prompt, int max){
        return get_int(prompt, 0, max);
    }

    public static String get_string(String prompt){
        System.out.print(prompt);
        return scan.nextLine();
    }

    public static void clear(){
        System.out.println("\n\n");
    }
}
