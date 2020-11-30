package tsp;

import java.io.*;
import java.lang.String;
import java.util.ArrayList;
import java.util.Scanner;

public class myFileReader {

    public static ArrayList<String> importFromFile(String fileName) {
        // Arraylist that will be exported
        ArrayList<String> output = new ArrayList<>();

        // instantiate the file to be read from, and a string
        File file = new File(fileName);
        
        try {
            // instantiate the first scanner to read from the file
            Scanner inputSC = new Scanner(file);
            // instantiate the second scanner to specifically seperate by delimiter
            String str = "null";
            Scanner lineScanner = new Scanner(str);
            // seperate by spaces
            lineScanner.useDelimiter(" ");
            // while there are lines in the file,
            System.out.println(lineScanner.delimiter());
            while (inputSC.hasNextLine()) {
                str = inputSC.nextLine();
                for (String string : str.split(" ")) {
                    output.add(string);
                }
            }

            inputSC.close();
            lineScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println(e );
        }

        return output;
    }

}
