package tourism.controller;

import tourism.model.TouristAttraction;
import tourism.service.TouristService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/attractions")
public class TouristController {
    private final TouristService touristService;

    //constructor
    public TouristController(TouristService touristService) {
        this.touristService = touristService;
    }

    //get all attractions
    @GetMapping
    public ResponseEntity<List<TouristAttraction>> getAllTouristAttractions() {
        List<TouristAttraction> attractions = touristService.getAllTouristAttractions();
        return new ResponseEntity<>(attractions, HttpStatus.OK);
    }

    //get specific attraction
    @GetMapping("/{name}")
    public ResponseEntity<TouristAttraction> getTouristAttraction(@PathVariable String name) {
        TouristAttraction attraction = touristService.getTouristAttraction(name);
        if (attraction != null) {
            return new ResponseEntity<>(attraction, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    //add new attraction
    @PostMapping ("/add")
    public ResponseEntity<Void> addTouristAttraction(@RequestBody TouristAttraction touristAttraction) {
        touristService.addTouristAttraction(touristAttraction);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    //update existing attraction
    @PutMapping("/update/{name}")
    public ResponseEntity<Void> updateTouristAttraction(@PathVariable String name, @RequestBody TouristAttraction touristAttraction) {
        touristService.updateTouristAttraction(name, touristAttraction);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //delete attraction by index
    @DeleteMapping("/delete/{name}")
    public ResponseEntity<Void> deleteTouristAttraction(@PathVariable String name) {
        touristService.deleteTouristAttraction(name);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}