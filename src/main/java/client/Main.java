package client;

import javafx.application.Application;
import javafx.stage.Stage;
import jdk.nashorn.internal.parser.JSONParser;
import org.json.JSONArray;
import org.json.JSONObject;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Aleksey Morozov
 * @since 26.06.2022
 */
public class Main extends Application {

    private NetworkConnector network;
    private HttpURLConnection connection;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        List<String> contractIds = new ArrayList<>();
        List<String> contractDates = new ArrayList<>();
        List<String> contractUpdateDates = new ArrayList<>();
        List<String> contractCheckBox = new ArrayList<>();
        network = new NetworkConnector();
        connection =  (HttpURLConnection )network.connect();
        InputStream in = connection.getInputStream();
        String data = new BufferedReader(new InputStreamReader(in))
                .lines()
                .collect(Collectors.joining());
        JSONArray jsons = new JSONArray(data);
        for (Object json : jsons) {
            System.out.println(json);
        }
        in.close();
        connection.disconnect();
        System.exit(0);
    }

}
