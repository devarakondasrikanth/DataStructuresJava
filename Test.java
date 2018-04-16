Trees
Traversal
BFs
DFS
Height of the tree
isBalanced or Not
Each Level Sum
Max at level in Tree
Number of Nodes at each level in Binary
isMirror
isBST --- using stack
closetValue in BST
Lowest Common Ancestor in BST and Binary Tree
Binary Tree Maximum Path Sum
Minimum Distance Between BST Nodes

1)LRU Cache
2)Longest Common Subsequence
3)Longest Sub-Sequence without repeating characters
4)Palindrome
5)Longest Palindrome Sub-Sequence
6)Permutations
7)Minimum window sub-strings
8)Palindrome Partioning
9)Anagrams and Group Anagrams
10)First Unique Character in String
11)Contains-Duplicates
12)Valid Palindrome
13)Top K frequent Elements
14)Longest Common Prefix
15)Longest Palindrome String
https://algorithms.tutorialhorizon.com/category/top-companies/microsoft-interview/
Arrays and Maths
1)Smallest Difference Between two arrays
2)Contigouso  Sequnce with Largest Sum
3) Sum Swap 
4)Pair with sums
5)Missing Number in Array
6) Find Duplicates in a Array
7)write a method to count number of 2's between 0 and N
8)Continuous Median
9)Merge Sort
10)Quick Sort
11)Selection Sort
12)Bubble Sort
13)Fabonnaci
14)Stair Case
15)Contains Duplicates
16)MaxProduct Sub Array
17)Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
18)Prime Number
19)Palindrome Number
20)coin change
21)Count all possible paths from top left to bottom right of a mXn matrix
22)Longest Increasing Subsequence
23)

public int count(int [][] arrA, int row, int col){
    //base case
    //check if last row OR column is reached since after that only one path
    //is possible to reach to the bottom right corner.
    if(row==arrA.length-1 || col==arrA.length-1){
        return 1;
    }
    return count(arrA, row+1, col) + count(arrA, row, col+1);
}

public int countDP(int [][] arrA){
    int result [][] = new int[arrA.length][arrA.length];

    //base case: if we have one cell then there is only one way
    result[0][0] = 1;

    //no of paths to reach in any cell in first row = 1
    for (int i = 0; i <result.length ; i++) {
        result[0][i] = 1;
    }

    //no of paths to reach in any cell in first col = 1
    for (int i = 0; i <result.length ; i++) {
        result[i][0] = 1;
    }

    for (int i = 1; i <result.length ; i++) {
        for (int j = 1; j <result.length ; j++) {
            result[i][j] = result[i-1][j] + result[i][j-1];
        }
    }

    return result[arrA.length-1][arrA.length-1];
}

static long countWays(int S[], int m, int n)
{
    //Time complexity of this function: O(mn)
    //Space Complexity of this function: O(n)

    // table[i] will be storing the number of solutions
    // for value i. We need n+1 rows as the table is
    // constructed in bottom up manner using the base
    // case (n = 0)
    long[] table = new long[n+1];

    // Initialize all table values as 0
    Arrays.fill(table, 0);   //O(n)

    // Base case (If given value is 0)
    table[0] = 1;

    // Pick all coins one by one and update the table[]
    // values after the index greater than or equal to
    // the value of the picked coin
    for (int i=0; i<m; i++)
        for (int j=S[i]; j<=n; j++)
            table[j] += table[j-S[i]];

    return table[n];
}


int lcs( char[] X, char[] Y, int m, int n )
{
  int L[][] = new int[m+1][n+1];

  /* Following steps build L[m+1][n+1] in bottom up fashion. Note
       that L[i][j] contains length of LCS of X[0..i-1] and Y[0..j-1] */
  for (int i=0; i<=m; i++)
  {
    for (int j=0; j<=n; j++)
    {
      if (i == 0 || j == 0)
          L[i][j] = 0;
      else if (X[i-1] == Y[j-1])
          L[i][j] = L[i-1][j-1] + 1;
      else
          L[i][j] = max(L[i-1][j], L[i][j-1]);
    }
  }
return L[m][n];
}

/* Utility function to get max of 2 integers */
int max(int a, int b)
{
  return (a > b)? a : b;
}


