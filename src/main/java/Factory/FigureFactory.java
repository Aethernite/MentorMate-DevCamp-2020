package Factory;

import Figures.Figure;
import Figures.Rectangle;
import Figures.Square;
import Figures.Triangle;
import Utilities.Coordinates;

import java.util.List;

public class FigureFactory {

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
