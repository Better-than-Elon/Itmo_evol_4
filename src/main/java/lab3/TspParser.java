package lab3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TspParser {
    private int dimention;
    private List<Point> cities;
    Scanner scanner;

    public TspParser(String file) {
        try {
            scanner = new Scanner(new File(file));
            getNextInt();
            dimention = getNextInt();
            cities = new ArrayList<>(dimention);
            while (scanner.hasNext()) {
                int index = getNextInt()-1;
                System.out.print(index + " ");
                cities.add(index, new Point(getNextInt(), getNextInt()));
            }
        } catch (IOException e) {
//            e.printStackTrace();
            System.out.println("Exception while reading file");
        }
    }
    private void skipNoneInt(){
        while (scanner.hasNext() && !scanner.hasNextInt()) {
            scanner.next();
        }
    }
    private Integer getNextInt() {

        skipNoneInt();
        Integer res = scanner.nextInt();//scanner.hasNextInt() ? scanner.nextInt() : -1;
        skipNoneInt();
        return res;
    }

    public static void main(String[] args) {
        new TspParser("pka379.tsp");
    }

    public int getDimention() {
        return dimention;
    }

    public List<Point> getCities() {
        return cities;
    }
}
