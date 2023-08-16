package ooss;

public class Student extends Person {
    private final int age;
    private final String name;
    private final int id;
    private Klass enrolledClass;
    private int classId;

    public Student(int id, String name, int age) {
        super(id, name, age);
        this.name = name;
        this.age = age;
        this.id = id;
    }

    @Override
    public String introduce() {
        String classAttendance = enrolledClass != null ? " I am in class " + enrolledClass.getClassId() + "." : "";
        return super.introduce() + " I am a student." + classAttendance;
    }

    public void join(Klass klass) {
        enrolledClass = klass;
    }

    public boolean isIn(Klass klass) {
        return enrolledClass != null && enrolledClass.equals(klass);
    }
}
