public class WeightedGpaCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of courses: ");
        int numCourses = scanner.nextInt();

        double totalCredits = 0.0;
        double totalWeightedPoints = 0.0;

        for (int i = 1; i <= numCourses; i++) {
            System.out.println("Enter the grade for course " + i + " (A, B, C, D, F): ");
            String grade = scanner.next();

            System.out.println("Enter the credit hours for course " + i + ": ");
            int credits = scanner.nextInt();

            double gradePoints = getGradePoints(grade);
            double weightedPoints = gradePoints * credits;

            totalWeightedPoints += weightedPoints;
            totalCredits += credits;
        }

        double weightedGPA = totalWeightedPoints / totalCredits;

        System.out.println("Weighted GPA on a 5.0 scale: " + weightedGPA);
    }

    private static double getGradePoints(String grade) {
        switch (grade.toUpperCase()) {
            case "A":
                return 5.0;
            case "B":
                return 4.0;
            case "C":
                return 3.0;
            case "D":
                return 2.0;
            case "F":
                return 0.0;
            default:
                System.out.println("Invalid grade entered. Defaulting to 0.0 points.");
                return 0.0;
        }
    }
}
}
