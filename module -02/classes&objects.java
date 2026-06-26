// EXAMPLE 1: Instance fields vs Static fields
// ─────────────────────────────────────────────────────────────
 
class Counter {
    int count;            // instance field — each object has its own
    static int total = 0; // static field  — shared by ALL objects
 
    Counter() {
        count = 0;
        total++; // every time a Counter is created, total goes up
    }
 
    void increment() {
        count++;
    }
 
    void display() {
        System.out.println("This counter: " + count + " | Total counters created: " + total);
    }
}
 
 
// ─────────────────────────────────────────────────────────────
// EXAMPLE 2: Methods with different return types
// ─────────────────────────────────────────────────────────────
 
class Calculator {
    // void — returns nothing
    void printWelcome() {
        System.out.println("Welcome to Calculator!");
    }
 
    // int — returns a whole number
    int add(int a, int b) {
        return a + b;
    }
 
    // double — returns decimal
    double divide(double a, double b) {
        if (b == 0) {
            System.out.println("Error: Cannot divide by zero!");
            return 0;
        }
        return a / b;
    }
 
    // boolean — returns true or false
    boolean isEven(int number) {
        return number % 2 == 0;
    }
 
    // String — returns text
    String describe(int a, int b) {
        return a + " + " + b + " = " + (a + b);
    }
}
 
 
// ─────────────────────────────────────────────────────────────
// EXAMPLE 3: Method Overloading
// ─────────────────────────────────────────────────────────────
 
class Greeter {
    // Same method name, different parameters — Java picks the right one!
 
    void greet() {
        System.out.println("Hello, stranger!");
    }
 
    void greet(String name) {
        System.out.println("Hello, " + name + "!");
    }
 
    void greet(String name, String language) {
        if (language.equals("Bengali")) {
            System.out.println("হ্যালো, " + name + "!");
        } else if (language.equals("Spanish")) {
            System.out.println("¡Hola, " + name + "!");
        } else {
            System.out.println("Hello, " + name + "!");
        }
    }
 
    void greet(String name, int times) {
        for (int i = 0; i < times; i++) {
            System.out.println("Hello, " + name + "! [" + (i + 1) + "]");
        }
    }
}
 
 
// ─────────────────────────────────────────────────────────────
// EXAMPLE 4: 'this' keyword in action
// ─────────────────────────────────────────────────────────────
 
class Person {
    String name;
    int age;
    String city;
 
    // Without 'this', Java would confuse field and parameter
    Person(String name, int age, String city) {
        this.name = name;   // this.name = field, name = parameter
        this.age  = age;
        this.city = city;
    }
 
    // 'this' can also call another method of the same object
    void introduce() {
        System.out.println("Hi! I'm " + this.name +
                           ", " + this.age + " years old" +
                           ", from " + this.city + ".");
    }
 
    boolean isAdult() {
        return this.age >= 18;
    }
}
 
 
// ─────────────────────────────────────────────────────────────
// EXAMPLE 5: Getters & Setters (data protection)
// ─────────────────────────────────────────────────────────────
 
class BankAccount {
    private String owner;   // private = hidden from outside
    private double balance;
    private String accountNumber;
 
    BankAccount(String owner, String accountNumber) {
        this.owner         = owner;
        this.accountNumber = accountNumber;
        this.balance       = 0.0;
    }
 
    // Getter — read the balance
    public double getBalance() {
        return balance;
    }
 
    // Getter — read owner name
    public String getOwner() {
        return owner;
    }
 
    // Setter with validation — can't deposit negative money!
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("✔ Deposited: $" + amount);
        } else {
            System.out.println("✘ Invalid deposit amount.");
        }
    }
 
    // Withdraw with balance check
    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("✘ Insufficient funds. Balance: $" + balance);
        } else if (amount <= 0) {
            System.out.println("✘ Invalid amount.");
        } else {
            balance -= amount;
            System.out.println("✔ Withdrawn: $" + amount);
        }
    }
 
    public void printStatement() {
        System.out.println("┌──────────────────────────────┐");
        System.out.println("  Account: " + accountNumber);
        System.out.println("  Owner:   " + owner);
        System.out.printf( "  Balance: $%.2f%n", balance);
        System.out.println("└──────────────────────────────┘");
    }
}
 
 
// ─────────────────────────────────────────────────────────────
// MAIN CLASS
// ─────────────────────────────────────────────────────────────
 
public class ClassesAndObjects {
 
    public static void main(String[] args) {
 
        System.out.println("========================================");
        System.out.println(" Module 02: Classes & Objects Deep Dive");
        System.out.println("========================================\n");
 
 
        // ── Example 1: Instance vs Static fields ─────────────────
        System.out.println("── Example 1: Instance vs Static Fields ──");
 
        Counter c1 = new Counter();
        Counter c2 = new Counter();
        Counter c3 = new Counter();
 
        c1.increment();
        c1.increment();
        c2.increment();
 
        c1.display(); // count=2, total=3
        c2.display(); // count=1, total=3
        c3.display(); // count=0, total=3
        // Notice: 'total' is same for all — it's shared!
 
 
        // ── Example 2: Return types ───────────────────────────────
        System.out.println("\n── Example 2: Method Return Types ──");
 
        Calculator calc = new Calculator();
        calc.printWelcome();
 
        int sum    = calc.add(15, 27);
        double div = calc.divide(10.0, 3.0);
        boolean even = calc.isEven(42);
        String desc  = calc.describe(8, 12);
 
        System.out.println("Sum:     " + sum);
        System.out.printf( "Divide:  %.4f%n", div);
        System.out.println("42 even? " + even);
        System.out.println(desc);
 
 
        // ── Example 3: Method Overloading ────────────────────────
        System.out.println("\n── Example 3: Method Overloading ──");
 
        Greeter g = new Greeter();
        g.greet();
        g.greet("Rahim");
        g.greet("Karim", "Bengali");
        g.greet("Maria", "Spanish");
        g.greet("Alex", 3);
 
 
        // ── Example 4: 'this' keyword ─────────────────────────────
        System.out.println("\n── Example 4: 'this' Keyword ──");
 
        Person p1 = new Person("Nadia", 22, "Dhaka");
        Person p2 = new Person("Arif",  17, "Chittagong");
 
        p1.introduce();
        System.out.println("Is adult? " + p1.isAdult());
 
        p2.introduce();
        System.out.println("Is adult? " + p2.isAdult());
 
 
        // ── Example 5: Getters & Setters ─────────────────────────
        System.out.println("\n── Example 5: Getters & Setters (BankAccount) ──");
 
        BankAccount account = new BankAccount("Rahim Uddin", "BD-00123");
        account.printStatement();
 
        account.deposit(5000);
        account.deposit(2500);
        account.withdraw(1200);
        account.withdraw(9000);  // should fail — insufficient funds
        account.deposit(-500);   // should fail — invalid amount
 
        System.out.println();
        account.printStatement();
 
 
        // ── Summary ───────────────────────────────────────────────
        System.out.println("\n========================================");
        System.out.println(" Key Takeaways:");
        System.out.println("  ✔ Instance fields: each object has its own copy");
        System.out.println("  ✔ Static fields: shared by ALL objects");
        System.out.println("  ✔ Overloading: same name, different params");
        System.out.println("  ✔ 'this': refers to the current object");
        System.out.println("  ✔ private + getters/setters = data safety");
        System.out.println("========================================");
    }
}
