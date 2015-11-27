package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
public MyLinkedList() {
		
		head = new LLNode<E>();
		tail = new LLNode<E>();
		head.next = tail;
		tail.prev = head;
		size = 0;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		
		add(size(), element );
		/*// TODO: Implement this method
		
		LLNode <E> elementsNode = new LLNode<E>(element);
		LLNode <E> lastButOne = tail.prev;
		
		elementsNode.next = tail;
		tail.prev = elementsNode;
		
		lastButOne.next = elementsNode;
		elementsNode.prev = lastButOne;
		
		// return true if  Returns true if this collection changed as a result of the call. (Returns false 
		//if this collection does not permit duplicates and already contains the specified element.)
		size++;*/
		
		return true;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) throws IndexOutOfBoundsException
	{
		if (index < 0 )
			throw new IndexOutOfBoundsException("Index cannot be smaller than zero");	
		
		if (isEmpty())
			throw new IndexOutOfBoundsException("The list is empty");
		
		if (index >= size() )
			throw new IndexOutOfBoundsException("Index must be smaller than the size of the list");	
			
		LLNode<E> currentNode = head.next;	
		int counter = 0; 
		
		while (counter < index){ 
			
			LLNode<E> temp = null;
			temp = currentNode.next;
			currentNode = temp;
			counter++;			
		}
		
		return currentNode.data ;
	}
	
	public boolean isEmpty(){
		
		if (head.next == tail && tail.prev == head)
			return true;
		else
			return false;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// TODO: Implement this method
		if (index < 0 )
			throw new IndexOutOfBoundsException("Index cannot be smaller than zero");	
		
		if (index  > size() )
			throw new IndexOutOfBoundsException("Index must be smaller than the size of the list");
			
		LLNode<E> currentNode = head.next;	
		int counter = 0; 
		
		//the loops 'walks' to the node specified by the index
		while (counter < index){ 
			
			LLNode<E> temp = null;
			temp = currentNode.next;
			currentNode = temp;
			counter++;			
		}
		
		//do the insertion on currentNode
		LLNode<E> prevNode = currentNode.prev;
		LLNode<E> elementsNode = new LLNode<E>(element);
		
		prevNode.next = elementsNode;
		elementsNode.prev = prevNode;
		
		elementsNode.next = currentNode;
		currentNode.prev = elementsNode;
		
		// return true if  Returns true if this collection changed as a result of the call. (Returns false 
		//if this collection does not permit duplicates and already contains the specified element.)
		size++;
	}


	/** Return the size of the list 
	 *  @returnthe number of elements in this collection
	 *  */
	/* Returns the number of elements in this collection. 
	 * If this collection contains more than Integer.MAX_VALUE elements, returns Integer.MAX_VALUE.
	 * @Override
	 */
	public int size() 
	{
		return Math.min(size, Integer.MAX_VALUE);             //-1;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		// TODO: Implement this method
		return null;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		// TODO: Implement this method
		return null;
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}
	
	//my constructor
		public LLNode() 
		{
			this(null);
		}

}