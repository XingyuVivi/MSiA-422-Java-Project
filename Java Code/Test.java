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

        //Test case 10 for myDataFrame sort(int index)
        myDataFrame output10 = data.sort(4);
        String p10 = "/Users/wangxingyu/Dropbox/Mac/Desktop/NU/py_Java/MSiA-422-Java-Project/testCase_output" +
                "/test10.txt";
        MyPandas.writeCSV(p10, output10);

        myDataFrame output10_1 = data.sort(2);
        String p10_1 = "/Users/wangxingyu/Dropbox/Mac/Desktop/NU/py_Java/MSiA-422-Java-Project/testCase_output" +
                "/test10_1.txt";
        MyPandas.writeCSV(p10_1, output10_1);

        //Test case 11 for Object getMin(int index)
        Object output11 = data.getMin(4);
        System.out.println("Test case 11: The minimum name count in IL is ");
        System.out.println(output11);

        Object output11_1 = data.getMin(3);
        System.out.println("Test case 11_1: The smallest name,sorting alphabetically, in IL is ");
        System.out.println(output11_1);


        //Test case 12 for Object getMin(String label)
        Object output12 = data.getMin("Year");
        System.out.println("Test case 12: The earliest year record in IL is ");
        System.out.println(output12);

        Object output12_1 = data.getMin("Count");
        System.out.println("Test case 12_1: The minimum name count, in IL is ");
        System.out.println(output12_1);

        //Test case 13 for Object getMax(int index)
        Object output13 = data.getMax(2);
        System.out.println("Test case 13: The most recent year record in IL is ");
        System.out.println(output13);

        Object output13_1 = data.getMax(3);
        System.out.println("Test case 13_1: The largest name,sorting alphabetically, in IL is ");
        System.out.println(output13_1);

        //Test case 14 for Object getMax(String label)
        Object output14 = data.getMax("Year");
        System.out.println("Test case 14: The most recent year record in IL is ");
        System.out.println(output14);

        Object output14_1 = data.getMax("Count");
        System.out.println("Test case 14_1: The largest count in IL is ");
        System.out.println(output14_1);












    }
}
