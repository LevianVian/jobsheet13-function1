public class GradesManagement12 {

    private static final String[] STUDENT_NAMES = {"Sari", "Rina", "Yani", "Dwi", "Lusi"};
    private static final int NUM_WEEKS = 7;
    private static final int NUM_STUDENTS = STUDENT_NAMES.length;

    private static int[][] grades = new int[NUM_STUDENTS][NUM_WEEKS];

    public static void inputGradeData(int[][] data) {
        System.out.println("--- Initializing Grade Data ---");
        
        data[0] = new int[]{20, 19, 25, 20, 10, 0, 10}; 
        data[1] = new int[]{30, 30, 40, 10, 15, 20, 25}; 
        data[2] = new int[]{5, 0, 20, 25, 10, 5, 45}; 
        data[3] = new int[]{50, 0, 7, 8, 0, 30, 60}; 
        data[4] = new int[]{15, 10, 16, 15, 10, 10, 5};
        
        System.out.println("Grade data for " + NUM_STUDENTS + " students over " + NUM_WEEKS + " weeks has been loaded.");
    }

    public static void displayAllGrades(int[][] data) {
        System.out.println("\n--- Weekly Grade Report ---");
        
        System.out.printf("%-8s", "Student");
        for (int w = 0; w < NUM_WEEKS; w++) {
            System.out.printf(" | %-6s", "Week " + (w + 1));
        }
        System.out.println("\n" + "=".repeat(62));

        for (int i = 0; i < NUM_STUDENTS; i++) {
            System.out.printf("%-8s", STUDENT_NAMES[i]);
            for (int j = 0; j < NUM_WEEKS; j++) {
                System.out.printf(" | %-6d", data[i][j]);
            }
            System.out.println();
        }
    }

    public static void findHighestGradeWeek(int[][] data) {
        int maxGrade = -1;
        int maxWeekIndex = -1;
        String studentName = "";

        for (int i = 0; i < NUM_STUDENTS; i++) {
            for (int j = 0; j < NUM_WEEKS; j++) {
                if (data[i][j] > maxGrade) {
                    maxGrade = data[i][j];
                    maxWeekIndex = j;
                    studentName = STUDENT_NAMES[i];
                }
            }
        }
        
        System.out.println("\n--- Highest Grade Week ---");
        System.out.println("The highest single grade among all students is" + maxGrade + ".");
        System.out.println("It was achieved by " + studentName + " in Week " + (maxWeekIndex + 1) + ".");
    }

    public static void findHighestScoringStudent(int[][] data) {
        int highestTotalGrade = -1;
        int highestScoringStudentIndex = -1;

        System.out.println("\n--- Highest Total Scoring Student ---");

        for (int i = 0; i < NUM_STUDENTS; i++) {
            int currentTotal = 0;
            for (int j = 0; j < NUM_WEEKS; j++) {
                currentTotal += data[i][j];
            }
            
            if (currentTotal > highestTotalGrade) {
                highestTotalGrade = currentTotal;
                highestScoringStudentIndex = i;
            }
            
            System.out.printf("Total Grade for %s:  %d\n", STUDENT_NAMES[i], currentTotal);
        }

        if (highestScoringStudentIndex != -1) {
            String bestStudent = STUDENT_NAMES[highestScoringStudentIndex];
            System.out.println("\nBased on the total sum of all weekly grades:");
            System.out.println("The student with the highest total grade is " + bestStudent + " with a total of " + highestTotalGrade + ".");
        }
    }
    
    public static void main(String[] args) {
        inputGradeData(grades);
        displayAllGrades(grades);
        findHighestGradeWeek(grades);
        findHighestScoringStudent(grades);
    }
}