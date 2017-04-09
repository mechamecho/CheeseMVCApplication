package org.launchcode.controllers;

import org.launchcode.models.CheeseData;
import org.launchcode.models.CheeseType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.launchcode.models.Cheese;
import javax.validation.Valid;
import java.util.ArrayList;


/**
 * Created by Engineer on 3/9/2017.
 */

//Request Path=cheese
@Controller
@RequestMapping("cheese")
public class CheeseController {


    @RequestMapping(value="")

    public String index(Model model /*to use addAttribute to render "title"to our template*/){

        model.addAttribute("cheeses", CheeseData.getAll());
        model.addAttribute("title", "My Cheeses");
        return "cheese/index";

    }
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddCheeseForm(Model model) {


        model.addAttribute("title", "Add Cheese");

        model.addAttribute(new Cheese());
        //because the new Cheese attribute can only hold one cheese type, so we
        // had to provide the Array to the view
        model.addAttribute("CheeseTypes", CheeseType.values());
        return "cheese/add";
    }

    @RequestMapping(value="add", method=RequestMethod.POST)
    public String processAddCheeseForm(@ModelAttribute @Valid Cheese newCheese,
                                       Errors errors,Model model){
//model.addAttribute(new Cheese()); why was it a problem

        if (errors.hasErrors()){
            model.addAttribute("title", "Add a Cheese");
            return "cheese/add";
        }
        /* behind the scenes
        model-binding
        Cheese newCheese= new Cheese();
        newCheese.setName(Request.getParameter("name"));
        newCheese.setDescription(Request.getParameter("description));
        which means the names in the model have to correspond with the names
        in the view
         */

      CheeseData.add(newCheese);
      ArrayList<Cheese> debug = CheeseData.getAll();
      return "redirect:";
    }

    @RequestMapping(value="remove", method=RequestMethod.GET)
    public String displayRemoveCheese(Model model){
        model.addAttribute("title", "Remove Cheese");
        model.addAttribute("cheeses", CheeseData.getAll());
        return "cheese/remove";
    }


    @RequestMapping(value="remove", method=RequestMethod.POST)
    public String processRemoveCheese(@RequestParam int [] cheeseIds){
        for (int cheeseId:cheeseIds){
            CheeseData.remove(cheeseId);
        }
        return "redirect:";
    }
    @RequestMapping(value="edit/{cheeseId}", method=RequestMethod.GET)
    public String displayEditForm(Model model, @PathVariable int cheeseId){
        model.addAttribute("title","edit cheese");
        Cheese editedCheese=CheeseData.getById(cheeseId);
        model.addAttribute("cheese",editedCheese);
        model.addAttribute("CheeseTypes", CheeseType.values());
        return "cheese/edit";
    }
    @RequestMapping(value="edit/{cheeseId}", method=RequestMethod.POST)
    public String processEditForm(Model model, @Valid Cheese editedCheese,Errors errors,
                                  @RequestParam("name")String name,
                                  @RequestParam("description") String description) {


        if (errors.hasErrors()){
            model.addAttribute("title","edit cheese");
            model.addAttribute("cheeseTypes", CheeseType.values());
            return "cheese/edit";
        }
//
//        CheeseData.remove(editedCheese.getCheeseId());
//        CheeseData.add(editedCheese);
        editedCheese.setName(name);
        editedCheese.setDescription(description);
        return "redirect:/cheese";
    }



}



