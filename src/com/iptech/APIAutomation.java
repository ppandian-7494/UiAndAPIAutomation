package com.iptech;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class APIAutomation {

	public static void main(String[] args) {
		String url_string1 = "http://dummy.restapiexample.com/api/v1/employees";
        String url_string2 = "http://dummy.restapiexample.com/api/v1/employee/2";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request1 = HttpRequest.newBuilder()
          .uri(URI.create(url_string1))
          .build();
        HttpRequest request2 = HttpRequest.newBuilder()
                .uri(URI.create(url_string2))
                .build();

        HttpResponse<String> response1 =
                null;
        try {
            response1 = client.send(request1, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        HttpResponse<String> response2 =
                null;
        try {
            response2 = client.send(request2, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String Data1=response1.body(); 
        
        System.out.println(Data1);

        String Data2=response2.body(); 

        System.out.println(Data2);

	}

}
