package client;

import client.controllers.ViewController;
import client.model.ContractModel;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.json.JSONArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Aleksey Morozov
 * @since 26.06.2022
 */
public class Main extends Application {

    private static final String SAMPLE_FXML_PATH = "/sample.fxml";
    private NetworkConnector network;
    private HttpURLConnection connection;
    public Stage primaryStage;
    private ViewController controller;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        network = new NetworkConnector();

        createDialogWindow(primaryStage);
    }

    private void createDialogWindow(Stage primaryStage) throws IOException {
        FXMLLoader mainLoader = new FXMLLoader();
        mainLoader.setLocation(Main.class.getResource(SAMPLE_FXML_PATH));

        Parent root = mainLoader.load();

        primaryStage.setTitle("Messenger");
        primaryStage.setScene(new Scene(root, 600, 400));

        controller = mainLoader.getController();
        primaryStage.show();
    }

}
