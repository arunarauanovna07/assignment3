package assignment2;
public class Student {
    private String name;
    private double gpa;
    public Student(String name, double gpa) {
        this.name = name;
        this.gpa = gpa;
    }
    public String toString() {
        return "Student{name='" + name + "', gpa=" + gpa + "}";
    }
    public boolean equals(Object obj) {
        if (!(obj instanceof Student)) return false;
        Student s = (Student) obj;
        return name.equals(s.name) && Double.compare(gpa, s.gpa) == 0;
    }
}
