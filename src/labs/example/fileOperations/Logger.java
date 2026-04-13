/*
@author: Collin Houfek
@date: 4/12/2026
@purpose: Week 13 Lab
*/

package labs.example.fileOperations;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Logger {

    public static void main(String[] args) {

        try {
            // Step 1 & 2: Open file
            BufferedReader file = openErrorLog();

            // Step 3 & 4: Count error types
            getCountOfErrorTypes(file);

            // Close file after use
            file.close();

            // Step 5: Re-open file
            BufferedReader file2 = openErrorLog();

            // Count memory limit exceeded occurrences
            getMemoryLimitExceededCount(file2);

            // Close again
            file2.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Opens file and returns BufferedReader
    public static BufferedReader openErrorLog() throws IOException {
        FileReader fr = new FileReader("api_error.log"); // make sure file is in correct path
        BufferedReader br = new BufferedReader(fr);
        return br;
    }

    // Counts ERROR, WARN, INFO, DEBUG
    public static void getCountOfErrorTypes(BufferedReader file) throws IOException {
        String line;

        int errorCount = 0;
        int warnCount = 0;
        int infoCount = 0;
        int debugCount = 0;

        while ((line = file.readLine()) != null) {

            if (line.contains("[ERROR]")) {
                errorCount++;
            }
            if (line.contains("[WARN]")) {
                warnCount++;
            }
            if (line.contains("[INFO]")) {
                infoCount++;
            }
            if (line.contains("[DEBUG]")) {
                debugCount++;
            }
        }

        System.out.println("ERROR count: " + errorCount);
        System.out.println("WARN count: " + warnCount);
        System.out.println("INFO count: " + infoCount);
        System.out.println("DEBUG count: " + debugCount);
    }

    // Counts memory limit exceeded and tracks endpoints
    private static void getMemoryLimitExceededCount(BufferedReader file) throws IOException {
        String line;

        int count = 0;
        ArrayList<String> endpoints = new ArrayList<>();

        while ((line = file.readLine()) != null) {

            if (line.contains("Memory limit exceeded")) {
                count++;

                // Example: extract endpoint (adjust based on your log format)
                int index = line.indexOf("Endpoint:");
                if (index != -1) {
                    String endpoint = line.substring(index + 9).trim();
                    endpoints.add(endpoint);
                }
            }
        }

        System.out.println("Memory Limit Exceeded Count: " + count);

        System.out.println("Endpoints:");
        for (String ep : endpoints) {
            System.out.println(ep);
        }
    }
}