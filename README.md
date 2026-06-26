# java-oop-full-course-with-10-module


Module 01 — Introduction to OOP:



Course: Java OOP Complete Course

Level: Beginner

Topics: What is OOP, 4 Pillars, Class vs Object




📌 What is OOP?

Object-Oriented Programming (OOP) is a programming paradigm that organizes code around objects rather than functions and logic.

Think of it this way:


A class is a blueprint (like an architectural plan for a house)
An object is the actual thing built from that blueprint (the real house)



🏛️ The 4 Pillars of OOP

PillarSimple MeaningReal-life ExampleEncapsulationHide internal details, show only what's neededATM machine — you press buttons, don't see the wiringInheritanceChild gets properties from parentA Car inherits from VehiclePolymorphismSame action, different behaviorA dog and a cat both "speak" — but differentlyAbstractionShow only essential featuresA TV remote — you press power, you don't know the circuit


🔵 Class vs Object

CLASS                          OBJECT
-----                          ------
Blueprint / Template           Real instance created from class
Defined once                   Can create many objects
e.g. "Dog" (the concept)       e.g. myDog, yourDog, streetDog


📝 Key Terms


Class — a template that defines properties and behaviors
Object — an instance of a class
Field / Attribute — a variable inside a class (e.g. name, age)
Method — a function inside a class (e.g. bark(), eat())
Constructor — a special method that runs when an object is created



💻 Code Examples

See OOPIntro.java for all examples in this module.

What the code covers:


Defining a simple class
Creating objects
Accessing fields and methods
Using a constructor
Multiple objects from one class



✅ Summary


OOP helps us model real-world things in code
A class is a blueprint; an object is a real instance
OOP has 4 pillars: Encapsulation, Inheritance, Polymorphism, Abstraction
We'll explore each pillar deeply in the coming modules














Module 02 — Classes & Objects (Deep Dive):



Course: Java OOP Complete Course

Level: Beginner → Intermediate

Topics: Fields, Methods, this keyword, Method Overloading, Static vs Instance




📌 Recap from Module 01


A class is a blueprint
An object is created using new
A constructor runs when an object is created


Now we go deeper into how classes and objects actually work.


🔵 Anatomy of a Class

public class ClassName {

    // 1. Fields (state)
    dataType fieldName;

    // 2. Constructor
    ClassName(parameters) { ... }

    // 3. Methods (behavior)
    returnType methodName(parameters) { ... }
}


🔵 Fields — Instance vs Static

TypeBelongs ToShared?KeywordInstance fieldEach objectNo — each object has its own copy(none)Static fieldThe class itselfYes — all objects share one copystatic

javaclass Counter {
    int count;           // instance — each object has its own
    static int total;    // static  — shared across ALL objects
}


🔵 Methods

Return types

void        → returns nothing
int         → returns a whole number
double      → returns a decimal number
String      → returns text
boolean     → returns true or false

Method Overloading

Same method name, different parameters — Java picks the right one automatically.

javavoid greet()                  { ... }   // no param
void greet(String name)       { ... }   // one param
void greet(String name, int n){ ... }   // two params


🔵 The this Keyword

this refers to the current object. Used when a field name and parameter name are the same.

javaclass Person {
    String name;

    Person(String name) {
        this.name = name;  // 'this.name' = field, 'name' = parameter
    }
}


🔵 Getters & Setters

A good practice — keep fields private and provide public methods to read/write them.

javaclass BankAccount {
    private double balance;       // hidden from outside

    public double getBalance() {  // getter — read
        return balance;
    }

    public void setBalance(double amount) {  // setter — write
        if (amount >= 0) balance = amount;
    }
}


💻 Code Examples

See ClassesAndObjects.java for all examples.

What the code covers:


Instance fields vs static fields
Methods with different return types
Method overloading
this keyword in action
Getters and setters
Multiple objects sharing static data









Module 03 — Constructors :




Course: Java OOP Complete Course

Level: Beginner → Intermediate

Topics: Types of Constructors, Constructor Chaining, this(), Copy Constructor




📌 Recap from Module 02


Fields store data, methods define behavior
this refers to the current object
Getters/Setters protect private fields


Now we go deep into constructors — the special method that runs when an object is born.


🔵 What is a Constructor?

A constructor is a special method that:


Has the same name as the class
Has no return type (not even void)
Runs automatically when you use new


javaclass Box {
    Box() {
        // this runs when you write: Box b = new Box();
    }
}


🔵 Types of Constructors

1. Default Constructor

Java provides this automatically if you write no constructor at all.

