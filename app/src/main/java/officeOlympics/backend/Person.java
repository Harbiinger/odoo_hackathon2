package officeOlympics.backend;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class Person {

    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("profession")
    private String profession;
    private String nationality;
    @JsonProperty("isGuilty")
    private boolean isGuilty;
    private int currentInteraction;
    private ArrayList<Interaction> interactions;

    public Person(String lastName,String nationality ,String firstName, String profession ,ArrayList<Interaction> interactions, boolean isGuilty) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.profession = profession;
        this.interactions = interactions;
        this.nationality = nationality;
        this.isGuilty = isGuilty;
        currentInteraction = 0;
    }

    public ArrayList<Interaction> getInteractions() {
        return interactions;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getProfession() {
        return profession;
    }

    public boolean isGuilty() {
        return isGuilty;
    }

    /**
     * Return the interaction we are currently in with the person
     * @return The interaction object
     */
    public Interaction getCurrentInteraction() {
        return this.interactions.get(currentInteraction);
    }

    /**
     * Change the value of the current interaction. <br>
     * The idea is to get the interaction and when you make a choice you get an index which is the index to give to this function.
     * @param interactionIndex The index of the next interaction
     */
    public void changeInteraction(int interactionIndex) {
        if (interactionIndex < 0) {
            currentInteraction = 0;
        } else {
            currentInteraction = interactionIndex;
        }
    }

    public void reset() {
        currentInteraction = 0;
    }
}
