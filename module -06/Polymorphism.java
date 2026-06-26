// EXAMPLE 1: Compile-time Polymorphism — Method Overloading
// ─────────────────────────────────────────────────────────────
 
class MathUtils {
 
    // Same method name 'calculate' — different parameter lists
    int calculate(int a, int b) {
        System.out.println("  [int + int]");
        return a + b;
    }
 
    double calculate(double a, double b) {
        System.out.println("  [double + double]");
        return a + b;
    }
 
    int calculate(int a, int b, int c) {
        System.out.println("  [int + int + int]");
        return a + b + c;
    }
 
    double calculate(int a, double b) {
        System.out.println("  [int + double]");
        return a + b;
    }
 
    // Same name 'describe' — different types
    String describe(int n) {
        return n + " is " + (n % 2 == 0 ? "even" : "odd");
    }
 
    String describe(double d) {
        return d + " is a decimal number";
    }
 
    String describe(boolean b) {
        return "Boolean value: " + b;
    }
}
 
 
// ─────────────────────────────────────────────────────────────
// EXAMPLE 2: Runtime Polymorphism — Animal hierarchy
// ─────────────────────────────────────────────────────────────
 
class PolyAnimal {
    protected String name;
 
    PolyAnimal(String name) {
        this.name = name;
    }
 
    // This method will be overridden by each child
    void makeSound() {
        System.out.println(name + " makes a generic sound.");
    }
 
    void breathe() {
        System.out.println(name + " is breathing.");  // NOT overridden — same for all
    }
 
    String getType() { return "Animal"; }
}
 
class PolyDog extends PolyAnimal {
    private String breed;
 
    PolyDog(String name, String breed) {
        super(name);
        this.breed = breed;
    }
 
    @Override
    void makeSound() {
        System.out.println(name + " barks: Woof! Woof! 🐕");
    }
 
    @Override
    String getType() { return "Dog (" + breed + ")"; }
 
    void fetch() {
        System.out.println(name + " fetches the ball!");
    }
}
 
class PolyCat extends PolyAnimal {
    PolyCat(String name) { super(name); }
 
    @Override
    void makeSound() {
        System.out.println(name + " meows: Meow~ 🐈");
    }
 
    @Override
    String getType() { return "Cat"; }
 
    void purr() {
        System.out.println(name + " is purring...");
    }
}
 
class PolyBird extends PolyAnimal {
    PolyBird(String name) { super(name); }
 
    @Override
    void makeSound() {
        System.out.println(name + " chirps: Tweet! Tweet! 🐦");
    }
 
    @Override
    String getType() { return "Bird"; }
 
    void fly() {
        System.out.println(name + " is flying high!");
    }
}
 
class PolyCow extends PolyAnimal {
    PolyCow(String name) { super(name); }
 
    @Override
    void makeSound() {
        System.out.println(name + " moos: Moooo~ 🐄");
    }
 
    @Override
    String getType() { return "Cow"; }
}
 
 
// ─────────────────────────────────────────────────────────────
// EXAMPLE 3: Polymorphic Shape Calculator
// ─────────────────────────────────────────────────────────────
 
class Shape {
    protected String color;
 
    Shape(String color) {
        this.color = color;
    }
 
    double area() {
        return 0;  // base — child classes override this
    }
 
    double perimeter() {
        return 0;
    }
 
    void describe() {
        System.out.printf("  %-12s | Color: %-8s | Area: %8.2f | Perimeter: %7.2f%n",
                          getClass().getSimpleName(), color, area(), perimeter());
    }
}
 
class Circle extends Shape {
    private double radius;
 
    Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }
 
    @Override
    double area() { return Math.PI * radius * radius; }
 
    @Override
    double perimeter() { return 2 * Math.PI * radius; }
}
 
class Rectangle extends Shape {
    private double width, height;
 
    Rectangle(String color, double width, double height) {
        super(color);
        this.width  = width;
        this.height = height;
    }
 
    @Override
    double area() { return width * height; }
 
    @Override
    double perimeter() { return 2 * (width + height); }
}
 
class Triangle extends Shape {
    private double a, b, c;  // three sides
 
