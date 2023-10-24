package be.bstorm.controllers;

import be.bstorm.models.dtos.AnimalShortDTO;
import be.bstorm.models.entities.Animal;
import be.bstorm.models.forms.AnimalForm;
import be.bstorm.services.AnimalService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/animal")
public class AnimalController {

    private final AnimalService animalService;
    //Injection de dépendance de AnimalService via constructeur
    //Ceci fonctionne grâce à l'annotation @Service mise sur la class AnimalServiceImpl
    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping("/create")
    public String getCreate(Model model){
        model.addAttribute("animal",new AnimalForm());
        return "animal/create";
    }

    @PostMapping("/create")
    public String postCreate(@ModelAttribute AnimalForm form){
        animalService.create(form.toEntity());
        return "redirect:/animal";
    }

    @GetMapping
    public String index(Model model){
        List<Animal> animals = animalService.findAll();
        List<AnimalShortDTO> dtos = animals.stream()
                .map(AnimalShortDTO::fromEntity)
                .toList();
        model.addAttribute("animals",dtos);

        return "animal/index";
    }

    @GetMapping("/{id}")
    public String findOne(@PathVariable Long id,Model model){
        Animal animal = animalService.findById(id);
        model.addAttribute("animal",animal);
        return "animal/detail";
    }
}
