package ooss;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Teacher extends Person {
    private final String name;

    private final List<Klass> assignedClasses = new ArrayList<>();

    public Teacher(int id, String name, int age) {
        super(id, name, age);
        this.name = name;
    }

    public void assignTo(Klass klass) {
        assignedClasses.add(klass);
    }

    public boolean belongsTo(Klass klass) {
        return assignedClasses.contains(klass);
    }

    public boolean isTeaching(Student student) {
        for (Klass klass : assignedClasses) {
            if (klass.hasStudent(student)) {
                return true;
            }
        }
        return false;
    }

    public String getName() {
        return name;
    }

    @Override
    public String introduce() {
        String teacherSpeech = super.introduce() + " I am a teacher.";

        if (!assignedClasses.isEmpty()) {
            String classAssigned = assignedClasses.stream()
                    .map(klass -> String.valueOf(klass.getClassId()))
                    .collect(Collectors.joining(", "));

            teacherSpeech += " I teach Class " + classAssigned + ".";
        }
        return teacherSpeech;
    }
}
