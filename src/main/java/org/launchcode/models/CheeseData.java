package org.launchcode.models;

import java.util.ArrayList;

/**
 * Created by Engineer on 3/23/2017.
 */
public class CheeseData {
    static ArrayList<Cheese> cheeses=new ArrayList<Cheese>();

    /*
    looking at our code we want to adopt from the cheese controller
    we need to import all the processes we did with the ArrayList there
    in the model here
     */

    //get All
    public static ArrayList<Cheese> getAll(){
        return cheeses;
    }

    //add
    public static void add(Cheese newCheese){
        cheeses.add(newCheese);
    }

    //remove which will use the getById method
    public static void remove (int id){
        Cheese cheeseToRemove=getById(id);
        cheeses.remove(cheeseToRemove);

    }


    //getById
    public static Cheese getById(int id){
        Cheese theCheese=null;
        for(Cheese candidateCheese:cheeses){
            if(candidateCheese.getCheeseId()==id){
                theCheese=candidateCheese;
            }
        }
        return theCheese;
    }
}
