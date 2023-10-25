package csc34002.demo.skateboard;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Callie Hampton
 *
 */
@Entity
@Table(name = "boards")
@NoArgsConstructor
@Getter
@Setter

public class Skateboard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private double price;
    private String brand;
    private String type;

    public Skateboard(double price, String brand, String type){
        this.price = price;
        this.brand = brand;
        this.type = type;
    }

}
