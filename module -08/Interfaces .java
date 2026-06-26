// EXAMPLE 1: Basic Interface — Drawable shapes
// ─────────────────────────────────────────────────────────────
 
interface Drawable {
    // Constant — always public static final
    String DEFAULT_COLOR = "Black";
 
    // Abstract methods — must be implemented
    void draw();
    double area();
 
    // Default method — optional to override
    default void describe() {
        System.out.println("  Shape: " + getClass().getSimpleName() +
                           " | Area: " + String.format("%.2f", area()));
    }
 
    // Static method — called on interface itself
    static void printInfo() {
        System.out.println("  [Drawable] All shapes must implement draw() and area()");
    }
}
 
class ICircle implements Drawable {
    private double radius;
    private String color;
 
    ICircle(double radius, String color) {
        this.radius = radius;
        this.color  = color;
    }
 
    @Override
    public void draw() {
        System.out.println("  Drawing Circle — radius: " + radius +
                           ", color: " + color);
    }
 
    @Override
    public double area() { return Math.PI * radius * radius; }
}
 
class ISquare implements Drawable {
    private double side;
 
    ISquare(double side) { this.side = side; }
 
    @Override
    public void draw() {
        System.out.println("  Drawing Square — side: " + side +
                           ", color: " + DEFAULT_COLOR);  // using interface constant
    }
 
    @Override
    public double area() { return side * side; }
 
    @Override
    public void describe() {
        // Overriding default method to add more info
        System.out.println("  Square | Side: " + side +
                           " | Area: " + String.format("%.2f", area()) +
                           " | Perimeter: " + (4 * side));
    }
}
 
 
// ─────────────────────────────────────────────────────────────
// EXAMPLE 2: Multiple Interfaces
// ─────────────────────────────────────────────────────────────
 
interface Swimmable {
    void swim();
    default String getSwimStyle() { return "freestyle"; }
}
 
interface Flyable {
    void fly();
    int MAX_ALTITUDE = 10000;  // constant
}
 
interface Walkable {
    void walk();
    default void run() {
        System.out.println(getClass().getSimpleName() + " is running fast!");
    }
}
 
// Duck implements all three!
class Duck implements Swimmable, Flyable, Walkable {
    private String name;
 
    Duck(String name) { this.name = name; }
 
    @Override
    public void swim() {
        System.out.println(name + " swims using " + getSwimStyle() + " stroke 🏊");
    }
 
    @Override
    public void fly() {
        System.out.println(name + " flies up to " + MAX_ALTITUDE + "m altitude 🦆");
    }
 
    @Override
    public void walk() {
        System.out.println(name + " waddles along the pond 🐾");
    }
}
 
// Fish can only swim
class Fish implements Swimmable {
    private String species;
 
    Fish(String species) { this.species = species; }
 
    @Override
    public void swim() {
        System.out.println(species + " swims gracefully underwater 🐟");
    }
 
    @Override
    public String getSwimStyle() { return "tail-fin propulsion"; }
}
 
// Eagle can fly and walk but not swim
class Eagle implements Flyable, Walkable {
    private String name;
 
    Eagle(String name) { this.name = name; }
 
    @Override
    public void fly() {
        System.out.println(name + " soars majestically at " + MAX_ALTITUDE + "m 🦅");
    }
 
    @Override
    public void walk() {
        System.out.println(name + " walks on the ground with talons 🦶");
    }
}
 
 
// ─────────────────────────────────────────────────────────────
// EXAMPLE 3: Interface as a Type — Polymorphism
// ─────────────────────────────────────────────────────────────
 
interface Printable {
    void print();
 
    default void printWithBorder() {
        System.out.println("  ┌" + "─".repeat(38) + "┐");
        System.out.print("  │  ");
        print();
        System.out.println("  └" + "─".repeat(38) + "┘");
    }
}
 
class Invoice implements Printable {
    private String customer;
    private double amount;
 
