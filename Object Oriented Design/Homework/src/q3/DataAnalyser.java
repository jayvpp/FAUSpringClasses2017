package q3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;

/**
 * Created by jason on 1/10/2017.
 */
public class DataAnalyser {

    private final LinkedList<Integer> sequence;

    public DataAnalyser(LinkedList<Integer> sequence)
    {
        this.sequence = sequence;
    }

    public void SaveContentToFile(String filePath) {

        CreateFileIfDoesNotExist(filePath);
        try
        {
            FileWriter fileWriter = new FileWriter(filePath,true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            WriteSequenceToFile(bufferedWriter);
        }
        catch (IOException e) {
            PrintCannotWriteIntoFileAndExitProgram();
        }
    }

    private void WriteSequenceToFile(BufferedWriter bufferedWriter) throws IOException {
        for(Integer n: sequence)
            bufferedWriter.write(n + " ");

        bufferedWriter.newLine();
        bufferedWriter.close();
    }

    private void PrintCannotWriteIntoFileAndExitProgram() {
        System.out.println("Error: Cannot Write into the file");
        System.exit(0);
    }

    public void SaveMinMaxAveToFile(String filePath) throws IOException
    {
        CreateFileIfDoesNotExist(filePath);
        try
        {
            FileWriter fileWriter = new FileWriter(filePath,true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            WriteMinMaxAveToFile(bufferedWriter);
        }
        catch (IOException e)
        {
            PrintCannotWriteIntoFileAndExitProgram();
        }
    }

    private void WriteMinMaxAveToFile(BufferedWriter bufferedWriter ) throws IOException {
        bufferedWriter.write("Min= " +  min());
        bufferedWriter.newLine();
        bufferedWriter.write("Max= " + max());
        bufferedWriter.newLine();
        bufferedWriter.write("Average= " + average());
        bufferedWriter.newLine();
        bufferedWriter.close();
    }

    private void CreateFileIfDoesNotExist(String filePath) {
        try
        {
            File file = new File(filePath);
            if (!file.exists())
                file.createNewFile();
        }
        catch (IOException e)
        {
            System.out.println("Error: Cannot Create File, make sure file exits");
            System.exit(0);
        }
    }

    public void PrintMinMaxAveToConsole() throws IOException
    {
        System.out.println("Min " + min());
        System.out.println("Max " + max());
        System.out.println("Average " + average());
    }

    public int min()
    {
        return Collections.min(sequence);
    }
    public  int max()
    {
        return Collections.max(sequence);
    }
    public  double average()
    {
        if(sequence.size() == 0) return 0;

        Integer sum = 0;
        for (Integer i : sequence)
            sum +=i;

        return sum / (double)sequence.size();
    }
}
