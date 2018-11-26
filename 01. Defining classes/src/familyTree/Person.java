package familyTree;

import java.util.Date;

public class Person {
    private String name;
    private Date date;

    public Person(String name, Date date) {
        this.name = name;
        this.date = date;
    }

    public Person(String name) {
        this.name = name;
    }

    public Person(Date date) {
        this.date = date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public Date getDate() {
        return date;
    }
}
