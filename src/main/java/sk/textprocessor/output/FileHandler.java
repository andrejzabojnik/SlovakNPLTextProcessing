package sk.textprocessor.output;

import sk.textprocessor.arguments.ArgumentParser;
import sk.textprocessor.exceptions.InvalidInputFileException;
import sk.textprocessor.exceptions.InvalidOutputFileException;

import java.io.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.Map;

public class FileHandler {




    public <T>  void createNewFile(String fileName, T outputData) throws InvalidOutputFileException{
        String path = System.getProperty("user.home") + "/Desktop";
        String text = processFileData(outputData);
        String filename = fileName + ".txt";
        String fullPath = Paths.get(path, filename).toString();

        try{
            Files.createFile(Paths.get(fullPath));
            Files.write(Paths.get(fullPath), String.join("\n", text).getBytes());
            System.out.println("Súbor bol úspešne vytvorený");
        } catch(IOException e){
            throw new InvalidOutputFileException("Chyba: súbor sa nepodarilo vytvoriť");
        }
    }

    public <T> void changeFile(String path, T outputData) throws InvalidOutputFileException {
        String text = processFileData(outputData);
        try {
            FileWriter fw = new FileWriter(path);
            fw.write(String.join("\n", text));
            fw.close();
            System.out.println("Súbor bol úspene prepísaný!");
        } catch (IOException e) {
            throw new InvalidOutputFileException("Chyba: subor nebol najdeny");
        }
    }

    public <T> String processFileData(T fileData) {
        StringBuilder sb = new StringBuilder();
        if (fileData instanceof String[]) {
            String[] lines = (String[]) fileData;
            for (String line : lines) {
                sb.append(line).append("\n");
            }
        } else if (fileData instanceof LinkedHashMap) {
            LinkedHashMap<String, Double> map = (LinkedHashMap<String, Double>) fileData;
            for (Map.Entry<String, Double> entry : map.entrySet()) {
                sb.append(entry.getKey()).append(" : ").append(entry.getValue()).append("\n");
            }
        }
        return sb.toString();
    }





}