javaclass Cat {
    String name;
    // Java silently adds: Cat() {}
}
Cat c = new Cat(); // works even with no constructor written

2. No-Arg Constructor

You write it yourself — useful for setting default values.

javaclass Cat {
    String name;
    Cat() {
        name = "Unknown";
    }
}

3. Parameterized Constructor

Accepts values when creating the object.

javaclass Cat {
    String name;
    Cat(String name) {
        this.name = name;
    }
}
Cat c = new Cat("Whiskers");

4. Copy Constructor

Creates a new object as a copy of another object.

javaclass Cat {
    String name;
    Cat(Cat other) {          // takes another Cat as input
        this.name = other.name;
    }
}
Cat original = new Cat("Luna");
Cat copy     = new Cat(original); // copy of Luna


🔵 Constructor Chaining with this()

One constructor can call another using this().

This avoids repeating code across multiple constructors.

javaclass Phone {
    String brand;
    String model;
    int storage;

    Phone() {
        this("Unknown", "Unknown", 64); // calls 3-param constructor
    }

    Phone(String brand, String model) {
        this(brand, model, 128);         // calls 3-param constructor
    }

    Phone(String brand, String model, int storage) {
        this.brand   = brand;
        this.model   = model;
        this.storage = storage;
    }
}


⚠️ this() must always be the first line inside a constructor.




🔵 Constructor vs Method

FeatureConstructorMethodNameSame as classAny nameReturn typeNoneMust have one (or void)Called bynew keywordObject or classPurposeInitialize objectDefine behaviorInherited?NoYes


🔵 Common Mistakes

java// ✘ WRONG — constructor has a return type
void MyClass() { }   // this is a method, NOT a constructor!

// ✔ CORRECT
MyClass() { }

// ✘ WRONG — this() is not the first line
MyClass(String name) {
    System.out.println("Hello");
    this();   // compile error!
}

// ✔ CORRECT
MyClass(String name) {
    this();   // must be first
    System.out.println("Hello");
}


💻 Code Examples

See Constructors.java for all examples.

What the code covers:


No-arg, parameterized, and copy constructors
Constructor chaining with this()
Real-world example — Laptop class with all constructor types
Common mistake demonstration



✅ Summary

Constructor TypeWhen to UseNo-argSet default valuesParameterizedPass custom values at creationCopyDuplicate an existing objectChained (this())Avoid repeated initialization code












Module 04 — Encapsulation:




Course: Java OOP Complete Course

Level: Intermediate

Topics: Access Modifiers, Getters/Setters, Data Hiding, Validation, Immutable Classes




📌 Recap from Module 03


Constructors initialize objects
this() chains constructors to avoid repetition
Copy constructor creates an independent duplicate


Now we learn Encapsulation — the first of the 4 OOP pillars.


🔵 What is Encapsulation?

Encapsulation means bundling data (fields) and behavior (methods) together inside a class, and hiding the internal details from the outside world.

Think of it like a medicine capsule — the medicine is hidden inside, and you only interact with the outer shell.

Without Encapsulation         With Encapsulation
─────────────────────         ──────────────────
account.balance = -5000;      account.deposit(5000);   ✔
// Anyone can set anything!   // Validation happens inside


🔵 Access Modifiers

Java has 4 access levels:

ModifierSame ClassSame PackageSubclassEverywhereprivate✅❌❌❌(default)✅✅❌❌protected✅✅✅❌public✅✅✅✅

The golden rule:


🔒 Fields → always private

🔓 Methods → public only if needed outside




🔵 Getters and Setters

The standard way to safely read and write private fields.

javaclass Employee {
    private String name;   // hidden
    private int salary;    // hidden

    // Getter — read only
    public String getName() {
        return name;
    }

    // Setter — write with validation
    public void setSalary(int salary) {
        if (salary >= 5000) {         // validation!
            this.salary = salary;
        } else {
            System.out.println("Salary too low!");
        }
    }
}

Naming convention:

Field name: age
Getter:     getAge()
Setter:     setAge()

Field name: active (boolean)
Getter:     isActive()   ← note: 'is' instead of 'get' for booleans
Setter:     setActive()


🔵 Why Encapsulation Matters

1. Validation — prevent invalid data

javapublic void setAge(int age) {
    if (age >= 0 && age <= 120) this.age = age;
}
// Without this: person.age = -999; // nonsense!

2. Read-only fields — getter only, no setter

javaprivate String nationalId;       // set once in constructor
public String getNationalId() { return nationalId; }
// No setNationalId() — can never be changed after creation

