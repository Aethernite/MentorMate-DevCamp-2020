package Utilities.JSON;

import Factory.FigureFactory;
import Figures.Figure;
import Utilities.Coordinates;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Tools {

    public static JSONObject convertFiguresToJSON(List<Figure> figures){
        JSONObject json = new JSONObject();
        JSONArray array = new JSONArray();
        for (Figure figure : figures) {
            Map<Object, Object> map = new LinkedHashMap<>();
            map.put("id", figure.getId());
            map.put("area", figure.calculateArea());
            map.put("perimeter", figure.calculatePerimeter());
            array.add(map);
        }
        json.put("figures", array);

        return json;
    }

    public static void exportToOutputFile(JSONObject data,String outputFile) throws IOException {
        FileWriter fw = new FileWriter(new File(outputFile));
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String prettyPrinted = gson.toJson(data);
        fw.write(prettyPrinted);
        fw.close();
        System.out.println("Successfully exported JSON data to " + outputFile);
    }

    public static void exportJSONData(List<Figure> figures, String output) throws IOException {
        JSONObject data = convertFiguresToJSON(figures);
        exportToOutputFile(data,output);
    }

    public static JSONObject extractDataJSON(String inputFile) throws IOException, ParseException {
        FileReader file = new FileReader(inputFile);
        JSONParser parser = new JSONParser();
        return (JSONObject)parser.parse(file);
    }

    public static List<Figure> extractFiguresFromJSON(JSONArray figuresJSON) {
        List<Figure> figures = new ArrayList<>();
        for (Object value : figuresJSON) {
            JSONObject obj = (JSONObject) value;
            JSONArray coordinatesJSON = (JSONArray) obj.get("coordinates");
            String id = (String) obj.get("id");
            String type = (String) obj.get("type");
            List<Coordinates> coordinates = extractCoordinatesFromJSON(coordinatesJSON);
            Figure figure = FigureFactory.getFigure(id, type, coordinates);
            figures.add(figure);
        }
        return figures;
    }


    public static List<Coordinates> extractCoordinatesFromJSON(JSONArray coordinates) {
        List<Coordinates> list = new ArrayList<Coordinates>();
        for (Object o : coordinates) {
            JSONObject coordinatesObject = (JSONObject) o;
            long x = (long) coordinatesObject.get("x");
            long y = (long) coordinatesObject.get("y");
            Coordinates object = new Coordinates(x, y);
            list.add(object);
        }
        return list;
    }
}
