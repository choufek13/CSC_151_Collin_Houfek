/*
@author: Collin Houfek
@date: 3/29/2026
@purpose: Week 11 Lab
*/

package labs.example.fileOperations;

import java.io.*;
import java.util.*;

public class FileOperator {

    public static void main(String[] args) {
        String filePath = "src/labs/example/fileOperations/files/users.csv";
        String logPath = "src/labs/example/fileOperations/logs/csv_error.log";

        createLogFileIfNotExists(logPath);

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = br.readLine()) != null) {
                try {
                    String[] parts = line.split(",");

                    String name = parts[0];
                    int sum = 0;

                    for (int i = 1; i < parts.length; i++) {
                        sum += Integer.parseInt(parts[i]);
                    }

                    double average = (double) sum / (parts.length - 1);

                    System.out.println(name + " average: " + average);

                } catch (Exception e) {
                    writeError(logPath, "Error processing line: " + line);
                }
            }

        } catch (IOException e) {
            writeError(logPath, "File read error: " + e.getMessage());
        }
    }

    // Create log file if it doesn't exist
    public static void createLogFileIfNotExists(String path) {
        File file = new File(path);
        try {
            if (!file.exists()) {
                file.createNewFile();
                System.out.println("csv_error.log created.");
            }
        } catch (IOException e) {
            System.out.println("Failed to create log file.");
        }
    }

    // Write errors to log file
    public static void writeError(String path, String message) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
            bw.write(message);
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error writing to log.");
        }
    }
}