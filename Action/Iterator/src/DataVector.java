/**
 *  Data stored in a vector
 */
import java.io.*;
import java.util.*;

public class DataVector implements Aggregate {
    private Vector data = new Vector();
    
    public DataVector(String fileName) {
        try {
            BufferedReader f = new BufferedReader(new FileReader(fileName));
            String s = f.readLine();
            while(s != null) {
                if(s.trim().length() > 0) {
                    data.add(s);
                }
                s = f.readLine();
            }
            f.close();
        } catch (FileNotFoundException e) {
            System.out.println("Can not find such file !");
        } catch (IOException e) {
            System.out.println("I/O Error !");
            System.exit(0);
        }
    }
    //这里使用的是白箱模式，如果使用黑箱模式这里可以使用一个内部类来实现迭代器接口
    public Iterator CreateIterator() {
        return new VectorIterator(data);
    }
    
}
