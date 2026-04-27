/*
@author: Collin Houfek
@date: 4/26/2026
@purpose: Week 15 Lab
*/ 

package labs.example.chatbot;

import java.io.*;
import java.net.*;

public class Client1 {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 5000);
            System.out.println("Connected to server.");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String message;

            while (true) {
                message = reader.readLine();
                out.println(message);
                String response = in.readLine();
                System.out.println(response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}