package ch.noseryoung.grocerie.domain.grocery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroceryRepository extends JpaRepository<Grocery, Integer> {
    boolean existsByName(String name);
}
