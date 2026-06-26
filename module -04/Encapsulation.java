// EXAMPLE 1: Basic Encapsulation — Person class
// ─────────────────────────────────────────────────────────────
 
class Person {
    private String name;
    private int    age;
    private String email;
 
    Person(String name, int age, String email) {
        this.name  = name;
        setAge(age);       // use setter so validation runs even in constructor
        setEmail(email);
    }
 
    // Getters
    public String getName()  { return name; }
    public int    getAge()   { return age; }
    public String getEmail() { return email; }
 
    // Setters with validation
    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            System.out.println("✘ Name cannot be empty.");
        }
    }
 
    public void setAge(int age) {
        if (age >= 0 && age <= 120) {
            this.age = age;
        } else {
            System.out.println("✘ Invalid age: " + age + ". Age must be 0–120.");
        }
    }
 
    public void setEmail(String email) {
        if (email != null && email.contains("@")) {
            this.email = email;
        } else {
            System.out.println("✘ Invalid email: " + email);
        }
    }
 
    public void display() {
        System.out.println("Name: " + name + " | Age: " + age + " | Email: " + email);
    }
}
 
 
// ─────────────────────────────────────────────────────────────
// EXAMPLE 2: Validation inside setters — Employee
// ─────────────────────────────────────────────────────────────
 
class Employee {
    private String name;
    private String department;
    private double baseSalary;
    private double bonusPercent;
    private boolean isActive;
 
    Employee(String name, String department, double baseSalary) {
        this.name       = name;
        this.department = department;
        setSalary(baseSalary);
        this.bonusPercent = 10.0;
        this.isActive     = true;
    }
 
    // Getters
    public String  getName()         { return name; }
    public String  getDepartment()   { return department; }
    public double  getBaseSalary()   { return baseSalary; }
    public boolean isActive()        { return isActive; }  // 'is' prefix for boolean
 
    // Computed getter — not stored separately
    public double getTotalSalary() {
        return baseSalary + (baseSalary * bonusPercent / 100);
    }
 
    // Setters with rules
    public void setSalary(double salary) {
        if (salary >= 10000) {
            this.baseSalary = salary;
        } else {
            System.out.println("✘ Minimum salary is ৳10,000. Setting to minimum.");
            this.baseSalary = 10000;
        }
    }
 
    public void setBonusPercent(double percent) {
        if (percent >= 0 && percent <= 50) {
            this.bonusPercent = percent;
        } else {
            System.out.println("✘ Bonus must be between 0% and 50%.");
        }
    }
 
    public void deactivate() { this.isActive = false; }
    public void activate()   { this.isActive = true;  }
 
    public void printPayslip() {
        System.out.println("┌────────────────────────────────────┐");
        System.out.println("  Employee Payslip");
        System.out.println("  Name:       " + name);
        System.out.println("  Department: " + department);
        System.out.printf( "  Base:       ৳%.2f%n", baseSalary);
        System.out.printf( "  Bonus (%s%%): ৳%.2f%n",
                           (int)bonusPercent, baseSalary * bonusPercent / 100);
        System.out.printf( "  Total:      ৳%.2f%n", getTotalSalary());
        System.out.println("  Status:     " + (isActive ? "Active" : "Inactive"));
        System.out.println("└────────────────────────────────────┘");
    }
}
 
 
// ─────────────────────────────────────────────────────────────
// EXAMPLE 3: Read-only field — NationalID (set once, never changed)
// ─────────────────────────────────────────────────────────────
 
class NationalID {
    private final String idNumber;    // 'final' = cannot be reassigned
    private final String holderName;
    private final String dateOfBirth;
    private       String address;     // this one CAN be updated
 
    NationalID(String idNumber, String holderName, String dateOfBirth, String address) {
        this.idNumber    = idNumber;
        this.holderName  = holderName;
        this.dateOfBirth = dateOfBirth;
        this.address     = address;
    }
 
    // Read-only getters (no setters for final fields)
    public String getIdNumber()    { return idNumber; }
    public String getHolderName()  { return holderName; }
    public String getDateOfBirth() { return dateOfBirth; }
 
    // Address CAN change (people move)
    public String getAddress()            { return address; }
    public void   setAddress(String addr) { this.address = addr; }
 
    public void display() {
        System.out.println("NID:      " + idNumber);
        System.out.println("Name:     " + holderName);
        System.out.println("DOB:      " + dateOfBirth);
        System.out.println("Address:  " + address);
    }
}
 
 
// ─────────────────────────────────────────────────────────────
// EXAMPLE 4: Computed getter — ShoppingCart
// ─────────────────────────────────────────────────────────────
 
class ShoppingCart {
    private String[] items;
    private double[] prices;
    private int      count;
    private double   discountPercent;
 
    ShoppingCart(int capacity) {
        items           = new String[capacity];
        prices          = new double[capacity];
        count           = 0;
        discountPercent = 0;
    }
 
    public void addItem(String name, double price) {
        if (count < items.length) {
            items[count]  = name;
            prices[count] = price;
            count++;
            System.out.println("  Added: " + name + " @ ৳" + price);
        } else {
            System.out.println("✘ Cart is full!");
        }
    }
 
    public void setDiscount(double percent) {
        if (percent >= 0 && percent <= 100) {
            this.discountPercent = percent;
        }
    }
 
    // Computed getters — calculated on the fly, not stored
    public double getSubtotal() {
        double total = 0;
        for (int i = 0; i < count; i++) total += prices[i];
        return total;
    }
 
    public double getDiscountAmount() {
        return getSubtotal() * discountPercent / 100;
    }
 
    public double getTotal() {
        return getSubtotal() - getDiscountAmount();
    }
 
