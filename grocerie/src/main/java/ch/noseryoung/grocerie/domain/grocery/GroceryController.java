package ch.noseryoung.grocerie.domain.grocery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.management.InstanceAlreadyExistsException;
import javax.management.InstanceNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/grocery")
public class GroceryController {
    @Autowired
    GroceryService groceryService;

    @GetMapping
    @PreAuthorize("hasAuthority('GET')")
    public List<Grocery> getAllGroceries() {
        return groceryService.getAllGroceries();
    }

    @GetMapping("/{groceryId}")
    @PreAuthorize("hasAuthority('GET')")
    public ResponseEntity<Grocery> getById(@PathVariable("groceryId") int groceryId) throws InstanceNotFoundException {
        return ResponseEntity.ok().body(groceryService.getById(groceryId));
    }

    @PostMapping
    @PreAuthorize("hasAuthority('POST')")
    public ResponseEntity<Grocery> addGrocery(@RequestBody Grocery grocery) throws DataIntegrityViolationException {
        return ResponseEntity.status(201).body(groceryService.addGrocery(grocery));
    }

    @PutMapping("/{groceryId}")
    @PreAuthorize("hasAuthority('PUT')")
    public ResponseEntity<Grocery> updateById(@PathVariable("groceryId") int id, @RequestBody Grocery grocery)
            throws InstanceNotFoundException, DataIntegrityViolationException {
        return ResponseEntity.status(200).body(groceryService.updateById(id, grocery));
    }

    @DeleteMapping("/{groceryId}")
    @PreAuthorize("hasAuthority('DELETE')")
    public String deleteById(@PathVariable("groceryId") int dishId) throws InstanceNotFoundException {
        groceryService.deleteById(dishId);
        return "Dish with id " + dishId + " was successfully deleted.";
    }

    @ExceptionHandler(InstanceNotFoundException.class)
    public ResponseEntity<String> instanceNoteFoundException(InstanceNotFoundException infe) {
        return ResponseEntity.status(404).body(infe.getMessage());
    }

    @ExceptionHandler(InstanceAlreadyExistsException.class)
    public ResponseEntity<String> instanceAlreadyExistsException(InstanceAlreadyExistsException iaee) {
        return ResponseEntity.status(404).body(iaee.getMessage());
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String> dataIntegrityViolationException(DataIntegrityViolationException dive) {
        return ResponseEntity.status(400).body(dive.getMessage());
    }
}