int countWays(int[] coins,int amount){
	int[] ways = new int[amount+1];
		ways[0]  = 1;
	for(int coin:coins){
		for(int i=1;i<ways.length;i++){
			if(i>=coin){
				ways[i]+ = ways[i-coin]; 
			}
		}
	}
	return ways[amount];
}

public int[] mergeSort(int[] arr){
	if(arr==null){
		return arr;
	}else if(arr.length==1){
		return arr;
	}else{
		int midPoint = arr.length/2;
		int[] left = new int[midPoint];
		int[] right = new int[arr.length-midPoint];
		for(int i=0;i<left.length;i++){
			left[i] = arr[i];
		}
		for(int j=0;j<right.length;j++){
			right[j] = arr[j+midPoint];
		}
		left = mergeSort(left);
		right = mergeSort(right);
		return merge(left,right);
	}
}

private int[] merge(int[] left,int[] right){
	int lIndex = 0;
	int rIndex =0;
	int[] result = new int[left.length+right.length];
	int i=0;
	while(lIndex<left.length&&rIndex<right.length){
		if(left[lIndex]<right[rIndex]){
			result[i++] = left[lIndex++];
		}else{
			result[i++] = right[rIndex++];
		}
	}
	while(lIndex<left.length){
		result[i++] = left[lIndex++];
	}
	while(rIndex<right.length){
		result[i++] = right[rIndex++];
	}
	return result;
}

public int[] QucikSort(int[] arr){
	if(arr==null){
		return arr;
	}else if(arr.length==1){
		return arr;
	}else{
		qs(arr,0,arr.length-1);
		return arr;
	}
}

private void qs(int[] arr,int left,int right){
	int i = left;
	int j = right;
	int pivotal = arr[left+(right-left)/2];
	while(i<=j){
		while(arr[i]<pivotal){
			i++;
		}
		while(arr[j]>pivotal){
			j--;
		}
		if(i<=j){
			int t = arr[i];
			arr[i] = arr[j];
			arr[j] = t;
			i++;
			j--;
		}
	}
	 if(i<right)
		 qs(arr,i,right);
	 if(left<j)
		 qs(arr,left,j);
}

public arr[] bubbleSort(int[] arr){
	for(int i=0;i<arr.lengthi++){
		for(int j = 1;j<arr.length-i;j++){
			if(arr[j-1]>arr[j]){
				int t = arr[j-1];
				arr[j-1] = arr[j];
				arr[j] = t;
			}
		}
	}
	return arr;
}

public int maxSumInArray(int[] arr){
	if(arr==null){
		return 0;
	}else if(arr.length==1){
		return arr[0];
	}else{
		int curr_max = 0;
		int max_so_far = Integer.MIN_VALUE;
		for(int i=0;i<arr.length;i++){
			curr_max = Math.max(arr[i]+curr_max,a[i]);
			max_so_far Math.max(max_so_far,curr_max);
		}
		return max_so_far;
	}
}

public int maxSumArray(int[] arr){
	int curr_max = 0;
	int max_so_far = Integer.MIN_VALUE;
	for(int i:arr){
		curr_max = Math.max(curr_max+i,i);
		max_so_far = Math.max(curr_max,max_so_far);
	}
	return max_so_far;
}

public int maxProductSubArray(int[] arr){
	int max = min = arr[0];
	int res = Integer.MIN_VALUE;
	for(int i=1;i<arr.length;i++){
		if(arr[i]>0){
			max = Math.max(max*arr[i],arr[i]);
			min = Math.min(min*arr[i],arr[i]);
		}else{
			int lastMax = max;
			max = Math.max(min*arr[i],arr[i]);
			min = Math.min(lastMax*arr[i],arr[i]);
		}
		res = Math.max(res,max);
	}
}

public int longestConsecutiveElements(int[] arr){
	if(arr==null){
		return 0;
	}else if(arr.length==0){
		return 0;
	}else if(arr.length==1){
		return 1;
	}else{
		int max = 1;
		set<Integer> set = new HashSet<>();
		for(int e:arr){
			set.add(e);
		}
		for(int i:arr){
			int left = i-1;
			int right = i+1;
			int count = 1;
			while(set.contains(left)){
				count++;
				set.remove(left);
				left--;
			}
			while(set.contains(right)){
				count++;
				set.remove(right);
				right++;
			}
			max = Math.max(count,max);
		}
		return max;
	}
}

