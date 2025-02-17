package tourism.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import tourism.model.TouristAttraction;
import tourism.service.TouristService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
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

    @GetMapping("/{name}/tags")
    public ResponseEntity<TouristAttraction> getAttractionsTags(@PathVariable String name) {
        TouristAttraction attraction = touristService.getTouristAttraction(name);
        if (attraction != null) {
            return new ResponseEntity<>(attraction.getTags(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //new add-form instead of add
    @GetMapping("/add-form")
    public String showAddAttractionForm(Model model){
        model.addAttribute("touristAttraction", new TouristAttraction());
        return "add-attraction";


    }

    // new save with PostMapping
    @PostMapping("/save")
    public String saveTouristAttraction(@ModelAttribute TouristAttraction touristAttraction){
        touristService.addTouristAttraction((touristAttraction));
        return "redirect:view/attractions";
    }

    //add new attraction
    @PostMapping ("/add")
    public ResponseEntity<Void> addTouristAttraction(@RequestBody TouristAttraction touristAttraction) {
        touristService.addTouristAttraction(touristAttraction);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{name}/edit")
    public String showEditForm(@PathVariable String name, Model model){
        TouristAttraction attraction = touristService.getTouristAttraction(name);
        if (attraction == null) {
            return "redirect:view/attractions";
        }
        model.addAttribute("touristAttraction", attraction);
        return "edit-attraction";
    }

    //updateTouristAttraction for Thymeleaf form
    @PostMapping("/update")
    public String updateTouristAttraction(@ModelAttribute TouristAttraction touristAttraction) {
        touristService.updateTouristAttraction(touristAttraction.getName(), touristAttraction);
        return "redirect:view/attractions";
    }

    //update existing attraction for REST API
//    @PostMapping("/update/{name}")
//    public ResponseEntity<Void> updateTouristAttraction(@PathVariable String name, @RequestBody TouristAttraction touristAttraction) {
//        touristService.updateTouristAttraction(name, touristAttraction);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }


    //delete attraction by index
    @DeleteMapping("/delete/{name}")
    public ResponseEntity<Void> deleteTouristAttraction(@PathVariable String name) {
        touristService.deleteTouristAttraction(name);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}