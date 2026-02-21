package SmallProject;
import java.util.*;
class Workout {

    private int id;
    private String exerciseName;
    private String date;
    private int duration;
    private int calories;

    public Workout(int id, String exerciseName, String date, int duration, int calories) {
        this.id = id;
        this.exerciseName = exerciseName;
        this.date = date;
        this.duration = duration;
        this.calories = calories;
    }

    public int getId() {
        return id;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public String getDate() {
        return date;
    }

    public int getDuration() {
        return duration;
    }

    public int getCalories() {
        return calories;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    @Override
    public String toString() {
        return id + " | " + exerciseName + " | " + date + " | " + duration + " mins | " + calories + " cal";
    }
}

class WorkoutStorage{

    private final List<Workout> workouts;

    WorkoutStorage(Workout workout){
        workouts = new LinkedList<>();
    }

    public void addWorkout(Workout workout){
        workouts.add(workout);
    }

    public Workout deleteWorkout(int id){
        for(Workout w : workouts){
            if(w.getId() == id){
                workouts.remove(w);
                return w;
            }
        }
        return null;
    }

    public boolean updateWorkout(int id, String exerciseName, String date, int duration, int calories){
        for(Workout w :  workouts){
            if(w.getId() == id){
                w.setExerciseName(exerciseName);
                w.setDate(date);
                w.setDuration(duration);
                w.setCalories(calories);
                return true;
            }
        }
        return false;
    }

    public List<Workout> getAllWorkouts(){
        return workouts;
    }
}

//=============== Hafeez Ullah =======================
//============ SU-24-01-002-063=======================
//================== Stack class ========================
class UndoStack{

    private final Stack<Workout>  stackWorkout;

    UndoStack(){
        stackWorkout = new Stack<>();
    }

    public void push(Workout workout) {
        stackWorkout.push(workout);
    }

    public Workout pop(){
        if(stackWorkout.isEmpty()){
            return null;
        }
        return stackWorkout.pop();
    }

    public boolean isEmpty() {
        return stackWorkout.isEmpty();
    }
}

// ==============BST Node===============
class BSTNode{

    Workout workout;
    BSTNode left;
    BSTNode right;

        public BSTNode(Workout workout) {
            this.workout = workout;
            this.left = null;
            this.right = null;
        }
}

//========== BST class ==============

class WorkoutBST {

    private BSTNode root;

    public WorkoutBST() {
        root = null;
    }

    public void insert(Workout workout) {
        if (workout == null) return;
        root = insertRec(root, workout);
    }

    private BSTNode insertRec(BSTNode root, Workout workout) {
        if (root == null) {
            return new BSTNode(workout);
        }
        if (workout.getCalories() < root.workout.getCalories()) {
            root.left = insertRec(root.left, workout);
        } else {
            root.right = insertRec(root.right, workout);
        }
        return root;
    }

    public List<Workout> inorder() {
        List<Workout> list = new ArrayList<>();
        inorderRec(root, list);
        return list;
    }

    private void inorderRec(BSTNode root, List<Workout> list) {
        if (root != null) {
            inorderRec(root.left, list);
            list.add(root.workout);
            inorderRec(root.right, list);
        }
    }

}

class SearchService{

    public List<Workout> searchByExercise(List<Workout> workouts, String exerciseName) {
        List<Workout> result = new LinkedList<>();
        for(Workout w : workouts){
            if(w.getExerciseName().equalsIgnoreCase(exerciseName)){
                result.add(w);
            }
        }
        return result;
    }
}



class SortService {

    public void bubbleSort(List<Workout> workouts, String sortBy) {
        int n = workouts.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (compare(workouts.get(j), workouts.get(j + 1), sortBy) > 0) {
                    Workout temp = workouts.get(j);
                    workouts.set(j, workouts.get(j + 1));
                    workouts.set(j + 1, temp);
                }
            }
        }
    }

    private int compare(Workout w1, Workout w2, String sortBy) {
        switch (sortBy.toLowerCase()) {
            case "date":
                return w1.getDate().compareTo(w2.getDate());
            case "duration":
                return Integer.compare(w1.getDuration(), w2.getDuration());
            case "calories":
                return Integer.compare(w1.getCalories(), w2.getCalories());
            default:
                return 0;
        }
    }
}

class ProgressAnalyzer {

    public int calculateTotalCalories(List<Workout> workouts) {
        int total = 0;
        for (Workout w : workouts) {
            total += w.getCalories();
        }
        return total;
    }

