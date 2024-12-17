package googleclassroom;

import java.util.*;

public class Classroom {
    static Scanner input = new Scanner(System.in);
    //class info
    static String className = "";
    static String section = "";
    static String room = "";
    static String subject = "";

    //next Classroom
    private Classroom next;
    public void setNext(Classroom c) {
        next = c;
    }
    public Classroom getNext() {
        return next;
    }

    public Classroom(Classroom c) {
        className = c.getClassName();
        section = c.getSection();
        room = c.getRoom();
        subject = c.getSubject();
    }

    public Classroom() {
        className = null;
        section = null;
        room = null;
        subject = null;
    }

    //setters and getters
    public void setClassName(String s) {
        className = s;
    }
    public String getClassName() {
        return className;
    }
    public void setSection(String s) {
        section = s;
    }
    public String getSection() {
        return section;
    }
    public void setRoom(String s) {
        room = s;
    }
    public String getRoom() {
        return room;
    }
    public void setSubject(String s) {
        subject = s;
    }
    public String getSubject() { return subject;}


    // A methods that creates a new Class in the Google Classroom.
    public static Classroom createClass() {
        Classroom newClass = new Classroom();

        System.out.println("Class name: ");
        className = input.nextLine();

        System.out.println("Section: ");
        section = input.nextLine();

        System.out.println("Room");
        room = input.nextLine();

        System.out.println("Subject:");
        subject = input.nextLine();

        System.out.println("Classroom successfully created.");

        return newClass;
    }

    //print all classes
    public static void print(Classroom a){
        if(className == null) {
            System.out.println("No classes found!");
        }
        while (a.next != null) {
            System.out.println(a.getClassName());
        }
    }

    // A methods that displays the menu of the Network class.
    public static void printMenu(){
        System.out.println("○--------- MENU ---------○");
        System.out.println("[1] Stream");
        System.out.println("[2] Classworks");
        System.out.println("[3] People");
        System.out.println("[4] Classroom Setting");
        System.out.println("[5] Exit");
        int menuChoice = enterChoice(1, 5);
        switch (menuChoice){
            case 1: stream();
            case 2: classwork();
            case 3: people();
            case 4: classSettings();
            case 5: System.exit(0);
        }
    }

    // A method that displays options for the class stream.
    public static void stream() {
        MySinglyLinkedList<String> streamPost = new MySinglyLinkedList<>();
        Scanner input = new Scanner(System.in);
        String post;
        int menuChoice;

        streamPost.add("We will have a meeting today at 9:00 AM.");
        streamPost.add("Good day everyone! We have a quiz tomorrow.");
        streamPost.add("Kindly read the material for tomorrow's discussion.");
        streamPost.add("Good day! Please be reminded of the deadline of the project.");

        do {
            System.out.println("○----- Stream in " + className + " -----○");
            System.out.println("[1] Post");
            System.out.println("[2] Back to Menu");
            menuChoice = enterChoice(1, 2);
            switch (menuChoice) {
                case 1:
                    do {
                        System.out.println("○--------- Post on Stream ---------○");
                        System.out.println("[1] Create Announcements");
                        System.out.println("[2] View Announcements");
                        System.out.println("[3] Edit Announcements");
                        System.out.println("[4] Delete Announcements");
                        System.out.println("[5] Get the Announcement to Reuse");
                        System.out.println("[6] Back to Stream");
                        menuChoice = enterChoice(1, 6);
                        switch (menuChoice) {
                            case 1 -> {
                                System.out.println("○--------------- Create Announcements ---------------○");
                                System.out.println("Announce something to your class");
                                System.out.println("Type an announcement below and press enter to post:");
                                post = input.nextLine();
                                streamPost.add(post);
                                System.out.println("Your announcement is now posted!\n");
                            }
                            case 2 -> {
                                System.out.println("○----- List of Announcements -----○");
                                streamPost.print();
                                System.out.println();
                            }
                            case 3 -> {
                                System.out.println("○------------- Edit Announcements -------------○");
                                System.out.println("Enter the announcement that you want to edit:");
                                post = input.nextLine();
                                streamPost.delete(post);
                                System.out.println("Enter the edited announcement:");
                                post = input.nextLine();
                                streamPost.add(post);
                                System.out.println("Your announcement has been edited!\n");
                            }
                            case 4 -> {
                                System.out.println("○------------- Delete Announcements -------------○");
                                System.out.println("Enter the announcement that you want to delete: ");
                                post = input.nextLine();
                                if (streamPost.delete(post))
                                    System.out.println("\nThe post " + post + " has been deleted from the announcements.\n");
                                else
                                    System.out.println("\nThe post " + post + " has NOT been deleted from the announcements.\n");
                            }
                            case 5 -> {
                                System.out.println("○---------------- Reuse Post ----------------○");
                                System.out.println("Get an announcement to would like to reuse:");
                                post = input.nextLine();
                                streamPost.getElement(post);
                            }
                            case 6 -> stream();
                        }
                    } while (menuChoice != 6);
                    break;

                case 2:
                    printMenu();
                    break;
            }
        } while (menuChoice != 2);
    }

