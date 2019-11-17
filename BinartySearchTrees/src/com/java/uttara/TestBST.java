package com.java.uttara;

public class TestBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BTree b = new BTree();
		System.out.println("Insertion begins");
		
		
		//insert iteratively
		b.insert(60);
		b.insert(20);
		b.insert(50);
		b.insert(30);
		b.insert(100);
		b.insert(40);
		b.insert(10);
		b.insert(70);
		
		//insert recursively
		/*b.insertRecur(60);
		b.insertRecur(20);
		b.insertRecur(50);
		b.insertRecur(30);
		b.insertRecur(100);
		b.insertRecur(40);
		b.insertRecur(10);
		b.insertRecur(70);*/
		
		System.out.println("Insertion ends");
		
		System.out.println("Traversing output-");
		b.inOrderTrav();
		
		int minimum =b.min();
		System.out.println("Minimum value of BSTree ="+minimum);
		
		int maximum = b.max();
		System.out.println("Maximum value of BSTree ="+maximum);
	}

}
