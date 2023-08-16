package ooss;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Klass {
    private int classId;
    private Student leader;

    private List<Student> students = new ArrayList<>();


    public Klass(int classId) {
        this.classId = classId;
    }

    public int getClassId() {
        return classId;
    }

    public void addStudent(Student student) {
        students.add(student);
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

    public boolean hasStudent(Student student) {
        return students.contains(student);
    }

    public void assignLeader(Student student) {
        if (hasStudent(student)) {
            leader = student;
        } else {
            System.out.println("Student is not in this class.");
        }
    }

    public boolean isLeader(Student student) {
        return student.equals(leader);
    }
}
