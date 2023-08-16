package ooss;

public class Person {
    private final int age;
    private final String name;
    private final int id;

    public Person(int id, String name, int age) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public String introduce() {
        return String.format("My name is " + name + "." + " I am " + age + " years old.");
    }
}
