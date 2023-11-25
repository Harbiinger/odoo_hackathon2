package officeOlympics.backend;

import java.util.ArrayList;

public class Interaction {

    private final int id;
    private ArrayList<Choice> choices;
    private final String text;

    public Interaction(int id, ArrayList<Choice> choices, String text) {
        this.id = id;
        this.choices = choices;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public ArrayList<Choice> getChoices() {
        return choices;
    }

    public String getText() {
        return text;
    }

    public int makeAChoice(Choice choice){
        return choice.getInteractionDir();
    }
}
