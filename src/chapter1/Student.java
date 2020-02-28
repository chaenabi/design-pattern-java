package chapter1;

/*
public class Student {

    private String name;
    private String major;
    private String studentId;
    private String subject;

    public void enrollCourse(Course course) {
        course.addStudent(this);

    }

    public void cancelCourse(Course course) {
        course.deleteStudent(this);

    }

}
*/

import java.util.ArrayList;
import java.util.HashMap;

public class Student {
    private String name;
    private String major;
    private String studentId; //학번
    private ArrayList<Transcript> transcripts;

    public void addTranscript(Transcript transcript) {
        this.transcripts.add(transcript);
    }

}
