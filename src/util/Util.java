
package util;

import dataStructures.*;
import java.util.ArrayList;

public class Util {
    
	public static int factorial(int n) {
		
		if(n == 1) return 1;
		
		return n * factorial(n-1);
	}
	
	
    private static void log(String msg) {

        System.out.println("[DEBUG] " + msg);
    }
    
    public static String arrayToString(int[] nums) {
    	
    	String ret = "";
    	
    	for(int i = 0; i < nums.length; i++) {
    		
    		if(i == 0) {
    			
    			ret += "[" + nums[i] + ", ";
    		
    		} else if(i != nums.length - 1) {
    			
    			ret += nums[i] + ", ";
    		
    		} else {
    			
    			ret += nums[i] + "]";
    		}    		
    	}
    	
    	return ret;
    }
    
    public static String binaryTreeToString(BinaryNode root) {
    	
    	ArrayList<String> nodeValuesPerLevel = new ArrayList<String>();
    	
    	ArrayList<BinaryNode> nodesInNextLevel = new ArrayList<BinaryNode>();
    	
    	nodeValuesPerLevel.add("_" + root.getValue() + "{Null}" + "_");
    	
    	root.getLeft().setParentRelation("{L" + root.getValue() + "}");
    	
    	nodesInNextLevel.add(root.getLeft());
    	
    	root.getRight().setParentRelation("{R" + root.getValue() + "}");
    	
    	nodesInNextLevel.add(root.getRight());
    	
    	while(nodesInNextLevel.size() > 0) {
    		
    		ArrayList<BinaryNode> nodesInNextLevelTemp = new ArrayList<BinaryNode>();
    		
    		String thisLevel = "";
    		
    		for(BinaryNode n : nodesInNextLevel) {
    			
    			if(n != null) {
    				
	    			thisLevel += "_" + n.getValue() + n.getParentRelation();
	    			
	    			if(n.hasLeft()) {
	    				
	    				n.getLeft().setParentRelation("{L" + n.getValue() + "}");
		    			
		    			nodesInNextLevelTemp.add(n.getLeft());	    			
	    			}
	    			
	    			if(n.hasRight()) {

		    			n.getRight().setParentRelation("{R" + n.getValue() + "}");
		    			
		    			nodesInNextLevelTemp.add(n.getRight());
	    			}	    			
    			}
    		}
    		
    		nodeValuesPerLevel.add(thisLevel);
    		
    		nodesInNextLevel = nodesInNextLevelTemp;
    	}
    	
    	StringBuffer ret = new StringBuffer("\n");
    	
    	for(int i = 0; i < nodeValuesPerLevel.size(); i++) {
    		
    		ret.append("L" + i + " ->");
    		
    		String padding = getLevelPadding(i, nodeValuesPerLevel.size());
    		
    		String thisLevel = nodeValuesPerLevel.get(i).replace("_", padding);
    		
    		ret.append(thisLevel + "\n");
    	}
    	
    	return ret.toString();
    }
    
    private static String getLevelPadding(int level, int depth) {
    	
    	String padding = "";
    	
    	for(int d = depth; d != level; d--) {
    		
    		padding += " ";
    	}
    	
    	return padding;    	
    }
}