    // A method that displays the classwork of the class.
    public static void classwork() {
        MySinglyLinkedList<String> assignment = new MySinglyLinkedList<>();
        MySinglyLinkedList<String> studentClassWork = new MySinglyLinkedList<>();
        MySinglyLinkedList<String> question = new MySinglyLinkedList<>();
        MySinglyLinkedList<String> material = new MySinglyLinkedList<>();
        MySinglyLinkedList<String> topic = new MySinglyLinkedList<>();
        Scanner input = new Scanner(System.in);
        String classwork;
        int menuChoice;

        studentClassWork.add("Jhunisa Mae Montilla [Turned In]");
        studentClassWork.add("Faye Natania Naval [Turned In]");
        studentClassWork.add("Psalmer Balanza [Turned In]");
        studentClassWork.add("Kresha Mae Payanay [Turned In]");
        studentClassWork.add("Chistiane Pasigon [Turned In]");
        studentClassWork.add("Leoneil Palafox [Turned In]");

        assignment.add("Individual Activities");
        assignment.add("Project 1");
        assignment.add("Prelim Exercise 1");
        assignment.add("Prelims Exercise 2");

        material.add("Course Syllabus");
        material.add("Academic Calendar");
        material.add("Module 1");
        material.add("Prelim Module Lec");

        topic.add("Modules and Exercises");
        topic.add("Course Syllabus");
        topic.add("Other Materials");
        topic.add("Prelims");

        do {
            System.out.println("○----- Classworks -----○");
            System.out.println("[1] Assignment");
            System.out.println("[2] Question");
            System.out.println("[3] Material");
            System.out.println("[4] Topic");
            System.out.println("[5] Back to Menu");
            menuChoice = enterChoice(1, 5);
            switch (menuChoice) {
                case 1:
                    do {
                        System.out.println("○----- Assignment in Classwork -----○");
                        System.out.println("[1] View Student Works");
                        System.out.println("[2] Create Assignments");
                        System.out.println("[3] View Assignments");
                        System.out.println("[4] Edit Assignments");
                        System.out.println("[5] Delete Assignments");
                        System.out.println("[6] Back to Classwork");
                        menuChoice = enterChoice(1, 6);
                        switch (menuChoice) {
                            case 1 -> {
                                System.out.println("○----- View Students' Works -----○");
                                studentClassWork.print();
                                System.out.println();
                            }
                            case 2 -> {
                                System.out.println("○--------------- Create Assignments ---------------○");
                                System.out.println("Type the assignment below and press enter to post:");
                                classwork = input.nextLine();
                                assignment.add(classwork);
                                System.out.println("The assignment is now posted!\n");
                            }
                            case 3 -> {
                                System.out.println("○----- List of Assignments -----○");
                                assignment.print();
                                System.out.println();
                            }
                            case 4 -> {
                                System.out.println("○------------ Edit Assignments ------------○");
                                System.out.println("Enter the assignment that you want to edit:");
                                classwork = input.nextLine();
                                assignment.delete(classwork);
                                System.out.println("Re-enter the edited assignment:");
                                classwork = input.nextLine();
                                assignment.add(classwork);
                                System.out.println("The assignment has been edited!\n");
                            }
                            case 5 -> {
                                System.out.println("○------------ Delete Assignments ------------○");
                                System.out.println("Enter the assignment that you want to delete: ");
                                classwork = input.nextLine();
                                if (assignment.delete(classwork))
                                    System.out.println("\nThe assignment " + classwork + " has been deleted from the classwork.\n");
                                else
                                    System.out.println("\nThe assignment " + classwork + " has NOT been deleted from the classwork.\n");
                            }
                            case 6 -> classwork();
                        }
                    } while (menuChoice != 6);
                    break;

                case 2:
                    do {
                        System.out.println("○----- Question in Classwork -----○");
                        System.out.println("[1] Create Questions");
                        System.out.println("[2] View Questions");
                        System.out.println("[3] Delete Questions");
                        System.out.println("[4] Back to Classwork");
                        menuChoice = enterChoice(1, 4);
                        switch (menuChoice) {
                            case 1:
                                System.out.println("○--------------- Create Questions ---------------○");
                                System.out.println("Type the question below and press enter to post:");
                                classwork = input.nextLine();
                                question.add(classwork);
                                System.out.println("The question is now posted!\n");
                                break;

                            case 2:
                                System.out.println("○----- List of Questions -----○");
                                question.print();
                                System.out.println();

                            case 3:
                                System.out.println("○------------- Delete Questions -------------○");
                                System.out.println("Enter the question that you want to delete: ");
                                classwork = input.nextLine();
                                if (question.delete(classwork))
                                    System.out.println("\nThe question " + classwork + " has been deleted from the list.\n");
                                else
                                    System.out.println("\nThe question " + classwork + " has NOT been deleted from the list.\n");
                                break;

                            case 4:
                                classwork();
                                break;
                        }
                    } while (menuChoice != 4);
                    break;

                case 3:
                    do {
                        System.out.println("○----- Material in Classwork -----○");
                        System.out.println("[1] Create Materials");
                        System.out.println("[2] View Materials");
                        System.out.println("[3] Delete Materials");
                        System.out.println("[4] Back to Classwork");
                        menuChoice = enterChoice(1, 4);
                        switch (menuChoice) {
                            case 1:
                                System.out.println("○--------------- Create Materials ---------------○");
                                System.out.println("Type the material below and press enter to post:");
                                classwork = input.nextLine();
                                material.add(classwork);
                                System.out.println("The material is now posted!\n");
                                break;

                            case 2:
                                System.out.println("○----- List of Materials -----○");
                                material.print();
                                System.out.println();

                            case 3:
                                System.out.println("○-------------- Delete Materials -------------○");
                                System.out.println("Enter the material that you want to delete: ");
                                classwork = input.nextLine();
                                if (material.delete(classwork))
                                    System.out.println("\nThe material " + classwork + " has been deleted from the list.\n");
                                else
                                    System.out.println("\nThe material " + classwork + " has NOT been deleted from the list.\n");
                                break;

                            case 4:
                                classwork();
                                break;
                        }
                    } while (menuChoice != 4);
                    break;

                case 4:
                    do {
                        System.out.println("○----- Topic in Classwork -----○");
                        System.out.println("[1] Add a Topic");
                        System.out.println("[2] View Topics");
                        System.out.println("[3] Rename a Topic");
                        System.out.println("[4] Delete Topics");
                        System.out.println("[5] Back to Classwork");
                        menuChoice = enterChoice(1, 5);
                        switch (menuChoice) {
                            case 1 -> {
                                System.out.println("○-------- Add Topics --------○");
                                System.out.println("Type the name of the topic:");
                                classwork = input.nextLine();
                                topic.add(classwork);
                                System.out.println("The topic is now added!\n");
                            }
                            case 2 -> {
                                System.out.println("○----- List of Topics -----○");
                                topic.print();
                                System.out.println();
                            }
                            case 3 -> {
                                System.out.println("○------------- Rename Topics -------------○");
                                System.out.println("Enter the topic that you want to rename:");
                                classwork = input.nextLine();
                                topic.delete(classwork);
                                System.out.println("Enter the renamed topic:");
                                classwork = input.nextLine();
                                topic.add(classwork);
                                System.out.println("The topic has been renamed!\n");
                            }
                            case 4 -> {
                                System.out.println("○------------- Delete Topics -------------○");
                                System.out.println("Enter the topic that you want to delete: ");
                                classwork = input.nextLine();
                                if (topic.delete(classwork))
                                    System.out.println("\nThe topic " + classwork + " has been deleted from the list.\n");
                                else
                                    System.out.println("\nThe topic " + classwork + " has NOT been deleted from the list.\n");
                            }
                            case 5 -> classwork();
                        }
                    } while (menuChoice != 5);
                    break;

                case 5:
                    printMenu();
                    break;
            }
        } while (menuChoice != 5);
    }

