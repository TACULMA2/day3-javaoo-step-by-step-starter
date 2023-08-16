package ooss;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Klass {
    private int classId;

    private List<Student> students = new ArrayList<>();


    public Klass(int classId) {
        this.classId = classId;
    }

    public int getClassId() {
        return classId;
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
}
