package org.launchcode.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by LaunchCode
 */
public class Cheese {

    @NotNull
    @Size(min=3, max=15)
    private String name;

    @NotNull
    //NotNull is not enough, because an empty form field that was passed by a user gets returned
    //as an empty String
    @Size(min=1, message = "Description must not be empty")
    private String description;

    private int cheeseId;
    private static int nextId = 1;
    private CheeseType type;
    //removed CheeseType.HARD because we want it to be set in our controller through the view
    //default value

    public Cheese(String name, String description) {
        this();
        this.name = name;
        this.description = description;
    }

    public Cheese() {
        cheeseId = nextId;
        nextId++;
    }

    public int getCheeseId() {
        return cheeseId;
    }

    public void setCheeseId(int cheeseId) {
        this.cheeseId = cheeseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CheeseType getType() {
        return type;
    }

    public void setType(CheeseType type) {
        this.type = type;
    }
}