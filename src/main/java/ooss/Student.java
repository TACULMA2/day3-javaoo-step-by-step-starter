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

        String introduction = super.introduce() + " I am a student.";

        if (enrolledClass != null && enrolledClass.isLeader(this)) {
            introduction += " I am the leader of class " + enrolledClass.getClassId() + ".";
        }

        return introduction;
    }

    public void join(Klass klass) {
        enrolledClass = klass;
        klass.addStudent(this);
    }

    public boolean isIn(Klass klass) {
        return enrolledClass != null && enrolledClass.equals(klass);
    }
}
