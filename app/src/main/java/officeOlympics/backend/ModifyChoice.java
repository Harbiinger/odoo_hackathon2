package officeOlympics.backend;

public class ModifyChoice {

    private boolean unlock;
    private String name;
    private int interactionId;
    private int choiceId;

    public ModifyChoice(boolean unlock, String name, int interactionId, int choiceId) {
        this.unlock = unlock;
        this.name = name;
        this.interactionId = interactionId;
        this.choiceId = choiceId;
    }

    public boolean isUnlock() {
        return unlock;
    }

    public String getName() {
        return name;
    }

    public int getInteractionId() {
        return interactionId;
    }

    public int getChoiceId() {
        return choiceId;
    }
}
