/**
 * This class forms the Model part and contains methods storeDictionary, signatureToWords, 
 * wordToSignature, isValidWord and removeDuplicates, as well as a constructor for storing 
 * a dictionary in memory. The dictionary is stored as a TreeMap containing a String 
 * signature and an ArrayList of corresponding matching words. The methods within the class
 * are used to enable a mobile phone GUI to act in the same way as a mobile phone would 
 * when using predictive text. 
 * @author William Downs
 * @version 22/02/16 
 */


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Observable;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Model extends Observable   {
		
	// Set location of file to be read and initialise Map
	private static String location = "/usr/share/dict/words"; 
	private static Map<String, ArrayList<String>> dictionary;
	
	// Constructor - call storeDictionary method with file location
	public Model(){
		
		try {
			dictionary = storeDictionary(location);
		
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	/**
	 * This method reads from a dictionary and stores each entry and its corresponding
	 * numerical signature in a TreeMap which consists of signature keys mapped to 
	 * ArrayLists containing matching words for the given signature. If a signature
	 * already exists within the TreeMap for a given word, the word is added to its 
	 * respective ArrayList along with the other words already present with the same 
	 * numerical signature.  
	 * @param dir, which is the dictionary location that is to be read from.
	 * @return TreeMap, containing all words within the dictionary and their numeric 
	 * signatures.
	 */
	
	private static Map<String, ArrayList<String>> storeDictionary(String dir) throws IOException {
		// Creates a new scanner object and assigns it to dir.
		Scanner sc  = new Scanner(new FileReader(dir));
		// Creates a TreeMap object consisting of Strings and ArrayLists of Strings.
		Map<String, ArrayList<String>> myMap = new TreeMap<String, ArrayList<String>>();
		// (While the scanner has another line)
		while(sc.hasNext()){
			// (assign line to word and go to next line, and convert to lower case).
			String word = sc.nextLine().toLowerCase();
			if(isValidWord(word)){
			// Obtain signature using wordToSignature method and set as signature variable.
				String signature = wordToSignature(word);
			 // Checks to see if there are other words in the map with a matching signature.
			if(myMap.containsKey(signature)){
				// Create a temp ArrayList of existing matching words from TreeMap by
				// using signature as key to access, add word to it, and replace old
				// ArrayList with new updated one.
				ArrayList<String> tempList = myMap.get(signature);
				tempList.add(word);	
				myMap.put(signature, tempList);	
				}
			// If there are no words with matching signatures.
			else {
		// Create temp ArrayList and add word to input ArrayList and signature into TreeMap.
				ArrayList<String> tempList = new ArrayList<String>();
				tempList.add(word);
				myMap.put(signature, tempList);
				}	
			}
		}
		sc.close();
		return myMap;
	}
	
	/*
	 * Method SignatureToWords that takes the given numeric
	 * signature and returns a set of possible matching words from the
	 * dictionary. The returned list must not have duplicates and each word
	 * should be in lower-case. The method SignatureToWords will need to use the
	 * dictionary to find words that match the string signature and return all
	 * the matching words. 
	 * This method is inefficient because each time the method is called it has to open
	 * the file 'words' and check every single word in the dictionary.
	 */

	public static Set<String> signatureToWords(String signature){
		HashSet<String> signatureMatches = new HashSet<String>();
		BufferedReader reader = null;
		
		try {
		    File file = new File("/usr/share/dict/words");
		    reader = new BufferedReader(new FileReader(file));

		    String line;
		    while ((line = reader.readLine()) != null) {
		    	if(line.length()==signature.length() && isValidWord(line)){
		    		if(wordToSignature(line).equals(signature)){
		    			line = line.toLowerCase();
		    			if(!(signatureMatches.contains(line)))
		    				signatureMatches.add(line);
		    		}
		    	}
		    }

		} catch (IOException e) {
		    System.out.println("Words file not found.");
		} finally {
		    try {
		        reader.close();
		    } catch (IOException e) {
		        System.out.println("Error when closing Words file.");
		    }
		}
		return signatureMatches;
	}
	/**
	 * This method takes a word and returns its numerical value in accordance
	 * with standard mobile phone keypad number and letter mapping. The method
	 * uses StringBuffer as opposed to String. This is because Strings are
	 * immutable and therefore a new String would be created for each iteration
	 * of the loop, meaning that numerous String objects would be needlessly
	 * stored in the heap. StringBuffer allows a String to be edited without
	 * creating numerous objects, hence it is more efficient.
	 * @param 'word' a String to be converted into numerical format
	 * @return a String containing the numerical value of a given word
	 */

	public static String wordToSignature(String word) {
         // Takes a word and puts it into a char array to separate the elements.
		char[] myCharArray = word.toCharArray();

		// Creates a new StringBuffer object.
		StringBuffer buffer = new StringBuffer();

		// For loop to cycle through the characters within the array.
		for (int i = 0; i < myCharArray.length; i++) {

			// Each char put through conditional statements to determine the numerical value.
			if (myCharArray[i] >= 'A' && myCharArray[i] <= 'C'
					|| myCharArray[i] >= 'a' && myCharArray[i] <= 'c') {
				myCharArray[i] = '2';
			} else if (myCharArray[i] >= 'D' && myCharArray[i] <= 'F'
					|| myCharArray[i] >= 'd' && myCharArray[i] <= 'f') {
				myCharArray[i] = '3';
			}

			else if (myCharArray[i] >= 'G' && myCharArray[i] <= 'I'
					|| myCharArray[i] >= 'g' && myCharArray[i] <= 'i') {
				myCharArray[i] = '4';
			}

			else if (myCharArray[i] >= 'J' && myCharArray[i] <= 'L'
					|| myCharArray[i] >= 'j' && myCharArray[i] <= 'l') {
				myCharArray[i] = '5';
			} else if (myCharArray[i] >= 'M' && myCharArray[i] <= 'O'
					|| myCharArray[i] >= 'm' && myCharArray[i] <= 'o') {
				myCharArray[i] = '6';
			}

			else if (myCharArray[i] >= 'P' && myCharArray[i] <= 'S'
					|| myCharArray[i] >= 'p' && myCharArray[i] <= 's') {
				myCharArray[i] = '7';
			} else if (myCharArray[i] >= 'T' && myCharArray[i] <= 'V'
					|| myCharArray[i] >= 't' && myCharArray[i] <= 'v') {
				myCharArray[i] = '8';
			}

			else if (myCharArray[i] >= 'W' && myCharArray[i] <= 'Z'
					|| myCharArray[i] >= 'w' && myCharArray[i] <= 'z') {
				myCharArray[i] = '9';
			} else {
				myCharArray[i] = ' ';
			}
			// StringBuffer appends numerical value for each char
			buffer.append(myCharArray[i]);
		}
		// returns as a String
		return buffer.toString();
	}
	

	/**
	 * This method returns a boolean indicating that the given string is a valid word
	 * and does not contain non-alphabetical characters.
	 * @param word (gives a string containing a single word).
	 * @return A boolean indicating whether the given word is valid or not.
	 */
	protected static boolean isValidWord(String word){
		word = word.toLowerCase();
		char check;
		for(int i=0; i<word.length(); i++){
			check = word.charAt(i);
			if((check<97 || check>122)){ // ASCII Code = lower case letters
				return false;
			}
		}
		return true;
	
	}
	
	/**
	 * This method removes duplicate String values from an ArrayList by adding them to 
	 * a HashSet. It does not allow duplicates and subsequently automatically removes them.
	 * The HashSet is then converted back into an ArrayList with duplicates removed.
	 * @param An ArrayList <String> for which duplicates are to be removed.
	 * @return An ArrayList without duplicates.
	 */	
	
	public static ArrayList<String> removeDuplicates(ArrayList<String> a){
		ArrayList <String> temp = new ArrayList<String>();
		HashSet <String> hs = new HashSet<String>();
		hs.addAll(a);
		temp.addAll(hs);
		return temp;
	}

}