    Triangle(String color, double a, double b, double c) {
        super(color);
        this.a = a; this.b = b; this.c = c;
    }
 
    @Override
    double area() {
        double s = (a + b + c) / 2;          // Heron's formula
        return Math.sqrt(s * (s-a) * (s-b) * (s-c));
    }
 
    @Override
    double perimeter() { return a + b + c; }
}
 
class Square extends Rectangle {
    Square(String color, double side) {
        super(color, side, side);
    }
}
 
 
// ─────────────────────────────────────────────────────────────
// EXAMPLE 4: Real-world — Payment System
// ─────────────────────────────────────────────────────────────
 
class Payment {
    protected String payerName;
    protected double amount;
 
    Payment(String payerName, double amount) {
        this.payerName = payerName;
        this.amount    = amount;
    }
 
    // Each payment type overrides this
    void processPayment() {
        System.out.println("Processing payment of ৳" + amount + " by " + payerName);
    }
 
    String getPaymentType() { return "Generic"; }
 
    void printReceipt() {
        System.out.println("  Payer:  " + payerName);
        System.out.printf( "  Amount: ৳%.2f%n", amount);
        System.out.println("  Type:   " + getPaymentType());
    }
}
 
class CashPayment extends Payment {
    private double cashGiven;
 
    CashPayment(String payerName, double amount, double cashGiven) {
        super(payerName, amount);
        this.cashGiven = cashGiven;
    }
 
    @Override
    void processPayment() {
        double change = cashGiven - amount;
        System.out.println("  💵 Cash received: ৳" + cashGiven);
        System.out.printf( "  💰 Change returned: ৳%.2f%n", change);
    }
 
    @Override
    String getPaymentType() { return "Cash"; }
}
 
class CardPayment extends Payment {
    private String cardNumber;
    private String cardType;
 
    CardPayment(String payerName, double amount, String cardNumber, String cardType) {
        super(payerName, amount);
        // Show only last 4 digits for security
        this.cardNumber = "**** **** **** " + cardNumber.substring(cardNumber.length() - 4);
        this.cardType   = cardType;
    }
 
    @Override
    void processPayment() {
        System.out.println("  💳 Charging " + cardType + " card: " + cardNumber);
        System.out.println("  ✔ Transaction approved!");
    }
 
    @Override
    String getPaymentType() { return cardType + " Card"; }
}
 
class MobilePayment extends Payment {
    private String mobileNumber;
    private String provider;
 
    MobilePayment(String payerName, double amount, String mobileNumber, String provider) {
        super(payerName, amount);
        this.mobileNumber = mobileNumber;
        this.provider     = provider;
    }
 
    @Override
    void processPayment() {
        System.out.println("  📱 Sending via " + provider + " to: " + mobileNumber);
        System.out.println("  ✔ Payment sent successfully!");
    }
 
    @Override
    String getPaymentType() { return provider + " (Mobile)"; }
}
 
 
// ─────────────────────────────────────────────────────────────
// MAIN CLASS
// ─────────────────────────────────────────────────────────────
 
public class Polymorphism {
 
