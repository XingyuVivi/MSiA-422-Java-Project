import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

//import javafx.util.Pair;
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

    public String dType(int index){
        //Returns the type of the column specified by index. If the type is not uniform, return ‘String’.

        return "String";
    }

    public String dType(String name){
        //Returns the type of the column specified by name. If the type is not uniform, return ‘String’.

        return "String";
    }

// slicing
    public myDataFrame slice(int index){
        ArrayList<ArrayList<Object>> output_data = new ArrayList<ArrayList<Object>>();
        for (int i = 0; i < this.data.size(); i ++){
            ArrayList<Object> col_data = new ArrayList<Object>();
            col_data.add(this.data.get(i).get(index));
            output_data.add(col_data);
        }
        return new myDataFrame(output_data);
    }

    public myDataFrame slice(String name){
        ArrayList<ArrayList<Object>> output_data = new ArrayList<ArrayList<Object>>();
        int index = this.header.indexOf(name);
        for (int i = 0; i < this.data.size(); i ++){
            ArrayList<Object> col_data = new ArrayList<Object>();
            col_data.add(this.data.get(i).get(index));
            output_data.add(col_data);
        }
        return new myDataFrame(output_data);
    }

    public myDataFrame slice(int[] indexArr){
        ArrayList<ArrayList<Object>> output_data = new ArrayList<ArrayList<Object>>();
        for (int i = 0; i < this.data.size(); i ++){
            ArrayList<Object> col_data = new ArrayList<Object>();
            for (int j = 0; j < indexArr.length; j++){
                int index = indexArr[j];
                col_data.add(this.data.get(i).get(index));
            }
            output_data.add(col_data);
        }
        return new myDataFrame(output_data);
    }

    public myDataFrame slice(String[] nameArr){
        ArrayList<ArrayList<Object>> output_data = new ArrayList<ArrayList<Object>>();
        for (int i = 0; i < this.data.size(); i ++){
            ArrayList<Object> col_data = new ArrayList<Object>();
            for (int j = 0; j < nameArr.length; j++){
                int index = this.header.indexOf(nameArr[j]);
                col_data.add(this.data.get(i).get(index));
            }
            output_data.add(col_data);
        }
        return new myDataFrame(output_data);
    }

// filtering
    public myDataFrame filter(String col, String op, Object o){
        ArrayList<ArrayList<Object>> output_data = new ArrayList<ArrayList<Object>>();
        int index = this.header.indexOf(col);


        // If values in the column are integers
        if(this.data.get(0).get(index) instanceof Integer && o instanceof Integer){

            // loop through rows of data to see which fulfill the requirement
            for (int i = 0; i < this.data.size(); i ++ ) {
                int df_value = (Integer) this.data.get(i).get(index);
                int target = (Integer) o;

                if (op.equals(">") && df_value > target) {
                    output_data.add(this.data.get(i));
                }
                else if (op.equals(">=") && df_value >= target) {
                    output_data.add(this.data.get(i));
                }
                else if (op.equals("<") && df_value < target) {
                    output_data.add(this.data.get(i));
                }
                else if (op.equals("<=") && df_value <= target) {
                    output_data.add(this.data.get(i));
                }
                else if (op.equals("=") && df_value == target) {
                    output_data.add(this.data.get(i));
                }
            }
        }

        // if values in the column is not an integer, which means it is a string
        else {

            // loop through rows to see which fulfill the requirement
            for (int i = 0; i < this.data.size(); i++){
                String df_value = (String) this.data.get(i).get(index);
                String target = (String) o;
                if (op.equals("=") && df_value.compareTo(target) == 0){
                    output_data.add(this.data.get(i));
                }
                else if (op.equals(">") && df_value.compareTo(target) > 0) {
                    output_data.add(this.data.get(i));
                }
                else if (op.equals(">=") && df_value.compareTo(target) >= 0) {
                    output_data.add(this.data.get(i));
                }
                else if (op.equals("<") && df_value.compareTo(target) < 0) {
                    output_data.add(this.data.get(i));
                }
                else if (op.equals("<=") && df_value.compareTo(target) <= 0) {
                    output_data.add(this.data.get(i));
                }
                else if (op.equals("!=") && df_value.compareTo(target) != 0) {
                    output_data.add(this.data.get(i));
                }
            }

        }

        return new myDataFrame(output_data);

        }
