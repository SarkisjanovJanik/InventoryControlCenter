package model;

public class Material {

    private String name;
    private String description;
    private String icon;
    private int maxCapacity;

    public Material(String name, String description, String icon, int maxCapacity) {
        this.name = name;
        this.description = description;
        this.icon = icon;
        this.maxCapacity = maxCapacity;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getIcon() {
        return icon;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }
}
