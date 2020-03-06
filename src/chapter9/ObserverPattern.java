package chapter9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

interface ObserverPattern { // 추상화된 통보 대상
    void update();  // 데이터의 변경을 통보했을 때 처리하는 메서드
}

abstract class Subject { // 추상화된 변경 관심 대상 데이터
    private List<ObserverPattern> observers = new ArrayList<>(); // 추상화된 통보 대상 목록

    public void attach(ObserverPattern observer) { // 옵저버, 즉 통보 대상을 추가함.
       observers.add(observer);
    }
    public void detach(ObserverPattern observer) { // 옵저버, 즉 통보 대상을 제거함.
        observers.remove(observer);
    }

    // 통보 대상 목록, 즉 observers 의 각 옵저버에게 변경을 통보함.
    public void notifyObservers() {
        for(ObserverPattern o: observers) {
            o.update();
        }
    }
}

class ScoreRecord extends Subject { // 구체적인 변경 감시 대상 데이터
    private List<Integer> scores = new ArrayList<>();
    public void addScore(int score) {
        scores.add(score);

        //데이터가 변경되면 Subject 클래스의 notifyObservers 메서드를 호출해
        // 각 옵저버(통보 대상 클래스)에게 데이터의 변경을 통보함
        notifyObservers();
    }


    public List<Integer> getScoreRecord() {
        return scores;
    }
}

class DataSheetView implements ObserverPattern {

    private ScoreRecord scoreRecord;
    private int viewCount;

    DataSheetView(ScoreRecord scoreRecord, int viewCount) {
        this.scoreRecord = scoreRecord;
        this.viewCount = viewCount;
    }

    @Override
    public void update() { // 점수의 변경을 통보받음
        List<Integer> record = scoreRecord.getScoreRecord(); // 점수를 조회함.
        displayScores(record, viewCount); // 조회된 점수를 viewCount 만큼만 출력함
    }

    private void displayScores(List<Integer> record, int viewCount) {
        System.out.print("List of " + viewCount + " entries: ");
        for(int i = 0; i < viewCount && i < record.size(); i++) {
            System.out.print(record.get(i) + " ");
        }
        System.out.println();
    }

}

class MinMaxView implements ObserverPattern {
    private ScoreRecord scoreRecord;

    MinMaxView(ScoreRecord scoreRecord) { // MinMaxView를 설정함
        this.scoreRecord = scoreRecord;
    }

    @Override
    public void update() { // 점수의 변경을 통보받음
        List<Integer> record = scoreRecord.getScoreRecord(); // 점수를 조회함
        displayMinMax(record); // 최소 값과 최대 값을 출력함
    }

    private void displayMinMax(List<Integer> record) {
        int min = Collections.min(record, null);
        int max = Collections.max(record, null);
        System.out.println("Min: " + min + " Max: " + max);
    }


}

// StatisticsView 는 ObserverPattern 을 구현함으로써 통보 대상이 된다.
class StatisticsView implements ObserverPattern {
    private ScoreRecord scoreRecord;

    StatisticsView(ScoreRecord scoreRecord) {
        this.scoreRecord = scoreRecord;
    }

    @Override
    public void update() {
        List<Integer> record = scoreRecord.getScoreRecord();
        displayStatistics(record); // 변경 통보 시 조회된 점수의 합과 평균을 출력한다.
    }

    private void displayStatistics(List<Integer> record) { // 합과 평균을 출력한다.
        int sum = 0;
        for( int score:record) {
            sum += score;
        }
        double average = Math.round((double) sum / record.size());
        System.out.println("Sum:" + sum + " Average: " + average);
    }


}

class Client {
    public static void main(String[] args) {
        ScoreRecord scoreRecord = new ScoreRecord();
        DataSheetView dataSheetView = new DataSheetView(scoreRecord, 3);
        scoreRecord.attach(dataSheetView);
        MinMaxView minMaxView = new MinMaxView(scoreRecord);
        scoreRecord.attach(minMaxView);

        //3개 목록 DataSheetView, 5개 목록 DataSheetView, 그리고 MinMaxView 가 Observer 로 설정됨.
        for(int index = 1; index <= 5; index++) {
            int score = index * 10;
            System.out.println("Adding " + score);
            scoreRecord.addScore(score); // 각 점수 추가 시 최대 3개 목록, 5개 목록, 최소/최대 값을 출력함.
        }

        scoreRecord.detach(dataSheetView); // 3개 목록 DataSheetView 는 이제 Observer 가 아님.
        StatisticsView statisticsView = new StatisticsView(scoreRecord);
        scoreRecord.attach(statisticsView); // StatisticsView 가 Observer 로써 설정됨.

        //이제 5개 목록 DataSheetView, MinMaxView, 그리고 StatisticsView 가 Observer 임
        for (int index = 1; index <= 5; index++) {
            int score = index * 10;
            System.out.println("Adding " + score);
            scoreRecord.addScore(score); // 각 점수 추가 시 최대 5개 목록, 최소/최대 값, 합/평균을 출력함.
        }
    }
}