    Invoice(String customer, double amount) {
        this.customer = customer;
        this.amount   = amount;
    }
 
    @Override
    public void print() {
        System.out.printf("Invoice: %-15s ৳%.2f%n", customer, amount);
    }
}
 
class Report implements Printable {
    private String title;
    private int    pages;
 
    Report(String title, int pages) {
        this.title = title;
        this.pages = pages;
    }
 
    @Override
    public void print() {
        System.out.printf("Report: %-20s (%d pages)%n", title, pages);
    }
}
 
class Label implements Printable {
    private String text;
 
    Label(String text) { this.text = text; }
 
    @Override
    public void print() {
        System.out.println("Label: " + text);
    }
}
 
 
// ─────────────────────────────────────────────────────────────
// EXAMPLE 4: Functional Interface + Lambdas
// ─────────────────────────────────────────────────────────────
 
@FunctionalInterface
interface MathOperation {
    int operate(int a, int b);   // single abstract method
}
 
@FunctionalInterface
interface StringTransformer {
    String transform(String input);
}
 
@FunctionalInterface
interface Validator {
    boolean validate(String input);
}
 
 
// ─────────────────────────────────────────────────────────────
// EXAMPLE 5: Real-world — Smart Home Device System
// ─────────────────────────────────────────────────────────────
 
interface Switchable {
    void turnOn();
    void turnOff();
    boolean isOn();
}
 
interface Dimmable {
    void setBrightness(int percent);   // 0–100
    int  getBrightness();
}
 
interface Schedulable {
    void setSchedule(String onTime, String offTime);
    default void printSchedule() {
        System.out.println("  Schedule: " + getScheduleInfo());
    }
    String getScheduleInfo();
}
 
// Smart Bulb — all three interfaces
class SmartBulb implements Switchable, Dimmable, Schedulable {
    private String name;
    private boolean on;
    private int     brightness;
    private String  schedule;
 
    SmartBulb(String name) {
        this.name       = name;
        this.on         = false;
        this.brightness = 100;
        this.schedule   = "Not set";
    }
 
    @Override public void turnOn()  { on = true;  System.out.println("  💡 " + name + " ON"); }
    @Override public void turnOff() { on = false; System.out.println("  💡 " + name + " OFF"); }
    @Override public boolean isOn() { return on; }
 
    @Override
    public void setBrightness(int percent) {
        if (percent < 0 || percent > 100) {
            System.out.println("  ✘ Brightness must be 0–100");
            return;
        }
        brightness = percent;
        System.out.println("  💡 " + name + " brightness: " + percent + "%");
    }
    @Override public int getBrightness() { return brightness; }
 
    @Override
    public void setSchedule(String onTime, String offTime) {
        schedule = onTime + " → " + offTime;
        System.out.println("  ⏰ " + name + " scheduled: " + schedule);
    }
    @Override public String getScheduleInfo() { return schedule; }
 
    void status() {
        System.out.println("  [" + name + "] " +
                           (on ? "ON" : "OFF") +
                           " | Brightness: " + brightness + "%" +
                           " | Schedule: " + schedule);
    }
}
 
// Smart Fan — only Switchable and Schedulable (not Dimmable)
class SmartFan implements Switchable, Schedulable {
    private String name;
    private boolean on;
    private int     speed;   // 1–5
    private String  schedule;
 
    SmartFan(String name) {
        this.name     = name;
        this.on       = false;
        this.speed    = 3;
        this.schedule = "Not set";
    }
 
    @Override public void turnOn()  { on = true;  System.out.println("  🌀 " + name + " ON  (speed " + speed + ")"); }
    @Override public void turnOff() { on = false; System.out.println("  🌀 " + name + " OFF"); }
    @Override public boolean isOn() { return on; }
 
    public void setSpeed(int speed) {
        if (speed < 1 || speed > 5) { System.out.println("  ✘ Speed must be 1–5"); return; }
        this.speed = speed;
        System.out.println("  🌀 " + name + " speed set to " + speed);
    }
 
