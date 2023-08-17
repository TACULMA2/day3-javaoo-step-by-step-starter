package ooss;

public class Student extends Person {
    private final String name;
    private Klass enrolledClass;

    public Student(int id, String name, int age) {
        super(id, name, age);
        this.name = name;
    }

    public void join(Klass klass) {
        enrolledClass = klass;
        klass.addStudent(this);
    }

    public boolean isIn(Klass klass) {
        return enrolledClass != null && enrolledClass.equals(klass);
    }

    public String getName() {
        return name;
    }

    public String introduce() {
        StringBuilder introduction = new StringBuilder(super.introduce());
        String classAttendance = enrolledClass != null ? " I am in class " + enrolledClass.getClassId() + "." : "";

        if (enrolledClass != null && enrolledClass.isLeader(this)) {
            introduction.append(" I am a student. I am the leader of class ").append(enrolledClass.getClassId()).append(".");
        } else {
            introduction.append(" I am a student.").append(classAttendance);
        }
        return introduction.toString();
    }

}
