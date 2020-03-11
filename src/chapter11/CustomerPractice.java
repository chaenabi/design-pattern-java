package chapter11;

import java.util.ArrayList;
import java.util.List;

interface ReportGenerator {
    String generate(List<CustomerPractice> customerList);
}

class ComplexReportGenerator implements ReportGenerator {
    @Override
    public String generate(List<CustomerPractice> customerList) {
        String report = String.format("고객 수: %d명입니다.\n", customerList.size());
        int sum = 0;
        for(int i = 0 ; i < customerList.size(); i++) {
            CustomerPractice customer = customerList.get(i);
            report += String.format("고객%d %d : 고객%d %s\n", i+1, customer.getPoint() ,i+1, customer.getName());
        }
        for(CustomerPractice cp : customerList) {
            sum += cp.getPoint();
        }
        report += "점수 합계: " + sum;
        return report;
    }
}

class SimpleReportGenerator implements ReportGenerator {

    @Override
    public String generate(List<CustomerPractice> customerList) {
        String report = String.format("고객 수: %d명.\n", customerList.size());

        for(int i = 0 ; i < customerList.size(); i++) {
            CustomerPractice customer = customerList.get(i);
            report += String.format("%s: %d\n", customer.getName(), customer.getPoint());
        }

        return report;
    }
}

public class CustomerPractice {
    private String name;
    private int point;

    public CustomerPractice(String name, int point) {
        this.name = name;
        this.point = point;
    }

    public int getPoint() {
        return point;
    }

    public String getName() {
        return name;
    }
}

class Client {
    public static void main(String[] args) {
        List<CustomerPractice> customers = new ArrayList<>();

        customers.add(new CustomerPractice("홍길동",150));
        customers.add(new CustomerPractice("우수한",350));
        customers.add(new CustomerPractice("부족한",50));
        customers.add(new CustomerPractice("훌륭한",450));
        customers.add(new CustomerPractice("최고의",550));

        ReportGenerator simpleReportGenerator = new SimpleReportGenerator();
        System.out.println(simpleReportGenerator.generate(customers));
        ReportGenerator complexReportGenerator = new ComplexReportGenerator();
        System.out.println(complexReportGenerator.generate(customers));
    }
}