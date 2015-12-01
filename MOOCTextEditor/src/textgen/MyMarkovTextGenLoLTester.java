/**
 * 
 */
package textgen;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

/**
 * @author a
 *
 */
public class MyMarkovTextGenLoLTester {
	
	String shortText = "hi there";
	MarkovTextGeneratorLoL markovGen;
	
	MarkovTextGeneratorLoL markovGen2;
	String longerText = "hi there hi Leo Leo";
	 

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		
		markovGen = new MarkovTextGeneratorLoL();
		markovGen.train(shortText);
		
		markovGen2 = new MarkovTextGeneratorLoL();
		markovGen2.train(longerText);
		
	}

	/**
	 * Test method for {@link textgen.MarkovTextGeneratorLoL#MarkovTextGeneratorLoL(java.util.Random)}.
	 */
	@Test
	public void testMarkovTextGeneratorLoL() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link textgen.MarkovTextGeneratorLoL#train(java.lang.String)}.
	 */
	@Test
	public void testTrain() {
		assertEquals("Check output", "hi: " + "\n" + "there: " + "\n", markovGen.toString());
		assertEquals("Check output", "hi: " + "\n" + "there: " + "\n" + "Leo: "+ "\n", markovGen2.toString());
		//assertEquals("Check output", "hi: there->"+"\n"+"there: hi->", markovGen.toString());
		
	}

	/**
	 * Test method for {@link textgen.MarkovTextGeneratorLoL#generateText(int)}.
	 */
	@Test
	public void testGenerateText() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link textgen.MarkovTextGeneratorLoL#retrain(java.lang.String)}.
	 */
	@Test
	public void testRetrain() {
		fail("Not yet implemented");
	}

}