public int countWyas(int[] coins,int amount){
	int[] ways = new int[amount+1];
	ways[0] = 1;
	for(int coin:coins){
		for(int i=1;i<ways.length;i++){
			if(i>=coin){
				ways[i]+=ways[i-coin];
			}
		}
	}
	return ways[amount];
}

public boolean isPalindromeNumber(int in){
	String str = String.valueOf(in);
	StringBuffer sb = new StringBuffer(str);
	str = sb.reverse();
	return in==Integer.parseInt(str);
}
public  boolean isPalindrome(int n){
	if(n>-10&&n<10)
		return true;
	else{
		int temp = n;
		int rev =0;
		while(temp>0){
			rev = rev*10+temp%10;
			temp = temp/10;
		}
		return n==rev;
	}	
}
public boolean primeNumber(int n){
	if(n<1){
		return false;
	}else if(n==2){
		return true;
	}else{
		boolean ret = true;
		for(int i=2;i<Math.sqrt(n);i++){
			if(n%i==0){
				ret = false;
				break;
			}
		}
		return ret;
	}
}


Trees
Traversal
public void inOrder(TreeNode root){
	if(root==null){
		System.out.println("Tree is empty");
	}else{
		if(root.left!=null){
			inOrder(root.left);
		}
		System.out.println(root.val);
		if(root.right!=null){
			inOrder(root.right);
		}
	}
}
public void preOrder(TreeNode root){
	if(root==null){
		System.out.println("Tree is empty");
	}else{
		System.out.println(root.val);
		if(root.left!=null){
			preOrder(root.left);
		}
		if(root.right!=null){
			preOrder(root.right);
		}
	}
}
public void postOrder(TreeNode root){
	if(root==null){
		System.out.prtinln("Tree is empty");
	}else{
		if(root.left!=null){
			postOrder(root.left);
		}
		if(root.right!=null){
			postOrder(root.right);
		}
		System.out.println(root.val);
	}
}
BFS
public void BFS(TreeNode root){
	if(root==null){
		System.out.println("Tree is empty");
	}else{
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		while(!q.isEmpty()){
		TreeNode temp = q.poll();
		System.out.print(temp.data);
			if(temp.left!=null)
				q.add(temp.left);
			if(temp.right!=null)
				q.add(temp.right);
		}
	}
}
DFS
public void DFS(TreeNode root){
	if(root==null){
		System.out.println("Tree is empty")
	}else{
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while(!stack.isEmpty()){
			TreeNode temp = stack.pop();
			System.out.println(temp.val);
			if(temp.left!=null){
				stack.push(temp.left);
			}
			if(temp.right!=null){
				stack.push(temp.right);
			}
		}
	}
}
Height of the tree
public int heightOfTree(TreeNode root){
	if(root==null){
		return 0;
	}else{
		int l = heightOfTree(root.left);
		int r = heightOfTree(root.right);
		return Math.max(l,r)+1;
	}
}
isBalanced or Not
public boolean isBalanced(TreeNode root){
	if(root==null){
		return true;
	}else{
		int l = heightOfTree(root.left);
		int r = heightOfTree(root.right);
		return Math.abs(l-r)<=1?true:false;
	}
}
Each Level Sum
public void printSumAtLevel(TreeNode root){
	if(root==null){
		System.out.println("Tree is empty");
	}else{
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		while(!q.isEmpty()){
			int size = q.size();
			int sum = 0;
			while(size-->0){
				TreeNode temp = q.poll();
				sum += temp.val;
				if(temp.left!=null){
					q.add(temp.left);
				}
				if(temp.right!=null){
					q.add(temp.right);
				}
			}
			System.out.println(sum);
		}
	}
}
Max at level in Tree
public void maxAtLevel(TreeNode root){
	if(root == null){
		System.out.println("tree is empty");
	}else{
		Queue<TreeNode> queue = new LinkedList<>();
		int max = Integer.MIN_VALUE;
		queue.add(root);
		while(!queue.isEmpty()){
			int size = queue.size();
			int sum = 0;
			while(size-->0){
				TreeNode temp = queue.poll();
				sum += temp.val;
				if(temp.left!=null){
					queue.add(temp.left);
				}
				if(temp.right!=null){
					queue.add(temp.right);
				}
			}
			max = Math.max(max,sum);
		}
		return max;
	}
}
Number of Nodes at each level in BinaryTree

