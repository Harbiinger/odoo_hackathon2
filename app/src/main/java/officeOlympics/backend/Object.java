package officeOlympics.backend;

public class Object {

    private String name;
    private String description;

    public Object(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return description;
    }
}
