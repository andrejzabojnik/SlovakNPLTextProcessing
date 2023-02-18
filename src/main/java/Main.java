import cz.cuni.mff.ufal.morphodita.Morpho;
import org.w3c.dom.Text;
import sk.textprocessor.arguments.ArgumentParser;
import sk.textprocessor.exceptions.InvalidInputFileException;
import sk.textprocessor.exceptions.InvalidOutputFileException;
import sk.textprocessor.exceptions.InvalidParametersCombinationException;
import sk.textprocessor.exceptions.UnknownParametersException;

import sk.textprocessor.output.FileHandler;
import sk.textprocessor.processing.TextProcesses;

public class Main {

    public static void main(String[] args) throws Exception {
        TextProcesses TextProcesses = new TextProcesses();
        System.out.println(TextProcesses.lemmatize("Všetky pracovné ponuky som neprijal."));




    }
}
