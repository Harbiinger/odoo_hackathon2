package officeOlympics.backend;

import java.util.ArrayList;

public class Person {

    private String lastName;
    private String firstName;
    private String profession;
    private ArrayList<Interaction> interactions;

    public Person(String lastName, String firstName, String profession, ArrayList<Interaction> interactions) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.profession = profession;
        this.interactions = interactions;
    }

    public ArrayList<Interaction> getInteractions() {
        return interactions;
    }

    public String getLastName() {
        return lastName;
    }

    public Interaction loadInteraction(int interactionIndex){
        return interactions.get(interactionIndex);
    }
}
