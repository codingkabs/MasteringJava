/*
================================================================================
 Java Arrays & ArrayList – Full Lesson In One File
================================================================================

How to use this file:
- This is a "lesson in code" for someone NEW to programming.
- Read the comments from top to bottom.
- You can run the main method and uncomment example calls to see behaviour.
- Later, complete the PRACTICE TASKS at the bottom.

What this file covers:
1. Arrays – what they are, how to create and use them
2. Looping over arrays (for and for-each)
3. Common array patterns (sum, max, count, search, reverse)
4. ArrayList – what it is and how it differs from arrays
5. Using ArrayList (add, get, set, remove, contains)
6. Looping over ArrayList and common patterns
7. Arrays vs ArrayList comparison
8. Practice questions with TODOs

You can save this file as: ArraysAndListsLesson.java
Then run: ArraysAndListsLesson.main()
*/

import java.util.ArrayList;

public class Arrays_Lists {

    public static void main(String[] args) {

        // ================================
        // UNCOMMENT THESE LINES TO TEST
        // ================================

        // exampleArrayCreation();
        // exampleArrayAccessAndUpdate();
        // exampleArrayLoopFor();
        // exampleArrayLoopForEach();
        // exampleArraySumAndAverage();
        // exampleArrayMaxMin();
        // exampleArraySearch();
        // exampleArrayReversePrint();

        // exampleArrayListCreation();
        // exampleArrayListAddGetSize();
        // exampleArrayListSetRemove();
        // exampleArrayListLoop();
        // exampleArrayListContainsIndexOf();

        System.out.println("Arrays & ArrayList lesson loaded. Uncomment example calls in main() to try them.");
    }

    /*
    ================================================================================
    SECTION 1: ARRAYS – FIXED-SIZE LISTS OF VALUES
    ================================================================================

    An array is:
    - A fixed-size collection of values.
    - All values have the same type (all int, all double, all String, etc).
    - Values are stored in order.
    - Each position has an index, starting from 0.

    Example: marks for 3 exams

        index:   0    1    2
        value:  70   85   90

    We can store this as: int[] marks = {70, 85, 90};
    */

    public static void exampleArrayCreation() {
        // Way 1: create with a fixed size, fill later
        int[] marks = new int[3];  // space for 3 integers, all start as 0

        marks[0] = 70;
        marks[1] = 85;
        marks[2] = 90;

        // Way 2: create and fill at the same time
        int[] moreMarks = {60, 75, 88, 92};

        System.out.println("Example array creation:");
        System.out.println("marks[0] = " + marks[0]);
        System.out.println("marks[1] = " + marks[1]);
        System.out.println("marks[2] = " + marks[2]);
        System.out.println("length of marks = " + marks.length);

        System.out.println("moreMarks[0] = " + moreMarks[0]);
        System.out.println("moreMarks[3] = " + moreMarks[3]);
        System.out.println("length of moreMarks = " + moreMarks.length);
    }

    /*
    Accessing array elements:
        - Use the index inside [].
        - First element is index 0.
        - Last element is index length - 1.
    */

    public static void exampleArrayAccessAndUpdate() {
        String[] subjects = {"Maths", "English", "Computer Science"};

        System.out.println("First subject: " + subjects[0]);
        System.out.println("Second subject: " + subjects[1]);
        System.out.println("Third subject: " + subjects[2]);

        // Update a value
        subjects[1] = "English Literature";
        System.out.println("Updated second subject: " + subjects[1]);
    }

    /*
    ================================================================================
    SECTION 2: LOOPING OVER ARRAYS – FOR AND FOR-EACH
    ================================================================================

    We almost always use loops with arrays.

    Normal for loop (uses index):
        for (int i = 0; i < array.length; i++) {
            array[i]
        }

    Use when:
    - You need the index (position).
    - You want to modify elements.
    - You want to loop backwards or skip positions.

    Enhanced for loop (for-each):
        for (Type value : array) {
            value
        }

    Use when:
    - You just want to READ each value.
    - You do not care about the index.
    */