3. Computed values — getter does calculation

javaprivate double baseSalary;
private double bonus;

public double getTotalSalary() {
    return baseSalary + bonus;   // computed, not stored separately
}


🔵 Immutable Classes

An immutable class creates objects that cannot be changed after creation.

Rules for immutable classes:


All fields private final
No setters
Only getters
Set all values in constructor


javapublic final class ImmutablePoint {
    private final int x;
    private final int y;

    public ImmutablePoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() { return x; }
    public int getY() { return y; }
    // No setters — once created, x and y never change
}


Java's built-in String class is immutable — that's why str.toUpperCase() returns a new String instead of modifying the original.




💻 Code Examples

See Encapsulation.java for all examples.

What the code covers:


Basic encapsulation with a Person class
Validation inside setters — Employee salary rules
Read-only fields — NationalID card
Computed getter — ShoppingCart total
Immutable class — Temperature converter
Full real-world example — Hospital Patient record



✅ Summary

ConceptPurposeprivate fieldsHide data from outsideGettersSafe read accessSetters with validationSafe write access with rulesRead-only (getter only)Field set once, never changedComputed getterValue calculated on the flyImmutable classObject state never changes after creation







Module 05 — Inheritance:


Course: Java OOP Complete Course

Level: Intermediate

Topics: extends, super, Method Overriding, Inheritance Chain, final keyword




📌 Recap from Module 04


private fields hide data from outside
Setters validate before changing data
Immutable classes never change after creation


Now we learn Inheritance — the second OOP pillar.


🔵 What is Inheritance?

Inheritance lets a class acquire the fields and methods of another class.


The class being inherited from = Parent class (also called superclass or base class)
The class that inherits = Child class (also called subclass or derived class)


Parent                Child
──────                ─────
Animal   ──extends──► Dog
Vehicle  ──extends──► Car
Person   ──extends──► Student

The child gets everything the parent has — and can add its own stuff on top.


🔵 The extends Keyword

javaclass Animal {
    String name;
    void eat() { System.out.println(name + " is eating."); }
}

class Dog extends Animal {      // Dog inherits from Animal
    void bark() { System.out.println(name + " says: Woof!"); }
}

Dog d = new Dog();
d.name = "Bruno";
d.eat();   // inherited from Animal ✔
d.bark();  // Dog's own method     ✔


🔵 The super Keyword

super refers to the parent class. Used for:

1. Calling parent constructor

javaclass Animal {
    String name;
    Animal(String name) { this.name = name; }
}

class Dog extends Animal {
    String breed;
    Dog(String name, String breed) {
        super(name);          // calls Animal's constructor
        this.breed = breed;
    }
}

2. Calling parent method

javaclass Dog extends Animal {
    @Override
    void describe() {
        super.describe();           // runs Animal's describe()
        System.out.println("Breed: " + breed);  // then adds more
    }
}


⚠️ super() must always be the first line in a constructor.




🔵 Method Overriding

A child class can redefine a method it inherited from the parent.

javaclass Animal {
    void makeSound() { System.out.println("Some sound..."); }
}

class Dog extends Animal {
    @Override                        // tells Java: intentional override
    void makeSound() { System.out.println("Woof!"); }
}

class Cat extends Animal {
    @Override
    void makeSound() { System.out.println("Meow!"); }
}

Override rules:


Same method name ✔
Same parameter list ✔
Same or wider access modifier ✔
@Override annotation recommended (catches typos at compile time)



🔵 Inheritance Chain

Java supports multi-level inheritance (but NOT multiple inheritance with classes).

Animal
  └── Mammal
        └── Dog

javaclass Animal  { ... }
class Mammal  extends Animal { ... }   // Mammal is a child of Animal
class Dog     extends Mammal { ... }   // Dog is a child of Mammal

Dog inherits from both Mammal AND Animal automatically.


🔵 The final Keyword in Inheritance

Used OnEffectfinal classCannot be extended (no child classes)final methodCannot be overridden by childfinal fieldValue cannot be changed after assignment

javafinal class String { ... }        // nobody can extend String
class MyString extends String { } // compile error!

class Animal {
    final void breathe() { ... }  // cannot be overridden
}


🔵 What is NOT Inherited?


private fields and methods (hidden, but technically present)
Constructors (not inherited, but called via super())
Static methods (belong to the class, not the object)



💻 Code Examples

See Inheritance.java for all examples.

What the code covers:


