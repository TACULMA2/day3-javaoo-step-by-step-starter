package ooss;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Teacher extends Person {
    private final int age;
    private final String name;
    private final int id;
//    private Klass assignedClass;

    private List<Klass> assignedClasses = new ArrayList<>();
    public Teacher(int id, String name, int age) {
        super(id, name, age);
        this.name = name;
        this.age = age;
        this.id = id;
    }

    @Override
    public String introduce() {
         String teacherSpeech = super.introduce() + " I am a teacher.";

        if(!assignedClasses.isEmpty()) {
            String classAssigned = assignedClasses.stream()
                    .map(klass -> "Class " + klass.getClassId())
                    .collect(Collectors.joining(", "));

            teacherSpeech += " I teach " + classAssigned + ".";
        }
        return teacherSpeech;
    }

    public void assignTo(Klass klass) {
        assignedClasses.add(klass);
    }

    public boolean belongsTo(Klass klass) {
//        return assignedClass != null && assignedClass.equals(klass);
        return assignedClasses.contains(klass);
    }
}