    @Override
    public void setSchedule(String onTime, String offTime) {
        schedule = onTime + " → " + offTime;
        System.out.println("  ⏰ " + name + " scheduled: " + schedule);
    }
    @Override public String getScheduleInfo() { return schedule; }
 
    void status() {
        System.out.println("  [" + name + "] " +
                           (on ? "ON" : "OFF") +
                           " | Speed: " + speed +
                           " | Schedule: " + schedule);
    }
}
 
// Smart TV — Switchable only
class SmartTV implements Switchable {
    private String name;
    private boolean on;
    private String  channel;
 
    SmartTV(String name) {
        this.name    = name;
        this.on      = false;
        this.channel = "BBC News";
    }
 
    @Override public void turnOn()  { on = true;  System.out.println("  📺 " + name + " ON  → " + channel); }
    @Override public void turnOff() { on = false; System.out.println("  📺 " + name + " OFF"); }
    @Override public boolean isOn() { return on; }
 
    public void setChannel(String channel) {
        this.channel = channel;
        System.out.println("  📺 Switched to: " + channel);
    }
}
 
 
// ─────────────────────────────────────────────────────────────
// MAIN CLASS
// ─────────────────────────────────────────────────────────────
 
public class Interfaces {
 
    public static void main(String[] args) {
 
        System.out.println("========================================");
        System.out.println(" Module 08: Interfaces");
        System.out.println("========================================\n");
 
 
        // ── Example 1: Basic Interface ────────────────────────────
        System.out.println("── Example 1: Drawable Interface ──");
 
        Drawable.printInfo();   // static method on interface
 
        Drawable[] shapes = {
            new ICircle(5.0, "Red"),
            new ISquare(4.0)
        };
 
        for (Drawable d : shapes) {
            d.draw();
            d.describe();   // Circle uses default; Square overrides it
        }
 
 
        // ── Example 2: Multiple Interfaces ───────────────────────
        System.out.println("\n── Example 2: Multiple Interfaces ──");
 
        Duck  duck  = new Duck("Donald");
        Fish  fish  = new Fish("Salmon");
        Eagle eagle = new Eagle("Sam");
 
        System.out.println("Duck (Swimmable + Flyable + Walkable):");
        duck.swim();
        duck.fly();
        duck.walk();
        duck.run();   // default method from Walkable
 
        System.out.println("\nFish (Swimmable only):");
        fish.swim();
 
        System.out.println("\nEagle (Flyable + Walkable):");
        eagle.fly();
        eagle.walk();
        eagle.run();  // default method from Walkable
 
        // Interface as type — only Swimmable behaviours visible
        System.out.println("\nUsing interface as type:");
        Swimmable[] swimmers = { duck, fish };
        for (Swimmable s : swimmers) {
            s.swim();
        }
 
 
        // ── Example 3: Printable — polymorphism with interface ────
        System.out.println("\n── Example 3: Interface as Type (Printable) ──");
 
        Printable[] docs = {
            new Invoice("Rahim Uddin",  4500.00),
            new Invoice("Nadia Islam",  12750.50),
            new Report("Q2 Sales Summary", 12),
            new Label("FRAGILE — Handle with care"),
        };
 
        for (Printable doc : docs) {
            doc.printWithBorder();   // default method — same for all
        }
 
 
        // ── Example 4: Functional Interface + Lambdas ─────────────
        System.out.println("\n── Example 4: Functional Interface & Lambdas ──");
 
        // Define operations as lambdas — no class needed!
        MathOperation add      = (a, b) -> a + b;
        MathOperation subtract = (a, b) -> a - b;
        MathOperation multiply = (a, b) -> a * b;
        MathOperation power    = (a, b) -> (int) Math.pow(a, b);
 
        System.out.println("  10 + 3  = " + add.operate(10, 3));
        System.out.println("  10 - 3  = " + subtract.operate(10, 3));
        System.out.println("  10 × 3  = " + multiply.operate(10, 3));
        System.out.println("  10 ^ 3  = " + power.operate(10, 3));
 
        // String transformers
        StringTransformer toUpper  = s -> s.toUpperCase();
        StringTransformer toLower  = s -> s.toLowerCase();
        StringTransformer reverse  = s -> new StringBuilder(s).reverse().toString();
        StringTransformer addStars = s -> "★ " + s + " ★";
 
        String word = "Hello Java";
        System.out.println("\n  Original: " + word);
        System.out.println("  Upper:    " + toUpper.transform(word));
        System.out.println("  Lower:    " + toLower.transform(word));
        System.out.println("  Reverse:  " + reverse.transform(word));
        System.out.println("  Stars:    " + addStars.transform(word));
 
        // Validators
        Validator isEmail    = s -> s.contains("@") && s.contains(".");
        Validator isNotEmpty = s -> s != null && !s.trim().isEmpty();
        Validator isLong     = s -> s.length() >= 8;
 
        String[] inputs = { "user@email.com", "notanemail", "", "short", "validpassword123" };
        System.out.println("\n  Validation results:");
        for (String input : inputs) {
            System.out.printf("  %-20s | email:%-5s | notEmpty:%-5s | long:%-5s%n",
                              "\"" + input + "\"",
                              isEmail.validate(input),
                              isNotEmpty.validate(input),
                              isLong.validate(input));
        }
 
 
        // ── Example 5: Smart Home System ─────────────────────────
        System.out.println("\n── Example 5: Smart Home Device System ──");
 
        SmartBulb livingRoomLight = new SmartBulb("Living Room Light");
        SmartBulb bedroomLight    = new SmartBulb("Bedroom Light");
        SmartFan  ceilingFan      = new SmartFan("Ceiling Fan");
        SmartTV   tv              = new SmartTV("Samsung 55\"");
 
        System.out.println("\nTurning everything on:");
        livingRoomLight.turnOn();
        bedroomLight.turnOn();
        ceilingFan.turnOn();
        tv.turnOn();
 
        System.out.println("\nAdjusting settings:");
        livingRoomLight.setBrightness(80);
        bedroomLight.setBrightness(30);
        ceilingFan.setSpeed(4);
        tv.setChannel("Discovery Channel");
 
        System.out.println("\nSetting schedules:");
        livingRoomLight.setSchedule("06:00", "23:00");
        bedroomLight.setSchedule("21:00", "07:00");
        ceilingFan.setSchedule("08:00", "22:00");
 
        // Use interface type — only Switchable methods visible
        System.out.println("\nAll devices status (via Switchable interface):");
        Switchable[] allDevices = { livingRoomLight, bedroomLight, ceilingFan, tv };
        for (Switchable device : allDevices) {
            System.out.println("  " + device.getClass().getSimpleName() +
                               " is " + (device.isOn() ? "ON ✅" : "OFF ❌"));
        }
 
        System.out.println("\nTurning off bedroom light and TV:");
        bedroomLight.turnOff();
        tv.turnOff();
 
        System.out.println("\nFinal device statuses:");
        livingRoomLight.status();
        bedroomLight.status();
        ceilingFan.status();
 
 
        // ── Summary ───────────────────────────────────────────────
        System.out.println("\n========================================");
        System.out.println(" Key Takeaways:");
        System.out.println("  ✔ interface = pure contract (what, not how)");
        System.out.println("  ✔ implements = class follows the contract");
        System.out.println("  ✔ One class can implement MANY interfaces");
        System.out.println("  ✔ Interface fields are always constants");
        System.out.println("  ✔ default method = body in interface");
        System.out.println("  ✔ @FunctionalInterface = use with lambdas");
        System.out.println("  ✔ Interface as type = powerful polymorphism");
        System.out.println("========================================");
    }
}
