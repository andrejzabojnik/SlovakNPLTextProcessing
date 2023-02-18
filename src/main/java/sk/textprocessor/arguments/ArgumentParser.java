package sk.textprocessor.arguments;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import org.w3c.dom.Text;
import sk.textprocessor.exceptions.InvalidParametersCombinationException;
import sk.textprocessor.exceptions.UnknownParametersException;
import sk.textprocessor.processing.TextProcesses;

public class ArgumentParser {
    TextProcesses TextProcesses = new TextProcesses();

//    parameters for TextProcesses
    @Parameter(names = "-token", description = "Tokenize text")
    private boolean tokenize = false;

    @Parameter(names = "-extsents", description = "Extract sentences")
    private boolean extractSentences = false;

    @Parameter(names = "-lowercase", description = "lowercase")
    private boolean lowercasing = false;

//    file parameters
    @Parameter(names = "-input", description = "Input file")
    private String inputFile = "";

    @Parameter(names = "-print", description = "Print text")
    private boolean printText = false;

    @Parameter(names = "-change", description = "Change file")
    private boolean changeFile = false;

    @Parameter(names = "-newFile", description = "Tokenize text")
    private String newFile = "";

//  Jcommander instance
    public ArgumentParser(String[] args) throws InvalidParametersCombinationException,UnknownParametersException {
        JCommander jCommander = JCommander.newBuilder()
                .addObject(this)
                .build();
        try {
            jCommander.parse(args);
            if(checkNumberOfParameters() >  1) {
                throw new InvalidParametersCombinationException("Chyba: Nemôžete zadať súčasne dva parametre na spracovanie textu");
            }
            if(checkNumberOfParameters() == 0){
                throw new UnknownParametersException("Chyba: Nezadaly ste žiadny parameter na spracovanie textu");
            }
            }
         catch (ParameterException e) {
            throw new UnknownParametersException("Chyba: Zadane parametre neexistuju");
        }
    }

    public int checkNumberOfParameters(){
        boolean[] options = {tokenize, extractSentences, lowercasing};
        int count = 0;
        for (int i = 0; i < options.length; i++) {
            if (options[i]) {
                count++;
            }
        }
        return count;

    }

    public String[]  processTextArgument(String text){
        if(this.isTokenize()) {
            return TextProcesses.tokenize(text);
        }else if(this.isExtractSentences()){
            return TextProcesses.extractSentences(text);
        }
        String[] emptyArray = {};
        return emptyArray;
    }

//  functions
    public String getNewFileName() { return newFile;}
    public boolean isTokenize() {
        return tokenize;
    }
    public boolean isExtractSentences() {
        return extractSentences;
    }
    public boolean isChangeFile() {
        return changeFile;
    }
    public String getInputFile() {
        return inputFile;
    }
    public boolean isPrintText() {
        return printText;
    }
    public boolean isLowerCasing() {
        return lowercasing;
    }


}
