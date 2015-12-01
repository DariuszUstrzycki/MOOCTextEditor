package textgen;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



/** 
 * An implementation of the MTG interface that uses a list of lists.
 * @author UC San Diego Intermediate Programming MOOC team 
 */
public class MarkovTextGeneratorLoL implements MarkovTextGenerator {

	// The list of words with their next words
	private List<ListNode> wordList; 
	
	// The starting "word"
	private String starter;
	
	// The random number generator
	private Random rnGenerator;
	
	public MarkovTextGeneratorLoL(Random generator)
	{
		wordList = new LinkedList<ListNode>();
		starter = ""; 
		rnGenerator = generator;
	}
	
	//my constructor
	public MarkovTextGeneratorLoL()
	{
		wordList = new LinkedList<ListNode>();
		starter = "";
		rnGenerator = null;
	}
	
	
	/** Train the generator by adding the sourceText */
	@Override
	public void train(String sourceText)
	{
		String wordPattern = "[a-zA-Z]+";
		Pattern compiledPattern = Pattern.compile(wordPattern);
		Matcher m = compiledPattern.matcher(sourceText);
		
		ListNode starterNode = new ListNode(starter);
		ListNode preWordNode = starterNode;
		
		while (m.find()) {
			String word = m.group();
			
			ListNode checkedNode = getRepeatedNode(word);	
			
			if (checkedNode == null) {
				
				ListNode newNode = new ListNode(word);				
				wordList.add(newNode);
				preWordNode.addNextWord(word);
				preWordNode = newNode;
				
			} else {
				
				preWordNode.addNextWord(word);
				preWordNode = checkedNode;
			}
		}//end while
		
		preWordNode.addNextWord(starterNode.getFirstNextWord());
	}
	
	
	
	private ListNode getRepeatedNode(String wordToCheck){
		
		ListIterator<ListNode> listIter = wordList.listIterator();
		
		while(listIter.hasNext()){
			
			ListNode curNode = listIter.next();
			
			if(curNode.getWord().equals(wordToCheck) )
				return curNode;
		}
		
		return null;
	}
	
	
	
	/** 
	 * Generate the number of words requested.
	 */
	@Override
	public String generateText(int numWords) {
	    // TODO: Implement this method
		return null;
	}
	
	
	// Can be helpful for debugging
	@Override
	public String toString()
	{
		String toReturn = "";
		for (ListNode n : wordList)
		{
			toReturn += n.toString();
		}
		return toReturn;
	}
	
	/** Retrain the generator from scratch on the source text */
	@Override
	public void retrain(String sourceText)
	{
		// TODO: Implement this method.
	}
	
	// TODO: Add any private helper methods you need here.
	
	
	/**
	 * This is a minimal set of tests.  Note that it can be difficult
	 * to test methods/classes with randomized behavior.   
	 * @param args
	 */
	public static void main(String[] args)
	{
		/////////////my testing///////////////
		MarkovTextGeneratorLoL myGen = new MarkovTextGeneratorLoL();
		myGen.train("hi there");
		System.out.println(myGen);
		System.out.println();
		
		MarkovTextGeneratorLoL myGen2 = new MarkovTextGeneratorLoL();
		myGen2.train("hi there hi Leo Leo");
		System.out.println(myGen2);
		
		/////////////my testing///////////////
		
		
		/*// feed the generator a fixed random value for repeatable behavior
		MarkovTextGeneratorLoL gen = new MarkovTextGeneratorLoL(new Random(42));
		String textString = "Hello.  Hello there.  This is a test.  Hello there.  Hello Bob.  Test again.";
		System.out.println(textString);
		gen.train(textString);
		System.out.println(gen);
		System.out.println(gen.generateText(20));
		String textString2 = "You say yes, I say no, "+
				"You say stop, and I say go, go, go, "+
				"Oh no. You say goodbye and I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello. "+
				"I say high, you say low, "+
				"You say why, and I say I don't know. "+
				"Oh no. "+
				"You say goodbye and I say hello, hello, hello. "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello. "+
				"Why, why, why, why, why, why, "+
				"Do you say goodbye. "+
				"Oh no. "+
				"You say goodbye and I say hello, hello, hello. "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello. "+
				"You say yes, I say no, "+
				"You say stop and I say go, go, go. "+
				"Oh, oh no. "+
				"You say goodbye and I say hello, hello, hello. "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello, hello, hello,";
		System.out.println(textString2);
		gen.retrain(textString2);
		System.out.println(gen);
		System.out.println(gen.generateText(20));*/
	}

}

/** Links a word to the next words in the list 
 * You should use this class in your implementation. */
class ListNode
{
    // The word that is linking to the next words
	private String word;
	
	// The next words that could follow it
	private List<String> nextWords;
	
	ListNode(String word)
	{
		this.word = word;
		nextWords = new LinkedList<String>();
	}
	
	public String getWord()
	{
		return word;
	}

	public void addNextWord(String nextWord)
	{
		nextWords.add(nextWord);
	}
	
	public String getRandomNextWord(Random generator)
	{
		// TODO: Implement this method
	    // The random number generator should be passed from 
	    // the MarkovTextGeneratorLoL class
	    return null;
	}
	
	public String getFirstNextWord()
	{
	    return nextWords.get(0);
	}

	public String toString()
	{
		String toReturn = word + ": ";
		for (String s : nextWords) {
			toReturn += s + "->";
		}
		toReturn += "\n";
		return toReturn;
	}
}


