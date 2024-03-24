
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReading {
    public static int[] getData(String fileName) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            List<Integer> durations = new ArrayList<>();

            reader.readLine(); // Skip the first line.
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                durations.add(Integer.parseInt(parts[6]));
            }

            int[] array = new int[durations.size()];
            for (int i = 0; i < durations.size(); i++) {
                array[i] = durations.get(i);
            }
            return array;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
