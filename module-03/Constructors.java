 // EXAMPLE 1: No-arg, Parameterized, and Copy Constructor
// ─────────────────────────────────────────────────────────────
 
class Book {
    String title;
    String author;
    double price;
    int pages;
 
    // No-arg constructor — sets default values
    Book() {
        title  = "Untitled";
        author = "Unknown";
        price  = 0.0;
        pages  = 0;
    }
 
    // Parameterized constructor — full details
    Book(String title, String author, double price, int pages) {
        this.title  = title;
        this.author = author;
        this.price  = price;
        this.pages  = pages;
    }
 
    // Copy constructor — creates a duplicate of another Book
    Book(Book other) {
        this.title  = other.title;
        this.author = other.author;
        this.price  = other.price;
        this.pages  = other.pages;
    }
 
    void display() {
        System.out.println("\"" + title + "\" by " + author +
                           " | $" + price + " | " + pages + " pages");
    }
}
 
 
// ─────────────────────────────────────────────────────────────
// EXAMPLE 2: Constructor Chaining with this()
// ─────────────────────────────────────────────────────────────
 
class Phone {
    String brand;
    String model;
    int    storage;   // GB
    String color;
 
    // No-arg → calls 2-param constructor
    Phone() {
        this("Generic", "Basic");
        System.out.println("  [No-arg constructor called]");
    }
 
    // 2-param → calls 4-param constructor
    Phone(String brand, String model) {
        this(brand, model, 128, "Black");
        System.out.println("  [2-param constructor called]");
    }
 
    // 3-param → calls 4-param constructor
    Phone(String brand, String model, int storage) {
        this(brand, model, storage, "White");
        System.out.println("  [3-param constructor called]");
    }
 
    // 4-param — the "master" constructor that does all the work
    Phone(String brand, String model, int storage, String color) {
        this.brand   = brand;
        this.model   = model;
        this.storage = storage;
        this.color   = color;
        System.out.println("  [4-param constructor called — object initialized]");
    }
 
    void display() {
        System.out.println(brand + " " + model +
                           " | " + storage + "GB | " + color);
    }
}
 
 
// ─────────────────────────────────────────────────────────────
// EXAMPLE 3: Real-world — Laptop class with all constructor types
// ─────────────────────────────────────────────────────────────
 
class Laptop {
    private String brand;
    private String processor;
    private int    ramGB;
    private int    storageGB;
    private double price;
 
    // No-arg — budget default laptop
    Laptop() {
        this("Generic Brand", "Intel Core i3", 4, 256, 30000);
    }
 
    // Brand only — fills the rest with sensible defaults
    Laptop(String brand) {
        this(brand, "Intel Core i5", 8, 512, 60000);
    }
 
    // Full parameterized constructor
    Laptop(String brand, String processor, int ramGB, int storageGB, double price) {
        this.brand     = brand;
        this.processor = processor;
        this.ramGB     = ramGB;
        this.storageGB = storageGB;
        this.price     = price;
    }
 
    // Copy constructor — duplicate a laptop config
    Laptop(Laptop other) {
        this.brand     = other.brand;
        this.processor = other.processor;
        this.ramGB     = other.ramGB;
        this.storageGB = other.storageGB;
        this.price     = other.price;
    }
 
    // Upgrade RAM (returns new upgraded copy — original unchanged)
    Laptop withRam(int newRam) {
        Laptop upgraded = new Laptop(this);  // copy
        upgraded.ramGB  = newRam;
        upgraded.price += 5000 * (newRam - this.ramGB) / 4;
        return upgraded;
    }
 
    void printSpec() {
        System.out.println("┌─────────────────────────────────────┐");
        System.out.println("  Brand:     " + brand);
        System.out.println("  CPU:       " + processor);
        System.out.println("  RAM:       " + ramGB + " GB");
        System.out.println("  Storage:   " + storageGB + " GB");
        System.out.printf( "  Price:     ৳%.0f%n", price);
        System.out.println("└─────────────────────────────────────┘");
    }
}
 
 
// ─────────────────────────────────────────────────────────────
// EXAMPLE 4: Demonstrating copy constructor independence
// ─────────────────────────────────────────────────────────────
 