isMirror
public boolean isMirror(TreeNode root){
	if(root == null){
		return true;
	}else{
		return isMirror(root,root);
	}
}

private boolean isMirror(TreeNode leftRoot,TreeNode rightRoot){
	if(leftRoot==null&&rightRoot==null){
		return true;
	}
	if(leftRoot.val!=rightRoot.val){
		return false;
	}else{
		if(leftRoot!=null && rightRoot!=null&&leftRoot.val==rightRoot.val){
			return isMirror(leftRoot.left,rightRoot.right)&&isMirror(leftRoot.right,rightRoot.left);
		}
		return false;
	}
}
isBST --- using stack
public boolean isBST(TreeNode root){
	  if (root == null) return true;
   Stack<TreeNode> stack = new Stack<>();
   TreeNode pre = null;
   while (root != null || !stack.isEmpty()) {
      while (root != null) {
         stack.push(root);
         root = root.left;
      }
      root = stack.pop();
      if(pre != null && root.val <= pre.val) return false;
      pre = root;
      root = root.right;
   }
   return true;
    }
}

closetValue in BST
public int closeValue(TreeNode root,int target){
	if(root==null||null==target){
		return 0;
	}else{
		int returnVal = root.val;
		TreeNode temp = root;
		while(temp!=null){
			if(Math.abs(target-temp.val)<Math.abs(target-returnVal)){
				returnVal = temp.val;
			}
			temp = target>temp.Val?temp.right:temp.left;
		}
		return returnVal;
	}
}

Lowest Common Ancestor in BST and Binary Tree
public TreeNode LCABST(TreeNode root,TreeNode p,TreeNode q){
	if(root==null){
		return root;
	}else{
		if(p.val>root.val&&q.val>root.val){
			return LCABST(root.right);
		}else if(p.val<root.val&&q.val<root.val){
			return LCABST(root.left);
		}else{
			return root;
		}
	}
}

public TreeNode LCABT(TreeNode root,TreeNode p,TreeNode q){
	if(root==null){
		return root;
	}else if(p==root||q==root){
		return root;
	}else{
		TreeNode left = LCABT(root.left,p,q);
		TreeNode right = LCABT(root.right,p,q);
		
		if(left!=null&&right!=null){
			return root;
		}
		
		return left!=null?left:right;
	}
}

Binary Tree Maximum Path Sum
Class BTUtility{
	private int max = Integer.MIN_VALUE;
	public int maxPathSum(TreeNode root){
		if(root ==null){
			return 0;
		}else{
			maxPath(root);
			return max;
		}
	}
	
	public int maxPath(TreeNode root){
		int left = Math.max(0,maxPath(root.left));
		int right = Math.max(0,maxPath(root.right));
		max = Math.max(max,left+right+root.val);
		return Math.max(left,right)+root.val;
	}
}

Minimum Difference Between BST Nodes

Class BUtility{
	private int min = Integer.MAX_VALUE;
	private TreeNode prev=null;
	public int minDiffInBST(TreeNode root){
		if(root == null){
			return -1;
		}else{
			inOrder(root);
			return min;
		}
	}
	private void inOrder(TreeNode root){
		if(root.left!=null){
			inOrder(root.left);
		}
		if(prev!=null){
			min = Math.min(min,Math.abs(prev.data-root.data));
		}
		prev = root;
		if(root.right!=null){
			inOrder(root.right);
		}
	}
}

Implementing Stack and Queue using LInked List
LRU 

Implementing Stack and Queue using LInked List
LRU 
Class LRUCache{
	private int capacity;
	private Map<Integer,Object> map;
	public LRUCache(int cap){
		this.capacity = cap;
		map = new LinkedHashMap<>(cap,0.75f,true){
			protected boolean removeOldestEntry(Map.Entry entry){
				return size()>cap;
			}
		};
	}
	
	public void put(Integer key,Object obj){
		this.map.put(key,obj);
	}
	
	public Object get(Integer key){
		this.map.getoRDefault(key,-1);
	}
	
}
Linked List
Middle Node
Delete End Node
Reverse
Check Reverse
Longest Common Sub-Sequence


