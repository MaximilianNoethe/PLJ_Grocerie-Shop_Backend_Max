package ch.noseryoung.grocerie.domain.grocery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import javax.management.InstanceNotFoundException;
import java.util.List;

@Service
public class GroceryService {
    @Autowired
    GroceryRepository groceryRepository;

    public List<Grocery> getAllGroceries() {
        return groceryRepository.findAll();
    }

    public Grocery getById(int groceryId) throws InstanceNotFoundException {
        return groceryRepository.findById(groceryId)
                .orElseThrow(() -> new InstanceNotFoundException("Grocery with id " + groceryId +
                        " could not be found!"));
    }

    public Grocery addGrocery(Grocery newGrocery) throws DataIntegrityViolationException {

        if (groceryRepository.existsByName(newGrocery.getName())) {
            throw new DataIntegrityViolationException("Grocery with the name '" + newGrocery.getName() + "' already exists!");
        }
        return groceryRepository.save(newGrocery);
    }

    public Grocery updateById(int id, Grocery grocery) throws InstanceNotFoundException {
        if (!groceryRepository.existsById(id)) {
            throw new InstanceNotFoundException("Grocery with id " + grocery.getGroceryId() + " could not be found!");
        }
        grocery.setGroceryId(id);
        return groceryRepository.save(grocery);
    }

    public void deleteById(int groceryId) throws InstanceNotFoundException {
        if (!groceryRepository.existsById(groceryId)) {
            throw new InstanceNotFoundException("Grocery with id " + groceryId + " could not be found!");
        }
        groceryRepository.deleteById(groceryId);
    }
}
