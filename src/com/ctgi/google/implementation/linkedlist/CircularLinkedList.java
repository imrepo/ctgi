/**
 * 
 */
package com.ctgi.google.implementation.linkedlist;


/**
 * @author Dany
 *
 *
 *WARNING - CHANGES REQUIRED
 */
public class CircularLinkedList {

	class Node{
		int key;
		int value;
		Node next;
		Node prev;
		public Node(int key, int value, Node next, Node prev)
		{
			this.key=key;
			this.value=value;
			this.next=next;
			this.prev=prev;
		}
	}
	Node first;
	int N;

	public void insert(int key, int value)
	{
		for(Node x=first;x!=null;x=x.next)
		{
			if(x.key==key)
				x.value=value;
		}
		first=new Node(key, value, first, null);
		if(first.next==null)
		{
			first.prev=first;
			first.next=first;
		}
		if(first.next!=null)
		{
			first.next.prev=first;
		}
	}

	public int remove(int key)
	{
		int value=-1;
		if(first.key==key)
		{
			value=first.value;
			if(first.next==null)
			{
				first=null;
			}else
			{
				first.key=first.next.key;
				first.value=first.next.value;
				first.next=first.next.next;
				first.prev=null;
			}
			return value;
		}

		for(Node x=first;x.next!=null;x=x.next)
		{
			if(x.key==key)
			{
				if(x.next.next==null)
				{
					value = x.next.value;
					x.next = null;
					N--;
					return value;
				}else
				{
					value=x.value;
					x.key=x.next.key;
					x.value=x.next.value;
					x.next=x.next.next;
					N--;
					return value;
				}
			}
		}
		return value;
	}

	public int lookUp(int key)
	{
		int value = -1;
		for(Node x=first;x!=null;x=x.next)
		{
			if(x.key==key)
			{
				value=x.value;
			}
		}
		return value;
	}

	public int size()
	{
		return N;
	}

	public void printList()
	{
		System.out.print("[");
		for(Node x=first;x!=null;x=x.next)
		{
			System.out.print(x.value);
			if(x.next!=null)
				System.out.print(",");
		}
		System.out.print("]\n");
	}

	public void reverse()
	{
		Node current = first;
		Node reversedPart=null;
		Node next;
		while(current!=null)
		{
			next=current.next;
			current.next=reversedPart;
			reversedPart=current;
			current=next;
		}
		first=reversedPart;
	}	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