    // A methods that displays the people in the class
    public static void people() {
        MySinglyLinkedList<String> teacherList = new MySinglyLinkedList<>();
        MySinglyLinkedList<String> studentList = new MySinglyLinkedList<>();
        Scanner scan = new Scanner(System.in);
        int userChoice;

        teacherList.add("Ramel Cabanilla");
        studentList.add("Balanza, Psamler Josh");
        studentList.add("Montilla, Jhunisa Mae");
        studentList.add("Naval, Faye Natania");
        studentList.add("Palafox, Leoneil Luis");
        studentList.add("Pasigon, Christiane");
        studentList.add("Payanay, Kresha Mae");

        do{
            System.out.println("○----- People in Network Fundamentals -----○");
            System.out.println("[1] View Teacher List ");
            System.out.println("[2] View Student List");
            System.out.println("[3] Invite Teacher");
            System.out.println("[4] Invite Student ");
            System.out.println("[5] Remove Teacher ");
            System.out.println("[6] Remove Student ");
            System.out.println("[7] Back ");
            userChoice = enterChoice(1, 7);
            switch (userChoice) {
                case 1:
                    teacherList.print();
                    break;
                case 2:
                    studentList.print();
                    break;
                case 3:
                    System.out.print("Invite how many teachers?: ");
                    int inviteTeacher = Integer.parseInt(scan.nextLine());
                    for (int i = 0; i < inviteTeacher; i++) {
                        System.out.println("Invite Teacher " + inviteTeacher + ": ");
                        String teacherName = scan.nextLine();
                        teacherList.add(teacherName);
                    }
                    System.out.println();
                    break;
                case 4:
                    System.out.print("Invite how many students?: ");
                    int inviteStudent = Integer.parseInt(scan.nextLine());
                    for (int i = 0; i < inviteStudent; i++) {
                        System.out.println("Invite Student " + inviteStudent + ": ");
                        String studentName = scan.nextLine();
                        studentList.add(studentName);
                    }
                    System.out.println();
                    break;
                case 5:
                    System.out.print("Remove how many teachers?: ");
                    int removeTeacher = Integer.parseInt(scan.nextLine());
                    for (int i = 0; i < removeTeacher; i++) {
                        System.out.println("Remove Teacher " + removeTeacher + ": ");
                        String teacherName = scan.nextLine();
                        if (teacherList.delete(teacherName)){
                            System.out.println("Teacher " + teacherName + " is deleted.");
                        } else
                            System.out.println("Teacher " + teacherName + "is NOT found.");
                    }
                    System.out.println();
                    break;
                case 6:
                    System.out.print("Remove how many students?: ");
                    int removeStudent = Integer.parseInt(scan.nextLine());
                    for (int i = 0; i < removeStudent; i++) {
                        System.out.println("Remove Teacher " + removeStudent + ": ");
                        String studentName = scan.nextLine();
                        if (teacherList.delete(studentName)){
                            System.out.println("Student " + studentName + " is deleted.");
                        } else
                            System.out.println("Student " + studentName + "is NOT found.");
                    }
                    System.out.println();
                    break;
                case 7:
                    return;
            }
        }while(userChoice != 8);
    }

