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



✅ Summary

ConceptKey PointInstance fieldEach object has its own copyStatic fieldShared by all objectsMethod overloadingSame name, different parametersthisRefers to current objectGetters/SettersControlled access to private fields
