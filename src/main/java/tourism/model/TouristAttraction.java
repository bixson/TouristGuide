package tourism.model;

import java.util.List;

public class TouristAttraction {
    private String name;
    private String description;
    private List tags;
    private String city;


    //constructor
    public TouristAttraction(String name, String description, List tags, String city){
        this.name = name;
        this.description = description;
        this.tags = tags;
        this.city = city;


    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List getTags()
    {return tags;}

    public void setTags(List tags)
    {this.tags = tags;}

    public String getCity()
    {return city;}

    public void setCity(String city)
    {this.city = city;}
}
