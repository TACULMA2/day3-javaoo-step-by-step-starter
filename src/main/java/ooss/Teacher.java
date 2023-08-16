package ooss;

public class Teacher extends Person {
    private final int age;
    private final String name;
    private final int id;
    private Klass assignedClass;
    public Teacher(int id, String name, int age) {
        super(id, name, age);
        this.name = name;
        this.age = age;
        this.id = id;
    }

    @Override
    public String introduce() {
        return super.introduce() + " I am a teacher.";
    }

    public void assignTo(Klass klass) {
        assignedClass = klass;
    }

    public boolean belongsTo(Klass klass) {
        return assignedClass != null && assignedClass.equals(klass);
    }
}
