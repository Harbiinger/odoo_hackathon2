package officeOlympics.backend;

import java.util.ArrayList;

public class Choice {

    private final int id;
    private boolean isLock;
    private final String value;
    private ArrayList<ModifyChoice> modifyChoices;

    public Choice(int id, boolean isLock, String value, ArrayList<ModifyChoice> modifyChoices) {
        this.id = id;
        this.isLock = isLock;
        this.value = value;
        this.modifyChoices = modifyChoices;
    }

    public int getId() {
        return id;
    }
}
