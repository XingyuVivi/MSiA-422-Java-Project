import java.util.ArrayList;
public class myDataFrame {

    public ArrayList<ArrayList<Object>> data;
    public int length;
    public ArrayList<String> header;

    public myDataFrame(ArrayList<ArrayList<Object>> data) {

        ArrayList<String> header = new ArrayList<String>();

        header.add("State");
        header.add("Gender");
        header.add("Year");
        header.add("Name");
        header.add("Count");

        this.header = header;
        this.length = data.size();
        this.data = data;

    }

}
