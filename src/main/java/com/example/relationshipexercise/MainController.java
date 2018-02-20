package com.example.relationshipexercise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@RestController
public class MainController {
    @Autowired
    CountryRepo countryRepo;

    @Autowired
    PersonRepo personRepo;

    @GetMapping("/personform")
    public String addPerson(Model model){
        model.addAttribute("person",new Person());
        return "personform";
    }
    @PostMapping("/personform")
    public String addEducationForm(@Valid @ModelAttribute("person") Person person, BindingResult result,
                                   RedirectAttributes redirectAttributes){
        if(result.hasErrors()){
            return "personform";
        }
        else{
            personRepo.save(person);
            return "redirect:/";
        }
    }

    @RequestMapping("/")
    public String addHere()
    {
        Country c = new Country("Ghana");
        countryRepo.save(c);

        c = new Country ("Dominican Republic");
        countryRepo.save(c);

        c = new Country ("United States");
        countryRepo.save(c);

        //List Countries:
        System.out.println("This is a list of countries in the database:");

        for(Country thisCountry:countryRepo.findAll()) {
            System.out.println(thisCountry.getCountryname());
        }

        Person A = new Person();
        A.setFirstname("Jane");
        A.setLastname("Doe");

        A.addCountry(countryRepo.findByCountryname("Ghana"));


        //Update this exercise:
        /* For each Person in the database, show where they are from. A person can be from more than one country.*/

//Use this section to display a list of people and the countries they are from.

        return "Check the console for your details";

    }
}
