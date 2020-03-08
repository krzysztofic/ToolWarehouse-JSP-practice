package pl.vermintyn.model;

import java.io.Serializable;

public class Tool implements Serializable {

    private Long id;
    private String name;
    private ToolType type;
    private boolean availability;

    public Tool(){
    }

    public Tool(Long id, String name, ToolType type, boolean availability) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.availability = availability;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ToolType getType() {
        return type;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(ToolType type) {
        this.type = type;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    @Override
    public String toString() {
        return "Tool{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", availability=" + availability +
                '}';
    }
}
