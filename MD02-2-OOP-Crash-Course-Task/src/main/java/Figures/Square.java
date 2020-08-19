package Figures;

import Utilities.Coordinates;

import java.util.List;

public class Square extends Figure {
    public Square(String id, List<Coordinates> coordinates) {
        super(id, "square", coordinates);
    }

    @Override
    public double calculateArea() {
        double[] sides = getSides();

        return sides[0] * sides[1];
    }

    @Override
    public double calculatePerimeter() {
        double[] sides = getSides();
        double perimeter = 0;
        for(double side: sides){
            perimeter+=side;
        }
        return perimeter*2;
    }

    private double[] getSides(){
        Coordinates A = coordinates.get(0);
        Coordinates B = coordinates.get(1);
        Coordinates C = coordinates.get(2);
        Coordinates D = coordinates.get(3);
        double[] sides = new double[2];
        sides[0] = Math.abs(A.x-C.x);
        sides[1] = Math.abs(B.y-D.y);

        return sides;
    }
}
