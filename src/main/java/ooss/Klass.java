package ooss;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Klass {
    private final int classId;
    private Student leader;
    private Teacher teacher;

    private final List<Student> students = new ArrayList<>();

    public Klass(int classId) {
        this.classId = classId;
    }

    public int getClassId() {
        return classId;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public boolean hasStudent(Student student) {
        return students.contains(student);
    }

    public void assignLeader(Student student) {
        if (students.contains(student)) {
            String message = createLeaderAssignmentMessage(student);
            System.out.println(message);
            leader = student;
        } else {
            System.out.println("It is not one of us.");
        }
    }

    private String createLeaderAssignmentMessage(Student student) {
        String studentInClass = students.stream()
                .filter(s -> s.equals(student))
                .findFirst()
                .map(Student::getName)
                .orElse("Unknown");

        String roleDescription = (teacher != null)
                ? "teacher of Class " + getClassId()
                : "student of Class " + getClassId();

        return "I am " + getRoleDescription(studentInClass, roleDescription) + ". I know " + student.getName() + " become Leader.";
    }

    private String getRoleDescription(String studentInClass, String roleDescription) {
        return (teacher != null) ? teacher.getName() + ", " + roleDescription : studentInClass + ", " + roleDescription;
    }

    public boolean isLeader(Student student) {
        return leader != null && leader.equals(student);
    }

    public void attach(Object person) {
        if (person instanceof Teacher) {
            this.teacher = (Teacher) person;
        } else if (person instanceof Student) {
            this.students.add((Student) person);
        } else {
            System.out.println("Invalid attachment.");
        }
    }

    public Teacher getTeacher() {
        return teacher;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Klass klass = (Klass) o;
        return classId == klass.classId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(classId);
    }

}