public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int a = countNodes(headA);
        int b = countNodes(headB);
        ListNode c = headA;
        ListNode d = headB;
        if(a>b){
            int diff1 = a-b;
            while(diff1>0){
                c = c.next;
                diff1--;
            }
        }else if(b>a){
            int diff2 = b-a;
            while(diff2>0){
                d = d.next;
                diff2--;
            }
        }
        while(c!=null&&d!=null){
            if(c==d){
                return c;
            }
            c = c.next;
            d = d.next;
        }
        return null;
    }
    
    public int countNodes(ListNode head){
        ListNode temp = head;
        int count =0;
        while(temp!=null){
            count++;
            temp = temp.next;
        }
        return count;
    }
    
public int LongestCommonSubSequence(String s1,String s2){
	if(s1==null||s2==null){
		return 1;
	}else{
		return lcs(s1,s2,s1.length()-1,s2.length()-1);
	}
}

public int lcs(String s1,String s2,int m,int n){
	if(s1.charAt(m)==s2.CharAt(n)){
		return 1+lcs(s1,s2,m-1,n-1);
	}else{
		return Math.max(lcs(s1,s2,m,n-1),lcs(s1,s2,m-1,n));
}

public int longestSubSequence(String s){
	if(s==null){
		return -1;
	}else{
		Set<Character> set = new HashSet<>();
		int i=0j=0;
		int max = Integer.MIN_VALUE;
		while(j<s.length()){
			if(!set.contains(s.charAt(j))){
				set.add(s.charAt(j++));
				max = Math.max(max,j-i);
			}else{
				set.remove(s.charAt(i++));
			}
		}
		return max;
	}
}
public boolean Anagrams(String s1,String s2){
	if(s1==null||s2==null){
		return fasle;
	}
	if(s1.length()!=s2.length()){
		return false;
	}
	char[] c1 = s1.toCharArray();
	char[] c2 = s2.toCharArray();
	Arrays.sort(c1);
	Arrays.sort(c2);
	return Arrays.equals(c1,c2);
}

public int uniquieCharacterInString(String str){
	int[] freq = new int[26];
	for(int i=0;i<str.length();i++){
		freq[str.charAt(i)-'a'] ++;
	for(int i=0;i<str.length();i++){
		if(freq[str.charAt(i)-'a']==1)
			return i;
	}
	return -1;
}

public boolean stringContainsDuplicates(String str){
	int[] freq = new int[26];
	for(int i=0;i<str.length();i++)
		freq[str.charAt(i)-'a']++;
	for(int i=0;i<str.length();i++){
		if(freq[str.charAt(i)-'a']>1)
			return true;
	}
	return false;
}

public void BFS(TreeNode root){
	if(root == null){
		System.out.prtinln("Tree is Empty");
	}else{
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		while(!q.isEmpty()){
			TreeNode temp = q.poll();
			System.out.prtinln(temp.data);
			if(temp.left!=null){
				q.add(temp.left);
			}
			if(temp.right!=null){
				q.add(temp.right);
			}
		}
	}
}
public String longestPalindromicSequence(String str){
	if(str==null){
		return str;
	}else{
		int curr_len =0;
		int start = -1;
		char[] c = str.toCharArray();
		for(int i=0;i<c.length;i++){
			if(isPalindrome(arr,i-curr_len-1,i)){
				start = i-curr_len-1;
				curr_len +=2;
			}else if(isPalindrome(arr,i-curr_len,i))
				start = i-curr_len;
				curr_len +=1;
		}
		return new String(c,start,curr_len);
	}
}
private boolean isPalindrome(Char[] c,int i,int j){
	if(i<0){
		return false;
	}else{
		boolean ret = true;
		while(i<j){
			if(c[i]!=c[j]){
				ret = false;
				break;
			}
			i++;
			j--;
		}
		return ret;
	}
}


public boolean isPalindrome(String str){
	if(str==null){
		return false;
	}else{
		int i=0;
		int j = str.length()-1;
		boolean ret = true;
		while(i<j){
			if(str.charAt(i++)!=Str.charAt(j--)){
				ret = false;
				break;
			}
		}
		return ret;
	}
}

