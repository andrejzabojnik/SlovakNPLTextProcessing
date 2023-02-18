
package sk.textprocessor.input;

import sk.textprocessor.exceptions.InvalidInputFileException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class InputReader {

    public String readFile(String fileName) throws InvalidInputFileException {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String text = "";
            String line;

            while (( line = br.readLine()) != null) {
                text += line + "\n";
            }
            return text;

        } catch (IOException e) {
            throw new InvalidInputFileException("Chyba: Nespravne zadaný súbor");
        }
    }
}