    // A methods that allow users to modify the settings of the class.
    public static void classSettings(){
        Scanner scan = new Scanner(System.in);
        int userChoice;
        String title = Classroom.createClass().getClassName();
        String section = Classroom.createClass().getSection();
        String room = Classroom.createClass().getRoom();
        String subject = Classroom.createClass().getSubject();

        String classCode = Classroom.RandomString.getAlphaNumericString(7);
        String invitationLink = "";
        MySinglyLinkedList<String> streamSettingList = new MySinglyLinkedList<>();
        MySinglyLinkedList<String> classworkSettingList = new MySinglyLinkedList<>();

        do{
            System.out.println("○----- Class Settings -----○");
            System.out.println("[1] View Current About Class Settings ");
            System.out.println("[2] Update About Class Settings ");
            System.out.println("[3] Access General Class Settings");
            System.out.println("[4] Back ");
            userChoice = enterChoice(1, 4);
            switch (userChoice) {
                case 1:
                    System.out.println("About");
                    System.out.println("Title: " + title);
                    System.out.println("Section: " + section);
                    System.out.println("Room: " + room);
                    System.out.println("Subject: " + subject);
                    break;
                case 2:
                    System.out.println("Update Title into: ");
                    String updateTitle = scan.nextLine();
                    title = updateTitle;
                    System.out.println("Update Description into: ");
                    System.out.println("Update Section into: ");
                    String updateSection = scan.nextLine();
                    section = updateSection;
                    System.out.println("Update Room into: ");
                    String updateRoom = scan.nextLine();
                    room = updateRoom;
                    System.out.println("Update Subject into: ");
                    String updateSubject = scan.nextLine();
                    subject = updateSubject;
                    break;
                case 3:
                    int generalSettingsChoice;
                    do {
                        System.out.println("○----- General Class Settings -----○");
                        System.out.println("[1] Change Class Code ");
                        System.out.println("[2] Change Stream Settings");
                        System.out.println("[3] Change Classwork on the Stream");
                        System.out.println("[4] View General Settings");
                        System.out.println("[5] Back ");
                        generalSettingsChoice = enterChoice(1, 5);
                        switch (generalSettingsChoice) {
                            case 1:
                                int classCodeChoice;
                                System.out.println("○----- Student Invitation Settings -----○");
                                System.out.println("[1] Disable Invitation Code");
                                System.out.println("[2] Reset Invitation Code");
                                classCodeChoice = enterChoice(1, 2);
                                if (classCodeChoice == 1) {
                                    String disableClassCode = null;
                                    classCode = disableClassCode;
                                }
                                if (classCodeChoice == 2) {
                                    System.out.println("Reset Class Code");
                                    String resetClassCode = Classroom.RandomString.getAlphaNumericString(7);
                                    classCode = resetClassCode;
                                }
                                break;
                            case 2:
                                int streamSettingsChoice;
                                System.out.println("○----- Stream Settings -----○");
                                System.out.println("[1] Students can post and comment");
                                System.out.println("[2] Students can only comment");
                                System.out.println("[3] Only teachers can post and comment");
                                streamSettingsChoice = enterChoice(1, 3);
                                if (streamSettingsChoice == 1) {
                                    if (streamSettingList != null) {
                                        streamSettingList.delete("Students can only comment");
                                        streamSettingList.delete("Only teachers can post and comment");
                                    }
                                    streamSettingList.add("Students can post and comment");
                                }
                                else if (streamSettingsChoice == 2) {
                                    if (streamSettingList != null) {
                                        streamSettingList.delete("Students can post and comment");
                                        streamSettingList.delete("Only teachers can post and comment");
                                    }
                                    streamSettingList.add("Students can only comment");
                                }
                                else if (streamSettingsChoice == 3) {
                                    if (streamSettingList != null) {
                                        streamSettingList.delete("Students can post and comment");
                                        streamSettingList.delete("Students can only comment");
                                    }
                                    streamSettingList.add("Only teachers can post and comment");
                                }
                                break;
                            case 3:
                                int classworkSettingsChoice;
                                System.out.println("○----- Classwork on the Stream Settings -----○");
                                System.out.println("[1] Show attachments and details");
                                System.out.println("[2] Show condensed notifications");
                                System.out.println("[3] Hide notifications");
                                System.out.println("[4] Return");
                                classworkSettingsChoice = enterChoice(1, 4);
                                if (classworkSettingsChoice == 1) {
                                    classworkSettingList.delete("Show condensed notifications");
                                    classworkSettingList.delete("Hide notifications");
                                    classworkSettingList.add("Show attachments and details");
                                } else if (classworkSettingsChoice == 2) {
                                    classworkSettingList.add("Show condensed notifications");
                                } else if (classworkSettingsChoice == 3) {
                                    classworkSettingList.add("Hide notifications");
                                }
                                break;
                            case 4:
                                System.out.println("General");
                                System.out.println("Student Invitation Settings");
                                System.out.println("Class Code: " + classCode);
                                System.out.println("Manage Meet Link");
                                System.out.println("Invitation Link : " + invitationLink);
                                System.out.println("Stream Settings");
                                streamSettingList.print();
                                System.out.println("Classwork on the Stream ");
                                classworkSettingList.print();
                                break;
                            case 5:
                                return;
                        }
                    } while (generalSettingsChoice != 6);
                    break;
                case 4:
                    return;
                default:
                    throw new IllegalStateException("Unexpected value: " + userChoice);
            }
        }while(userChoice != 5);
    }

