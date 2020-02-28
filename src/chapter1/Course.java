package chapter1;

import java.util.ArrayList;

public class Course {
    private String id;
    private String name;
    private int numOfStudents = 0;
    private ArrayList<Transcript> transcripts;



    public void addTranscript(Transcript transcript) {
        transcripts.add(transcript);
    }

    public ArrayList<Student> getStudents() {
        ArrayList<Student> students = new ArrayList<>();

        for(Transcript transcript : transcripts ) {
            students.add(transcript.getStudent());
        }

        return students;
    }
}
