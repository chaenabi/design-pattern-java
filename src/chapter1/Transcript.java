package chapter1;

public class Transcript {

    private Student student;
    private Course course;
    private String year;
    private Double score;

    public Transcript(Student student, Course course, String year) {
        this.student = student;
        this.student.addTranscript(this);

        this.course = course;
        this.course.addTranscript(this);

        this.year = year;

    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }

    public String getYear() {
        return year;
    }

    public Double getScore() {
        return score;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}
