package officeOlympics.backend;

import java.util.ArrayList;

public class Choice {
    private final int id;
    private final int interactionDir;
    private boolean isLock;
    private final String value;

    private boolean seen = false;

    private ArrayList<ModifyChoice> modifyChoices;

    public Choice(int id, int interactionDir, boolean isLock, String value, ArrayList<ModifyChoice> modifyChoices) {
        this.id = id;
        this.interactionDir = interactionDir;
        this.isLock = isLock;
        this.value = value;
        this.modifyChoices = modifyChoices;
    }

    public int getId() {
        return id;
    }

    public void setLock(boolean lock) {
        isLock = lock;
    }

    public boolean isLock() {
        return isLock;
    }

    public int getInteractionDir() {
        return interactionDir;
    }

    public String getValue() {
        return value;
    }

    public ArrayList<ModifyChoice> getModifyChoices() {
        return modifyChoices;
    }

    public String toString() {
        String res = "";
        res += id + " | ";
        res += "val = " + value + " | ";
        res += "direction= " + interactionDir;
        return res;
    }

    public void saw() {
        this.seen = true;
    }

    public boolean getSeeb() {
        return this.seen;
    }
}
