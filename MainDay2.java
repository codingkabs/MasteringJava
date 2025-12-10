/*
================================================================================
 Java OOP Lessons In One File
================================================================================

This file is designed as a full "lesson in code" that you can open in your IDE
and read from top to bottom.

It contains:

 1. A simple MAIN method to run small examples.
 2. The Student class you have so far, written "the right way" with:
      - private fields
      - constructor
      - getters and setters
      - a fixed gender value
 3. Lesson 9: static vs instance (StudentWithCounter example).
 4. Lesson 10: Inheritance (Person, StudentChild, Teacher).
 5. Lesson 11: Method overriding and polymorphism.
 6. Lesson 12: Abstract classes.
 7. Lesson 13: Interfaces.
 8. Lesson 14: Method overloading.
 9. Lesson 15: final keyword examples.

Read the comments as if they are the written lesson.
You can run main(...) and play around with the code.

If you want, you can rename this file to Main.java and keep experimenting.
*/

public class MainDay2 {

    public static void main(String[] args) {
        /*
         =====================================================================
         DEMO SECTION
         =====================================================================
         This method is just to show how things work by running the program.
         Feel free to change it, add prints, or comment parts out.
        */

        // 1) Create some Student objects using the constructor
        Student s1 = new Student("Kabir", 21);
        Student s2 = new Student("Aisha", 20);

        System.out.println("=== Basic Student demo ===");
        System.out.println("s1 name: " + s1.getName());
        System.out.println("s1 age: " + s1.getAge());
        System.out.println("s1 gender (fixed): " + s1.getGender());

        System.out.println("s2 name: " + s2.getName());
        System.out.println("s2 age: " + s2.getAge());
        System.out.println("s2 gender (fixed): " + s2.getGender());

        // Update age using setter with validation
        s1.setAge(22);
        s2.setAge(-5); // invalid, will trigger message

        System.out.println("s1 new age: " + s1.getAge());
        System.out.println("s2 new age (unchanged because invalid): " + s2.getAge());

        // 2) Static vs instance demo
        System.out.println("\n=== Static vs instance demo ===");
        StudentWithCounter st1 = new StudentWithCounter("Ali", 19);
        StudentWithCounter st2 = new StudentWithCounter("Ben", 20);
        StudentWithCounter st3 = new StudentWithCounter("Cara", 21);

        // Static field belongs to the class, so we access it on the class
        System.out.println("Total StudentWithCounter objects created: " + StudentWithCounter.getStudentCount());
        System.out.println("School name (static shared value): " + StudentWithCounter.schoolName);

        // 3) Inheritance and polymorphism demo
        System.out.println("\n=== Inheritance and polymorphism demo ===");
        Person p1 = new StudentChild("Kabir", 21, "K123");
        Person p2 = new Teacher("Sara", 30, "Mathematics");

        p1.introduce(); // StudentChild version of introduce
        p2.introduce(); // Teacher version of introduce

        // Polymorphism: both stored as Person, but behaviour depends on actual type
        p1.work();
        p2.work();

        // 4) Abstract class usage
        System.out.println("\n=== Abstract class demo ===");
        // We cannot do: PersonBase base = new PersonBase();  // not allowed
        PersonBase baseStudent = new AbstractStudent("Maya", 19, "S777");
        baseStudent.introduce();
        baseStudent.work(); // implemented in AbstractStudent

        // 5) Interface demo
        System.out.println("\n=== Interface demo ===");
        Drivable car = new Car();
        car.drive();

        // 6) Method overloading demo
        System.out.println("\n=== Method overloading demo ===");
        Printer printer = new Printer();
        printer.print(42);
        printer.print("Hello");
        printer.print("Number:", 99);

        // 7) final keyword demo (read comments in FinalExamples class)
        System.out.println("\n=== final keyword demo ===");
        FinalExamples.demoFinal();
    }
}

/*
================================================================================
 LESSON 1–8: The Student class as we have built it so far
================================================================================

This class shows:

  - private fields (encapsulation)
  - a constructor to create valid objects
  - getters and setters
  - basic validation in the setter
  - a fixed gender value set in the constructor

Key ideas:

  * Fields are private so code outside the class cannot change them directly.
  * We provide public methods (getters/setters) to control how data is accessed.
  * The constructor ensures every Student has a name, age and gender when created.
*/

