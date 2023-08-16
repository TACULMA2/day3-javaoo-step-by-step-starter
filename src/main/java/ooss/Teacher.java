package ooss;

public class Teacher extends Person {
    private final int age;
    private final String name;
    private final int id;
    public Teacher(int id, String name, int age) {
        super(age, "Tom", 18);
        this.name = name;
        this.age = age;
        this.id = id;
    }
}
