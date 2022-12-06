import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
//      Test path
        String path_r = "/Users/wangxingyu/Dropbox/Mac/Desktop/NU/py_Java/Project/namesbystate/IL.TXT";
        String path_w = "/Users/wangxingyu/Dropbox/Mac/Desktop/NU/py_Java/MSiA-422-Java-Project" +
                "/text_write.txt";
        myDataFrame data = MyPandas.readCSV(path_r);

        // Test case1:  myDataFrame slice(int index)
        myDataFrame output1 = data.slice(3);
        String p1 = "/Users/wangxingyu/Dropbox/Mac/Desktop/NU/py_Java/MSiA-422-Java-Project/testCase_output" +
                "/test1.txt";
        MyPandas.writeCSV(p1, output1);

        // Test case2 for myDataFrame slice(String name)
        myDataFrame output2 = data.slice("Name");
        String p2 = "/Users/wangxingyu/Dropbox/Mac/Desktop/NU/py_Java/MSiA-422-Java-Project/testCase_output" +
                "/test2.txt";
        MyPandas.writeCSV(p2, output2);

        // Test case3 for myDataFrame slice(int[] indexArr)
        myDataFrame output3 = data.slice(new int[] {0,1,3});
        String p3 = "/Users/wangxingyu/Dropbox/Mac/Desktop/NU/py_Java/MSiA-422-Java-Project/testCase_output" +
                "/test3.txt";
        MyPandas.writeCSV(p3, output3);

        // Test case4 for myDataFrame slice(String[] nameArr)
        myDataFrame output4 = data.slice(new String[] {"State","Gender","Name"});
        String p4 = "/Users/wangxingyu/Dropbox/Mac/Desktop/NU/py_Java/MSiA-422-Java-Project/testCase_output" +
                "/test4.txt";
        MyPandas.writeCSV(p4, output4);

        // Test case 5 for myDataFrame filter(String col, String op, Object o)

        //Test for numeric columns
        myDataFrame output5 = data.filter("Count", "<=", 10);
        String p5 = "/Users/wangxingyu/Dropbox/Mac/Desktop/NU/py_Java/MSiA-422-Java-Project/testCase_output" +
                "/test5.txt";
        MyPandas.writeCSV(p5, output5);

        //Test for categorical columns
        myDataFrame output5_1 = data.filter("Name", "<=", "Anna");
        String p5_1 = "/Users/wangxingyu/Dropbox/Mac/Desktop/NU/py_Java/MSiA-422-Java-Project/testCase_output" +
                "/test5_1.txt";
        MyPandas.writeCSV(p5_1, output5_1);



        // Test case 6 myDataFrame loc(int index)
        myDataFrame output6 = data.loc(3);
        String p6 = "/Users/wangxingyu/Dropbox/Mac/Desktop/NU/py_Java/MSiA-422-Java-Project/testCase_output" +
                "/test6.txt";
        MyPandas.writeCSV(p6, output6);

        // Test case 7 for myDataFrame loc(String label)
        myDataFrame output7 = data.loc("Aleta");
        String p7 = "/Users/wangxingyu/Dropbox/Mac/Desktop/NU/py_Java/MSiA-422-Java-Project/testCase_output" +
                "/test7.txt";
        MyPandas.writeCSV(p7, output7);

        // Test case 8 for myDataFrame loc(int from, int to)
        myDataFrame output8 = data.loc(0,10);
        String p8 = "/Users/wangxingyu/Dropbox/Mac/Desktop/NU/py_Java/MSiA-422-Java-Project/testCase_output" +
                "/test8.txt";
        MyPandas.writeCSV(p8, output8);

        //Test case 9 for myDataFrame loc(String from, String to)
        myDataFrame output9 = data.loc("Agnes","Alison");
        String p9 = "/Users/wangxingyu/Dropbox/Mac/Desktop/NU/py_Java/MSiA-422-Java-Project/testCase_output" +
                "/test9.txt";
        MyPandas.writeCSV(p9, output9);






    }
}
