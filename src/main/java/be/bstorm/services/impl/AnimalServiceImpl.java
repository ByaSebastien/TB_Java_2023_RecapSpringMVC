package be.bstorm.services.impl;

import be.bstorm.models.entities.Animal;
import be.bstorm.repositories.AnimalRepository;
import be.bstorm.services.AnimalService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalServiceImpl implements AnimalService {

    private final AnimalRepository animalRepository;
    //Injection de dépendance par constructeur du service (fonctionne grace à @Repository)
    public AnimalServiceImpl(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @Override
    public void create(Animal animal) {
        animalRepository.save(animal);
    }

    @Override
    public Animal findById(Long id) {
        return animalRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Animal> findAll() {
        return animalRepository.findAll();
    }

    @Override
    public void update(Long id, Animal animal) {
        Animal existingAnimal = findById(id);
        existingAnimal.setName(animal.getName());
        existingAnimal.setColor(animal.getColor());
        animalRepository.save(existingAnimal);
    }

    @Override
    public void delete(Long id) {
        animalRepository.deleteById(id);
    }
}
