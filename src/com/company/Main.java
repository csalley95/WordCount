package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        var wordCounts = new HashMap<String, Integer>();
        var allLines = "";
        var path = Paths.get("2600-0.txt");
        try{
            allLines = Files.readString(path);
        }catch (IOException e){
            System.out.println("Couldn't load file: " + path);
        }
        String[] lines = allLines.split("\n");
        for(var line: lines){
            String[] words = line.split(" ");   //splits up the words after each space
            for(var word : words){
                word = word.replaceAll("\\p{Punct}","");
                if(word.length() < 1)
                    continue;
                if(wordCounts.containsKey(word)){
                    var oldCount = wordCounts.get(word);
                    wordCounts.replace(word, oldCount+1);   //if its seen the word already then it will do the oldCunt +1
                }
                else{
                    wordCounts.put(word, 1);    //if it hasnt seen it before then it will at the count to 1
                }
            }
        }
        var allWords = wordCounts.keySet();
        for(var word : allWords){
            var count = wordCounts.get(word);
            System.out.println(word+ " : " + count);
        }
    }
}
