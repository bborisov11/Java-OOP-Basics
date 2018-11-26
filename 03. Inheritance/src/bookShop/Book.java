package bookShop;

import java.text.DecimalFormat;

public class Book {
    private String title;
    private String author;
    private double price;

    public Book(String title, String author, double price) {
        this.setAuthor(author);
       this.setTitle(title);
       this.setPrice(price);
    }

    public String getTitle() {
        return title;
    }

    protected void setTitle(String title) {
        if (title.length() < 3) {
            throw new IllegalArgumentException("Title not valid!");
        }
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    protected void setAuthor(String author) {
        if (isValidAuthor(author)) {
            throw new IllegalArgumentException("Author not valid!");
        }
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    protected void setPrice(double price) {
        if (price < 1) {
            throw new IllegalArgumentException("Price not valid!");
        }
        this.price = price;
    }

    private boolean isValidAuthor(String author) {
        if (author.split(" ").length == 2) {
            String secondName = author.split(" ")[1];
            try {
                int d = Integer.parseInt(secondName.charAt(0) + "");
                return true;
            } catch (Exception ex) {
                return false;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Type: ").append(this.getClass().getSimpleName())
                .append(System.lineSeparator())
                .append("Title: ").append(this.getTitle())
                .append(System.lineSeparator())
                .append("Author: ").append(this.getAuthor())
                .append(System.lineSeparator())
                .append("Price: ").append(this.getPrice())
                .append(System.lineSeparator());
        return sb.toString();

    }
}
