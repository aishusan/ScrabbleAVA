package scrabble;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by vedsharma on 05-Aug-16.
 */

public class Scrabble {

    public static int charToPrime(char ch) {
        Integer[] primes = {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,71,73,79,83,89,97,101,103};
        if (ch==' ')
            return 1;
        return primes[ch-'A'];
    }

    public static boolean isPrimePresent(int num) {
        Integer[] primes = {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,71,73,79,83,89,97,101,103};
        for (int prime:primes)
            if (prime==num)
                return true;
        return false;
    }

    public static int calculatePrimeProduct(String str) {
        int prod = 1;
        for (char ch:str.toUpperCase().toCharArray())
            prod*=charToPrime(ch);
        return prod;
    }

    public static String[] getAllWords() throws java.io.FileNotFoundException {
        return new Scanner(new File("C:\\Users\\vedsharma\\Downloads\\Bootcamp\\Day 4\\sowpods.txt")).useDelimiter("\\Z").next().split("\\r?\\n");
    }

    public static HashMap<String, Integer> createPrimeList(String[] words) throws java.io.FileNotFoundException {
        HashMap<String,Integer> primeMap = new HashMap<>();
        for (String word : words)
            primeMap.put(word,calculatePrimeProduct(word));
        return primeMap;
    }

    public static ArrayList<String> getAllWords(Word rack) throws java.io.FileNotFoundException {
        String rackString = "";
        for (Letter letter: rack.getWord())
            rackString+=letter.getCharacter();
        int primeProduct = calculatePrimeProduct(rackString);
        ArrayList<String> allWords = new ArrayList<>();
        HashMap<String,Integer> primeMap = createPrimeList(getAllWords());
        for (String word: primeMap.keySet())
            if (primeProduct%primeMap.get(word)==0)
                allWords.add(word);
        return allWords;
    }

    public static ArrayList<Word> convertToObject(ArrayList<String> wordsString) {
        ArrayList<Word> words = new ArrayList<>();
        for (String wordString: wordsString) {
            Word word = new Word(wordString);
            words.add(word);
        }
        return words;
    }

    public static void main(String[] args) {
        System.out.print("Enter rack : ");
        Scanner sc = new Scanner(System.in);
        Word rack = new Word(sc.nextLine().toUpperCase());
        //System.out.println(rack);
        //System.out.println("-----------------------------------------------------");
        try {
            for (Word word:convertToObject(getAllWords(rack))) {
                System.out.println(word);
            }
        }
        catch(java.io.FileNotFoundException e) {
            System.out.println("Unable to open file.");
        }
    }
}

//    public static ArrayList<String> permutation(String str) {
//        ArrayList<String> permutations = new ArrayList<>();
//        return permutation(permutations, "", str);
//    }
//    private static ArrayList<String> permutation(ArrayList<String> permutations, String prefix, String str) {
//        int n = str.length();
//        if (n == 0)
//            permutations.add(prefix);
//        else
//            for (int i=0; i < n; i++)
//                permutations = permutation(permutations, prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
//        return permutations;
//    }