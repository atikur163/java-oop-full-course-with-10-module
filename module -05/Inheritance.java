// EXAMPLE 1: Basic Inheritance — Animal family
// ─────────────────────────────────────────────────────────────
 
class Animal {
    protected String name;
    protected int    age;
    protected String sound;
 
    Animal(String name, int age) {
        this.name  = name;
        this.age   = age;
        this.sound = "...";
    }
 
    void eat() {
        System.out.println(name + " is eating.");
    }
 
    void sleep() {
        System.out.println(name + " is sleeping.");
    }
 
    void makeSound() {
        System.out.println(name + " says: " + sound);
    }
 
    void describe() {
        System.out.println("Animal — Name: " + name + " | Age: " + age);
    }
}
 
// ── Dog extends Animal ───────────────────────────────────────
class Dog extends Animal {
    private String breed;
 
    Dog(String name, int age, String breed) {
        super(name, age);       // calls Animal's constructor
        this.breed = breed;
        this.sound = "Woof!";   // override the default sound
    }
 
    // Dog's own method
    void fetch() {
        System.out.println(name + " fetches the ball! 🎾");
    }
 
    @Override
    void describe() {
        super.describe();       // print Animal info first
        System.out.println("  Breed: " + breed);
    }
}
 
// ── Cat extends Animal ───────────────────────────────────────
class Cat extends Animal {
    private boolean isIndoor;
 
    Cat(String name, int age, boolean isIndoor) {
        super(name, age);
        this.isIndoor = isIndoor;
        this.sound    = "Meow!";
    }
 
    void purr() {
        System.out.println(name + " is purring... 😺");
    }
 
    @Override
    void describe() {
        super.describe();
        System.out.println("  Type: " + (isIndoor ? "Indoor" : "Outdoor") + " cat");
    }
}
 
// ── Bird extends Animal ──────────────────────────────────────
class Bird extends Animal {
    private double wingspanCm;
 
    Bird(String name, int age, double wingspanCm) {
        super(name, age);
        this.wingspanCm = wingspanCm;
        this.sound      = "Tweet!";
    }
 
    void fly() {
        System.out.println(name + " is flying with " + wingspanCm + "cm wingspan! 🦅");
    }
 
    @Override
    void describe() {
        super.describe();
        System.out.println("  Wingspan: " + wingspanCm + " cm");
    }
}
 
 
// ─────────────────────────────────────────────────────────────
// EXAMPLE 2: Multi-level inheritance — Vehicle chain
// Vehicle → Car → ElectricCar
// ─────────────────────────────────────────────────────────────
 
class Vehicle {
    protected String brand;
    protected int    year;
    protected double fuelLevel;   // percentage 0–100
 
    Vehicle(String brand, int year) {
        this.brand     = brand;
        this.year      = year;
        this.fuelLevel = 100.0;
    }
 
    void start() {
        System.out.println(brand + " engine started.");
    }
 
    void stop() {
        System.out.println(brand + " engine stopped.");
    }
 
    void refuel(double amount) {
        fuelLevel = Math.min(100, fuelLevel + amount);
        System.out.println(brand + " refuelled. Level: " + fuelLevel + "%");
    }
 
    void status() {
        System.out.println("[" + year + " " + brand + "] Fuel: " + fuelLevel + "%");
    }
}
 
// ── Car extends Vehicle ──────────────────────────────────────
class Car extends Vehicle {
    protected int    doors;
    protected String transmission;
 
    Car(String brand, int year, int doors, String transmission) {
        super(brand, year);        // Vehicle constructor
        this.doors        = doors;
        this.transmission = transmission;
    }
 
    void honk() {
        System.out.println(brand + ": Beep beep! 📯");
    }
 
    @Override
    void status() {
        super.status();
        System.out.println("  Doors: " + doors + " | Gearbox: " + transmission);
    }
}
 
// ── ElectricCar extends Car ──────────────────────────────────
class ElectricCar extends Car {
    private double batteryLevel;   // percentage 0–100
    private int    rangeKm;
 
    ElectricCar(String brand, int year, int doors, int rangeKm) {
        super(brand, year, doors, "Automatic"); // Car constructor
        this.batteryLevel = 100.0;
        this.rangeKm      = rangeKm;
    }
 
    void charge(double amount) {
        batteryLevel = Math.min(100, batteryLevel + amount);
        System.out.println(brand + " charging... Battery: " + batteryLevel + "%");
    }
 
    @Override
    void start() {
        System.out.println(brand + " quietly starts. ⚡ (Electric)");
    }
 
    @Override
    void refuel(double amount) {
        // Electric cars don't refuel — override to redirect
        System.out.println("⚠ Electric car! Use charge() instead of refuel().");
    }
 
    @Override
    void status() {
        super.status();
        System.out.println("  Battery: " + batteryLevel + "% | Range: " + rangeKm + "km");
    }
}
 
 
// ─────────────────────────────────────────────────────────────
// EXAMPLE 3: Real-world — Staff hierarchy
// Person → Employee → Manager
// ─────────────────────────────────────────────────────────────
 
class StaffPerson {
    protected String name;
    protected int    age;
    protected String address;
 
    StaffPerson(String name, int age, String address) {
        this.name    = name;
        this.age     = age;
        this.address = address;
    }
 
    void printBasicInfo() {
        System.out.println("Name:    " + name);
        System.out.println("Age:     " + age);
        System.out.println("Address: " + address);
    }
}
 
// ── Employee extends StaffPerson ─────────────────────────────
class StaffEmployee extends StaffPerson {
    protected String employeeId;
    protected String department;
    protected double salary;
 
