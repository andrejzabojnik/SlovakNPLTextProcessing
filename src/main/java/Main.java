import cz.cuni.mff.ufal.morphodita.Morpho;
import org.w3c.dom.Text;
import sk.textprocessor.arguments.ArgumentParser;
import sk.textprocessor.exceptions.InvalidInputFileException;
import sk.textprocessor.exceptions.InvalidOutputFileException;
import sk.textprocessor.exceptions.InvalidParametersCombinationException;
import sk.textprocessor.exceptions.UnknownParametersException;

import sk.textprocessor.input.InputReader;
import sk.textprocessor.output.FileHandler;
import sk.textprocessor.processing.TextProcesses;

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
                System.out.println(ArgumentParser.processTextArgument(inputText));
            }

//
        } catch (UnknownParametersException | InvalidInputFileException | InvalidParametersCombinationException | InvalidOutputFileException e) {
            System.err.println(e.getMessage());
        }




    }
}
