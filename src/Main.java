import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner scnr = new Scanner(System.in);
    public static Graph initialClasses(){
        Graph schedule = new Graph();
        System.out.println("Enter the classes that the student has taken already. If none, or done," +
                " enter F to finish.");
        String classes = "Placeholder";
        classes = scnr.nextLine();
        while(!classes.contains("F")){
            schedule.addVertex(classes);
            classes = scnr.nextLine();
        }
        return schedule;
    }
    public static void addClasses(Graph schedule){
        String classes = "Placeholder";
        ArrayList<String> prereq = new ArrayList<>();
        System.out.println("Enter the class you wish to add to the schedule. Enter F to finish.");
        classes = scnr.nextLine();
        while(!classes.contains("F")){
            String prereqString = "Placeholder";
            System.out.println("Enter the prerequisite(s) for the class. Enter F to finish.");
            prereqString = scnr.nextLine();
            while(!prereqString.contains("F")){
                prereq.add(prereqString);
                prereqString = scnr.nextLine();
            }
            boolean eligible = true;
            String requirementNotFulfilled = "";
            for(int i = 0; i < prereq.size(); i++){
                if(!schedule.containsName(prereq.get(i))){
                    eligible = false;
                    requirementNotFulfilled = prereq.get(i);
                }
            }
            if(eligible == true){
                for(int i = 0; i < prereq.size(); i++){
                    schedule.addVertex(prereq.get(i));
                    schedule.addEdge(classes, prereq.get(i), 1.0);
                }
            } else {
                System.out.println("Student not eligible for this class. They still need to take " +
                        requirementNotFulfilled);
            }
            for(int i = prereq.size() - 1; i >= 0; i--){
                prereq.remove(i);
            }
            System.out.println("Enter the class you wish to add to the schedule. Enter F to finish.");
            classes = scnr.nextLine();
        }
    }
    public static void main(String[] args){
        Graph schedule = initialClasses();
        addClasses(schedule);
        System.out.println(schedule.toString());
    }
}
