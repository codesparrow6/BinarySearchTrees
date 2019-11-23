package com.java.uttara;

public class TestBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BSTree b = new BSTree();
		System.out.println("Insertion begins");
		
		
		//insert iteratively
		b.insert(60);
		b.insert(20);
		b.insert(50);
		b.insert(30);
		b.insert(100);
		b.insert(100);
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
		
		int rootInfo = b.getRoot();
		System.out.println("Root="+rootInfo);
		
		System.out.println("Traversing output-");
		b.inOrderTrav();
		
		int minimum =b.min();
		int maximum = b.max();
		
		//Recursive approach
		//int minimum =b.minRec();
		//int maximum = b.maxRec();
		System.out.println("Minimum value of BSTree ="+minimum);
		System.out.println("Maximum value of BSTree ="+maximum);
		
		BSTNode temp = b.delete(60);
		
		System.out.println("Traversing output after deletion-");
		b.inOrderTrav();
		
		int newRoot = b.getRoot();
		System.out.println("New root="+newRoot);
		
		//Check for the given data in BST
		boolean check1 = b.checkBST(50);
		boolean check2 = b.checkBST(60);
		System.out.println("Check1="+check1);
		System.out.println("Check2="+check2);
		
		
		//Check whether given BT is BST or Not.
		boolean isBST = b.isBST();
		System.out.println("IsBST="+isBST);
		
		
		
		
		
		
	}

}
