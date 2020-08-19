import Figures.Figure;
import Utilities.JSON.Tools;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.*;

public class Main {
    private final String input = "crash-course-task-input.json";
    private final String output = "crash-course-task-output.json";

    public static void main(String[] args) throws IOException, ParseException {
        Main main = new Main();
        main.start();
    }

    public Main(){
    }

    public void start() throws IOException, ParseException {
        JSONObject dataJSON = Tools.extractDataJSON(input);
        JSONArray figuresJSON = (JSONArray) dataJSON.get("figures");
        List<Figure> figures = Tools.extractFiguresFromJSON(figuresJSON);
        Tools.exportJSONData(figures, output);
    }



}