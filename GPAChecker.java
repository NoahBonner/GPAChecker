/*This file is for testing purposes only. This is the baseline for my GPA Checker program, which will eventually be a GUI-based Android app. For now, this file DOES NOT feature a 
 * GUI, but rather is text-based to ensure the code works properly. This file is a testing file which will be synced via the THS computer and my person computer through my personal
 * Github account. This test Java file will be coded in Visual Studio Code.*/

 //UPDATED ON 11/28/2023 10:01 AM 
import java.util.Scanner; //imports user input
public class GPAChecker { //creates the GPA Checker class
    public static void main(String[] args){
        System.out.println("How many classes do you take?\n");
        Scanner sc = new Scanner(System.in); //prompts the user for input
        int classes = sc.nextInt();
        String className = "";
        String letterGrade = "";
        int gpaScoreUnweighted = 0;
        int gpaScoreWeighted = 0;
        while (classes > -1){
            System.out.println("Enter the name of your class.");
            className = className + sc.nextLine() + "\n";
            System.out.println("Now, enter your LETTER grade (i.e. A, A-, B+, etc.)");
            letterGrade = letterGrade + sc.nextLine() + "\n";
            classes--;
            if (letterGrade == "A"){
                gpaScoreUnweighted+=4.0;
                gpaScoreWeighted+=5.0;
            }else if (letterGrade == "A-"){
                gpaScoreUnweighted+=3.7;
                gpaScoreWeighted+=4.7;
            }
        }
        System.out.println("The classes you take are: \n" + className);
        System.out.println("and your grades of your classes are: \n" + letterGrade);
        System.out.println("Your GPAs are: " + gpaScoreUnweighted + gpaScoreWeighted);
    }
}