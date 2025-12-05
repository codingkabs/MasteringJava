// FundamentalsDemo.java
// A single file to revise core Java fundamentals:
// - Class & main method structure
// - Primitive & reference types
// - Variables, memory basics
// - Operators (arithmetic, comparison, logical, assignment, ++/--)
// - Arrays & Strings basics
//
// You can compile & run this file, read the comments, and tweak code as revision.

import java.util.Arrays; // used later to print arrays nicely

// Public class name MUST match the filename: FundamentalsDemo.java
public class DayOne {

    // ==== ENTRY POINT ====
    // The JVM starts here when you run:  java FundamentalsDemo
    public static void main(String[] args) {
        System.out.println("=== Java Fundamentals Demo ===\n");

        basicsOfClassAndMain();
        primitiveTypesDemo();
        referenceTypesDemo();
        operatorsDemo();
    }

    // =========================================================================
    // 1) Basic class & main structure
    // =========================================================================
    public static void basicsOfClassAndMain() {
        System.out.println("1) CLASS & MAIN STRUCTURE\n");

        // This method itself is an example of:
        // - public: can be called from anywhere
        // - static: belongs to the class, not to an object
        // - void: returns nothing
        // - basicsOfClassAndMain: method name
        // - () no parameters here

        System.out.println("This is a method called from main().");
        System.out.println("The JVM always starts in: public static void main(String[] args)\n");
    }

    // =========================================================================
    // 2) Primitive data types and variables
    // =========================================================================
    public static void primitiveTypesDemo() {
        System.out.println("2) PRIMITIVE TYPES & VARIABLES\n");

        // Primitive types store actual values directly (on the stack).
        int age = 21;                 // 32-bit integer
        double height = 1.78;         // 64-bit floating point
        boolean isStudent = true;     // true / false
        char grade = 'A';             // single character
        long bigNumber = 1_000_000L;  // long, note the 'L' suffix

        // Variable naming: use meaningful camelCase names
        int numberOfCourses = 5;

        System.out.println("age = " + age);
        System.out.println("height = " + height);
        System.out.println("isStudent = " + isStudent);
        System.out.println("grade = " + grade);
        System.out.println("bigNumber = " + bigNumber);
        System.out.println("numberOfCourses = " + numberOfCourses);

        // Reassigning a variable:
        age = 22; // new value overwrites the old one
        System.out.println("age after birthday = " + age);

        // final variables: cannot be changed after assignment
        final int DAYS_IN_WEEK = 7;
        // DAYS_IN_WEEK = 8; // ❌ would cause a compile error

        System.out.println("DAYS_IN_WEEK (final) = " + DAYS_IN_WEEK + "\n");
    }

    // =========================================================================
    // 3) Reference types (Strings, arrays, custom classes)
    // =========================================================================
    public static void referenceTypesDemo() {
        System.out.println("3) REFERENCE TYPES\n");

        // Reference types store a REFERENCE (pointer) to an object in heap memory.

        // ---- 3.1 String (reference type) ----
        // Most common way: string literal
        String name = "Kabir";
        // Less common: using new (creates a new String object explicitly)
        String city = new String("London");

        System.out.println("name = " + name);
        System.out.println("city = " + city);

        // Some basic String methods:
        System.out.println("name length = " + name.length());
        System.out.println("name in upper case = " + name.toUpperCase());
        System.out.println("First character of name = " + name.charAt(0));
        System.out.println("Substring of name (0, 3) = " + name.substring(0, 3)); // "Kab"

        // ---- 3.2 Arrays (reference type) ----
        // Arrays are fixed-length sequences of elements of the same type.

        // Option A: declare with size, then fill
        int[] scores = new int[3]; // defaults to [0, 0, 0]
        scores[0] = 85;
        scores[1] = 90;
        scores[2] = 95;

        // Option B: literal initialisation
        int[] ages = {18, 21, 25, 30};

        // Printing an array directly prints its reference:
        System.out.println("scores (raw) = " + scores); // something like [I@6d06d69c

        // Use Arrays.toString for a readable representation:
        System.out.println("scores = " + Arrays.toString(scores)); // [85, 90, 95]
        System.out.println("ages = " + Arrays.toString(ages));     // [18, 21, 25, 30]

        // Looping over an array using a classic for loop:
        System.out.print("ages (loop): ");
        for (int i = 0; i < ages.length; i++) {
            System.out.print(ages[i] + " ");
        }
        System.out.println();

        // Enhanced for loop (for-each):
        System.out.print("ages (enhanced for): ");
        for (int a : ages) {
            System.out.print(a + " ");
        }
        System.out.println("\n");

        // ---- 3.3 Custom class (reference type) ----
        // Person is a static nested class defined at the bottom of this file.
        Person p = new Person("Kabir", 21);
        System.out.println("Person object: " + p); // uses Person.toString()
        System.out.println("Person name = " + p.name);
        System.out.println("Person age  = " + p.age + "\n");
    }

