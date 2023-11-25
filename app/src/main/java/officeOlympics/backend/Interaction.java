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

    /**
     * Return the list of choices with only the unlocked ones.
     */
    public ArrayList<Choice> getChoices() {
        // Return the list of choices but only the unlocked ones
        ArrayList<Choice> res = new ArrayList<>();
        for(Choice choice: choices) {
            if (!choice.isLock()) {
                res.add(choice);
            }
        }
        return res;
    }

    public ArrayList<Choice> getAllChoices() {
        return choices;
    }

    public String getText() {
        return text;
    }

    public int makeAChoice(Choice choice){
        return choice.getInteractionDir();
    }
}
