package be.bstorm.models.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Animal {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true,nullable = false,length = 50)
    private String name;

    private String color;
}
