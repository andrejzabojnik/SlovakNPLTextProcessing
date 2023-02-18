package sk.textprocessor.processing;

import sk.textprocessor.output.FileHandler;
import cz.cuni.mff.ufal.morphodita.*;


import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.charset.Charset;
import java.util.*;


import java.util.List;


public class TextProcesses {


    //    tokenization
    public String[] tokenize(String text){

        String output = "";
        String[] array;
        String punctuation = ".,<>/\\\"\'}{[]|!@#$%^&*()_-=+:;?`~";
        for (char s: punctuation.toCharArray()){
            String charakter = Character.toString(s);
            text = text.replace(charakter," "+charakter+" ");
        }

        array = text.split(" ");

        // prejdeme cez kazdy prvok a odstranime potencialne space okolo punctuation
        for(int i = 0; i < array.length; i++) {
            array[i] = array[i].replaceAll("\\s+","").trim();
        }

        return array;
    }

//    extractSentences
    public String[] extractSentences(String text) {
        ArrayList<String> sentences = new ArrayList<String>();

        Abbreviation skr = new Abbreviation();
        boolean dictionary = false;

        int sentenceLastChar = 0;
        int wordLastChar = 0;
        String word = "";
        String input = text;

        sentenceLastChar = 0;
        wordLastChar = 0;

        for (int i = 1; i < input.length() - 3; i++) {
            String ch = input.substring(i, i + 3);

            if (input.charAt(i + 2) == ' ') {
                word = input.substring(wordLastChar, i + 2).trim().toLowerCase();
                wordLastChar = i + 3;
                dictionary = skr.isAbbreviation(word);
            }

            if ((ch.matches("([!?.])(\\s)[A-Z]")) && !dictionary && (input.substring(i-1,i).matches("[a-z]") )) {
                sentences.add(input.substring(sentenceLastChar, i + 1));
                sentenceLastChar = i + 1;
            }
        }

        String[] sentenceArray = new String[sentences.size()];
        sentenceArray = sentences.toArray(sentenceArray);

        return sentenceArray;
    }

    public String LowerCasing(String text){
       return text.toLowerCase();
    }





    public List<String> lemmatize(String text) throws Exception {
        // Načítanie modelu
        String modelPath = "src/taggers/slovak-morfflex-pdt-170914.tagger";
        Tagger tagger = Tagger.load(modelPath);

        String dictPath = "src/taggers/slovak-morfflex-170914.dict";
        Morpho morpho = Morpho.load(dictPath);

        // Lematizácia každého slova v texte
        List<String> words = Arrays.asList(this.tokenize(text));
        List<String> lemmasList = new ArrayList<>();
        for (String word : words) {
            TaggedLemmas lemmas = new TaggedLemmas();
            Forms forms = new Forms();
            forms.add(word);
            tagger.tag(forms, lemmas);
            String lemma = lemmas.get(0).getLemma();
            List<String> rawLemmas = Collections.singletonList(morpho.rawLemma(lemma));
            String rawLemma = rawLemmas.get(0);
            lemmasList.add(rawLemma);
        }

        return lemmasList;
    }


    public String stopWord(String text){
        List<String> stopWords = loadStopWords("src/main/resources/stopwords_file.txt");
        String[] tokenizeWord = tokenize(text);
        for(String word: tokenizeWord){
            if(stopWords.contains(word)){
                tokenizeWord


            }

        }

    }


    public List<String> loadStopWords(String fileName) {
        List<String> stopWords = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                stopWords.add(line.trim());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stopWords;
    }

}








