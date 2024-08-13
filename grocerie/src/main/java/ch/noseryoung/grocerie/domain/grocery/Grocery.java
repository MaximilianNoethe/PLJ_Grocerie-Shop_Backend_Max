package ch.noseryoung.grocerie.domain.grocery;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "tables")
public class Grocery {
    @Id
    @Column(name = "grocery_id")
    private int groceryId;

    @Column(name = "name")
    private String name;

    @Column(name = "region")
    private String region;

    @Column(name = "description")
    private String description;

    @Column(name = "sale")
    private int sale;

    @Column(name = "price")
    private int price;

    public Grocery(int groceryId, String name, String region, String description, int sale, int price) {
        this.groceryId = groceryId;
        this.name = name;
        this.region = region;
        this.description = description;
        this.sale = sale;
        this.price = price;
    }

    public Grocery() {

    }
}