class Student {

    // These fields hold the "state" of each Student object.
    // They are private to protect the data (encapsulation).
    private String name;
    private int age;
    private String gender;

    /*
     Constructor:
     -----------
     - Has the same name as the class.
     - No return type.
     - Runs automatically when you do: new Student("Kabir", 21);

     We pass in the data needed to make a valid Student and store it into fields.
     Here we also fix gender to "male" for every Student (your test idea).
    */
    public Student(String name, int age) {
        this.name = name;    // "this.name" refers to the field, "name" is the parameter
        this.age = age;
        this.gender = "male"; // fixed value for every Student object
    }

    /*
     Getter for name:
     ----------------
     - Allows code outside the class to read the name safely.
    */
    public String getName() {
        return name;
    }

    /*
     Setter for name:
     ----------------
     - Allows updating the name from outside the class in a controlled way.
     - We could add validation here if we wanted (e.g. not empty).
    */
    public void setName(String newName) {
        this.name = newName;
    }

    /*
     Getter for age:
     ---------------
    */
    public int getAge() {
        return age;
    }

    /*
     Setter for age with validation:
     --------------------------------
     - We only update the age if the new value is positive.
     - Otherwise we print an error message.
     - Notice we check "newAge" (the input parameter), not "age".
    */
    public void setAge(int newAge) {
        if (newAge > 0) {
            this.age = newAge;
        } else {
            System.out.println("Age is invalid");
        }
    }

    /*
     Getter for gender:
     ------------------
     - Even though we always set gender to "male" in the constructor,
       it is still normal to expose a getter so code can read it.
    */
    public String getGender() {
        return gender;
    }
}

/*
================================================================================
 LESSON 9: Static vs Instance (class level vs object level)
================================================================================

- Instance fields (non static) belong to each object.
  Example: each Student has its own name, age, gender.

- Static fields belong to the CLASS itself, shared across all objects.
  Example: a school name, or a counter of how many Students have been created.

Below we define a StudentWithCounter class that:
  - counts how many objects have been created (static int studentCount)
  - has a static schoolName shared by all students
*/

class StudentWithCounter {

    private String name;
    private int age;

    // This value is shared by ALL StudentWithCounter objects.
    // It belongs to the class, not to a specific object.
    public static int studentCount = 0;

    // This is also shared by all objects. Every student goes to the same school.
    public static String schoolName = "KCL";

    public StudentWithCounter(String name, int age) {
        this.name = name;
        this.age = age;

        // Each time we create a new StudentWithCounter,
        // we increment the shared counter.
        studentCount++;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    /*
     Static methods:
     ---------------
     - Belong to the class, not to objects.
     - You call them like: StudentWithCounter.getStudentCount();
    */
    public static int getStudentCount() {
        return studentCount;
    }
}

/*
================================================================================
 LESSON 10: Inheritance
================================================================================

Idea:
  - We define a more general class Person.
  - StudentChild and Teacher are more specific types that "extend" Person.

Key points:
  - "extends" expresses "is a" relationship:
        StudentChild is a Person
        Teacher is a Person
  - They inherit fields and methods from Person.
  - They can also add their own fields and methods.
*/

class Person {

    // protected means:
    // - visible inside this class
    // - visible in subclasses (like StudentChild, Teacher)
    // - visible in the same package
    protected String name;
    protected int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // A common behaviour that all Person objects will have.
    public void introduce() {
        System.out.println("I am " + name + ", age " + age);
    }

    // A method we will override in subclasses to show polymorphism.
    public void work() {
        System.out.println("This person is working");
    }
}

/*
 StudentChild:
 -------------
 - Inherits name, age, introduce(), work() from Person.
 - Adds its own field studentId.
 - Overrides work() and introduce() to give more specific behaviour.
*/
class StudentChild extends Person {

    private String studentId;

    public StudentChild(String name, int age, String studentId) {
        // super(...) calls the constructor of the parent class (Person).
        super(name, age);
        this.studentId = studentId;
    }

