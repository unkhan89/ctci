import dataStructures.*;
import util.*;

public class TestDataStructure {
    
    public static void main(String[] args) {
    	
//    	TreeNode<Character> tree = new TreeNode<>('A');
//    	tree.addChild('B');
//    	tree.addChild('C');
//    	tree.addChild('D');
//    	
//    	tree.getChild(0).addChild('E');
//    	tree.getChild(1).addChild('F');
//    	
//    	
//    	System.out.println("Tree: " + tree.toString());
    	
    	BinaryNode binTree = new BinaryNode(5);
    	binTree.setRight(new BinaryNode(7));
    	binTree.setLeft(new BinaryNode(2));
    	binTree.getLeft().setLeft(new BinaryNode(3));
    	binTree.getLeft().getLeft().setRight(new BinaryNode(-1));

    	System.out.println(BinaryNode.getHeight(binTree));
    	System.out.println(BinaryNode.getDepth(binTree));
    	
//    	log(Util.binaryTreeToString(binTree));
    	
    	
//    	ArrayList list = new ArrayList();    	
//    	list.add(3);
//    	list.add(5);
//    	list.add(6);
//    	list.add(1);
//    	log("List has " + list.size() + " elements: " + list.toString());
//    	list.set(1, 10);
//    	log("List has " + list.size() + " elements: " + list.toString());    	
//    	list.remove(2);    	 
//    	log("List has " + list.size() + " elements: " + list.toString());    	
//    	log("Index of 1 is " + list.indexOf(1));    	
//    	log("Index of 99 is " + list.indexOf(99));    	
//    	
    	
//    	SinglyLinkedList list = new SinglyLinkedList(2);   	
//    	list.add(54);
//    	list.add(4);
//    	list.add(521);
//      log(list.toString());       
//      log("" + list.get(4));
    
    }
    
    private static void log(String msg) {
    	
    	System.out.println("[TestDataStructure] " + msg);
    }
}