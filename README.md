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



✅ Summary

ConceptKey PointInstance fieldEach object has its own copyStatic fieldShared by all objectsMethod overloadingSame name, different parametersthisRefers to current objectGetters/SettersControlled access to private fields