    // Override introduce to provide a more specific message for StudentChild.
    @Override
    public void introduce() {
        System.out.println("I am student " + name + ", age " + age + ", ID " + studentId);
    }

    // Override work to show what a student does.
    @Override
    public void work() {
        System.out.println(name + " is studying");
    }
}

/*
 Teacher:
 --------
 - Also extends Person.
 - Adds subject.
 - Overrides work() and introduce().
*/
class Teacher extends Person {

    private String subject;

    public Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    @Override
    public void introduce() {
        System.out.println("I am teacher " + name + ", age " + age + ", I teach " + subject);
    }

    @Override
    public void work() {
        System.out.println(name + " is teaching " + subject);
    }
}

/*
================================================================================
 LESSON 11: Polymorphism and Method Overriding
================================================================================

Polymorphism means:
  - One reference type (Person) can refer to different actual object types 
    (StudentChild, Teacher).
  - When we call an overridden method, Java will use the version from the actual
    object type, not just the reference type.

Example used in main:

    Person p1 = new StudentChild("Kabir", 21, "K123");
    Person p2 = new Teacher("Sara", 30, "Mathematics");

    p1.work();  // StudentChild's work()
    p2.work();  // Teacher's work()

Even though both are typed as Person, the behaviour depends on the real object.
We achieved this by overriding the work() method in the subclasses.
*/

/*
================================================================================
 LESSON 12: Abstract Classes
================================================================================

An abstract class:
  - Cannot be instantiated directly (you cannot do new PersonBase()).
  - Can contain abstract methods (no body) that must be implemented by subclasses.
  - Can also contain normal methods with a body.

We will define an abstract PersonBase and a concrete AbstractStudent that extends it.
*/

abstract class PersonBase {
    private String name;
    private int age;

    public PersonBase(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Abstract method: no body here.
    // Subclasses MUST implement this.
    public abstract void work();

    // Normal method: subclasses inherit it as is.
    public void introduce() {
        System.out.println("I am " + name + ", age " + age + " (from abstract base)");
    }

    // Protected getter so subclasses can access the name.
    protected String getName() {
        return name;
    }
}

class AbstractStudent extends PersonBase {

    private String studentId;

    public AbstractStudent(String name, int age, String studentId) {
        super(name, age);
        this.studentId = studentId;
    }

    // We must implement the abstract method from PersonBase.
    @Override
    public void work() {
        System.out.println(getName() + " is studying (abstract version), ID " + studentId);
    }
}

/*
================================================================================
 LESSON 13: Interfaces
================================================================================

An interface:
  - Is a pure contract of methods a class must implement.
  - A class can implement multiple interfaces.
  - Methods in an interface are implicitly public and abstract (in classic Java).

We will define a simple Drivable interface and a Car class that implements it.
*/

interface Drivable {
    void drive();
}

class Car implements Drivable {

    @Override
    public void drive() {
        System.out.println("The car is driving");
    }
}

/*
================================================================================
 LESSON 14: Method Overloading
================================================================================

Method overloading:
  - Same method name.
  - Different parameter types or number of parameters.
  - Defined in the same class.

The compiler decides which version to call based on the arguments.
*/

class Printer {

    public void print(int x) {
        System.out.println("Printing int: " + x);
    }

    public void print(String s) {
        System.out.println("Printing String: " + s);
    }

    public void print(String s, int x) {
        System.out.println("Printing both: " + s + " " + x);
    }
}

/*
================================================================================
 LESSON 15: final keyword
================================================================================

final:
  - final variable cannot be reassigned.
  - final method cannot be overridden in subclasses.
  - final class cannot be extended.

Examples below are grouped in one helper class.
*/

class FinalExamples {

    // final variable example
    public static void demoFinal() {
        final int x = 10;
        System.out.println("Final variable x = " + x);
        // x = 20;  // not allowed, would cause a compile error if uncommented
    }
}

/*
End of lesson file.

You can keep this as a single Java file in your IDE and:
  - Collapse and expand classes.
  - Read comments to revise concepts.
  - Experiment by changing values and running main().
*/
