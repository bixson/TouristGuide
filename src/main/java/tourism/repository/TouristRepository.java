package tourism.repository;

import tourism.model.TouristAttraction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TouristRepository {
    private final List<TouristAttraction> touristAttractionList = new ArrayList<>();

    // Constructor to add initial TouristAttraction objects
    public TouristRepository() {
        touristAttractionList.add(new TouristAttraction("Den Lille Havfrue", "Den er meget lille", "København", List.of("Udendørs, Kunst")));
        touristAttractionList.add(new TouristAttraction("Amalienborg", "Der bor kongen", "København", List.of("Historisk", "Museum")));
        touristAttractionList.add(new TouristAttraction("Kongens Nytorv", "Der er hyggeligt om sommeren", "København", List.of("Udendørs", "Shopping")));
        touristAttractionList.add(new TouristAttraction("KEA", "Det er en fin skole", "København", List.of("Natteliv", "Studieliv")));
        touristAttractionList.add(new TouristAttraction("Guldbar", "Der er billig øl", "København", List.of("Natteliv", "Studieliv")));
        touristAttractionList.add(new TouristAttraction("Christiania", "Der er frit", "København", List.of("Udendørs")));
        touristAttractionList.add(new TouristAttraction("Nyhavn", "Der er flot og livligt", "København", List.of("Udendørs")));
        touristAttractionList.add(new TouristAttraction("Zoologisk Have", "Der er mange forskellige dyr", "Frederiksberg", List.of("Udendørs", "Børnevenligt")));
        touristAttractionList.add(new TouristAttraction("Amager Centret", "Det er hér det sker", "Amagerbro", List.of("Shopping")));
        touristAttractionList.add(new TouristAttraction("Torvehallerne", "Dyr og lækker madoplevelse","København", List.of("Shopping", "Mad")));

    }

    // Read list method
    public List<TouristAttraction> getAllTouristAttractions() {
        return new ArrayList<>(touristAttractionList);
    }

    // Get specific attraction
    public TouristAttraction getTouristAttraction(String name) {
        for (TouristAttraction attraction : touristAttractionList) {
            if (attraction.getName().equalsIgnoreCase(name)) {
                return attraction;
            }
        }
        return null;
    }

    // Add/create to list method
    public void addTouristAttraction(TouristAttraction touristAttraction) {
        touristAttractionList.add(touristAttraction);
    }

    // Update specific attraction
    public void updateTouristAttraction(String name, TouristAttraction touristAttraction) {
        for (int i = 0; i < touristAttractionList.size(); i++) {
            if (touristAttractionList.get(i).getName().equals(name)) {
                touristAttractionList.set(i, touristAttraction);
                return;
            }
        }
    }

    // Delete from list method
    public void deleteTouristAttraction(String name) {
        touristAttractionList.removeIf(attraction -> attraction.getName().equals(name));
    }
}