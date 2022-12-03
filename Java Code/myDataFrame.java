import java.util.ArrayList;
public class myDataFrame {

    public ArrayList<ArrayList<Object>> data;
    public ArrayList<String> header;

    public myDataFrame(ArrayList<ArrayList<Object>> data) {

        ArrayList<String> header = new ArrayList<String>();

        header.add("State");
        header.add("Gender");
        header.add("Year");
        header.add("Name");
        header.add("Count");

        this.header = header;
        this.data = data;

    }

    public myDataFrame head(int n) {
        ArrayList<ArrayList<Object>> temp = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            temp.add(data.get(i));
        }
        return new myDataFrame(temp);
    }

    public myDataFrame tail(int n) {
        ArrayList<ArrayList<Object>> temp = new ArrayList<>();

        int length = data.size();
        for (int i = length-n; i < length; i++) {
            temp.add(data.get(i));
        }
        return new myDataFrame(temp);
    }
}
