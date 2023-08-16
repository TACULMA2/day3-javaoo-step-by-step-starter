package ooss;

public class Student extends Person {
    private final int age;
    private final String name;
    private final int id;

    public Student(int id, String name, int age) {
        super(id, name, age);
        this.name = name;
        this.age = age;
        this.id = id;
    }

    @Override
    public String introduce() {
        return super.introduce() + " I am a student.";
    }
}
