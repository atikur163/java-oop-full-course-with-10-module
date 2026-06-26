// EXAMPLE 1: Defining a simple class
// ─────────────────────────────────────────────────────────────
 
class Dog {
    // Fields (attributes)
    String name;
    String breed;
    int age;
 
    // Method (behavior)
    void bark() {
        System.out.println(name + " says: Woof! Woof!");
    }
 
    void displayInfo() {
        System.out.println("Name:  " + name);
        System.out.println("Breed: " + breed);
        System.out.println("Age:   " + age + " years");
    }
}
 
 
 
// ─────────────────────────────────────────────────────────────
// EXAMPLE 2: Class with a Constructor
// ─────────────────────────────────────────────────────────────
 
class Car {
    String brand;
    String color;
    int speed;
 
    // Constructor — runs automatically when object is created
    Car(String brand, String color, int speed) {
        this.brand = brand;
        this.color = color;
        this.speed = speed;
    }
 
    void showDetails() {
        System.out.println(color + " " + brand + " | Top speed: " + speed + " km/h");
    }
 
    void accelerate(int amount) {
        speed += amount;
        System.out.println(brand + " accelerated! New speed: " + speed + " km/h");
    }
}
 
 
// ─────────────────────────────────────────────────────────────
// EXAMPLE 3: Class with default + parameterized constructor
// ─────────────────────────────────────────────────────────────
 
class Student {
    String name;
    int rollNumber;
    double gpa;
 
    // Default constructor
    Student() {
        name = "Unknown";
        rollNumber = 0;
        gpa = 0.0;
    }
 
    // Parameterized constructor
    Student(String name, int rollNumber, double gpa) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.gpa = gpa;
    }
 
    void printReport() {
        System.out.println("┌─────────────────────────┐");
        System.out.println("  Student Report Card");
        System.out.println("  Name:   " + name);
        System.out.println("  Roll:   " + rollNumber);
        System.out.println("  GPA:    " + gpa);
        System.out.println("└─────────────────────────┘");
    }
}
 
 
// ─────────────────────────────────────────────────────────────
// MAIN CLASS — Run all examples here
// ─────────────────────────────────────────────────────────────
 
public class OOPIntro {
 
    public static void main(String[] args) {
 
        System.out.println("========================================");
        System.out.println(" Module 01: Introduction to OOP");
        System.out.println("========================================\n");
 
 
        // ── Example 1: Creating objects from Dog class ──────────
        System.out.println("── Example 1: Dog Objects ──");
 
        Dog dog1 = new Dog();   // create object
        dog1.name  = "Bruno";
        dog1.breed = "German Shepherd";
        dog1.age   = 3;
 
        Dog dog2 = new Dog();
        dog2.name  = "Milo";
        dog2.breed = "Labrador";
        dog2.age   = 5;
 
        dog1.displayInfo();
        dog1.bark();
 
        System.out.println();
 
        dog2.displayInfo();
        dog2.bark();
 
 
        // ── Example 2: Car with Constructor ─────────────────────
        System.out.println("\n── Example 2: Car Objects ──");
 
        Car car1 = new Car("Toyota", "White", 120);
        Car car2 = new Car("BMW", "Black", 200);
 
        car1.showDetails();
        car1.accelerate(30);
 
        System.out.println();
 
        car2.showDetails();
        car2.accelerate(50);
 
 
        // ── Example 3: Student with both constructors ────────────
        System.out.println("\n── Example 3: Student Objects ──");
 
        Student s1 = new Student();                        // default
        Student s2 = new Student("Rahim", 101, 3.85);     // parameterized
        Student s3 = new Student("Karim", 102, 3.60);
 
        s1.printReport();
        System.out.println();
        s2.printReport();
        System.out.println();
        s3.printReport();
 
 
        // ── Key Concept Summary ──────────────────────────────────
        System.out.println("\n========================================");
        System.out.println(" Key Takeaways:");
        System.out.println("  ✔ A class is a blueprint");
        System.out.println("  ✔ An object is an instance of a class");
        System.out.println("  ✔ 'new' keyword creates an object");
        System.out.println("  ✔ Constructor runs on object creation");
        System.out.println("  ✔ 'this' refers to current object");
        System.out.println("========================================");
    }
}
