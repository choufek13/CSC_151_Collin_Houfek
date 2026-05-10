/*
@author: Collin Houfek
@date: 05/10/2026
@purpose: Week 16 Lab
*/

import java.net.URI;
import java.net.URISyntaxException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class GeminiChatBot {

    public static void main(String[] args)
            throws IOException, URISyntaxException {

        Scanner scanner = new Scanner(System.in);

        String apiKey = "AIzaSyCIMblHFoyfKp6FOP2Z5QNbff8Pq4ZxmE0";

        System.out.println("Gemini ChatBot Started");
        System.out.println("Type 'exit' to quit.\n");

        while (true) {

            System.out.print("You: ");
            String userInput = scanner.nextLine();

            if (userInput.equalsIgnoreCase("exit")) {
                System.out.println("Chat ended.");
                break;
            }

            // Gemini API endpoint
            String endpoint =
                    "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.0-flash:generateContent?key="
                            + apiKey;

            URI uri = new URI(endpoint);
            URL url = uri.toURL();

            HttpURLConnection connection =
                    (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            // JSON request body
            String jsonInput = 
                    "{"
                    + "\"contents\": ["
                    + "{"
                    + "\"parts\": ["
                    + "{"
                    + "\"text\": \"" + userInput + "\""
                    + "}"
                    + "]"
                    + "}"
                    + "]"
                    + "}";
                    
            // Send request
            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = jsonInput.getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }

            // Read response
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(connection.getInputStream(),
                            StandardCharsets.UTF_8));

            StringBuilder response = new StringBuilder();
            String responseLine;

            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }

            // Convert response to String
            String jsonResponse = response.toString();

            // Simple parsing to extract Gemini text
            String searchText = "\"text\":\"";

            int start = jsonResponse.indexOf(searchText);

            if (start != -1) {

                start += searchText.length();

                int end = jsonResponse.indexOf("\"", start);

                String botReply = jsonResponse.substring(start, end);

                // Clean escaped characters
                botReply = botReply.replace("\\n", "\n");

                System.out.println("\nGemini: " + botReply + "\n");

            } else {
                System.out.println("No response found.");
            }

            connection.disconnect();
        }

        scanner.close();
    }
}