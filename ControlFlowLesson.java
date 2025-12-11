/*
================================================================================
 Java Control Flow & Basics – Full Lesson In One File
================================================================================

How to use this file:
- This is a "lesson in code" for someone NEW to programming.
- Read the comments from top to bottom.
- You can run the main method and uncomment example calls to see behaviour.
- Later, complete the PRACTICE TASKS at the bottom.

What this file covers:
1. If / else basics (making decisions)
2. Comparison & logical operators
3. for loops (repeat a fixed number of times)
4. while and do-while loops (repeat until a condition changes)
5. switch statements
6. Arrays (as a bridge to collections)
7. Practice questions with TODOs

You can save this file as: ControlFlowLesson.java
Then run: ControlFlowLesson.main()
*/

public class ControlFlowLesson {

    public static void main(String[] args) {

        // ================================
        // UNCOMMENT THESE LINES TO TEST
        // ================================

        exampleIfElseBasic();
        exampleIfElseMultiple();
        // exampleLogicalOperators();
        // exampleForLoop();
        // exampleForLoopReverse();
        // exampleWhileLoop();
        // exampleDoWhileLoop();
        // exampleSwitchBasic();
        // exampleArrayBasics();
        // exampleArrayLoop();

        System.out.println("Lesson file loaded. Uncomment example calls in main() to try them.");
    }

    /*
    ================================================================================
    SECTION 1: IF / ELSE – MAKING DECISIONS
    ================================================================================

    In programming, we often need to run different code depending on a condition.

    Example in real life:
        - If it is raining → take an umbrella
        - Else → do not take an umbrella

    In Java:

        if (condition) {
            // code that runs if condition is true
        } else {
            // code that runs if condition is false
        }

    A condition is something that is either TRUE or FALSE.
    */

    public static void exampleIfElseBasic() {
        int age = 17;

        if (age >= 18) {
            System.out.println("You are an adult.");
        } else {
            System.out.println("You are under 18.");
        }
    }

    /*
    You can chain conditions using else if:

        if (condition1) {
            ...
        } else if (condition2) {
            ...
        } else {
            ...
        }
    */

    public static void exampleIfElseMultiple() {
        int mark = 72;

        if (mark >= 70) {
            System.out.println("Grade: A");
        } 
        else if (mark >= 60) {
            System.out.println("Grade: B");
        } 
        else if (mark >= 50) {
            System.out.println("Grade: C");
        } 
        else {
            System.out.println("Grade: Fail");
        }
    }

    /*
    ================================================================================
    SECTION 2: COMPARISON & LOGICAL OPERATORS
    ================================================================================

    Comparison operators (used inside conditions):

        ==  equal to
        !=  not equal to
        >   greater than
        <   less than
        >=  greater than or equal to
        <=  less than or equal to

    Logical operators (combine conditions):

        &&  AND     (both conditions must be true)
        ||  OR      (at least one condition is true)
        !   NOT     (flips true/false)

    Example:
        if (age >= 18 && age <= 25) { ... }
    */

    public static void exampleLogicalOperators() {
        int age = 20;
        boolean hasStudentCard = true;

        // Offer a discount if:
        // age is between 18 and 25 AND they have a student card
        if (age >= 18 && age <= 25 && hasStudentCard) {
            System.out.println("You get a student discount.");
        } else {
            System.out.println("No discount.");
        }
    }

    /*
    ================================================================================
    SECTION 3: FOR LOOPS – REPEATING A FIXED NUMBER OF TIMES
    ================================================================================

    A loop is used to repeat some code.

    for loop structure:

        for (initialise; condition; update) {
            // code that runs each time
        }

    Example: print numbers 1 to 5
    */

    public static void exampleForLoop() {
        // i starts at 1; loop while i <= 5; increase i by 1 each time
        for (int i = 1; i <= 5; i++) {
            System.out.println("i = " + i);
        }
    }

    // Example: print from 10 down to 1
    public static void exampleForLoopReverse() {
        for (int i = 10; i >= 1; i--) {
            System.out.println("Countdown: " + i);
        }
        System.out.println("Lift off!");
    }

    /*
    When to use a for loop:
    - You KNOW how many times you want to repeat.
    - Example: loop through the first 100 numbers.
    */

    /*
    ================================================================================
    SECTION 4: WHILE AND DO-WHILE LOOPS – REPEAT UNTIL SOMETHING CHANGES
    ================================================================================

    while loop:

        while (condition) {
            // runs while condition is true
        }

    Use while when:
    - You do NOT know in advance how many times you need to loop.
    - Example: keep asking the user for input until they type "exit".
    */

    public static void exampleWhileLoop() {
        int count = 0;

        while (count < 3) {
            System.out.println("While loop count = " + count);
            count++; // important! or it will never end
        }
    }

    /*
    do-while loop:

        do {
            // code runs at least once
        } while (condition);

    Difference from while:
    - while checks the condition BEFORE the first run
    - do-while checks AFTER first run, so it always runs at least once
    */

    public static void exampleDoWhileLoop() {
        int number = 5;

        do {
            System.out.println("This runs at least once. Number = " + number);
            number--;
        } while (number > 5); // false after first run, so loop stops
    }

    /*
    When to use while:
    - Repeat something WHILE a condition is true.
    Example: while there are still items in a list, keep processing them.

    When to use do-while:
    - When you MUST run the code at least once
    Example: show a menu, then ask if the user wants to continue.
    */

    /*
    ================================================================================
    SECTION 5: SWITCH STATEMENT – MANY OPTIONS FROM ONE VALUE
    ================================================================================

    switch is used when you have many possible cases for one variable.

    Instead of:

        if (x == 1) { ... }
        else if (x == 2) { ... }
        else if (x == 3) { ... }
        else { ... }

    You can write:

        switch (x) {
            case 1: ...
            case 2: ...
            case 3: ...
            default: ...
        }
    */

