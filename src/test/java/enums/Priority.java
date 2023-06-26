package enums;

public enum Priority {

    CRITICAL("Critical", 1), HIGH("High",2), MEDIUM("Medium",3), LOW("Low",4);
    private final String name;
    private final int index;

    Priority(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public static Priority fromName(String name) {
        for (Priority value : Priority.values()) {
            if (value.getName().equals(name)) {
                return value;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public int getIndex() {
        return index;
    }
}
