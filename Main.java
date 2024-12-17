package googleclassroom;
import java.util.Scanner;

//test comment
public class Main{
    private static Scanner scan;

    public static void main(String[] args) {
        int userChoice;
        scan = new Scanner(System.in);

        System.out.println("Welcome to Google Classroom");

        // Displays the main menu of the program
        do{
            System.out.println();
            System.out.println("○--------- Classes ---------○");
            System.out.println("[1] Requirements, Analysis, and Modelling");
            System.out.println("[2] Network Fundamentals");
            System.out.println("[3] Data Structures");
            System.out.println("[4] Create a New Class");
            System.out.println("[5] Exit Program");

            userChoice = enterChoice(1, 4);
            switch (userChoice) {
                case 1: Classroom.printMenu();
                    break;
                case 2: Classroom.printMenu();
                    break;
                case 3: Classroom.printMenu();
                    break;
                case 4:
                    Classroom headClass = new Classroom(Classroom.createClass());
                    System.out.println("Your new Google Classroom is: " + headClass.getClassName() + " " + headClass.getSubject() +
                            " " + headClass.getSection() + " located in " + headClass.getRoom());
                    headClass.setNext(headClass);
                    do{

                        System.out.println();
                        System.out.println("○--------- Classes ---------○");
                        System.out.println("[1] Requirements, Analysis, and Modelling");
                        System.out.println("[2] Network Fundamentals");
                        System.out.println("[3] Data Structures");
                        System.out.println("[4] Create a New Class");
                        System.out.println("[5]" + headClass.getClassName());
                        System.out.println("[6] Exit Program");

                        userChoice = enterChoice(1, 5);
                        switch (userChoice) {
                            case 1: Classroom.printMenu();
                                break;
                            case 2: Classroom.printMenu();
                                break;
                            case 3: Classroom.printMenu();
                                break;
                            case 4: Classroom.printMenu();
                                break;
                            case 5:
                                System.exit(0);
                        } // End of switch case.
                    }while(userChoice != 6);
                    break;
                case 5:
                    System.exit(0);
            } // End of switch case.
        }while(userChoice != 5);
    } // End of main method.

    // A method that allows users to input their choice.
    public static int enterChoice(int min, int max) {
        int choice;

        do {
            System.out.print("Input the number corresponding to your choice: ");
            choice = Integer.parseInt(scan.nextLine());
            if (choice < min || choice > max) { // validates choice input
                System.out.println("Invalid Choice! Please ensure that you enter a number from " +
                        min + " to " + max + ".");
            }
        } while (choice < min || choice > max);
        return choice;
    } // end of enterChoice method
}
