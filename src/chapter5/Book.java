package chapter5;

class Book {

    private String signature;
    private int publishedYear;
    private double bookPrice;

    public Book(String signature, int publishedYear, double bookPrice) {
        this.signature = signature;
        this.publishedYear = publishedYear;
        this.bookPrice = bookPrice;
    }

    public void setBookPrice(SellingBookStrategy sellingBookStrategy) {
        this.bookPrice *= sellingBookStrategy.discountRate();
    }

    public String getSignature() {
        return signature;
    }

    public int getPublishedYear() {
        return publishedYear;
    }

    public double getBookPrice() {
        return bookPrice;
    }

    @Override
    public String toString() {
        return "Book{" +
                "signature='" + signature + '\'' +
                ", publishedYear=" + publishedYear +
                ", bookPrice=" + bookPrice +
                '}';
    }
}

// 232
