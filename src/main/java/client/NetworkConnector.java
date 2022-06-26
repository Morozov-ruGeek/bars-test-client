package client;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author Aleksey Morozov
 * @since 26.06.2022
 */
public class NetworkConnector {

    private static final String serverUrl= "http://localhost:8190/contracts/api/v1/contracts/all";

    public URLConnection connect(){
        try {
            URL url = new URL(serverUrl);
            return url.openConnection();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
