// EXAMPLE 1: Basic Abstract Class — Shape hierarchy
// ─────────────────────────────────────────────────────────────
 
abstract class Shape {
    protected String color;
    protected String name;
 
    // Abstract class CAN have a constructor (called via super())
    Shape(String name, String color) {
        this.name  = name;
        this.color = color;
    }
 
    // Abstract methods — child MUST implement these
    abstract double area();
    abstract double perimeter();
 
    // Concrete methods — shared by all shapes (no override needed)
    void describe() {
        System.out.printf("  %-12s | Color: %-8s | Area: %8.2f | Perimeter: %7.2f%n",
                          name, color, area(), perimeter());
    }
 
    boolean isLargerThan(Shape other) {
        return this.area() > other.area();
    }
}
 
class AbsCircle extends Shape {
    private double radius;
 
    AbsCircle(String color, double radius) {
        super("Circle", color);
        this.radius = radius;
    }
 
    @Override
    double area()      { return Math.PI * radius * radius; }
 
    @Override
    double perimeter() { return 2 * Math.PI * radius; }
}
 
class AbsRectangle extends Shape {
    private double width, height;
 
    AbsRectangle(String color, double width, double height) {
        super("Rectangle", color);
        this.width  = width;
        this.height = height;
    }
 
    @Override
    double area()      { return width * height; }
 
    @Override
    double perimeter() { return 2 * (width + height); }
}
 
class AbsTriangle extends Shape {
    private double a, b, c;
 
    AbsTriangle(String color, double a, double b, double c) {
        super("Triangle", color);
        this.a = a; this.b = b; this.c = c;
    }
 
    @Override
    double area() {
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }
 
    @Override
    double perimeter() { return a + b + c; }
}
 
 
// ─────────────────────────────────────────────────────────────
// EXAMPLE 2: Abstract class with concrete + abstract methods
//            Vehicle hierarchy
// ─────────────────────────────────────────────────────────────
 
abstract class Vehicle {
    protected String brand;
    protected String model;
    protected int    year;
    protected double fuelLevel;
 
    Vehicle(String brand, String model, int year) {
        this.brand     = brand;
        this.model     = model;
        this.year      = year;
        this.fuelLevel = 100.0;
    }
 
    // Abstract — every vehicle starts differently
    abstract void start();
    abstract void stop();
    abstract String getFuelType();
 
    // Concrete — same logic for all vehicles
    void refuel(double amount) {
        fuelLevel = Math.min(100, fuelLevel + amount);
        System.out.printf("  %s refuelled. Fuel level: %.1f%%%n", brand, fuelLevel);
    }
 
    void printInfo() {
        System.out.println("  Brand:     " + brand + " " + model);
        System.out.println("  Year:      " + year);
        System.out.println("  Fuel type: " + getFuelType());
        System.out.printf( "  Fuel:      %.1f%%%n", fuelLevel);
    }
}
 
class PetrolCar extends Vehicle {
    private int horsepower;
 
    PetrolCar(String brand, String model, int year, int horsepower) {
        super(brand, model, year);
        this.horsepower = horsepower;
    }
 
    @Override
    void start() {
        System.out.println("  🔑 " + brand + " petrol engine roars to life! Vroom!");
    }
 
    @Override
    void stop() {
        System.out.println("  🛑 " + brand + " petrol engine shut down.");
    }
 
    @Override
    String getFuelType() { return "Petrol (" + horsepower + " HP)"; }
}
 
class ElectricVehicle extends Vehicle {
    private int batteryCapacityKwh;
    private int rangeKm;
 
    ElectricVehicle(String brand, String model, int year,
                    int batteryCapacityKwh, int rangeKm) {
        super(brand, model, year);
        this.batteryCapacityKwh = batteryCapacityKwh;
        this.rangeKm            = rangeKm;
    }
 
    @Override
    void start() {
        System.out.println("  ⚡ " + brand + " silently starts. Zero emissions!");
    }
 
    @Override
    void stop() {
        System.out.println("  🔋 " + brand + " powered down. Battery preserved.");
    }
 
    @Override
    String getFuelType() {
        return "Electric (" + batteryCapacityKwh + " kWh, " + rangeKm + "km range)";
    }
 
    void charge() {
        fuelLevel = 100;
        System.out.println("  🔌 " + brand + " fully charged!");
    }
}
 
class Bicycle extends Vehicle {
    private int gears;
 
    Bicycle(String brand, String model, int year, int gears) {
        super(brand, model, year);
        this.fuelLevel = 0;   // no fuel needed
        this.gears     = gears;
    }
 
    @Override
    void start() {
        System.out.println("  🚴 " + brand + " bicycle — pedal power engaged!");
    }
 
    @Override
    void stop() {
        System.out.println("  🛑 " + brand + " bicycle — brakes applied.");
    }
 
    @Override
    String getFuelType() { return "Human-powered (" + gears + " gears)"; }
 
