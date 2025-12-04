import java.util.Scanner;

public class GradesManagement12 {

    private static final String[] student_names = {"Sari", "Rina", "Yani", "Dwi", "Lusi"};
    public static int[] getuserinputdimensions() {
        try (Scanner input = new Scanner(System.in)) { 
            System.out.println("--- Setup for Grade Management ---");


            System.out.print("Enter the number of students (max " + student_names.length + "): ");
            int numstudents = input.nextInt(); 
            
            if (numstudents > student_names.length) {
                numstudents = student_names.length;
                System.out.println("Max limit exceeded. setting number of students to 5.");
            } else if (numstudents < 1) {
                numstudents = 1;
            }

            System.out.print("Enter the number of weeks: ");
            int numweeks = input.nextInt();
            if (numweeks < 1) {
                numweeks = 1;
            }

            return new int[]{numstudents, numweeks};
        }
    }

    public static void inputgradedata(int[][] data, int numstudents, int numweeks) {
        System.out.println("\n--- Initializing Grade Data ---");
        
        int[][] initialdata = new int[][]{
            {20, 19, 25, 20, 10, 0, 10}, 
            {30, 30, 40, 10, 15, 20, 25}, 
            {5, 0, 20, 25, 10, 5, 45}, 
            {50, 0, 7, 8, 0, 30, 60}, 
            {15, 10, 16, 15, 10, 10, 5}
        };
        
        for (int i = 0; i < numstudents; i++) {
            for (int j = 0; j < numweeks; j++) {
                if (i < initialdata.length && j < initialdata[i].length) {
                    data[i][j] = initialdata[i][j];
                } else {
                    data[i][j] = 0;
                }
            }
        }

        System.out.println("Grade data for " + numstudents + " Students over " + numweeks + " Weeks has been loaded.");
    }

    public static void displayallgrades(int[][] data, int numstudents, int numweeks) {
        System.out.println("\n--- Weekly Grade Report ---");

        System.out.printf("%-8s", "Student");
        for (int w = 0; w < numweeks; w++) {
            System.out.printf(" | %-6s", "Week " + (w + 1));
        }
        System.out.println("\n" + "=".repeat(8 + (numweeks * 9)));

        for (int i = 0; i < numstudents; i++) {
            System.out.printf("%-8s", student_names[i]);
            for (int j = 0; j < numweeks; j++) {
                System.out.printf(" | %-6d", data[i][j]);
            }
            System.out.println();
        }
    }

    public static void findhighestgradeweek(int[][] data, int numstudents, int numweeks) {
        int maxgrade = -1; 
        int maxweekindex = -1;
        String studentname = "";

        for (int i = 0; i < numstudents; i++) {
            for (int j = 0; j < numweeks; j++) {
                if (data[i][j] > maxgrade) {
                    maxgrade = data[i][j];
                    maxweekindex = j;
                    studentname = student_names[i];
                }
            }
        }

        System.out.println("\n--- Highest Grade Week ---");
        System.out.println("the highest single grade among all students is " + maxgrade + ".");
        System.out.println("it was achieved by " + studentname + " in week " + (maxweekindex + 1) + ".");
    }

    public static void findhighestscoringstudent(int[][] data, int numstudents, int numweeks) {
        int highesttotalgrade = -1;
        int highestscoringstudentindex = -1;

        System.out.println("\n--- Highest Total Scoring Student ---");

        for (int i = 0; i < numstudents; i++) {
            int currenttotal = 0;
            for (int j = 0; j < numweeks; j++) {
                currenttotal += data[i][j];
            }

            if (currenttotal > highesttotalgrade) {
                highesttotalgrade = currenttotal;
                highestscoringstudentindex = i;
            }

            System.out.printf("total grade for %s:  %d\n", student_names[i], currenttotal);
        }

        if (highestscoringstudentindex != -1) {
            String beststudent = student_names[highestscoringstudentindex];
            System.out.println("\nbased on the total sum of all weekly grades:");
            System.out.println("the student with the highest total grade is " + beststudent + " with a total of " + highesttotalgrade + ".");
        }
    }

    public static void main(String[] args) {
        
        int[] dimensions = getuserinputdimensions();
        int numstudents = dimensions[0];
        int numweeks = dimensions[1];
        
        int[][] grades = new int[numstudents][numweeks];

        inputgradedata(grades, numstudents, numweeks);
        displayallgrades(grades, numstudents, numweeks);
        findhighestgradeweek(grades, numstudents, numweeks);
        findhighestscoringstudent(grades, numstudents, numweeks);
    }
}