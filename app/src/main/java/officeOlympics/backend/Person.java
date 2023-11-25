package officeOlympics.backend;

import java.util.ArrayList;

public class Person {

    private String lastName;
    private String firstName;
    private String profession;
    private ArrayList<Choice> choices;

    public Person(String lastName, String firstName, String profession, ArrayList<Choice> choices) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.profession = profession;
        this.choices = choices;
    }

    public ArrayList<Choice> getChoices() {
        return choices;
    }

    public String getLastName() {
        return lastName;
    }
}
