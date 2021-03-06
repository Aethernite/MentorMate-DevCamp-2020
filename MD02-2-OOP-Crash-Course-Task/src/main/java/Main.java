
import utils.json.Tools;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import figure.*;

import java.io.*;
import java.util.*;
/**
 * MD02-2-OOP-Crash-Course-Task
 * @author  Borislav Arangelov
 * @version 1.0.0
 * @since   2020-07-20
 *
 * Library used:
 * - Simple.JSON v1.1.1
 * - Gson v2.8.5
 */
public class Main {
    private final String INPUT = "crash-course-task-input.json";
    private final String OUTPUT = "crash-course-task-output.json";

    public static void main(String[] args) throws IOException, ParseException {
        Main main = new Main();
        main.start();
    }

    public Main(){
    }

    public void start() throws IOException, ParseException {
        JSONObject dataJSON = Tools.extractDataJSON(INPUT);
        JSONArray figuresJSON = (JSONArray) dataJSON.get("figures");
        List<Figure> figures = Tools.deserializeFiguresFromJSON(figuresJSON);
        Tools.exportJSONData(figures, OUTPUT);
    }



}