    @Override
    void refuel(double amount) {
        System.out.println("  🚴 Bicycles don't need fuel — just pedal harder!");
    }
}
 
 
// ─────────────────────────────────────────────────────────────
// EXAMPLE 3: Partial Abstraction
//            Abstract child of abstract parent
// ─────────────────────────────────────────────────────────────
 
abstract class LivingThing {
    abstract void breathe();
    abstract void reproduce();
 
    void grow() {
        System.out.println("This living thing is growing.");
    }
}
 
// Animal implements breathe() but leaves reproduce() abstract
abstract class AbsAnimal extends LivingThing {
    protected String name;
 
    AbsAnimal(String name) { this.name = name; }
 
    @Override
    void breathe() {
        System.out.println(name + " breathes oxygen.");
    }
 
    // Still abstract — not implemented here
    abstract void makeSound();
 
    // reproduce() still not implemented — stays abstract
}
 
// Dog must implement both makeSound() AND reproduce()
class AbsDog extends AbsAnimal {
    AbsDog(String name) { super(name); }
 
    @Override
    void makeSound() {
        System.out.println(name + " barks: Woof!");
    }
 
    @Override
    void reproduce() {
        System.out.println(name + " gives birth to puppies.");
    }
}
 
 
// ─────────────────────────────────────────────────────────────
// EXAMPLE 4: Real-world — Employee Payroll System
// ─────────────────────────────────────────────────────────────
 
abstract class StaffMember {
    protected String name;
    protected String id;
    protected String department;
 
    StaffMember(String name, String id, String department) {
        this.name       = name;
        this.id         = id;
        this.department = department;
    }
 
    // Each type calculates salary differently
    abstract double calculateSalary();
    abstract String getEmployeeType();
 
    // Concrete — same for all staff
    void printPayslip() {
        System.out.println("┌──────────────────────────────────────┐");
        System.out.println("  " + getEmployeeType() + " Payslip");
        System.out.println("  Name:   " + name + " [" + id + "]");
        System.out.println("  Dept:   " + department);
        System.out.printf( "  Salary: ৳%.2f%n", calculateSalary());
        System.out.println("└──────────────────────────────────────┘");
    }
 
    boolean earnsMoreThan(StaffMember other) {
        return this.calculateSalary() > other.calculateSalary();
    }
}
 
// Full-time: fixed monthly salary + bonus
class FullTimeEmployee extends StaffMember {
    private double baseSalary;
    private double bonusPercent;
 
    FullTimeEmployee(String name, String id, String dept,
                     double baseSalary, double bonusPercent) {
        super(name, id, dept);
        this.baseSalary    = baseSalary;
        this.bonusPercent  = bonusPercent;
    }
 
    @Override
    double calculateSalary() {
        return baseSalary + (baseSalary * bonusPercent / 100);
    }
 
    @Override
    String getEmployeeType() { return "Full-Time Employee"; }
}
 
// Part-time: hourly rate × hours worked
class PartTimeEmployee extends StaffMember {
    private double hourlyRate;
    private int    hoursWorked;
 
    PartTimeEmployee(String name, String id, String dept,
                     double hourlyRate, int hoursWorked) {
        super(name, id, dept);
        this.hourlyRate  = hourlyRate;
        this.hoursWorked = hoursWorked;
    }
 
    @Override
    double calculateSalary() { return hourlyRate * hoursWorked; }
 
    @Override
    String getEmployeeType() { return "Part-Time Employee"; }
}
 
// Contractor: project fee − tax
class Contractor extends StaffMember {
    private double projectFee;
    private double taxPercent;
 
    Contractor(String name, String id, String dept,
               double projectFee, double taxPercent) {
        super(name, id, dept);
        this.projectFee = projectFee;
        this.taxPercent = taxPercent;
    }
 
    @Override
    double calculateSalary() {
        return projectFee - (projectFee * taxPercent / 100);
    }
 
    @Override
    String getEmployeeType() { return "Contractor"; }
}
 
 
// ─────────────────────────────────────────────────────────────
// EXAMPLE 5: Template Method Pattern
//            Abstract class defines the FLOW, child fills steps
// ─────────────────────────────────────────────────────────────
 
abstract class DataProcessor {
    // Template method — defines the fixed algorithm skeleton
    // Child classes cannot change this order (final)
    final void process() {
        System.out.println("  [1] Reading data...");
        readData();
        System.out.println("  [2] Processing data...");
        processData();
        System.out.println("  [3] Saving results...");
        saveResults();
        System.out.println("  [4] Done!");
    }
 
    // Steps that child classes must implement
    abstract void readData();
    abstract void processData();
    abstract void saveResults();
}
 
class CSVProcessor extends DataProcessor {
    @Override
    void readData()     { System.out.println("      Reading rows from CSV file..."); }
    @Override
    void processData()  { System.out.println("      Parsing columns, removing nulls..."); }
    @Override
    void saveResults()  { System.out.println("      Saving cleaned data to output.csv"); }
}
 
