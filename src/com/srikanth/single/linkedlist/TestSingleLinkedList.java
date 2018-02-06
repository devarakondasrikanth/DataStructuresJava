package com.srikanth.single.linkedlist;

public class TestSingleLinkedList {

	public static void main(String[] args) {
		
		Node head = SingleLinkedList.add(10,null);
		head = SingleLinkedList.add(20,head);
		head = SingleLinkedList.add(30,head);
		head = SingleLinkedList.add(40,head);
		head = SingleLinkedList.add(50,head);
		head = SingleLinkedList.add(60,head);
		head = SingleLinkedList.add(70,head);
		head = SingleLinkedList.add(80,head);
		head = SingleLinkedList.add(90,head);
		head = SingleLinkedList.add(100,head);
		head = SingleLinkedList.add(110,head);
		head = SingleLinkedList.add(120,head);
		head = SingleLinkedList.add(130,head);
		head = SingleLinkedList.add(140,head);
		//printing values in single linked list
		//SingleLinkedList.printNodes(head);
		
		System.out.println("Number of Nodes in list--->"+SingleLinkedList.countNodes(head));
		
		System.out.println("Node containg the value 38 exists in the list--->"+SingleLinkedList.find(38, head));
		
		head = SingleLinkedList.swapFirstTwoNodes(head);
		
		//SingleLinkedList.printNodes(head);
		
		head = SingleLinkedList.swapFirstTwoNodes(head);
		
		SingleLinkedList.printMiddleNodeValue(head);
		
		SingleLinkedList.printNthNodeFromLast(head, 4);
		
		head = SingleLinkedList.reverseSingleLinkedList(head);
		
		SingleLinkedList.printNodes(head);
		
		head = SingleLinkedList.reverseSingleLinkedList(head);
		
		SingleLinkedList.printNodes(head);
		
		head = SingleLinkedList.chunckNodeReverse(head, 3);
		
		System.out.println("*****************************");
		
		SingleLinkedList.printNodes(head);
		
		head = SingleLinkedList.chunkRev(head, 3);
		
		System.out.println("*****************************");
		
		SingleLinkedList.printNodes(head);
	}

}
