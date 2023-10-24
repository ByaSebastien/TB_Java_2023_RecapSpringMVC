package be.bstorm.services;

import be.bstorm.models.entities.Animal;

import java.util.List;

public interface AnimalService {

    void create(Animal animal);

    Animal findById(Long id);

    List<Animal> findAll();

    void update(Long id,Animal animal);

    void delete(Long id);
}
