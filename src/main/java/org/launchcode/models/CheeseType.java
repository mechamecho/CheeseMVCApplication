package org.launchcode.models;

/**
 * Created by Engineer on 3/29/2017.
 */

//enum is a special type of class
// means one of a list
public enum CheeseType {
//calling the constructor to initialize the CheeseType
    HARD ("Hard"),
    SOFT ("Soft"),
    FAKE("Fake");
    // to add more functionality you have to put a semicolon at the end of the list
    //since we don't want them to be changed after being initialized
    private final String name;

    //Constructor, has default access, since we don't want it to be accessed
    CheeseType(String name){
        this.name=name;
    }

    public String getName(){
        return this.name;
    }

}
