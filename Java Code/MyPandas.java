import java.io.*;
import java.util.ArrayList;

public class MyPandas {

    public static String path;

    public static myDataFrame readCSV(String path) throws IOException {

        ArrayList<ArrayList<Object>> data = new ArrayList<ArrayList<Object>>();

        BufferedReader br = new BufferedReader(new FileReader(path));
        String line;

        while ((line = br.readLine()) != null) {
            String[] row_data_split = line.split(",");

            ArrayList<Object> row_data = new ArrayList<>();

            row_data.add(String.valueOf(row_data_split[0]));
            row_data.add(String.valueOf(row_data_split[1]));
            row_data.add(Integer.valueOf(row_data_split[2]));
            row_data.add(String.valueOf(row_data_split[3]));
            row_data.add(Integer.valueOf(row_data_split[4]));

            data.add(row_data);
        }
        return new myDataFrame(data);
    }

    public static void writeCSV(String path, myDataFrame df) throws IOException {
        FileWriter wr = new FileWriter(path);
        ArrayList<String> temp = new ArrayList<String>();
        for (int i = 0; i < df.data.size(); i++) {
            String s = "";
            for (int j = 0; j < df.data.get(i).size(); j++) {
                s += df.data.get(i).get(j) + ",";
            }
            s = s.substring(0, s.length() - 1);
            temp.add(s);
        }
        for (String str: temp) {
            wr.write(str + System.lineSeparator());
        }
        wr.close();
    }

    public myDataFrame concat(myDataFrame df_1, myDataFrame df_2) {
        ArrayList<ArrayList<Object>> concatArr = new ArrayList<>();

        concatArr.addAll(df_1.data);
        concatArr.addAll(df_2.data);
                
        return new myDataFrame(concatArr);
    }
}