class JSONProcessor extends DataProcessor {
    @Override
    void readData()     { System.out.println("      Fetching JSON from REST API..."); }
    @Override
    void processData()  { System.out.println("      Parsing JSON, extracting fields..."); }
    @Override
    void saveResults()  { System.out.println("      Writing result to database..."); }
}
 
class XMLProcessor extends DataProcessor {
    @Override
    void readData()     { System.out.println("      Loading XML document..."); }
    @Override
    void processData()  { System.out.println("      Traversing XML nodes, mapping data..."); }
    @Override
    void saveResults()  { System.out.println("      Exporting transformed XML..."); }
}
 
 
// ─────────────────────────────────────────────────────────────
// MAIN CLASS
// ─────────────────────────────────────────────────────────────
 
public class Abstraction {
 
    public static void main(String[] args) {
 
        System.out.println("========================================");
        System.out.println(" Module 07: Abstraction");
        System.out.println("========================================\n");
 
 
        // ── Example 1: Shape hierarchy ────────────────────────────
        System.out.println("── Example 1: Abstract Shape Hierarchy ──");
 
        Shape[] shapes = {
            new AbsCircle("Red",    7.0),
            new AbsRectangle("Blue",  8.0, 5.0),
            new AbsTriangle("Green", 3.0, 4.0, 5.0),
            new AbsCircle("Purple", 3.5),
        };
 
        System.out.printf("  %-12s | %-14s | %-14s | %s%n",
                          "Shape", "Color", "Area", "Perimeter");
        System.out.println("  " + "─".repeat(60));
        for (Shape s : shapes) s.describe();
 
        System.out.println();
        System.out.println("  Is Red Circle larger than Green Triangle?");
        System.out.println("  " + shapes[0].isLargerThan(shapes[2]));
 
 
        // ── Example 2: Vehicle hierarchy ──────────────────────────
        System.out.println("\n── Example 2: Abstract Vehicle Hierarchy ──");
 
        Vehicle[] vehicles = {
            new PetrolCar("Toyota", "Corolla", 2022, 130),
            new ElectricVehicle("Tesla", "Model 3", 2023, 75, 560),
            new Bicycle("Trek", "FX3", 2023, 21)
        };
 
        for (Vehicle v : vehicles) {
            System.out.println("\n" + v.brand + " " + v.model + ":");
            v.start();
            v.printInfo();
            v.refuel(20);
            v.stop();
        }
 
 
        // ── Example 3: Partial Abstraction ────────────────────────
        System.out.println("\n── Example 3: Partial Abstraction Chain ──");
 
        AbsDog dog = new AbsDog("Bruno");
        dog.breathe();      // from AbsAnimal (concrete)
        dog.makeSound();    // from AbsDog (concrete)
        dog.reproduce();    // from AbsDog (concrete)
        dog.grow();         // from LivingThing (concrete)
 
 
        // ── Example 4: Employee Payroll ───────────────────────────
        System.out.println("\n── Example 4: Employee Payroll System ──");
 
        StaffMember[] staff = {
            new FullTimeEmployee("Rahim Uddin",  "FT-001", "Engineering", 60000, 15),
            new FullTimeEmployee("Nadia Islam",  "FT-002", "Design",      55000, 10),
            new PartTimeEmployee("Karim Khan",   "PT-001", "Marketing",   400, 80),
            new Contractor("Sara Ahmed",         "CT-001", "Legal",       120000, 20),
        };
 
        for (StaffMember s : staff) {
            s.printPayslip();
            System.out.println();
        }
 
        // Find highest earner
        StaffMember highest = staff[0];
        for (StaffMember s : staff) {
            if (s.earnsMoreThan(highest)) highest = s;
        }
        System.out.println("  Highest earner: " + highest.name +
                           " (" + highest.getEmployeeType() + ")");
 
 
        // ── Example 5: Template Method Pattern ───────────────────
        System.out.println("\n── Example 5: Template Method Pattern ──");
 
        DataProcessor[] processors = {
            new CSVProcessor(),
            new JSONProcessor(),
            new XMLProcessor()
        };
 
        String[] names = {"CSV Processor", "JSON Processor", "XML Processor"};
 
        for (int i = 0; i < processors.length; i++) {
            System.out.println("\nRunning " + names[i] + ":");
            processors[i].process();   // same flow, different steps!
        }
 
 
        // ── Summary ───────────────────────────────────────────────
        System.out.println("\n========================================");
        System.out.println(" Key Takeaways:");
        System.out.println("  ✔ abstract class cannot be instantiated");
        System.out.println("  ✔ abstract method has no body");
        System.out.println("  ✔ child MUST implement all abstract methods");
        System.out.println("  ✔ abstract class can have concrete methods");
        System.out.println("  ✔ abstract class can have a constructor");
        System.out.println("  ✔ Template Method: parent defines flow,");
        System.out.println("    child fills in the steps");
        System.out.println("========================================");
    }
}
 
