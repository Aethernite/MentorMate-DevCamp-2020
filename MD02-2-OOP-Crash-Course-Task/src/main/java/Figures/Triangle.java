package Figures;

import Utilities.Coordinates;
import java.util.List;


public class Triangle extends Figure{
    public Triangle(String id, List<Coordinates> coordinates) {
        super(id,"triangle", coordinates);
    }

    @Override
    public double calculateArea() {
        //Area Formula Triangle
        //1/2*[x1(y2 - y3) + x2(y3 - y1) + x3(y1 - y2)]
        Coordinates A = coordinates.get(0);
        Coordinates B = coordinates.get(1);
        Coordinates C = coordinates.get(2);
        return Math.abs((double)1/2*(A.x*(B.y-C.y) + B.x*(C.x-A.x) + C.x*(A.y-B.y)));
    }

    @Override
    public double calculatePerimeter() {
        //Distance Formula
        // sqrt((x1-x2)^2)+(y1-y2)^2)
        Coordinates A = coordinates.get(0);
        Coordinates B = coordinates.get(1);
        Coordinates C = coordinates.get(2);
        double AB = Math.sqrt((A.x-B.x)*(A.x-B.x) + (A.y-B.y)*(A.y-B.y));
        double BC = Math.sqrt((B.x-C.x)*(B.x-C.x) + (B.y-C.y)*(B.y-C.y));
        double CA = Math.sqrt((C.x-A.x)*(C.x-A.x) + (C.y-A.y)*(C.y-A.y));
        return AB+BC+CA;
    }
}
