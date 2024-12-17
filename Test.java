package googleclassroom;

public class Test {
    public static void main(String [] args) {
        Classroom first = new Classroom();
        first.setClassName("First");
        Classroom second = new Classroom();
        second.setClassName("second");
        first.setNext(second);
        System.out.println("First class is: " + first.getClassName());
        first = first.getNext();
        System.out.println("Second class is: " + first.getClassName());
        SearchNodes<String> first12 = new SearchNodes<>();
        first12.add("second");
        first12.add("third");
        first12.printParent();
    }
}