    // A methods that allows users to send a feedback
    public static void sendGoogleFeedback() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Send feedback to Google");
        System.out.println("Tell us how we can improve our product");
        String suggestion = scan.nextLine();
        System.out.println("Thank you for sending your feedback!");
    }

    // A method that allows users to enter a choice and then validates the inputted choice of user.
    public static int enterChoice(int min, int max) {
        int choice;
        Scanner scan = new Scanner(System.in);
        do {
            System.out.print("Input the number corresponding to your choice: ");
            choice = Integer.parseInt(scan.nextLine());
            if (choice < min || choice > max) { // validates choice input
                System.out.println("Invalid Choice! Please ensure that you enter a number from " +
                        min + " to " + max + ".");
            }
        } while (choice < min || choice > max);
        return choice;
    }

    public class RandomString {
        // function to generate a random string of length n
        static String getAlphaNumericString(int n) {
            // chose a Character random from this String
            String AlphaNumericString =  "0123456789" + "abcdefghijklmnopqrstuvxyz";
            // create StringBuffer size of AlphaNumericString
            StringBuilder sb = new StringBuilder(n);
            for (int i = 0; i < n; i++) {
                // generate a random number between
                // 0 to AlphaNumericString variable length
                int index = (int) (AlphaNumericString.length() * Math.random());
                // add Character one by one in end of sb
                sb.append(AlphaNumericString.charAt(index));
            }
            return sb.toString();
        }
    }
}

