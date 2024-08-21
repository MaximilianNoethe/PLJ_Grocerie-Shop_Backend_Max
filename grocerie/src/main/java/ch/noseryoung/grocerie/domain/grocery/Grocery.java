package ch.noseryoung.grocerie.domain.grocery;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "groceries")
public class Grocery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "grocery_id")
    private int groceryId;

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "region")
    private String region;

    @Column(name = "description")
    private String description;

    @Column (name = "url")
    private String url;

    @Column(name = "price")
    private int price;

    public Grocery(int groceryId, String name, String region, String description, int price) {
        this.groceryId = groceryId;
        this.name = name;
        this.region = region;
        this.description = description;
        this.price = price;
    }

    public Grocery() {

    }
}