    // =========================================================================
    // 4) Operators & expressions
    // =========================================================================
    public static void operatorsDemo() {
        System.out.println("4) OPERATORS & EXPRESSIONS\n");

        // ---------------------------------------------------------------------
        // 4.1 Arithmetic operators
        // ---------------------------------------------------------------------
        int a = 10;
        int b = 3;

        int sum = a + b;
        int diff = a - b;
        int product = a * b;
        int intDivision = a / b;         // integer division: 10 / 3 = 3
        int remainder = a % b;           // remainder: 10 % 3 = 1

        // If you want decimal division, make at least one operand double:
        double decimalDivision = (double) a / b; // 10.0 / 3 = 3.333...

        System.out.println("a = " + a + ", b = " + b);
        System.out.println("a + b = " + sum);
        System.out.println("a - b = " + diff);
        System.out.println("a * b = " + product);
        System.out.println("a / b (int) = " + intDivision);
        System.out.println("a % b = " + remainder);
        System.out.println("a / b (double) = " + decimalDivision);
        System.out.println();

        // ---------------------------------------------------------------------
        // 4.2 Comparison operators (result is boolean)
        // ---------------------------------------------------------------------
        boolean isEqual = (a == b);
        boolean notEqual = (a != b);
        boolean greater = (a > b);
        boolean lessOrEqual = (a <= b);

        System.out.println("a == b -> " + isEqual);
        System.out.println("a != b -> " + notEqual);
        System.out.println("a > b  -> " + greater);
        System.out.println("a <= b -> " + lessOrEqual);
        System.out.println();

        // ---------------------------------------------------------------------
        // 4.3 Logical operators (AND, OR, NOT)
        // ---------------------------------------------------------------------
        boolean hasID = true;
        int age = 20;

        // AND: both conditions must be true
        boolean canEnterClub = (age >= 18 && hasID); // true && true -> true

        // OR: at least one condition must be true
        boolean isStudent = false;
        boolean hasStudentCard = true;
        boolean getsDiscount = (isStudent || hasStudentCard); // false || true -> true

        // NOT: flips a boolean
        boolean hungry = true;
        boolean notHungry = !hungry; // false

        System.out.println("canEnterClub (age >= 18 && hasID) = " + canEnterClub);
        System.out.println("getsDiscount (isStudent || hasStudentCard) = " + getsDiscount);
        System.out.println("hungry = " + hungry + ", !hungry = " + notHungry);
        System.out.println();

        // ---------------------------------------------------------------------
        // 4.4 Assignment operators (shorthand)
        // ---------------------------------------------------------------------
        int total = 10;
        total += 5; // total = total + 5 -> 15
        total -= 3; // total = total - 3 -> 12
        total *= 2; // total = total * 2 -> 24
        total /= 4; // total = total / 4 -> 6
        total %= 4; // total = total % 4 -> 2

        System.out.println("total after sequence of assignments = " + total);
        System.out.println();

        // ---------------------------------------------------------------------
        // 4.5 Increment / decrement: ++ and --
        // ---------------------------------------------------------------------
        int x = 5;

        // Post-increment:
        // yPost gets the OLD value of x (5), then x becomes 6
        int yPost = x++;
        // Now x is 6

        // Pre-increment:
        // x is first increased to 7, then yPre gets 7
        int yPre = ++x; // x becomes 7, yPre = 7

        System.out.println("After x = 5; yPost = x++; yPre = ++x;");
        System.out.println("x    = " + x);      // 7
        System.out.println("yPost = " + yPost); // 5
        System.out.println("yPre  = " + yPre);  // 7
        System.out.println();

        // ---------------------------------------------------------------------
        // 4.6 Operator precedence (order of evaluation)
        // ---------------------------------------------------------------------
        int result1 = 10 + 5 * 2;        // * happens before +  -> 10 + (5*2) = 20
        int result2 = (10 + 5) * 2;      // parentheses first -> (15)*2 = 30

        System.out.println("10 + 5 * 2 = " + result1);
        System.out.println("(10 + 5) * 2 = " + result2);
        System.out.println();
    }

    // =========================================================================
    // 5) Helper nested class (used to demonstrate reference types)
    // =========================================================================
    // This is a simple custom class. Every object of type Person will have:
    // - a String field 'name'
    // - an int field 'age'
    static class Person {
        String name;
        int age;

        // Constructor: called when you do `new Person("Kabir", 21)`
        Person(String name, int age) {
            // 'this.name' refers to the field, 'name' is the parameter
            this.name = name;
            this.age = age;
        }

        // toString() is used when you print the object directly:
        // System.out.println(p); -> calls p.toString()
        @Override
        public String toString() {
            return "Person{name='" + name + "', age=" + age + "}";
        }
    }
}
