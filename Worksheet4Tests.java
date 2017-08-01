/**
 * This class contains manual testing results for a created 
 * controller object as well as JUnit tests for the Model 
 * class.All tests were done using the dictionary file 
 * located at "/usr/share/dict/words" on the 
 * School's file system.
 * @author William Downs
 * @version 26/02/16
 * 
 */

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.Set;
import java.util.TreeSet;
import org.junit.Test;

public class Worksheet4Tests {

	/** Manual Test 1 - Normal Input 
	 * 
	 * Input: 2, 0, 7, 2, 6, 3, 6, 6, 0, 7, 3, 6, 8, 3, 6, 2, 3
	 * Display expected: "a random sentence"
	 * 
	 * Test Result: Passed
	 * Test Date: 26/02/2016
	 * Test Time: 22:38
	 * Tested by: William Downs	
	 */

	/** Manual Test 2 - Normal Input - with star button use
	 * 
	 * Input: 9, 4, 6, 0, 5, 8, 6, 7, 3, 3, 0, 3, 8, 7, 8, 4, 3, 7, 8, *, 0, 9, 3, 7, 8, 3, 7, 3, 2, 9
	 * Display expected: "who jumped furthest yesterday"
	 * 
	 * Test Result: Passed
	 * Test Date: 26/02/2016
	 * Test Time: 22:40
	 * Tested by: William Downs	
	 */

	/** Manual Test 3 - Testing Star Button 
	 *  Testing to see if star button successfully cycles through possible words and returns
	 *  to original word once the final possible word has been presented
	 * 	Input: 2, 9, 2, 5, 3, *, *, *, *, *
	 *  End Display expected: "cycle"
	 * 
	 * Test Result: Passed
	 * Test Date: 26/02/2016
	 * Test Time: 22:42
	 * Tested by: William Downs	
	 */

	/** Manual Test 4 - Zero Button Test
	 *  Testing to see if 0 button will create multiple space between words
	 * 	Input: 2, 0, 0, 0, 0, 0, 7, 7, 2, 2, 3, *
	 *  End Display expected: "a     space"
	 * 
	 * Test Result: Passed
	 * Test Date: 26/02/2016
	 * Test Time: 22:50
	 * Tested by: William Downs	
	 */

	/** Manual Test 5 - No Matching Words
	 *  Testing to ensure the program does not crash if there are no matching words
	 *  Should display last possible matching word and allow to move onto next word
	 * 	Input: 3, 5, 3, 7, 4, 2, 6, 8, 7, 9, 9, 7, 5, 0, 4, 6, *, *
	 *  End Display expected: "elephantry go"
	 * 
	 * Test Result: Passed
	 * Test Date: 26/02/2016
	 * Test Time: 22:52
	 * Tested by: William Downs	
	 */

	@Test
	/**
	 * Model - signatureToWords
	 * Empty Case - An Empty String - Should return an Empty TreeSet
	 */
	public void ModelTest1() {

		String input = "";
		Model model = new Model();
		Set<String> input2 = model.signatureToWords(input);
		TreeSet<String> expected = new TreeSet<String>();
		assertEquals(expected, input2);
	}	
	@Test
	/**
	 * Model - signatureToWordsList
	 * Should return expected possible words List - multiple word match
	 */
	public void ModelTest2() {

		String input = "8463";
		Model model = new Model();
		Set<String> input2 = model.signatureToWords(input);
		TreeSet<String> expected = new TreeSet<String>();
		expected.add("time");
		expected.add("vine");
		expected.add("thof");
		expected.add("tind");
		expected.add("tine");



		assertEquals(expected, input2);
	}	

	@Test
	/**
	 * Model - signatureToWords - no matching words
	 * Should return an empty TreeSet 
	 */
	public void ModelTest3() {

		String input = "22222222";
		Model model = new Model();
		Set<String> input2 = model.signatureToWords(input);
		TreeSet<String> expected = new TreeSet<String>();
		assertEquals(expected, input2);
	}

	@Test
	/**
	 * Model - wordToSignature
	 * Empty Case - Should return an Empty String
	 */
	public void ModelTest4() {

		String word = "";

		String word2 = Model.wordToSignature(word);

		String expected = "";
		assertEquals(expected, word2);
	}

	@Test
	/**
	 * Model - wordToSignature
	 * Should return expected signature 
	 */
	public void ModelTest5() {

		String word = "elephant";

		String word2 = Model.wordToSignature(word);

		String expected = "35374268";
		assertEquals(expected, word2);
	}

	@Test
	/**
	 * Model - wordToSignature with invalid characters
	 * Should return expected signature with spaces 
	 */
	public void ModelTest6() {

		String word = "e!l£e$p%h^a&n*t";

		String word2 = Model.wordToSignature(word);

		String expected = "3 5 3 7 4 2 6 8";
		assertEquals(expected, word2);
	}	

	@Test
	/**
	 * Model - wordToSignature
	 * Should return expected signature 
	 */
	public void ModelTest7() {

		String input = "abcdefghijklmnopqrstuvwxyz";
		String input2 = Model.wordToSignature(input);

		String expected = "22233344455566677778889999";
		assertEquals(expected, input2);
	}	

	@Test
	/**
	 * Model - isValidWord
	 * Invalid Word - Should return false 
	 */
	public void ModelTest8() {

		String word = "octo!pus";
		assertFalse(Model.isValidWord(word));
	}

	@Test
	/**
	 * Model - isValidWord
	 * Invalid Word - Should return false 
	 */
	public void ModelTest9() {

		String word = "hello4";
		assertFalse(Model.isValidWord(word));
	}

	@Test
	/**
	 * Model - isValidWord
	 * Invalid Word - Should return false 
	 */
	public void ModelTest10() {

		String word = "lio*n";
		assertFalse(Model.isValidWord(word));
	}

	@Test
	/**
	 * Model - isValidWord
	 * Invalid Word - Should return false 
	 */
	public void ModelTest11() {

		String word = "&";
		assertFalse(Model.isValidWord(word));
	}

	@Test
	/**
	 * Model - isValidWord
	 * Valid Word - Should return true 
	 */
	public void ModelTest12() {

		String word = "doctor";
		assertTrue(Model.isValidWord(word));
	}

	@Test
	/**
	 * Model - isValidWord
	 * Valid Word - Should return true 
	 */
	public void ModelTest13() {

		String word = "crocodile";
		assertTrue(Model.isValidWord(word));
	}


}