    public int getItemCount() { return count; }
 
    public void printReceipt() {
        System.out.println("┌──────────────────────────────────────┐");
        System.out.println("  Shopping Receipt");
        System.out.println("  ─────────────────────────────────────");
        for (int i = 0; i < count; i++) {
            System.out.printf("  %-20s ৳%7.2f%n", items[i], prices[i]);
        }
        System.out.println("  ─────────────────────────────────────");
        System.out.printf( "  Subtotal:            ৳%7.2f%n", getSubtotal());
        System.out.printf( "  Discount (%.0f%%):      ৳%7.2f%n",
                           discountPercent, getDiscountAmount());
        System.out.printf( "  Total:               ৳%7.2f%n", getTotal());
        System.out.println("└──────────────────────────────────────┘");
    }
}
 
 
// ─────────────────────────────────────────────────────────────
// EXAMPLE 5: Immutable Class — Temperature
// ─────────────────────────────────────────────────────────────
 
final class Temperature {           // 'final' class = cannot be subclassed
    private final double celsius;   // 'final' field = set once, never changed
 
    public Temperature(double celsius) {
        this.celsius = celsius;
    }
 
    // Getters only — no setters
    public double getCelsius()    { return celsius; }
    public double getFahrenheit() { return celsius * 9 / 5 + 32; }
    public double getKelvin()     { return celsius + 273.15; }
 
    // "Modifier" returns a NEW object — original untouched
    public Temperature add(double degrees) {
        return new Temperature(this.celsius + degrees);
    }
 
    @Override
    public String toString() {
        return String.format("%.1f°C / %.1f°F / %.2fK",
                             celsius, getFahrenheit(), getKelvin());
    }
}
 
 
// ─────────────────────────────────────────────────────────────
// MAIN CLASS
// ─────────────────────────────────────────────────────────────
 
public class Encapsulation {
 
    public static void main(String[] args) {
 
        System.out.println("========================================");
        System.out.println(" Module 04: Encapsulation");
        System.out.println("========================================\n");
 
 
        // ── Example 1: Person with validated setters ──────────────
        System.out.println("── Example 1: Person — Basic Encapsulation ──");
 
        Person p = new Person("Rahim", 25, "rahim@email.com");
        p.display();
 
        System.out.println("\nTrying invalid updates:");
        p.setAge(-10);          // rejected
        p.setAge(200);          // rejected
        p.setEmail("notvalid"); // rejected
        p.setName("");          // rejected
 
        System.out.println("\nValid update:");
        p.setAge(26);
        p.setEmail("rahim.new@email.com");
        p.display();
 
 
        // ── Example 2: Employee — computed getter + boolean ───────
        System.out.println("\n── Example 2: Employee — Salary Validation ──");
 
        Employee emp1 = new Employee("Nadia Islam", "Engineering", 50000);
        Employee emp2 = new Employee("Karim", "HR", 8000);  // below minimum
 
        emp1.setBonusPercent(15);
        emp1.printPayslip();
 
        System.out.println();
        emp2.setBonusPercent(60);   // rejected — too high
        emp2.printPayslip();
 
        emp1.deactivate();
        System.out.println("\nAfter deactivation — " + emp1.getName() +
                           " active? " + emp1.isActive());
 
 
        // ── Example 3: Read-only NationalID ───────────────────────
        System.out.println("\n── Example 3: NationalID — Read-only Fields ──");
 
        NationalID nid = new NationalID("BD-1234567890", "Arif Hossain",
                                        "1995-06-15", "Dhaka, Bangladesh");
        nid.display();
 
        // Can update address
        System.out.println("\nUpdating address...");
        nid.setAddress("Chittagong, Bangladesh");
        System.out.println("New address: " + nid.getAddress());
 
        // Cannot change ID or name — no setter exists
        // nid.setIdNumber("XX-999"); // compile error — method doesn't exist!
        System.out.println("ID is locked: " + nid.getIdNumber());
 
 
        // ── Example 4: ShoppingCart — computed totals ─────────────
        System.out.println("\n── Example 4: ShoppingCart — Computed Getters ──");
 
        ShoppingCart cart = new ShoppingCart(10);
        cart.addItem("Java Programming Book", 650.00);
        cart.addItem("Mechanical Keyboard",  3200.00);
        cart.addItem("USB Hub",               850.00);
        cart.addItem("Monitor Stand",        1200.00);
        cart.setDiscount(10);
 
        System.out.println("\nItems in cart: " + cart.getItemCount());
        cart.printReceipt();
 
 
        // ── Example 5: Immutable Temperature ─────────────────────
        System.out.println("\n── Example 5: Immutable Temperature ──");
 
        Temperature t1 = new Temperature(100.0);   // boiling point
        Temperature t2 = t1.add(50);               // new object, t1 unchanged
        Temperature t3 = new Temperature(-40.0);   // same in C and F!
 
        System.out.println("Boiling point:  " + t1);
        System.out.println("t1 + 50 deg:    " + t2);
        System.out.println("t1 unchanged:   " + t1);  // still 100°C
        System.out.println("Special temp:   " + t3);  // -40°C = -40°F
 
 
        // ── Summary ───────────────────────────────────────────────
        System.out.println("\n========================================");
        System.out.println(" Key Takeaways:");
        System.out.println("  ✔ private fields = data is hidden");
        System.out.println("  ✔ Setters validate before changing data");
        System.out.println("  ✔ Getter-only fields = read-only");
        System.out.println("  ✔ Computed getters = value on demand");
        System.out.println("  ✔ Immutable class = state never changes");
        System.out.println("  ✔ Use 'is' prefix for boolean getters");
        System.out.println("========================================");
    }
}
