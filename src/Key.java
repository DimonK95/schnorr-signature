import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Dmitrii on 17.11.2016.
 */
public class Key {
    private ArrayList<BigInteger> Entity;

    public Key(){
        Entity = new ArrayList<BigInteger>();
    }

    public Key(BigInteger[] keys){
        Entity = new ArrayList<BigInteger>();
        for (int i = 0; i < keys.length; i++){
            Entity.add(keys[i]);
        }
    }
    public Key(String path) throws FileNotFoundException {
        readFromFile(path);
    }

    public BigInteger get(int idx){
        if (idx >= Entity.size()) {
            throw new IllegalArgumentException("idx more then size");
        }
        return Entity.get(idx);
    }

    public void readFromFile(String path) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileReader(path));
        Entity = new ArrayList<BigInteger>();
        while (scanner.hasNextBigInteger()){
            Entity.add(scanner.nextBigInteger());
        }
        scanner.close();
    }

    public void writeToFile(String path) throws FileNotFoundException {
        PrintWriter printWriter = new PrintWriter(new File(path));
        for (BigInteger element : Entity){
            printWriter.println(element);
        }
        printWriter.close();
    }
}
