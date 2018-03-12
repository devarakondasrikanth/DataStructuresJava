package com.srikanth.binary.searchtree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinarySearchTree {
	
	public static TreeNode addNode(TreeNode root,int data){
		TreeNode temp = root;
		if(root == null){
			return new TreeNode(data);
		}
		
		if(data<=root.data ){
			if(root.left != null)
				addNode(root.left,data);
			else
				root.left = new TreeNode(data);
		}
		
		if(data>root.data ){
			if(root.right != null)
				addNode(root.right,data);
			else
				root.right = new TreeNode(data);
		}		
		return temp;
	}
	
	public static void printNodeInOrder(TreeNode root){
		if(root ==null){
			System.out.println("Tree is empty");
		}
		if(root.left != null){
			printNodeInOrder(root.left);
		}
		System.out.println(root.data);
		if(root.right != null){
			printNodeInOrder(root.right);
		}
	}
	
	public static void printNodePreOrder(TreeNode root){
		if(root == null){
			System.out.println("Tree is empty");
		}
		
		System.out.println(root.data);
		if(root.left != null){
			printNodeInOrder(root.left);
		}
		if(root.right != null){
			printNodeInOrder(root.right);
		}
	}
	
	public static void printNodePostOrder(TreeNode root){
		if(root == null){
			System.out.println("Tree is empty");
		}
		if(root.left != null){
			printNodeInOrder(root.left);
		}
		if(root.right != null){
			printNodeInOrder(root.right);
		}
		System.out.println(root.data);
	}
	
	public static int height(TreeNode root){
		if(root == null){
			return 0;
		}else{
			int lheight = height(root.left);
			int rheight = height(root.right);
			if(lheight>rheight){
				return lheight+1;
			}
			else{
				return rheight+1;
			}
		}
		
		
	}
	
	public static void printNodesBFS(TreeNode root){
		TreeNode temp = root;
		if(temp == null){
			System.out.println("Tree is empty");
		}else{
			
			Queue<TreeNode> queue = new LinkedList<>();
			queue.add(temp);
			while(!queue.isEmpty()){
				TreeNode node = queue.poll();
				System.out.println(node.data);
				if(node.left!= null){
					queue.add(node.left);
				}
				if(node.right!= null){
					queue.add(node.right);
				}
			}
			
		}
	}
	
	public static void printNodesAtLevel(TreeNode root,int level){
		if(root == null){
			System.out.println("Tree is empty");
		}else{
			if(level == 0){
				System.out.println(root.data);
			}
			else{
				if(root.left!= null){
					printNodesAtLevel(root.left,level-1);
				}
				if(root.right!= null){
					printNodesAtLevel(root.right,level-1);
				}
			}
		}
	}
	
	public static int heightOfTree(TreeNode root){
		if(root == null){
			System.out.println("Tree is empty");
		}
		if(root.left==null &&root.right==null ){
			return 1;
		}
			int lheight = heightOfTree(root.left);
			int rheight = heightOfTree(root.right);
			if(lheight>rheight)
				return lheight+1;
			else
				return rheight+1;
		
	}
	
	public static int sumOfNodesAtGivenLevel(TreeNode root,int level){
		List<Integer> arrayList = new ArrayList<>();
		sumofNodesAtLevel(root,level,arrayList);
		if(arrayList.size()<=0){
			return 0;
		}else{
			return arrayList.stream().reduce(0, Integer::sum);
		}
	}
	
	public static void sumofNodesAtLevel(TreeNode root,int level,List<Integer> aList){
		if(level == 0){
			aList.add(root.data);
		}else{
			if(root.left != null){
				sumofNodesAtLevel(root.left,level-1,aList);
			}
			if(root.right != null){
				sumofNodesAtLevel(root.right,level-1,aList);
			}
		}
	}
	
	public static void printSumAtEachlevel(TreeNode root){
		if(root == null){
			System.out.println("Tree is empty");
		}else{
			Queue<TreeNode> queue = new LinkedList<>();
			queue.add(root);
			int level =1;
			while(!queue.isEmpty()){
				int count = queue.size();
				int sum =0;
				while(count-->0){
					TreeNode temp = queue.poll();
					sum = sum+temp.data;
					if(temp.left!=null){
						queue.add(temp.left);
					}
					if(temp.right!=null){
						queue.add(temp.right);
					}
				}
				System.out.println("sum of nodes at level "+(level++)+" is "+sum );
			}
		}
	}
	
	public static boolean isBst(TreeNode root){
		if(root == null)
			return true;
		else{
			List<Integer> lst = new ArrayList<>();
		    inOrder(root,lst);
			if(lst.size()==1)
				return true;
			else{
				for(int i=1;i<lst.size();i++){
					if(lst.get(i-1)>=lst.get(i))
						return false;
				}
				return true;
			}
		}
	}

	public static void inOrder(TreeNode root,List<Integer> lst){
			if(root.left!=null)
			inOrder(root.left,lst);
			lst.add(root.data);
			if(root.right!=null)
			inOrder(root.right,lst);
	}
	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
        return null;
    }
    
    if(root == p || root == q){
        return root;
    }
    
    TreeNode l = lowestCommonAncestor(root.left,p,q);
    TreeNode r = lowestCommonAncestor(root.right,p,q);
    
    if(l != null && r != null){
        return root;
    }
    
    return l != null ? l:r;
    }
}
