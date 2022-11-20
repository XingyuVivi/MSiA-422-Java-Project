import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MyPandas {
    public static void main(String[] args) {
        // Test code for the class
        String test_path = "C:/Users/nuke2/Desktop/NW Work/Data/babynames/IL.TXT";
        readCSV(test_path);
    }

    public static void readCSV(String path) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                System.out.println(values[0]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
