//package org.launchcode.controllers;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import java.util.List;
//
//@Controller
//@RequestMapping("cheese")
//public class CheeseController {
//    List<String> cheeses;
//
//    @RequestMapping(value="")
//    public String index(Model model) {
//        String title = "A list of my cheeses";
//        model.addAttribute("title", title);
//        model.addAttribute("cheeses", cheeses);
//        return "cheese/index";
//    }
//}



package org.launchcode.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


/**
 * Created by Engineer on 3/9/2017.
 */

//Request Path=cheese
@Controller
@RequestMapping("cheese")
public class CheeseController {
    //had to move the Array here, to be able to access it in the processAddCheeseForm method
//    private ArrayList<String> cheeses=new ArrayList<>();
    private Map<String, String> cheeses=new HashMap<>();

    @RequestMapping(value="")
    //@ResponseBody had to remove it because we are using a template
    public String index(Model model /*to use addAttribute to render "title"to our template*/){
//        ArrayList<String> cheeses=new ArrayList<>();
//        cheeses.add("cheddar");
//        cheeses.add("parmesan");
//        cheeses.add("Gouda");
//        cheeses.add("munster"); removed since we want to add it from the form

        model.addAttribute("cheeses", cheeses);

        model.addAttribute("title", "My Cheeses");
        return "cheese/index";

    }
    //Request path =cheese/add
    @RequestMapping(value="add", method= RequestMethod.GET)
    public String displayAddCheeseForm(Model model) {

        model.addAttribute("title", "Add Cheese");
        return "cheese/add";
    }
//RequestMethod is very important if you have two handlers at the same directory
    @RequestMapping(value="add", method=RequestMethod.POST)
    public String processAddCheeseForm(@RequestParam String cheeseName,@RequestParam String cheeseDescription){
        cheeses.put(cheeseName, cheeseDescription);
        //redirect to /cheese (RequestMapping of the controller)
      return "redirect:";
    }
}

//    public String helloworld(){
//
//        return "Hello World!";
//
//        }
//    public String main(){
//        return helloworld();
//    }
//

