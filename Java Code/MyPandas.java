import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class MyPandas {

    public static String path;

    public static myDataFrame readCSV(String path) throws FileNotFoundException {
        File text = new File(path);

        ArrayList<ArrayList<Object>> data = new ArrayList<ArrayList<Object>>();

        Scanner sc = new Scanner(text);

        while (sc.hasNextLine()) {
            String row = sc.nextLine();
            String[] row_data_split = row.split(",");

            ArrayList<Object> row_data = new ArrayList<>();

            row_data.add(row_data_split[0]);
            row_data.add(row_data_split[1]);
            row_data.add(row_data_split[2]);
            row_data.add(row_data_split[3]);
            row_data.add(row_data_split[4]);

            data.add(row_data);
        }
        sc.close();

        return new myDataFrame(data);
    }



}
