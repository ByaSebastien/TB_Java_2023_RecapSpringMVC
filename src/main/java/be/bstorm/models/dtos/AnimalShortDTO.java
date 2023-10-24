package be.bstorm.models.dtos;

import be.bstorm.models.entities.Animal;
import lombok.Data;

@Data
public class AnimalShortDTO {

    private Long id;
    private String name;

    public static AnimalShortDTO fromEntity(Animal animal){
        AnimalShortDTO a = new AnimalShortDTO();
        a.setId(animal.getId());
        a.setName(animal.getName());
        return a;
    }
}
