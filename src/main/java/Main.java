import Factory.FigureFactory;
import Figures.Figure;
import Utilities.Coordinates;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    private final String path = "crash-course-task-input.json";
    private List<Figure> figures;
    private FileReader jsonFile;
    private JSONParser jsonParser;
    private JSONObject object;
    private JSONArray figuresJSON;


    public static void main(String[] args) throws IOException, ParseException {
        Main main = new Main();
        main.start();
    }

    public Main() throws IOException, ParseException {
        jsonFile = new FileReader(path);
        jsonParser = new JSONParser();
        object = (JSONObject)jsonParser.parse(jsonFile);
        figuresJSON = (JSONArray) object.get("figures");
        figures = new ArrayList<>();
    }

    public void start(){
        for (Object value : figuresJSON) {
            JSONObject obj = (JSONObject) value;
            JSONArray coordinatesJSON = (JSONArray) obj.get("coordinates");
            String id = (String) obj.get("id");
            String type = (String) obj.get("type");
            List<Coordinates> coordinatesList = new LinkedList<Coordinates>();
            for (Object o : coordinatesJSON) {
                JSONObject coordinatesObject = (JSONObject) o;
                long x = (long) coordinatesObject.get("x");
                long y = (long) coordinatesObject.get("y");
                Coordinates coordinates = new Coordinates(x, y);
                coordinatesList.add(coordinates);
            }

            Figure figure = FigureFactory.getFigure(id, type, coordinatesList);
            figures.add(figure);
        }

        for(Figure figure: figures){
            if(figure.getType().equals("triangle")){
                System.out.println(figure.calculatePerimeter());
            }
        }
    }
}
