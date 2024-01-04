import java.util.Scanner;

public class GPACalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to GPA Calculator!");

        // Ask the user for the input method choice
        System.out.print("Enter 'P' for percentage grades or 'L' for letter grades: ");
        char inputMethod = scanner.next().toUpperCase().charAt(0);

        int numClasses;
        // Get the number of classes
        System.out.print("Enter the number of classes: ");
        numClasses = scanner.nextInt();

        // Arrays to store grade and credit hours for each class
        double[] grades = new double[numClasses];
        String[] letterGrades = new String[numClasses];
        int[] creditHours = new int[numClasses];
        boolean[] isHonors = new boolean[numClasses];

        // Flags to track if the first class is an Early Bird class
        boolean isFirstClassEarlyBird = false;

        // Input grades, credit hours, and whether the course is Honors for each class
        for (int i = 0; i < numClasses; i++) {
            System.out.println("\nEnter details for Class " + (i + 1) + ":");

            if (i == 0) {
                // Ask if the first class is an Early Bird class
                System.out.print("Is Class 1 an Early Bird class? (true/false): ");
                isFirstClassEarlyBird = scanner.nextBoolean();
            }

            if (inputMethod == 'P') {
                // Input as a percentage
                System.out.print("Enter the percentage grade (0-100) for Class " + (i + 1) + ": ");
                grades[i] = scanner.nextDouble();
            } else if (inputMethod == 'L') {
                // Input as a letter grade
                System.out.print("Enter the letter grade for Class " + (i + 1) + ": ");
                letterGrades[i] = scanner.next().toUpperCase();
            } else {
                System.out.println("Invalid input method choice. Exiting...");
                return;
            }

            System.out.print("Enter the credit hours for Class " + (i + 1) + ": ");
            creditHours[i] = scanner.nextInt();

            System.out.print("Is Class " + (i + 1) + " an Honors course? (true/false): ");
            isHonors[i] = scanner.nextBoolean();
        }

        // Calculate unweighted GPA
        double unweightedGPA;
        if (inputMethod == 'P') {
            unweightedGPA = calculateUnweightedGPA(grades, creditHours);
        } else {
            unweightedGPA = calculateUnweightedGPA(letterGrades, creditHours);
        }

        // Calculate weighted GPA
        double weightedGPA;
        if (inputMethod == 'P') {
            weightedGPA = calculateWeightedGPA(grades, creditHours, isHonors, isFirstClassEarlyBird);
        } else {
            weightedGPA = calculateWeightedGPA(letterGrades, creditHours, isHonors, isFirstClassEarlyBird);
        }

        // Display results
        System.out.println("\nOverall Unweighted GPA: " + unweightedGPA);
        System.out.println("Overall Weighted GPA: " + weightedGPA);

        scanner.close();
    }

    // Function to calculate unweighted GPA on a 4.0 scale
    private static double calculateUnweightedGPA(double[] grades, int[] creditHours) {
        double totalQualityPoints = 0;
        int totalCreditHours = 0;

        for (int i = 0; i < grades.length; i++) {
            totalQualityPoints += convertGradeToScale(grades[i]) * creditHours[i];
            totalCreditHours += creditHours[i];
        }

        return totalQualityPoints / totalCreditHours;
    }

    // Function to calculate unweighted GPA on a 4.0 scale using letter grades
    private static double calculateUnweightedGPA(String[] letterGrades, int[] creditHours) {
        double totalQualityPoints = 0;
        int totalCreditHours = 0;

        for (int i = 0; i < letterGrades.length; i++) {
            totalQualityPoints += convertLetterGradeToScale(letterGrades[i]) * creditHours[i];
            totalCreditHours += creditHours[i];
        }

        return totalQualityPoints / totalCreditHours;
    }

    // Function to calculate weighted GPA on a 5.0 scale
    private static double calculateWeightedGPA(double[] grades, int[] creditHours, boolean[] isHonors, boolean isFirstClassEarlyBird) {
        double totalQualityPoints = 0;
        int totalCreditHours = 0;

        for (int i = 0; i < grades.length; i++) {
            if (isHonors[i] && !isFirstClassEarlyBird) {
                totalQualityPoints += convertGradeToWeightedScale(grades[i]) * creditHours[i];
            } else {
                totalQualityPoints += convertGradeToScale(grades[i]) * creditHours[i];
            }
            totalCreditHours += creditHours[i];
        }

        return totalQualityPoints / totalCreditHours;
    }

    // Function to calculate weighted GPA on a 5.0 scale using letter grades
    private static double calculateWeightedGPA(String[] letterGrades, int[] creditHours, boolean[] isHonors, boolean isFirstClassEarlyBird) {
        double totalQualityPoints = 0;
        int totalCreditHours = 0;

        for (int i = 0; i < letterGrades.length; i++) {
            if (isHonors[i] && !isFirstClassEarlyBird) {
                totalQualityPoints += convertLetterGradeToWeightedScale(letterGrades[i]) * creditHours[i];
            } else {
                totalQualityPoints += convertLetterGradeToScale(letterGrades[i]) * creditHours[i];
            }
            totalCreditHours += creditHours[i];
        }

        return totalQualityPoints / totalCreditHours;
    }

    // Function to convert percentage grades to the specified GPA scale
    private static double convertGradeToScale(double percentageGrade) {
        if (percentageGrade >= 93) {
            return 4.0;
        } else if (percentageGrade >= 90) {
            return 3.67;
        } else if (percentageGrade >= 87) {
            return 3.33;
        } else if (percentageGrade >= 83) {
            return 3.0;
        } else if (percentageGrade >= 80) {
            return 2.67;
        } else if (percentageGrade >= 77) {
            return 2.33;
        } else if (percentageGrade >= 73) {
            return 2.0;
        } else if (percentageGrade >= 70) {
            return 1.67;
        } else if (percentageGrade >= 67) {
            return 1.33;
        } else if (percentageGrade >= 63) {
            return 1.0;
        } else if (percentageGrade >= 60) {
            return 0.67;
        } else {
            return 0.0;
        }
    }
    // Function to convert percentage grades to the specified Weighted GPA scale
    private static double convertGradeToWeightedScale(double percentageGrade) {
        if (percentageGrade >= 93) {
            return 5.0;
        } else if (percentageGrade >= 90) {
            return 4.67;
        } else if (percentageGrade >= 87) {
            return 4.33;
        } else if (percentageGrade >= 83) {
            return 4.0;
        } else if (percentageGrade >= 80) {
            return 3.67;
        } else if (percentageGrade >= 77) {
            return 3.33;
        } else if (percentageGrade >= 73) {
            return 3.0;
        } else if (percentageGrade >= 70) {
            return 2.67;
        } else if (percentageGrade >= 67) {
            return 1.33;
        } else if (percentageGrade >= 63) {
            return 1.0;
        } else if (percentageGrade >= 60) {
            return 0.67;
        } else {
            return 0.0;
        }
    }

    // Function to convert letter grades to the specified GPA scale
    private static double convertLetterGradeToScale(String letterGrade) {
        // Map letter grades to GPA values for an unweighted scale
        switch (letterGrade) {
            case "A": return 4.0;
            case "P": return 4.0;
            case "A-": return 3.67;
            case "B+": return 3.33;
            case "B": return 3.0;
            case "B-": return 2.67;
            case "C+": return 2.33;
            case "C": return 2.0;
            case "C-": return 1.67;
            case "D+": return 1.33;
            case "D": return 1.0;
            case "D-": return 0.67;
            default: return 0.0; // F or any other unrecognized grade
        }
    }

    // Function to convert letter grades to the specified Weighted GPA scale
    private static double convertLetterGradeToWeightedScale(String letterGrade) {
        // Map letter grades to GPA values for a weighted scale
        switch (letterGrade) {
            case "A": return 5.0;
            case "P": return 5.0;
            case "A-": return 4.67;
            case "B+": return 4.33;
            case "B": return 4.0;
            case "B-": return 3.67;
            case "C+": return 3.33;
            case "C": return 3.0;
            case "C-": return 2.67;
            case "D+": return 1.33;
            case "D": return 1.0;
            case "D-": return 0.67;
            default: return 0.0; // F or any other unrecognized grade
        }
    }
}
