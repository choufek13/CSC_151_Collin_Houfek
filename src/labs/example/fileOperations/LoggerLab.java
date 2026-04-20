/*
@author: Collin Houfek
@date: 4/19/2026
@purpose: Week 14 Lab
*/

package labs.example.fileOperations;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LoggerLab {

    public static void main(String[] args) throws IOException {

        // Part 1
        BufferedReader apiReader = new BufferedReader(new FileReader("api_error.log"));
        getDiskSpaceErrorsWithIPAddress(apiReader);

        // Parts 3–6 use overloaded method
        BufferedReader httpReader;

        httpReader = openErrorLog("http_access_log");
        getGMTOffset(httpReader);

        httpReader = openErrorLog("http_access_log");
        getHTTPCodes(httpReader);

        httpReader = openErrorLog("http_access_log");
        getResponseSizes(httpReader);

        httpReader = openErrorLog("http_access_log");
        groupHTTPMethodsAndEndPoints(httpReader);
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
    private static void getDiskSpaceErrorsWithIPAddress(BufferedReader reader) throws IOException {
        String line;
        int lineNumber = 0;

        while ((line = reader.readLine()) != null) {
        lineNumber++;

            if (line.toLowerCase().contains("disk") && line.toLowerCase().contains("space")) {
                // Assuming IP is at the start of the line
                String[] parts = line.split(" ");
                String ipAddress = parts[0];

                System.out.println("Disk space error on line " + lineNumber + 
                               " for IP Address: " + ipAddress);
            }
        }
    }
    public static BufferedReader openErrorLog(String fileName) {
        try {
            if (fileName.equals("http_access_log")) {
                return new BufferedReader(new FileReader("http_access.log"));
            } else {
                System.out.println("Invalid file name.");
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    private static void getGMTOffset(BufferedReader reader) throws IOException {
        ArrayList<String> offsets = new ArrayList<>();
        ArrayList<Integer> counts = new ArrayList<>();

        String line;

        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(" ");

            for (String part : parts) {
                if (part.matches("[+-]\\d{4}")) {
                    if (!offsets.contains(part)) {
                        offsets.add(part);
                        counts.add(1);
                    } else {
                        int index = offsets.indexOf(part);
                        counts.set(index, counts.get(index) + 1);
                    }
                }
            }
        }

        for (int i = 0; i < offsets.size(); i++) {
            System.out.println(offsets.get(i) + ": " + counts.get(i));
        }
    }
    private static void getHTTPCodes(BufferedReader reader) throws IOException {
        int count2xx = 0, count3xx = 0, count4xx = 0, count5xx = 0;
        String line;

        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(" ");

            for (String part : parts) {
                if (part.matches("\\d{3}")) {
                    int code = Integer.parseInt(part);

                    if (code >= 200 && code < 300) count2xx++;
                    else if (code >= 300 && code < 400) count3xx++;
                    else if (code >= 400 && code < 500) count4xx++;
                    else if (code >= 500 && code < 600) count5xx++;
                }
            }
        }

        System.out.println("5xx Errors: " + count5xx);
        System.out.println("2xx Errors: " + count2xx);
        System.out.println("3xx Errors: " + count3xx);
        System.out.println("4xx Errors: " + count4xx);
    }
    private static void getResponseSizes(BufferedReader reader) throws IOException {
        String line;
        int count = 0;

        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(" ");

            for (int i = 0; i < parts.length; i++) {
                if (parts[i].matches("\\d{3}")) {
                    // next value is response size
                    if (i + 1 < parts.length) {
                        try {
                            int size = Integer.parseInt(parts[i + 1]);
                            if (size > 3900) {
                                count++;
                            }
                        } catch (NumberFormatException ignored) {}
                    }
                }
            }
        }

        System.out.println("Responses > 3900 bytes: " + count);
    }  
    private static void groupHTTPMethodsAndEndPoints(BufferedReader reader) throws IOException {
        ArrayList<String> methods = new ArrayList<>();
        String line;

        while ((line = reader.readLine()) != null) {
            String[] parts = line.split("\"");

            if (parts.length > 1) {
                String requestPart = parts[1]; // GET /index.html HTTP/1.1
                String[] requestSplit = requestPart.split(" ");

                if (requestSplit.length > 0) {
                    String method = requestSplit[0];

                    if (!methods.contains(method)) {
                        methods.add(method);
                    }
                }
            }
        }

        for (String method : methods) {
            System.out.println(method);
        }
    } 
}