class Point {
    int x;
    int y;
 
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
 
    // Copy constructor
    Point(Point other) {
        this.x = other.x;
        this.y = other.y;
    }
 
    void display(String label) {
        System.out.println(label + " → (" + x + ", " + y + ")");
    }
}
 
 
// ─────────────────────────────────────────────────────────────
// MAIN CLASS
// ─────────────────────────────────────────────────────────────
 
public class Constructors {
 
    public static void main(String[] args) {
 
        System.out.println("========================================");
        System.out.println(" Module 03: Constructors Deep Dive");
        System.out.println("========================================\n");
 
 
        // ── Example 1: No-arg, Parameterized, Copy ───────────────
        System.out.println("── Example 1: Book Constructors ──");
 
        Book b1 = new Book();                                    // no-arg
        Book b2 = new Book("Clean Code", "Robert Martin", 35.99, 431); // parameterized
        Book b3 = new Book(b2);                                  // copy of b2
 
        System.out.print("Default book:      "); b1.display();
        System.out.print("Parameterized:     "); b2.display();
        System.out.print("Copy of b2:        "); b3.display();
 
        // Prove they are independent — changing b3 doesn't affect b2
        b3.title = "The Clean Coder";
        b3.price = 29.99;
        System.out.println("\nAfter modifying b3:");
        System.out.print("b2 (original): "); b2.display();
        System.out.print("b3 (copy):     "); b3.display();
 
 
        // ── Example 2: Constructor Chaining ──────────────────────
        System.out.println("\n── Example 2: Phone — Constructor Chaining ──");
 
        System.out.println("\nCreating Phone with no-arg:");
        Phone p1 = new Phone();
        p1.display();
 
        System.out.println("\nCreating Phone with 2 params:");
        Phone p2 = new Phone("Samsung", "Galaxy A54");
        p2.display();
 
        System.out.println("\nCreating Phone with 3 params:");
        Phone p3 = new Phone("Xiaomi", "Redmi Note 12", 256);
        p3.display();
 
        System.out.println("\nCreating Phone with all 4 params:");
        Phone p4 = new Phone("Apple", "iPhone 15", 512, "Midnight Blue");
        p4.display();
 
 
        // ── Example 3: Laptop — Real-world chaining + copy ───────
        System.out.println("\n── Example 3: Laptop Configurations ──");
 
        Laptop budget   = new Laptop();                // no-arg defaults
        Laptop mid      = new Laptop("Dell");          // brand only
        Laptop highEnd  = new Laptop(                  // fully custom
            "ASUS ROG", "AMD Ryzen 9", 32, 1000, 180000
        );
        Laptop upgraded = highEnd.withRam(64);         // copy + upgrade
 
        System.out.println("Budget Laptop:");
        budget.printSpec();
 
        System.out.println("Mid-range Laptop:");
        mid.printSpec();
 
        System.out.println("High-end Laptop:");
        highEnd.printSpec();
 
        System.out.println("Upgraded (64GB RAM):");
        upgraded.printSpec();
 
 
        // ── Example 4: Copy constructor independence ──────────────
        System.out.println("\n── Example 4: Copy Constructor Independence ──");
 
        Point original = new Point(10, 20);
        Point copy     = new Point(original);   // copy constructor
 
        original.display("Original");
        copy.display("Copy    ");
 
        // Modify the copy — original should NOT change
        copy.x = 99;
        copy.y = 99;
 
        System.out.println("\nAfter changing the copy:");
        original.display("Original");  // still (10, 20)
        copy.display("Copy    ");      // now (99, 99)
 
 
        // ── Summary ───────────────────────────────────────────────
        System.out.println("\n========================================");
        System.out.println(" Key Takeaways:");
        System.out.println("  ✔ No-arg: sets safe default values");
        System.out.println("  ✔ Parameterized: custom values at creation");
        System.out.println("  ✔ Copy: duplicates an existing object");
        System.out.println("  ✔ this(): chains constructors, avoids repetition");
        System.out.println("  ✔ this() must be the FIRST line in constructor");
        System.out.println("========================================");
    }
}