    public static void exampleArrayLoopFor() {
        int[] scores = {10, 20, 30, 40};

        System.out.println("Looping with normal for (using index):");
        for (int i = 0; i < scores.length; i++) {
            System.out.println("Index " + i + " has value " + scores[i]);
        }
    }

    public static void exampleArrayLoopForEach() {
        int[] scores = {10, 20, 30, 40};

        System.out.println("Looping with for-each:");
        for (int score : scores) {
            System.out.println("Score = " + score);
        }
    }

    /*
    ================================================================================
    SECTION 3: COMMON ARRAY PATTERNS
    ================================================================================

    Pattern 1: Sum and average of array values.
    Pattern 2: Find the maximum and minimum.
    Pattern 3: Count values that match a condition.
    Pattern 4: Search for a value.
    Pattern 5: Reverse print.
    */

    // Pattern 1: Sum and average
    public static void exampleArraySumAndAverage() {
        int[] marks = {70, 85, 90, 60};
        int sum = 0;

        // sum all marks
        for (int i = 0; i < marks.length; i++) {
            sum += marks[i];
        }

        // average = sum / number of items
        double average = 0.0;
        if (marks.length > 0) {
            average = (double) sum / marks.length;
        }

        System.out.println("Sum of marks = " + sum);
        System.out.println("Average mark = " + average);
    }

    // Pattern 2: Find max and min
    public static void exampleArrayMaxMin() {
        int[] marks = {70, 85, 90, 60, 99};

        // assume at least one element
        int max = marks[0];
        int min = marks[0];

        for (int i = 1; i < marks.length; i++) {
            if (marks[i] > max) {
                max = marks[i];
            }
            if (marks[i] < min) {
                min = marks[i];
            }
        }

        System.out.println("Max mark = " + max);
        System.out.println("Min mark = " + min);
    }

    // Pattern 3 & 4: Count / Search
    public static void exampleArraySearch() {
        int[] marks = {50, 60, 70, 60, 80};
        int target = 60;

        // count how many times 60 appears
        int count = 0;
        int firstIndex = -1;

        for (int i = 0; i < marks.length; i++) {
            if (marks[i] == target) {
                count++;
                if (firstIndex == -1) {
                    firstIndex = i;
                }
            }
        }

        System.out.println("Target " + target + " appears " + count + " times.");
        System.out.println("First index of " + target + " is " + firstIndex);
    }

    // Pattern 5: Reverse print
    public static void exampleArrayReversePrint() {
        String[] subjects = {"Maths", "English", "Computer Science", "OOP"};

        System.out.println("Subjects in normal order:");
        for (int i = 0; i < subjects.length; i++) {
            System.out.println(subjects[i]);
        }

        System.out.println("Subjects in reverse order:");
        for (int i = subjects.length - 1; i >= 0; i--) {
            System.out.println(subjects[i]);
        }
    }

    /*
    ================================================================================
    SECTION 4: ARRAYLIST – RESIZABLE LIST
    ================================================================================

    An ArrayList is similar to an array, but:
    - It can grow and shrink.
    - It has built-in methods like add, remove, get, size.
    - You write ArrayList<Type> with a wrapper type (Integer, Double, String, etc).

    You must import java.util.ArrayList to use it.
    */

    public static void exampleArrayListCreation() {
        // Create an empty list of Strings
        ArrayList<String> students = new ArrayList<>();

        // Add some names
        students.add("Kabir");
        students.add("Aisha");
        students.add("Tom");

        System.out.println("ArrayList creation example:");
        System.out.println("Number of students: " + students.size());
        System.out.println("First student: " + students.get(0));
    }

    public static void exampleArrayListAddGetSize() {
        ArrayList<Integer> marks = new ArrayList<>();

        marks.add(70);
        marks.add(85);
        marks.add(90);

        System.out.println("Marks list size: " + marks.size());
        System.out.println("First mark: " + marks.get(0));
        System.out.println("Second mark: " + marks.get(1));
        System.out.println("Third mark: " + marks.get(2));
    }

