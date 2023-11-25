package officeOlympics.backend;

import java.util.ArrayList;

public class Interaction {

    private final ArrayList<Choice> choices;
    private Person person;

    public Interaction(ArrayList<Choice> choices, Person person) {
        this.choices = choices;
        this.person = person;
    }

    public void makeAChoice(int choiceNumber){
        Choice choice = choices.get(choiceNumber);
        ArrayList<Choice> personChoices = person.getChoices();

        try{
            if (personChoices.contains(choice)){
                //TODO make an action
            }
        }
        catch (Exception e){
            System.out.println("Choice with id " + choice.getId() + " does not belong to Mr. " + person.getLastName());
        }

    }
}
