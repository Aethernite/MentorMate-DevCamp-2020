package factory;

import figure.Figure;
import figure.Rectangle;
import figure.Square;
import figure.Triangle;
import utils.Coordinates;

import java.util.List;


/**
 * Factory Design Pattern
 */
public class FigureFactory {

    /**
     *  @param id - The id of the figure
     *  @param type - The type of the figure
     *  @param coordinates - List of the coordinates for the figure
     *  @return Type of Figure
     */
    public static Figure getFigure(String id, String type, List<Coordinates> coordinates){
        if ("triangle".equals(type)) {
            return new Triangle(id, coordinates);
        } else if ("rectangle".equals(type)) {
            return new Rectangle(id, coordinates);
        } else if ("square".equals(type)) {
            return new Square(id, coordinates);
        }
        return null;
    }
}
