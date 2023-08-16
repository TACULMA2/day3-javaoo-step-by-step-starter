package ooss;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Klass {
    private int classId;
    private Student leader;
    private Teacher teacher;

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
//        if (hasStudent(student)) {
//            leader = student;
//        } else {
//            System.out.println("It is not one of us.");
//        }
        if (students.contains(student)) {
            if (teacher != null) {
                System.out.println("I am " + teacher.getName() + ", teacher of Class " + getClassId() + ". I know " + student.getName() + " become Leader.");
            } else {
                System.out.println("I am a student of Class " + getClassId() + ". I know " + student.getName() + " become Leader.");
            }
        } else {
            System.out.println("It is not one of us.");
        }
    }

    public boolean isLeader(Student student) {
        return student.equals(leader);
    }

    public void attach(Teacher teacher) {
        this.teacher = teacher;
    }
    public Teacher getTeacher() {
        return teacher;
    }
}
