package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

public class CSVUtils {

    public static List<HashMap<String, String>> readCSV(String filePath) {
        List<HashMap<String, String>> dataList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            String[] headers = br.readLine().split(","); // first line as headers

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                HashMap<String, String> dataMap = new HashMap<>();
                for (int i = 0; i < headers.length; i++) {
                    dataMap.put(headers[i], values[i]);
                }
                dataList.add(dataMap);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataList;
    }
}

