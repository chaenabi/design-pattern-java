package chapter1;

public class Professor {

    private String name;
    private String major;
    Student student;

    public void advise(Student student) {
        student = new Student();
    }

    public Student getAdvisedStudent() {
        if(student == null) return null;
        return student;
    }

}
