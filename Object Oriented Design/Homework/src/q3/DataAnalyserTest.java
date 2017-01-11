package q3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;


/**
 * Created by jason on 1/10/2017.
 */
public class DataAnalyserTest {
    public static void main(String[] args) {

        LinkedList<Integer> list;
        DataAnalyser analyser;
        String filePath ;
        try
        {
            list = new LinkedList<>();
            BufferedReader  reader = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Enter full path where you want to store file : example C:\\files\\myfile.txt");
            filePath = reader.readLine();
            if(filePath.length()==0) {
                System.out.println("You enter a invalid FilePath, exiting the program");
                System.exit(0);
            }

            System.out.println("Enter list of integer, space separated and press ENTER");
            String[] numbers = reader.readLine().split(" ");

            for (String n: numbers)
            {
                //Check if the use typed a whitespaces, if so we do not want to count them or add them in the list
                if(n.trim().length() == 0) continue;
                Integer element = Integer.parseInt(n);
                list.add(element);
            }
            if(list.size() == 0) { System.out.println("You did not enter any number, exiting the program"); System.exit(0);}
            analyser = new DataAnalyser(list);

            System.out.println("Printing Min, Max, and Average Values");

            analyser.SaveContentToFile(filePath);
            analyser.SaveMinMaxAveToFile(filePath);
            analyser.PrintMinMaxAveToConsole();

        }
        catch (NumberFormatException nfe)
        {
            System.out.println("Number Formatting Incorrect, Please enter a collection of integers whitespace separated");
            System.exit(0);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
