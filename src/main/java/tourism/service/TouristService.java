package tourism.service;

import tourism.model.TouristAttraction;
import tourism.repository.TouristRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TouristService {
    private TouristRepository touristRepository;

    //create method
    public TouristService(TouristRepository touristRepository){
        this.touristRepository = touristRepository;
    }

    //read method
    public List<TouristAttraction> getAllTouristAttractions(){
        return touristRepository.getAllTouristAttractions();
    }

    //update method
    public void updateTouristAttraction(String name, TouristAttraction touristAttraction) {
        touristRepository.updateTouristAttraction(name, touristAttraction);
    }

    //delete method
    public void deleteTouristAttraction(String name){
        touristRepository.deleteTouristAttraction(name);
    }

    public void addTouristAttraction(TouristAttraction touristAttraction) {
        touristRepository.addTouristAttraction(touristAttraction);
    }


    public TouristAttraction getTouristAttraction(String name) {
        return touristRepository.getTouristAttraction(name);
    }
}