Basic inheritance — Animal → Dog, Cat, Bird
super to call parent constructor and method
Method overriding with @Override
Multi-level inheritance chain — Vehicle → Car → ElectricCar
Real-world example — Staff hierarchy: Person → Employee → Manager



✅ Summary

ConceptKey PointextendsChild inherits parent's fields and methodssuper()Calls parent constructor (must be first line)super.method()Calls parent's version of a method@OverrideRedefines an inherited methodInheritance chainA → B → C — C gets everything from A and Bfinal classCannot be subclassedfinal methodCannot be overridden










Module 06 — Polymorphism:





Course: Java OOP Complete Course

Level: Intermediate

Topics: Compile-time vs Runtime Polymorphism, Upcasting, Downcasting, instanceof




📌 Recap from Module 05


extends gives child all parent fields and methods
super() calls parent constructor
@Override redefines an inherited method
Inheritance chains: A → B → C


Now we learn Polymorphism — the third OOP pillar.


🔵 What is Polymorphism?

Polymorphism means "many forms". The same method name behaves differently depending on which object calls it.

Animal a = new Dog();
a.makeSound();   // prints "Woof!" — not "Some sound..."

Even though a is declared as Animal, Java runs the Dog version at runtime. That is polymorphism.


🔵 Two Types of Polymorphism

TypeAlso CalledResolved AtHowCompile-timeStatic / Method OverloadingCompile timeSame method name, different parametersRuntimeDynamic / Method OverridingRuntimeChild overrides parent's method


🔵 Compile-time Polymorphism — Overloading

Same method name, different parameter list. Java picks the right one at compile time.

javaclass Printer {
    void print(int n)      { System.out.println("Int: "    + n); }
    void print(double d)   { System.out.println("Double: " + d); }
    void print(String s)   { System.out.println("String: " + s); }
    void print(int a, int b){ System.out.println("Sum: "   + (a+b)); }
}


🔵 Runtime Polymorphism — Overriding

A parent reference holds a child object. Java decides at runtime which version to call.

javaAnimal a;

a = new Dog();
a.makeSound();  // Woof!

a = new Cat();
a.makeSound();  // Meow!

a = new Bird();
a.makeSound();  // Tweet!

The reference type is Animal, but the actual object type changes — and Java always runs the actual object's version.


🔵 Upcasting and Downcasting

Upcasting — child → parent (automatic, safe)

javaAnimal a = new Dog("Bruno", 3);  // Dog IS-A Animal — automatic
a.eat();                          // works — inherited from Animal
// a.fetch();                     // compile error — Animal doesn't know fetch()

Downcasting — parent → child (manual, needs care)

javaAnimal a = new Dog("Bruno", 3);  // upcast first
Dog d = (Dog) a;                 // downcast — must cast explicitly
d.fetch();                       // now Dog methods are accessible


⚠️ Downcasting the wrong type throws ClassCastException at runtime!




🔵 The instanceof Keyword

Check what type an object actually is before downcasting.

javaAnimal a = new Dog("Bruno", 3);

if (a instanceof Dog) {
    Dog d = (Dog) a;      // safe to downcast
    d.fetch();
}

if (a instanceof Cat) {   // false — a is a Dog, not a Cat
    // this block won't run
}

Modern Java (Java 16+) — Pattern Matching

javaif (a instanceof Dog d) {   // check AND cast in one line
    d.fetch();
}


🔵 Polymorphic Arrays

Store different child objects in one parent-type array — very powerful!

javaAnimal[] zoo = {
    new Dog("Bruno", 3),
    new Cat("Luna", 2),
    new Bird("Sky", 1)
};

for (Animal a : zoo) {
    a.makeSound();   // each animal makes its OWN sound
}


🔵 The IS-A Relationship

Inheritance creates an IS-A relationship:

Dog    IS-A Animal  ✔
Cat    IS-A Animal  ✔
Animal IS-A Dog     ✘ (reverse is NOT true)

This is why upcasting is always safe — a Dog is always an Animal.


💻 Code Examples

See Polymorphism.java for all examples.

What the code covers:


Compile-time polymorphism — method overloading
Runtime polymorphism — method overriding with parent reference
Upcasting and downcasting safely
instanceof check before casting
Polymorphic array — shape area calculator
Real-world example — payment system



✅ Summary

ConceptKey PointCompile-time polymorphismOverloading — resolved at compile timeRuntime polymorphismOverriding — resolved at runtimeUpcastingChild → Parent, automatic and safeDowncastingParent → Child, manual, use instanceof firstinstanceofCheck actual type before castingPolymorphic arrayOne array holds many child types