    public static void main(String[] args) {
 
        System.out.println("========================================");
        System.out.println(" Module 06: Polymorphism");
        System.out.println("========================================\n");
 
 
        // ── Example 1: Compile-time — Overloading ────────────────
        System.out.println("── Example 1: Compile-time Polymorphism (Overloading) ──");
 
        MathUtils mu = new MathUtils();
 
        System.out.println("calculate(5, 3):");
        System.out.println("  Result: " + mu.calculate(5, 3));
 
        System.out.println("calculate(2.5, 3.5):");
        System.out.println("  Result: " + mu.calculate(2.5, 3.5));
 
        System.out.println("calculate(1, 2, 3):");
        System.out.println("  Result: " + mu.calculate(1, 2, 3));
 
        System.out.println("calculate(4, 1.5):");
        System.out.println("  Result: " + mu.calculate(4, 1.5));
 
        System.out.println();
        System.out.println(mu.describe(42));
        System.out.println(mu.describe(3.14));
        System.out.println(mu.describe(true));
 
 
        // ── Example 2: Runtime Polymorphism ──────────────────────
        System.out.println("\n── Example 2: Runtime Polymorphism (Overriding) ──");
 
        // Parent reference — different child objects
        PolyAnimal a;
 
        a = new PolyDog("Bruno", "Labrador");
        System.out.println("Type: " + a.getType());
        a.makeSound();
 
        a = new PolyCat("Luna");
        System.out.println("Type: " + a.getType());
        a.makeSound();
 
        a = new PolyBird("Tweety");
        System.out.println("Type: " + a.getType());
        a.makeSound();
 
        a = new PolyCow("Bessie");
        System.out.println("Type: " + a.getType());
        a.makeSound();
 
        // breathe() is NOT overridden — same for all
        System.out.println("\nbreathe() is not overridden:");
        a.breathe();
 
 
        // ── Upcasting + Downcasting + instanceof ─────────────────
        System.out.println("\n── Upcasting, Downcasting & instanceof ──");
 
        PolyAnimal animal = new PolyDog("Rex", "German Shepherd"); // upcast
 
        // Can only call Animal methods via parent reference
        animal.makeSound();  // runs Dog's version — runtime polymorphism!
 
        // instanceof check before downcast
        if (animal instanceof PolyDog) {
            PolyDog dog = (PolyDog) animal;  // safe downcast
            dog.fetch();                      // now Dog-specific method works
        }
 
        // Wrong downcast — caught by instanceof
        if (animal instanceof PolyCat) {
            System.out.println("This won't print — animal is a Dog, not a Cat");
        } else {
            System.out.println("instanceof check: animal is NOT a Cat. Safe!");
        }
 
 
        // ── Example 3: Polymorphic Shape Array ───────────────────
        System.out.println("\n── Example 3: Shape Area Calculator ──");
 
        Shape[] shapes = {
            new Circle("Red",    7.0),
            new Rectangle("Blue",  8.0, 5.0),
            new Triangle("Green", 3.0, 4.0, 5.0),
            new Square("Yellow", 6.0),
            new Circle("Purple", 3.5),
            new Rectangle("Orange", 10.0, 2.5)
        };
 
        System.out.printf("  %-12s | %-14s | %-14s | %s%n",
                          "Shape", "Color", "Area", "Perimeter");
        System.out.println("  " + "─".repeat(60));
 
        double totalArea = 0;
        for (Shape s : shapes) {
            s.describe();             // each shape uses ITS OWN area() and perimeter()
            totalArea += s.area();
        }
 
        System.out.printf("%n  Total area of all shapes: %.2f sq units%n", totalArea);
 
 
        // ── Example 4: Payment System ─────────────────────────────
        System.out.println("\n── Example 4: Polymorphic Payment System ──");
 
        Payment[] payments = {
            new CashPayment("Rahim", 850.00, 1000.00),
            new CardPayment("Nadia", 3200.00, "1234567890123456", "Visa"),
            new MobilePayment("Karim", 500.00, "01712345678", "bKash"),
            new MobilePayment("Sara", 1200.00, "01898765432", "Nagad"),
            new CardPayment("Arif", 7500.00, "9876543210987654", "Mastercard")
        };
 
        for (Payment p : payments) {
            System.out.println("\n--- Processing Payment ---");
            p.printReceipt();       // each prints its own type
            p.processPayment();     // each processes differently — polymorphism!
        }
 
 
        // ── Summary ───────────────────────────────────────────────
        System.out.println("\n========================================");
        System.out.println(" Key Takeaways:");
        System.out.println("  ✔ Overloading = compile-time polymorphism");
        System.out.println("  ✔ Overriding  = runtime polymorphism");
        System.out.println("  ✔ Parent ref can hold any child object");
        System.out.println("  ✔ Java always runs the ACTUAL object's method");
        System.out.println("  ✔ Upcasting: automatic and safe");
        System.out.println("  ✔ Downcasting: use instanceof first!");
        System.out.println("  ✔ Polymorphic arrays: powerful and clean");
        System.out.println("========================================");
    }
}
 
