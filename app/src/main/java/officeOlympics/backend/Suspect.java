package officeOlympics.backend;

import java.util.ArrayList;

public class Suspect extends Person{

    private boolean isGuilty;

    public Suspect(String lastName, String firstName, String profession, ArrayList<Choice> choices, boolean isGuilty) {
        super(lastName, firstName, profession, choices);
        this.isGuilty = isGuilty;
    }
}
