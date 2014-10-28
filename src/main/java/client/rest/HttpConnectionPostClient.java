package client.rest;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpConnectionPostClient {

    public static void main(String[] args) throws IOException {
        URL restURL = new URL("http://localhost:8080/webservices/math/table/post");
        HttpURLConnection connection = (HttpURLConnection) restURL.openConnection();
        connection.setRequestMethod("POST");
        connection.setDoInput(true);
        connection.setDoOutput(true);
        connection.setRequestProperty("Accept", "text/plain,text/html");
        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        connection.connect();
        String entity = "5";
        DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
        wr.writeBytes(entity);
        wr.flush();
        wr.close();
        InputStreamReader ins = new InputStreamReader(connection.getInputStream());
        BufferedReader in = new BufferedReader(ins);
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            System.out.println(inputLine);
        }
        in.close();
    }
}