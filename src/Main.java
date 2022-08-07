import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner scnr = new Scanner(System.in);
    public static Graph initialClasses(){
        Graph schedule = new Graph();
        System.out.println("Enter the classes that the student has taken already. If none, or done," +
                " enter F to finish.");
        String classes;
        classes = scnr.nextLine();
        while(!classes.contains("F")){
            schedule.addVertex(classes);
            classes = scnr.nextLine();
        }
        return schedule;
    }
    public static void addClasses(Graph schedule){
        String classes;
        ArrayList<String> prereq = new ArrayList<>();
        System.out.println("Enter the class you wish to add to the schedule. Enter F to finish.");
        classes = scnr.nextLine();
        while(!classes.contains("F")){
            String prereqString;
            System.out.println("Enter the prerequisite(s) for the class. Enter F to finish.");
            prereqString = scnr.nextLine();
            while(!prereqString.contains("F")){
                prereq.add(prereqString);
                prereqString = scnr.nextLine();
            }
            boolean eligible = true;
            String requirementNotFulfilled = "";
            for (String s : prereq) {
                if (!schedule.containsName(s)) {
                    eligible = false;
                    requirementNotFulfilled = s;
                }
            }
            if(eligible){
                for (String s : prereq) {
                    schedule.addVertex(s);
                    schedule.addEdge(classes, s, 1.0);
                }
            } else {
                System.out.println("Student not eligible for this class. They still need to take " +
                        requirementNotFulfilled);
            }
            if (prereq.size() > 0) {
                prereq.subList(0, prereq.size()).clear();
            }
            System.out.println("Enter the class you wish to add to the schedule. Enter F to finish.");
            classes = scnr.nextLine();
        }
    }
    public static void main(String[] args){
        Graph schedule = initialClasses();
        addClasses(schedule);
        System.out.println(schedule);
    }
}
