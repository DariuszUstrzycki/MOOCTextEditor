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
		assertEquals("Check two-word list output", "hi: there->" + "\n" + "there: hi->" + "\n", markovGen.toString());
		assertEquals("Check longer list output", "hi: there->Leo->" + "\n" + "there: hi->" + "\n" + "Leo: Leo->hi->" + "\n", markovGen2.toString());
		
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