    public Workout getHighestCalorieWorkout(List<Workout> workouts) {
        if (workouts.isEmpty()) return null;
        Workout highest = workouts.get(0);
        for (Workout w : workouts) {
            if (w.getCalories() > highest.getCalories()) {
                highest = w;
            }
        }
        return highest;
    }

    public String analyzeTrend(List<Workout> workouts) {
        if (workouts.size() < 2) {
            return "Not enough data for trend analysis";
        }
        boolean increasing = true;
        boolean decreasing = true;
        for (int i = 1; i < workouts.size(); i++) {
            if (workouts.get(i).getCalories() >
                    workouts.get(i - 1).getCalories()) {

                decreasing = false;
            }
            else if (workouts.get(i).getCalories() <
                    workouts.get(i - 1).getCalories()) {

                increasing = false;
            }
        }
        if (increasing) return "Calories Trend: Increasing ";
        if (decreasing) return "Calories Trend: Decreasing ";

        return "Calories Trend: Fluctuating ";
    }
}



public class FitnessTrackerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Workout out = new Workout(0 , null,null,0 , 0);
        WorkoutBST bst = new WorkoutBST();
        WorkoutStorage storage = new WorkoutStorage(out);
        UndoStack undoStack = new UndoStack();
        SearchService searchService = new SearchService();
        SortService sortService = new SortService();
        ProgressAnalyzer analyzer = new ProgressAnalyzer();


        while (true) {

            System.out.println("\n=== Fitness Progress Tracker ===");
            System.out.println("1. Add Workout");
            System.out.println("2. Delete Workout");
            System.out.println("3. Update Workout");
            System.out.println("4. View All Records");
            System.out.println("5. Search Workout");
            System.out.println("6. Sort Workouts");
            System.out.println("7. Undo Last Delete");
            System.out.println("8. Analyze Progress");
            System.out.println("9. Exit");

            System.out.print("Choose Option: ");
            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Exercise Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Date: ");
                    String date = scanner.nextLine();
                    System.out.print("Duration: ");
                    int duration = scanner.nextInt();
                    System.out.print("Calories: ");
                    int calories = scanner.nextInt();
                    Workout w = new Workout(id, name, date, duration, calories);
                    storage.addWorkout(w);
                    bst.insert(w);
                    System.out.println("Workout Added Successfully");
                    break;

                case 2:
                    System.out.print("Enter ID to Delete: ");
                    int deleteId = scanner.nextInt();
                    Workout deleted = storage.deleteWorkout(deleteId);
                    if (deleted != null) {
                        undoStack.push(deleted);
                        System.out.println("Deleted Successfully");
                    } else {
                        System.out.println("Workout Not Found");
                    }
                    break;

                case 3:
                    System.out.print("Enter ID to Update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("New Exercise: ");
                    String newName = scanner.nextLine();
                    System.out.print("New Date: ");
                    String newDate = scanner.nextLine();
                    System.out.print("New Duration: ");
                    int newDuration = scanner.nextInt();
                    System.out.print("New Calories: ");
                    int newCalories = scanner.nextInt();
                    storage.updateWorkout(updateId, newName, newDate, newDuration, newCalories);
                    break;

                case 4:
                    for (Workout workout : storage.getAllWorkouts()) {
                        System.out.println(workout);
                    }
                    break;

                case 5:
                    System.out.print("Enter Exercise name to Search: ");
                    scanner.nextLine();
                    String searchExercise = scanner.nextLine();
                    List<Workout> results =
                            searchService.searchByExercise(storage.getAllWorkouts(), searchExercise);
                    for (Workout result : results) {
                        System.out.println(result);
                    }
                    break;

                case 6:
                    System.out.println("\nWorkouts Sorted by Calories (Using BST):");
                    List<Workout> sortedList = bst.inorder();
                    for (Workout workout : sortedList) {
                        System.out.println(workout);
                    }
                    break;

                case 7:
                    if (!undoStack.isEmpty()) {
                        Workout restored = undoStack.pop();
                        storage.addWorkout(restored);
                        System.out.println("Undo Successful");
                    } else {
                        System.out.println("Nothing to Undo");
                    }
                    break;
                case 8:
                    List<Workout> workouts = storage.getAllWorkouts();
                    System.out.println("Total Calories: " +
                            analyzer.calculateTotalCalories(workouts));
                    System.out.println("Highest: " +
                            analyzer.getHighestCalorieWorkout(workouts));
                    System.out.println(analyzer.analyzeTrend(workouts));
                    break;
                case 9:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid Option");
            }
        }
    }
}
