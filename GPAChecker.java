/*This file is for testing purposes only. This is the baseline for my GPA Checker program, which will eventually be a GUI-based Android app. For now, this file DOES NOT feature a 
 * GUI, but rather is text-based to ensure the code works properly. This file is a testing file which will be synced via the THS computer and my person computer through my personal
 * Github account. This test Java file will be coded in Visual Studio Code.*/

import java.util.Scanner; //imports user input
public class GPAChecker { //creates the GPA Checker class
    public static void main(String[] args){
        System.out.println("How many classes do you take?\n");
        Scanner sc = new Scanner(System.in); //prompts the user for input
        int classes = sc.nextInt();
        String[][] className = ""; //TURNING THIS INTO AN MULTIDIMENSIONAL ARRAY 
        while (classes > -1){
            System.out.println("Enter the name of your class.");
            className = className + sc.nextLine() + "\n";
            classes--;
        }
        System.out.println("The classes you take are: \n" + className);
    }
}