package officeOlympics.backend;

import java.util.ArrayList;

public class Suspect extends Person{

    private boolean isGuilty;

    public Suspect(String lastName, String firstName, String profession, ArrayList<Interaction> interactions, boolean isGuilty) {
        super(lastName, firstName, profession, interactions);
        this.isGuilty = isGuilty;
    }
}