    /*
    Updating and removing elements:
    - set(index, value) changes an element.
    - remove(index) removes an element and shifts the rest left.
    */

    public static void exampleArrayListSetRemove() {
        ArrayList<String> subjects = new ArrayList<>();
        subjects.add("Maths");
        subjects.add("Eng");
        subjects.add("CS");

        System.out.println("Original subjects:");
        System.out.println(subjects);

        // Update index 1
        subjects.set(1, "English");
        System.out.println("After set(1, \"English\"):");
        System.out.println(subjects);

        // Remove the subject at index 0
        subjects.remove(0);
        System.out.println("After remove(0):");
        System.out.println(subjects);
    }

    /*
    Looping over an ArrayList

    We can use:
    - normal for loop with index: i from 0 to size() - 1
    - for-each loop: for (Type value : list)

    size() is like length for ArrayList.
    */

    public static void exampleArrayListLoop() {
        ArrayList<String> subjects = new ArrayList<>();
        subjects.add("Maths");
        subjects.add("English");
        subjects.add("Computer Science");

        System.out.println("Looping with normal for loop:");
        for (int i = 0; i < subjects.size(); i++) {
            System.out.println("Index " + i + ": " + subjects.get(i));
        }

        System.out.println("Looping with for-each:");
        for (String subject : subjects) {
            System.out.println("Subject: " + subject);
        }
    }

    /*
    Checking for values:

    - contains(value): returns true if list has the value.
    - indexOf(value): returns first index of value, or -1 if not found.
    */

    public static void exampleArrayListContainsIndexOf() {
        ArrayList<String> students = new ArrayList<>();
        students.add("Kabir");
        students.add("Aisha");
        students.add("Tom");

        System.out.println("Students: " + students);

        boolean hasKabir = students.contains("Kabir");
        boolean hasJohn = students.contains("John");

        System.out.println("Contains Kabir? " + hasKabir);
        System.out.println("Contains John? " + hasJohn);

        int indexOfAisha = students.indexOf("Aisha");
        int indexOfJohn = students.indexOf("John");

        System.out.println("Index of Aisha: " + indexOfAisha);
        System.out.println("Index of John: " + indexOfJohn); // -1 means not found
    }

    /*
    ================================================================================
    SECTION 5: ARRAYS VS ARRAYLIST – WHEN TO USE WHICH
    ================================================================================

    Arrays:
    - Fixed size.
    - Syntax: type[] name.
    - Length: array.length.
    - Faster, more low-level.
    - Good for algorithms, fixed data, performance.

    ArrayList:
    - Resizable (can add/remove).
    - Syntax: ArrayList<Type> name = new ArrayList<>();
    - Length: list.size().
    - Has many helpful methods.
    - Good for real-world modelling (students, videos, tasks, etc).

    Simple rule:
    - Use arrays when size is fixed or in algorithm questions.
    - Use ArrayList when size can change or in most application code.
    */

    /*
    ================================================================================
    SECTION 6: PRACTICE TASKS – IMPLEMENT THESE YOURSELF
    ================================================================================

    Rules:
    - Do NOT change the method signatures (name, parameters, return type).
    - Implement the logic inside each method.
    - In main(), call your methods with test values to check they work.

    Example:
        int[] numbers = {1, 2, 3};
        System.out.println(arraySum(numbers)); // expect 6
    */

    // =========================
    // TASK 1: arraySum
    // =========================
    /*
     * Given an array of ints, return the sum of all elements.
     * If the array is empty, return 0.
     */
    public static int arraySum(int[] numbers) {
        // TODO: implement this
        return 0; // placeholder
    }

