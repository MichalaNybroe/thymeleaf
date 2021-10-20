package thymeleaf.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import thymeleaf.services.BMIService;
import thymeleaf.services.Person;
import thymeleaf.services.PersonService;

import java.util.ArrayList;

@org.springframework.stereotype.Controller
public class Controller {
    PersonService personService = new PersonService();
    BMIService bmiService = new BMIService();

    @GetMapping("/")
    public String person(Model model) {
        Person person = new Person("Magrehte", 81);
        model.addAttribute("person", person);
        return "person";
    }

    @GetMapping("/tal")
    public String tal(Model model) {
        ArrayList<Integer> tal = new ArrayList<>();
        tal.add(1);
        tal.add(17);
        tal.add(15);
        model.addAttribute("tal", tal);
        return "numbers";
    }

    @GetMapping("/addPerson")
    public String addPerson() {
        return "post";
    }

    @PostMapping("/showPerson")
    public String showPerson(@RequestParam String name, @RequestParam int age, Model model) {
        personService.createPerson(name, age);
        model.addAttribute("person", personService.getPerson());
        return "person";
    }

    @GetMapping("/addInfo")
    public String addInfo() {
        return "info";
    }

    @PostMapping("/showBMI")
    public String showBMI(@RequestParam double weight, @RequestParam double height, Model model) {
        bmiService.calculateBMI(weight, height);
        model.addAttribute("BMI", bmiService.getBMI());
        return "showBMI";
    }
}
