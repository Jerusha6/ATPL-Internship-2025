// Unique Words from a Sentence
// Input a sentence and extract all unique words using a HashSet<String>.
package com.aaslin.java.assignments.assignment_6;
import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;
class UniqueWordsInSet{
    public static void main(String[] args){
        Set<String> set = new HashSet<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a sentence: ");
        String sentence = scanner.nextLine();
        String[] words = sentence.split(" ");
        for(String word:words){
            set.add(word);
        }
        System.out.println("Here is the unique words from the given sentence: "+set);
    }
}