    public static void exampleSwitchBasic() {
        int day = 3;

        switch (day) {
            case 1:
                System.out.println("Monday");
                break; // without break, it would continue to the next case
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            default:
                System.out.println("Another day");
                break;
        }
    }

    /*
    switch is good when:
    - You have a single variable
    - It can take a small set of known values
    - You want different behaviour for each value

    Example use cases:
    - Menu options (1 = play, 2 = pause, 3 = exit)
    - Handling commands
    - Mapping numbers to days, months, etc.
    */

    /*
    ================================================================================
    SECTION 6: ARRAYS – A LIST OF VALUES OF THE SAME TYPE
    ================================================================================

    An array holds multiple values of the SAME type.

        int[] marks = new int[3]; // space for 3 ints

        marks[0] = 70;
        marks[1] = 85;
        marks[2] = 90;

    You can also create and fill at the same time:

        int[] scores = {70, 85, 90};

    Arrays have a fixed length and a .length property.
    */

    public static void exampleArrayBasics() {
        int[] marks = new int[3];

        marks[0] = 70;
        marks[1] = 85;
        marks[2] = 90;

        System.out.println("marks[0] = " + marks[0]);
        System.out.println("marks[1] = " + marks[1]);
        System.out.println("marks[2] = " + marks[2]);
        System.out.println("Number of marks = " + marks.length);
    }

    /*
    We almost always use loops with arrays.
    */

    public static void exampleArrayLoop() {
        int[] scores = {10, 20, 30, 40, 50};
        int total = 0;

        // for loop using index
        for (int i = 0; i < scores.length; i++) {
            total += scores[i];
        }

        System.out.println("Total score = " + total);

        // enhanced for-loop (for-each)
        System.out.println("Scores individually:");
        for (int score : scores) {
            System.out.println(score);
        }
    }

    /*
    Arrays are the foundation for collections (like ArrayList, HashMap, etc.).
    In the future, we will replace many array uses with ArrayList and other
    more flexible data structures, but understanding arrays is essential.
    */

    /*
    ================================================================================
    SECTION 7: PRACTICE TASKS (YOUR TURN)
    ================================================================================

    Below are some methods for you to implement.

    Rules:
    - Do NOT change the method signatures (name, parameters, return type).
    - Implement the logic INSIDE the methods.
    - Then, in main(), call your methods with some test values to check they work.

    For example:
        System.out.println(isAdult(17)); // expect false
        System.out.println(isAdult(18)); // expect true
    */

    // =========================
    // TASK 1: isAdult
    // =========================
    /*
     * Return true if age is 18 or above, otherwise false.
     * Use if / else.
     */
    public static boolean isAdult(int age) {
        // TODO: implement this
        return false; // placeholder
    }

    // =========================
    // TASK 2: maxOfTwo
    // =========================
    /*
     * Return the larger of two numbers a and b.
     * If they are equal, return either.
     */
    public static int maxOfTwo(int a, int b) {
        // TODO: implement this
        return 0; // placeholder
    }

    // =========================
    // TASK 3: countDown
    // =========================
    /*
     * Print numbers from n down to 1 using a for loop.
     * Example: n = 5 → prints 5 4 3 2 1 on separate lines.
     */
    public static void countDown(int n) {
        // TODO: implement this
    }

    // =========================
    // TASK 4: sumUpToN
    // =========================
    /*
     * Return the sum of all numbers from 1 to n.
     * Example: n = 5 → 1 + 2 + 3 + 4 + 5 = 15
     * Use a for loop.
     */
    public static int sumUpToN(int n) {
        // TODO: implement this
        return 0; // placeholder
    }

    // =========================
    // TASK 5: countEvensInArray
    // =========================
    /*
     * Given an array of ints, return how many of them are even.
     * An even number has remainder 0 when divided by 2.
     */
    public static int countEvensInArray(int[] numbers) {
        // TODO: implement this
        return 0; // placeholder
    }

    // =========================
    // TASK 6: printMenu
    // =========================
    /*
     * Use a switch statement on the option parameter.
     * If option == 1 → print "Play"
     * If option == 2 → print "Pause"
     * If option == 3 → print "Stop"
     * Otherwise → print "Invalid option"
     */
    public static void printMenu(int option) {
        // TODO: implement this
    }

    // =========================
    // TASK 7: isVowel
    // =========================
    /*
     * Given a character c, return true if it is a vowel (a, e, i, o, u),
     * either upper or lower case.
     * Hint: you can use || (OR) inside an if.
     */
    public static boolean isVowel(char c) {
        // TODO: implement this
        return false; // placeholder
    }

    // =========================
    // TASK 8: firstIndexOf
    // =========================
    /*
     * Given an array of ints and a target value, return the FIRST index
     * where target appears, or -1 if it does not appear.
     *
     * Example: numbers = [4, 7, 2, 7], target = 7 → return 1
     */
    public static int firstIndexOf(int[] numbers, int target) {
        // TODO: implement this
        return -1; // placeholder
    }

    /*
    ================================================================================
    HOW TO PRACTISE WITH THIS FILE
    ================================================================================

    1. Go to each TODO method and implement the logic.
    2. In main(), call your methods with different inputs and print the results.
    3. If something does not work, add printlns inside your methods to see what is happening.
    4. Once these feel easy, we can step into:
        - ArrayList
        - HashMap
        - HashSet
        - More advanced OOP (inheritance, polymorphism, etc.)
    */
}
