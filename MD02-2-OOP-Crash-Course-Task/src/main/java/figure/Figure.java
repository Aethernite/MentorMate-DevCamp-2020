package figure;

import utils.Coordinates;

import java.util.List;
/**
 * Abstract Class Figure
 */
public abstract class Figure implements Calculable {
    protected String id;
    protected String type;
    protected List<Coordinates> coordinates;

    public Figure(String id, String type, List<Coordinates> coordinates) {
        this.id = id;
        this.type = type;
        this.coordinates = coordinates;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Coordinates> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<Coordinates> coordinates) {
        this.coordinates = coordinates;
    }
}
