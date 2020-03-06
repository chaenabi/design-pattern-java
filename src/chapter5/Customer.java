package chapter5;

import java.util.ArrayList;
import java.util.List;

class Customer {

    private String name;
    private double accumulateRentalAmount;
    private List<Book> buyingBookList = new ArrayList<>();

    public void setAccumulateRentalAmount(double accumulateRentalAmount) {
        this.accumulateRentalAmount += accumulateRentalAmount;
    }

    public void buyingBook(Book book) {
        setAccumulateRentalAmount(book.getBookPrice());
        buyingBookList.add(book);
    }

    public double getAccumulateRentalAmount() {
        return accumulateRentalAmount;
    }

    public List<Book> getBuyingBookList() {
        return buyingBookList;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", accumulateRentalAmount=" + accumulateRentalAmount +
                ", buyingBookList=" + buyingBookList +
                '}';
    }
}

interface SellingBookStrategy {
    public double discountRate();
}

class DiscountStrategy implements SellingBookStrategy {
    private Book book;
    private Customer customer;
    private double discountRate;
    SellingBookStrategy discountMember = new DiscountMember();
    SellingBookStrategy discountOldBook = new DiscountOldBook();

    @Override
    public double discountRate() {
        return getDiscountRate();
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate += discountRate;
    }

    public double getDiscountRate() {
        return customer.getAccumulateRentalAmount() * discountRate;
    }

    public void setStrategy(Customer customer, Book book) {
        double totalAmount = customer.getAccumulateRentalAmount();
        int publishedYear = book.getPublishedYear();
        if(totalAmount >= 10000) setDiscountRate(discountMember.discountRate());
        if(publishedYear >= 2010) setDiscountRate(discountOldBook.discountRate());
    }
}

class DiscountMember implements SellingBookStrategy {
    @Override
    public double discountRate() {
        return 0.1;
    }
}
class DiscountOldBook implements SellingBookStrategy {

    @Override
    public double discountRate() {
        return 0.3;
    }
}

class Main {
    public static void main(String[] args) {
        Book book1 = new Book("스프링 3.1 - 토비",2021,10000);
        Book book2 = new Book("이펙티브 자바 - 조슈아 블로크",2020,10000);
        Book book3 = new Book("알고리즘 - 로버트 세지윅",2017,10000);

        Customer customer = new Customer();
        customer.buyingBook(book1);
        customer.buyingBook(book2);
        customer.buyingBook(book3);

        for(Book book : customer.getBuyingBookList()) {
            System.out.println(book);
        }

        System.out.println(customer.getAccumulateRentalAmount());
    }
    //181
}