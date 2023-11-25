package officeOlympics.backend;

import java.util.ArrayList;

public class Suspect {

    private boolean isGuilty;

    public Suspect(String lastName, String firstName, String profession, ArrayList<Choice> choices, boolean isGuilty) {
        
        this.isGuilty = isGuilty;
    }
}