    // =========================
    // TASK 2: arrayAverage
    // =========================
    /*
     * Given an array of ints, return the average as a double.
     * If the array is empty, return 0.0.
     */
    public static double arrayAverage(int[] numbers) {
        // TODO: implement this
        return 0.0; // placeholder
    }

    // =========================
    // TASK 3: arrayMax
    // =========================
    /*
     * Given a non-empty array of ints, return the maximum value.
     */
    public static int arrayMax(int[] numbers) {
        // TODO: implement this
        return 0; // placeholder
    }

    // =========================
    // TASK 4: countGreaterThan
    // =========================
    /*
     * Given an array of ints and a threshold, return how many values are strictly
     * greater than the threshold.
     */
    public static int countGreaterThan(int[] numbers, int threshold) {
        // TODO: implement this
        return 0; // placeholder
    }

    // =========================
    // TASK 5: containsValue (array)
    // =========================
    /*
     * Given an array of ints and a target, return true if target appears in the
     * array, false otherwise.
     */
    public static boolean containsValue(int[] numbers, int target) {
        // TODO: implement this
        return false; // placeholder
    }

    // =========================
    // TASK 6: reverseArrayInPlace
    // =========================
    /*
     * Given an array of ints, reverse the elements IN PLACE.
     * Example: [1, 2, 3, 4] becomes [4, 3, 2, 1].
     * You must modify the original array (do not return a new one).
     */
    public static void reverseArrayInPlace(int[] numbers) {
        // TODO: implement this
    }

    // =========================
    // TASK 7: toStringArray
    // =========================
    /*
     * Given an array of Strings, return a single String that joins them with commas.
     * Example: ["a", "b", "c"] → "a, b, c"
     * Hint: build up a result String in a loop.
     */
    public static String toStringArray(String[] words) {
        // TODO: implement this
        return ""; // placeholder
    }

    // =========================
    // TASK 8: listSum
    // =========================
    /*
     * Given an ArrayList<Integer>, return the sum of all elements.
     * If the list is empty, return 0.
     */
    public static int listSum(ArrayList<Integer> numbers) {
        // TODO: implement this
        return 0; // placeholder
    }

    // =========================
    // TASK 9: listAverage
    // =========================
    /*
     * Given an ArrayList<Integer>, return the average as a double.
     * If the list is empty, return 0.0.
     */
    public static double listAverage(ArrayList<Integer> numbers) {
        // TODO: implement this
        return 0.0; // placeholder
    }

    // =========================
    // TASK 10: removeNegatives
    // =========================
    /*
     * Given an ArrayList<Integer>, remove all negative numbers from the list.
     * You should modify the list passed in.
     *
     * Hint: be careful when removing while looping by index.
     */
    public static void removeNegatives(ArrayList<Integer> numbers) {
        // TODO: implement this
    }

    // =========================
    // TASK 11: listContainsIgnoreCase
    // =========================
    /*
     * Given an ArrayList<String> and a target String, return true if the list
     * contains the target, ignoring case.
     *
     * Example: ["Kabir", "Alice"], target "kabir" → true
     */
    public static boolean listContainsIgnoreCase(ArrayList<String> words, String target) {
        // TODO: implement this
        return false; // placeholder
    }

    // =========================
    // TASK 12: copyArrayToList
    // =========================
    /*
     * Given an array of ints, create and return a new ArrayList<Integer> that
     * contains the same values in the same order.
     */
    public static ArrayList<Integer> copyArrayToList(int[] numbers) {
        // TODO: implement this
        return null; // placeholder
    }

    /*
    ================================================================================
    HOW TO PRACTISE WITH THIS FILE
    ================================================================================

    1. Go to each TODO method and implement the logic.
    2. In main(), create test arrays and ArrayLists and call your methods.
    3. Print the results and check they match what you expect.
    4. If something does not work, add printlns inside your methods to debug.
    5. Once these feel easy, you will be very comfortable with:
        - Arrays
        - ArrayList
        - Loops (for and for-each)
        - Basic data manipulation patterns
    */
}
