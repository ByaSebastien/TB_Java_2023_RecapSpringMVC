package be.bstorm.models.forms;

import be.bstorm.models.entities.Animal;
import lombok.Data;

@Data
public class AnimalForm {

    private String name;
    private String color;

    public Animal toEntity(){
        Animal a = new Animal();
        a.setName(this.name);
        a.setColor(this.color);
        return a;
    }
}
