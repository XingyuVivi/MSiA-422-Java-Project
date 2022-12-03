import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
//      Test path
        String path_r = "C:\\Users\\nuke2\\Desktop\\NW Work\\Data\\babynames\\IL.TXT";
        String path_w = "C:\\Users\\nuke2\\Desktop\\NW Work\\MSiA-422-Java-Project\\text_write.txt";
        myDataFrame data = MyPandas.readCSV(path_r);

        MyPandas.writeCSV(path_w, data);
    }
}
