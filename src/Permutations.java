

import java.io.*;
import java.util.*;

public class Permutations  {
	
	public static void main(String[] args) throws FileNotFoundException{
		Scanner s = new Scanner(System.in);
		

		System.out.print("Enter any combination of letters, and I will give you words:");
		String input = s.next();
		double time1 = System.currentTimeMillis();
		System.out.println();
		permute(input);
		double time2 = System.currentTimeMillis();
		System.out.println("total time: " + (time2-time1)/1000.0 + " seconds");
		
	}
	
	// Outputs all permutations of the given string, one per line.
    public static void permute(String s) throws FileNotFoundException { 
		Scanner fileScanner = new Scanner(new File("allWords.txt"));
    	ArrayList<String> words = new ArrayList<String>();
		while(fileScanner.hasNext()){
			words.add(fileScanner.next());
		}
		Set<String> results = new TreeSet<String>();
        permute(words, results, s, "");
        for(String word: results){
        	if(word.length() == s.length()){
        		System.out.println(word);
        	}
        }
        System.out.println(results.toString());
        System.out.println("Total words found: " + results.size());
    }   
    

    // Adds a 'chosen' parameter representing all characters that
    // have been chosen so far.
    private static void permute(ArrayList<String> words, Set<String> results, String s, String chosen) {
    	if (s.length() == 0) {
    		// Base case; all characters have been chosen. 
    		if(isWord(words, chosen)){
    			results.add(chosen);
    		}
    	} else {
    		// Recursive case; s contains some characters to permute.
    		// for each possible choice,
    		for (int i = s.length()-1; i >= 0; i--) {
        		// choose a character from s (and remove it)
    			char c = s.charAt(i);
    			String rest = s.substring(0, i) + s.substring(i + 1);
    			
 
    			permute(words, results, rest, chosen + c);
    			permute(words, results, rest, chosen);
    			
    		}
    	}
    }
	 
	 private static boolean isWord(ArrayList<String> words, String word){
		 int index = Collections.binarySearch(words, word);
		 if(index>=0){
			 return true;
		 }
		 return false;
	 }	
}