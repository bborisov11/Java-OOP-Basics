package mankind;

public class Human {
    private String firstName;
    private String lastName;

    private final String MESSAGE_FOR_HUMAN_FIRST_NAME = "Expected upper case letter!Argument: firstName";
    private final String MESSAGE_FOR_HUMAN_FIRST_NAME_SECOND = "Expected length at least 4 symbols!Argument: firstName";
    private final String MESSAGE_FOR_HUMAN_LAST_NAME = "Expected upper case letter!Argument: lastName";
    private final String MESSAGE_FOR_HUMAN_SECOND_NAME_SECOND = "Expected length at least 3 symbols!Argument: lastName";

    public Human(String firstName, String lastName) {
        setFirstName(firstName);
        setLastName(lastName);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if(firstName.charAt(0) != firstName.toUpperCase().charAt(0)) {
            throw new IllegalArgumentException(MESSAGE_FOR_HUMAN_FIRST_NAME);
        }
        if(firstName.length() < 4) {
            throw new IllegalArgumentException(MESSAGE_FOR_HUMAN_FIRST_NAME_SECOND);
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if(lastName.charAt(0) != lastName.toUpperCase().charAt(0)) {
            throw new IllegalArgumentException(MESSAGE_FOR_HUMAN_LAST_NAME);
        }
        if(lastName.length() < 3) {
            throw new IllegalArgumentException(MESSAGE_FOR_HUMAN_SECOND_NAME_SECOND);
        }
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        String human = "First Name: " + this.getFirstName() + System.lineSeparator() +
                "Last Name: " + this.getLastName();
        return human;
    }
}