// indexing
    public myDataFrame loc(int index){
        ArrayList<ArrayList<Object>> output_data = new ArrayList<ArrayList<Object>>();
        output_data.add(this.data.get(index));
        return new myDataFrame(output_data);
    }

    public myDataFrame loc(String label){
        ArrayList<ArrayList<Object>> output_data = new ArrayList<ArrayList<Object>>();
        // Assume to locate rows by Name
        int index = this.header.indexOf("Name");
        for (int i = 0; i < this.data.size(); i++){
            if (this.data.get(i).get(index).equals(label)){
                output_data.add(this.data.get(i));
            }
        }
        return new myDataFrame(output_data);
    }

    public myDataFrame loc(int from, int to){
        //indexing range from 0 to rows-1 of the dataset
        ArrayList<ArrayList<Object>> output_data = new ArrayList<ArrayList<Object>>();
        for (int i = from; i <= to; i++){
            output_data.add(this.data.get(i));
        }
        return new myDataFrame(output_data);
    }

    public myDataFrame loc(String from, String to){
        ArrayList<ArrayList<Object>> output_data = new ArrayList<ArrayList<Object>>();
        ArrayList<ArrayList<Object>> empty_data = new ArrayList<ArrayList<Object>>();
        int index = this.header.indexOf("Name");
        // whether the start name is found.
        boolean start_found = false;
        //whether the end name is found
        boolean end_found = false;
        for (int i = 0; i < this.data.size(); i++){
            if (this.data.get(i).get(index).equals(from)){
                start_found = true;
            }
            if (this.data.get(i).get(index).equals(to)){
                end_found = true;
                output_data.add(this.data.get(i));
                break;
            }
            if (start_found && !end_found){
                output_data.add(this.data.get(i));
            }
        }
        if (!start_found || !end_found){
            //if start name or end name is not found, return an empty dataframe
            return new myDataFrame(empty_data);
        }

        return new myDataFrame(output_data);
    }

    // sorting
    public myDataFrame sort(int index){
        ArrayList<ArrayList<Object>> output_data = this.data;
        Collections.sort(output_data, new Comparator<ArrayList<Object>>() {
            @Override
            public int compare(ArrayList<Object> a1, ArrayList<Object> a2){
                if (a1.get(index) instanceof Integer){
                    if ((Integer) a1.get(index) > (Integer) a2.get(index)){
                        return 1;
                    }
                    else if ((Integer) a1.get(index) < (Integer) a2.get(index)){
                        return -1;
                    }
                    return 0;
                }
                else {
                    return ((String) a1.get(index)).compareTo((String) a2.get(index));
                }
            }
        });
        return new myDataFrame(output_data);
    }

    // Aggregate
    public Object getMin(int index) {
        if (this.data.get(0).get(index) instanceof Integer){
            ArrayList<Integer> compared_col = new ArrayList<Integer>();
            for (int i = 0; i < this.data.size(); i++){
                int value = (Integer) this.data.get(i).get(index);
                compared_col.add(value);
            }
            return (Collections.min(compared_col));
        }
        else {
            ArrayList<String> compared_col = new ArrayList<String>();
            for (int i = 0; i < this.data.size(); i++){
                String value = (String) this.data.get(i).get(index);
                compared_col.add(value);
            }
            return (Collections.min(compared_col));
        }
    }

    public Object getMin(String label){
        int index = this.header.indexOf(label);
        if (this.data.get(0).get(index) instanceof Integer){
            ArrayList<Integer> compared_col = new ArrayList<Integer>();
            for (int i = 0; i < this.data.size(); i++){
                int value = (Integer) this.data.get(i).get(index);
                compared_col.add(value);
            }
            return (Collections.min(compared_col));
        }
        else {
            ArrayList<String> compared_col = new ArrayList<String>();
            for (int i = 0; i < this.data.size(); i++){
                String value = (String) this.data.get(i).get(index);
                compared_col.add(value);
            }
            return (Collections.min(compared_col));
        }
    }

    public Object getMax(int index){
        if (this.data.get(0).get(index) instanceof Integer){
            ArrayList<Integer> compared_col = new ArrayList<Integer>();
            for (int i = 0; i < this.data.size(); i++){
                int value = (Integer) this.data.get(i).get(index);
                compared_col.add(value);
            }
            return (Collections.max(compared_col));
        }
        else {
            ArrayList<String> compared_col = new ArrayList<String>();
            for (int i = 0; i < this.data.size(); i++){
                String value = (String) this.data.get(i).get(index);
                compared_col.add(value);
            }
            return (Collections.max(compared_col));
        }
    }

    public Object getMax(String label){
        int index = this.header.indexOf(label);
        if (this.data.get(0).get(index) instanceof Integer){
            ArrayList<Integer> compared_col = new ArrayList<Integer>();
            for (int i = 0; i < this.data.size(); i++){
                int value = (Integer) this.data.get(i).get(index);
                compared_col.add(value);
            }
            return (Collections.max(compared_col));
        }
        else {
            ArrayList<String> compared_col = new ArrayList<String>();
            for (int i = 0; i < this.data.size(); i++){
                String value = (String) this.data.get(i).get(index);
                compared_col.add(value);
            }
            return (Collections.max(compared_col));
        }
    }


}
