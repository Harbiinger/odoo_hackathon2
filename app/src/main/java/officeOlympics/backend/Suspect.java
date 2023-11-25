package officeOlympics.backend;

import java.util.ArrayList;

public class Suspect extends Person{

    private boolean isGuilty;

    public Suspect(String lastName, String firstName, String profession,String nationality, ArrayList<Interaction> interactions, boolean isGuilty) {
        super(lastName, firstName, profession,nationality, interactions);
        this.isGuilty = isGuilty;
    }
}
