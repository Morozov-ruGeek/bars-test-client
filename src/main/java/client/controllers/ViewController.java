package client.controllers;

import client.NetworkConnector;
import client.model.ContractModel;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.stream.Collectors;

/**
 * @author Aleksey Morozov
 * @since 27.06.2022
 */
public class ViewController {
    private HttpURLConnection connection;
    @FXML
    private ListView<String> contractsList;

    @FXML
    private Button getContracts;

    @FXML
    public void initialize() {
        getContracts.setOnAction(event -> ViewController.this.getContractsFromServer());
    }

    @FXML
    private void getContractsFromServer() {
        try {
            NetworkConnector network = new NetworkConnector();
            connection = (HttpURLConnection) network.connect();
            InputStream in = connection.getInputStream();
            String data = new BufferedReader(new InputStreamReader(in))
                    .lines()
                    .collect(Collectors.joining());
            JSONArray jsons = new JSONArray(data);

            for (int i = 0; i < jsons.length(); i++) {
                contractsList.setItems(FXCollections.observableArrayList(getContractFromJson(jsons.getJSONObject(i)).toString()));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private ContractModel getContractFromJson(JSONObject json) {
        String contractId = json.getString("contractId");
        String date = json.getString("date");
        String updateAt = json.getString("updateDate");
        boolean checkBox = json.getBoolean("checkBox");
        return ContractModel.create(contractId, date, updateAt, checkBox);
    }


}