    StaffEmployee(String name, int age, String address,
                  String employeeId, String department, double salary) {
        super(name, age, address);
        this.employeeId = employeeId;
        this.department = department;
        this.salary     = salary;
    }
 
    void work() {
        System.out.println(name + " [" + employeeId + "] is working in " + department + ".");
    }
 
    @Override
    void printBasicInfo() {
        super.printBasicInfo();
        System.out.println("Emp ID:  " + employeeId);
        System.out.println("Dept:    " + department);
        System.out.printf( "Salary:  ৳%.2f%n", salary);
    }
}
 
// ── Manager extends Employee ─────────────────────────────────
class StaffManager extends StaffEmployee {
    private String[] teamMembers;
    private int      teamSize;
    private double   bonus;
 
    StaffManager(String name, int age, String address,
                 String employeeId, double salary, int teamCapacity) {
        super(name, age, address, employeeId, "Management", salary);
        this.teamMembers = new String[teamCapacity];
        this.teamSize    = 0;
        this.bonus       = salary * 0.20;   // 20% bonus for managers
    }
 
    void addTeamMember(String memberName) {
        if (teamSize < teamMembers.length) {
            teamMembers[teamSize++] = memberName;
            System.out.println("  + " + memberName + " added to " + name + "'s team.");
        } else {
            System.out.println("✘ Team is at full capacity!");
        }
    }
 
    void conductMeeting() {
        System.out.println(name + " is conducting a team meeting with " + teamSize + " members.");
    }
 
    @Override
    void work() {
        super.work();
        System.out.println(name + " is also managing a team of " + teamSize + " people.");
    }
 
    @Override
    void printBasicInfo() {
        super.printBasicInfo();
        System.out.printf("Bonus:   ৳%.2f%n", bonus);
        System.out.println("Team (" + teamSize + "):");
        for (int i = 0; i < teamSize; i++) {
            System.out.println("  • " + teamMembers[i]);
        }
    }
}
 
 
// ─────────────────────────────────────────────────────────────
// MAIN CLASS
// ─────────────────────────────────────────────────────────────
 
public class Inheritance {
 
    public static void main(String[] args) {
 
        System.out.println("========================================");
        System.out.println(" Module 05: Inheritance");
        System.out.println("========================================\n");
 
 
        // ── Example 1: Animal family ──────────────────────────────
        System.out.println("── Example 1: Animal Family ──");
 
        Dog  dog  = new Dog("Bruno", 3, "German Shepherd");
        Cat  cat  = new Cat("Luna", 2, true);
        Bird bird = new Bird("Sky", 1, 45.5);
 
        // All inherit eat() and sleep() from Animal
        dog.eat();
        cat.eat();
        bird.eat();
 
        System.out.println();
 
        // Each has its own makeSound() — overridden
        dog.makeSound();
        cat.makeSound();
        bird.makeSound();
 
        System.out.println();
 
        // Own methods unique to each child
        dog.fetch();
        cat.purr();
        bird.fly();
 
        System.out.println();
 
        // describe() calls super.describe() then adds own info
        dog.describe();
        System.out.println();
        cat.describe();
        System.out.println();
        bird.describe();
 
 
        // ── Example 2: Vehicle → Car → ElectricCar ───────────────
        System.out.println("\n── Example 2: Vehicle Inheritance Chain ──");
 
        Vehicle    v   = new Vehicle("Generic", 2020);
        Car        car = new Car("Toyota Corolla", 2022, 4, "Manual");
        ElectricCar ev = new ElectricCar("Tesla Model 3", 2023, 4, 560);
 
        System.out.println("\nGeneric Vehicle:");
        v.start();
        v.status();
 
        System.out.println("\nCar:");
        car.start();         // inherited from Vehicle
        car.honk();          // Car's own
        car.status();        // overridden — shows extra info
 
        System.out.println("\nElectric Car:");
        ev.start();          // overridden — silent electric start
        ev.refuel(20);       // overridden — tells user to charge instead
        ev.charge(30);       // ElectricCar's own
        ev.honk();           // inherited from Car
        ev.status();         // full chain: Vehicle + Car + ElectricCar info
 
 
        // ── Example 3: Staff Hierarchy ────────────────────────────
        System.out.println("\n── Example 3: Staff Hierarchy ──");
 
        StaffEmployee emp = new StaffEmployee(
            "Rahim Uddin", 28, "Dhaka",
            "EMP-001", "Engineering", 55000
        );
 
        StaffManager mgr = new StaffManager(
            "Nadia Islam", 35, "Chittagong",
            "MGR-001", 90000, 5
        );
 
        mgr.addTeamMember("Rahim Uddin");
        mgr.addTeamMember("Karim Khan");
        mgr.addTeamMember("Sara Ahmed");
 
        System.out.println("\n--- Employee Info ---");
        emp.printBasicInfo();
        System.out.println();
        emp.work();
 
        System.out.println("\n--- Manager Info ---");
        mgr.printBasicInfo();
        System.out.println();
        mgr.work();           // calls super.work() then adds own behaviour
        mgr.conductMeeting();
 
 
        // ── Summary ───────────────────────────────────────────────
        System.out.println("\n========================================");
        System.out.println(" Key Takeaways:");
        System.out.println("  ✔ 'extends' gives child all parent members");
        System.out.println("  ✔ super() calls the parent constructor");
        System.out.println("  ✔ super.method() calls parent's method version");
        System.out.println("  ✔ @Override redefines an inherited method");
        System.out.println("  ✔ Chain: A→B→C — C inherits from both A and B");
        System.out.println("  ✔ 'final class' cannot be extended");
        System.out.println("  ✔ 'private' members are NOT inherited");
        System.out.println("========================================");
    }
}
