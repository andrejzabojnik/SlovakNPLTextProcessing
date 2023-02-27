
import cz.cuni.mff.ufal.morphodita.Morpho;
import org.w3c.dom.Text;
import sk.textprocessor.arguments.ArgumentParser;
import sk.textprocessor.exceptions.*;

import sk.textprocessor.input.InputReader;
import sk.textprocessor.output.FileHandler;
import sk.textprocessor.processing.TextProcesses;

import java.util.LinkedHashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        TextProcesses TextProcessor = new TextProcesses();
        InputReader InputReader = new InputReader();
        FileHandler FileHandler = new FileHandler();

        try {
            ArgumentParser ArgumentParser = new ArgumentParser(args);
            String inputText = InputReader.readFile(ArgumentParser.getInputFile());


//            new file controller

            if(!ArgumentParser.getNewFileName().equals("")){
                FileHandler.createNewFile(ArgumentParser.getNewFileName(),ArgumentParser.processTextArgument(inputText));

            }
            if(ArgumentParser.isChangeFile()){
                FileHandler.changeFile(ArgumentParser.processTextArgument(inputText),ArgumentParser.getInputFile());

            }
            if(ArgumentParser.isPrintText()){
                Object result = ArgumentParser.processTextArgument(inputText);
                System.out.println(result);
                if (result instanceof String[]) {
                    String[] output = (String[]) result;
                    for(String i : output){
                        System.out.println(i);
                    }

                } else if (result instanceof LinkedHashMap) {
                    LinkedHashMap<String, String> output = (LinkedHashMap<String, String>) result;
                    for (Map.Entry<String, String> entry : output.entrySet()) {
                        System.out.println(entry.getKey() + ": " + entry.getValue());
                    }
                }
            }

//
        } catch (UnknownParametersException | InvalidInputFileException | InvalidParametersCombinationException | InvalidOutputFileException | RuntimeException  |
                 InvalidTextProcessingTypeException e) {
            System.err.println(e.getMessage());
        }


    }
}
