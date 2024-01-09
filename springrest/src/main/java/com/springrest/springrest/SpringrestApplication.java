package com.springrest.springrest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

@SpringBootApplication
public class SpringrestApplication {

	public static void main(String[] args) throws IOException, InterruptedException {
		SpringApplication.run(SpringrestApplication.class, args);
		int val = 0;
		Scanner sc = new Scanner(System.in);

		while (val != 5){
			System.out.println("Enter: \n1 for Read, \n2 for Add, \n3 for Update, \n4 for Delete, \n5 for Stop");

			val = sc.nextInt();
			if(val == 1){
				var url = "http://localhost:8080/cources";
				System.out.println("Read Elements");
				var request = HttpRequest.newBuilder().GET().uri(URI.create(url)).build();
				var client = HttpClient.newBuilder().build();

				var response =  client.send(request, HttpResponse.BodyHandlers.ofString());

				System.out.println(response.statusCode());
				System.out.println(response.body());

			}
			else if(val == 2){
				System.out.println("Add New Element");
				var url = "http://localhost:8080/cources";
				System.out.println("Enter Id Of cource: ");
                 long Id = sc.nextLong();
				sc.nextLine();
				System.out.println("Enter title Of cource: ");
				String name = sc.nextLine();
				System.out.println("Enter Description Of cource: ");
				String description = sc.nextLine();

				// Example JSON payload for the POST request
				String jsonPayload = "{\n" +
						"    \"id\": " + Id + ",\n" +
						"    \"title\": \" " + name + " \",\n" +
						"    \"description\": \" " + description + "\"\n" +
						"}";

				// Build the POST request
				var request = HttpRequest.newBuilder()
						.uri(URI.create(url))
						.header("Content-Type", "application/json")
						.POST(HttpRequest.BodyPublishers.ofString(jsonPayload))
						.build();
				var client = HttpClient.newBuilder().build();

				try {
					// Send the POST request
					var response = client.send(request, HttpResponse.BodyHandlers.ofString());

					// Print the response status code and body
					System.out.println("Status Code: " + response.statusCode());
					System.out.println("Response Body: " + response.body());

				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			else if(val == 4){
				System.out.println("Delete Element");
				// Replace with your actual URL and ID
				System.out.println("Enter Id Of cource: ");
				long Id = sc.nextLong();
				var url = "http://localhost:8080/cources/"+Id;


				// Example JSON payload for the DELETE request
				String jsonPayload = "{\n" +
						"\"id\": " + Id+"\n" +
						"}";
				// Build the DELETE request
				var request = HttpRequest.newBuilder()
						.uri(URI.create(url))
						.header("Content-Type", "application/json")
						.DELETE()
						.header("Accept", "application/json") // Optional: Set the Accept header if needed
						.method("DELETE", HttpRequest.BodyPublishers.ofString(jsonPayload))
						.build();

				var client = HttpClient.newBuilder().build();

				try {
					// Send the DELETE request
					var response = client.send(request, HttpResponse.BodyHandlers.ofString());

					// Print the response status code and body
					System.out.println("Status Code: " + response.statusCode());
					System.out.println("Response Body: " + response.body());

				} catch (Exception e) {
					e.printStackTrace();
				}

			}
			else if(val == 3){
				System.out.println("Update Element");
				var url = "http://localhost:8080/cources";
				System.out.println("Enter Id Of cource: ");
				long Id = sc.nextLong();
				sc.nextLine();
				System.out.println("Enter title Of cource: ");
				String name = sc.nextLine();
				System.out.println("Enter Description Of cource: ");
				String description = sc.nextLine();

				// Example JSON payload for the PUT request
				String jsonPayload = "{\n" +
						"    \"id\":" + Id + ",\n" +
						"    \"title\": \""+ name + "\",\n" +
						"    \"description\": \" " + description + "\"\n" +
						"}";

				// Build the PUT request
				var request = HttpRequest.newBuilder()
						.uri(URI.create(url))
						.header("Content-Type", "application/json")
						.PUT(HttpRequest.BodyPublishers.ofString(jsonPayload))
						.build();

				var client = HttpClient.newBuilder().build();

				try {
					// Send the PUT request
					var response = client.send(request, HttpResponse.BodyHandlers.ofString());

					// Print the response status code and body
					System.out.println("Status Code: " + response.statusCode());
					System.out.println("Response Body: " + response.body());

				} catch (Exception e) {
					e.printStackTrace();
				}

			}

		}

		System.exit(0);
	}

}
