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

    public void assignLeader(Student student) {
        if (students.contains(student)) {
            String studentInClass = students.stream()
                    .filter(s -> s.equals(student))
                    .findFirst()
                    .map(Student::getName)
                    .orElse("Unknown");

            String message = (teacher != null)
                    ? "I am " + teacher.getName() + ", teacher of Class " + getClassId() + ". I know " + student.getName() + " become Leader."
                    : "I am " + studentInClass + ", student of Class " + getClassId() + ". I know " + student.getName() + " become Leader.";

            System.out.println(message);
            leader = student;
        } else {
            System.out.println("It is not one of us.");
        }
    }

    public boolean isLeader(Student student) {
        return leader != null && leader.equals(student);
    }

    public void attach(Object teacherOrStudent) {
        if (teacherOrStudent instanceof Teacher) {
            this.teacher = (Teacher) teacherOrStudent;
        } else if (teacherOrStudent instanceof Student) {
            this.students.add((Student) teacherOrStudent);
        } else {
            System.out.println("Invalid attachment.");
        }
    }

    public Teacher getTeacher() {
        return teacher;
    }

}
