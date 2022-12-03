import java.io.FileNotFoundException;

public class Test {
    public static void main(String[] args) throws FileNotFoundException {
//      Test path
        String path = "C:\\Users\\nuke2\\Desktop\\NW Work\\Data\\babynames\\IL.TXT";
        System.out.println(MyPandas.readCSV(path).header);
    }
}
