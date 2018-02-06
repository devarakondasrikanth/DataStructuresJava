
PUT metrics-2017.12/_mapping/log
{
  "teamName": {
            "type": "text",
            "fields": {
              "keyword": {
                "type": "keyword",
                "fielddata": true,
                "ignore_above": 256
              }
            }
          }
}


public static rev numRev(int num)
{
	int rev =0;
	while(num>0){
		rev = rev*10+num%10;
		num = num/10;
	}
	return rev;
}

//Tree is symmentric
public static boolean isSymentric(TreeNode root)
{
	isMirroed(root,root);
}

public static boolean isMirrored(TreeNode root1,TreeNode root2){
	if(root1 == null && root2 == null)
	return true;
	else{
		if(root1!=null &&root2!=null && root1.data==root2.data)
			return (isMirrored(root1.left,root2.right)&&isMirroed(root1.right,root2.left));
	}
	return false;
}

//Tree Traversals
//Inorder LEFT,ROOT,RIGHT
public static void InOrder(TreeNode root){
	if(root == null)
	 LOG.info("Tree is empty")
	else{
		if(root.left!=null)
		     InOrder(root.left);
		LOG.info(root.data);
		if(root.right!=null)
			InOrder(root.right);
	}
}

//height of a tree
public static int heightTree(TreeNode node){
		if(node == null){
			return 0;
		}
		else if(node.left==null&&node.right==null){
				return 1;
		}else{
				int lHeight = heightTree(node.left);
				int rHeight = heightTree(node.right);
				if(lHeight>rHeight){
						return lHeight+1;
				}else{
						return rHeight+1;
				}
		}
}

public static boolean isMirroed(TreeNode leftTree,TreeNode rightTree){
	if(leftTree==null&&rightTree==null){
		return true;
	}else if(leftTree.data!= rightTree.data){
		return false;
	}else if(leftTree = null && rightTree =null && leftTree.data == rightTree.data){
		return (isMirroed(leftTree.left,rightTree.right)&&isMirroed(leftTree.right,rightTree.left));
	}
}

public static void printBFS(TreeNode root){
	if(root == null){
		System.out.println("Tree is empty");
	}else{
			Queue<TreeNode> queue = new LinkedList<TreeNode>();
			queue.add(root);
			while(!queue.isEmpty()){
				TreeNode node = queue.poll();
				System.out.println(node.data);
				if(node.left!=null)
					queue.add(node.left);
				if(node.right!=null)
					queue.add(node.right);
			}
	}
}

public static int maxSum(TreeNode root){
	
	if(root == null){
		return 0;
	}else{
		int result =0;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		result = root.data;
		while(!queue.isEmpty()){
				int count = queue.size();
				int sum = 0;
				while(count--){
					TreeNode temp = queue.poll();
					sum = sum+temp.data;
					if(temp.left!=null)
						queue.add(temp.left);
					if(temp.right!=null)
						queue.add(temp.right);
				}
			result = Math.max(result,sum);
		}
		return result;
	}
}


public void printSumAtEachLevel(TreeNode root){
	if(root == null)
		System.out.println("Tree is Empty");
	else{
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		while(!q.isEmpty()){
			int count = q.size();
			int sum = 0;
			while(count-->0){
				TreeNode temp = q.poll();
				sum = sum+temp.data;
				if(temp.left!=null){
						q.add(temp.left);
				}
				if(temp.right!=null){
					q.add(temp.right);
				}
				
			}
			System.out.println("Sum of all nodes on this level is "+sum);
		}
	}
}

public void printNodesInDFS(TreeNode root){
	if(root == null){
		System.out.println("Tree is empty");
	}else{
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while(!stack.isEmpty()){
			TreeNode temp = stack.pop();
			System.out.println(temp.data);
			if(temp.left!=null){
				stack.push(temp.left);
			}
			if(temp.right!=null){
				stack.push(temp.data);
			}
		}
	}
}

public static int fab(int n){
	if(n==0)
		return 0;
	else if(n==1)
		return 1;
	else 
		return fab(n-1)+fab(n-2);
}

public static void printFab(int n){
	for(int i=1;i<=n;i++)
		System.out.println(fab(i));
}

//check two strings are anagrams are not
public static boolean isAnagarams(String str1,String str2){
	char[] c1 = str1.toCharArray();
	char[] c2 = str2.toCharArray();
	Arrays.sort(c1);
	Arrays.sort(c2);
	return Arrays.equals(c1,c2);
}


public static Node reverseLinkedList(Node head){
	if(node ==  null)
		return head;
	else{
		Node current = head;
		Node previous = null;
		Node next = null;
		while(current != null){
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		return previous;
	}
}

public static Node chunckReverse(Node head,int j) {
	if(node == null){
		return head;
	}else {
		Node current = head;
		Node previous = null;
		Node next = null;
		int count = j;
		while(current != null && count>0) {
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
			count--;
		}
		
		if(next != null){
			head.next = chunckReverse(next,j);
		}
		return previous;
	}
}

public static boolean isMirr(TreeNode root){
	if(root == null)
		return true;
	if(root.left == null && root.right == null)
		return true;
	if(root.left != null && root.right != null)
		isMirrored(root.left,root.right);
	return false;
}

public static boolean isMirrored(TreeNode leftTree,TreeNode rightTree) {	
	if(leftTree !=null && rightTree!=null && leftTree.data== rightTree.data)
		return (isMirroed(leftTree.left,rightTree.right)&&isMirrored(leftTree.right,rightTree.left));
	return false;
}

//Height of a tree
public static int heightOfTree(TreeNode root){
	if(root == null)
		return =0;
	if(root.left == null && root.right==null){
		return 1;
	}
	else{
		int lHeight = heightOfTree(root.left);
		int rHeight = heightOfTree(root.right);
		if(lHeight>rHeight)
			return 1+lHeight;
		else
			return 1+rHeight;
	}
}

//Depth first Search
public static void printNodesInDFS(TreeNode root){
	if(root == null)
		System.out.println("Tree is empty");
	else{
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while(!stack.isEmpty()){
			TreeNode temp = stack.pop();
			System.out.println(temp.data);
			if(temp.left!=null)
				stack.push(temp.left);
			if(temp.right!=null)
				stack.push(temp.right);
		}
	}
}

//Breadth First Search
//Printing nodes in levels
public static void printNodesInLevel(TreeNode root){
	if(root == null)
		System.out.println("Tree is Empty");
	else{
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()){
			int count = queue.size();			
			while(count--){
				TreeNode temp = queue.poll();
				System.out.print(temp.data);
				if(temp.left!=null){
					queue.add(temp.left);
				}else{
					queue.add(temp.right);
				}
			}
			System.out.println();
		}
	}
}

//sum of nodes at each level
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
			while(count--){
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
//sliding window problem
public static int maxLenghtSubString(String str){
	if(str == null)
		return 0;
	else{
		int i=0,j=0;
		int n = str.length();
		Set<Character> charSet = new LinkedHashSet<>();
		int ans = 0;
		while(i<n&&j<n){
			if(!charSet.contains(str.charAt(j))){
				charSet.add(str.charAt(j++));
				ans = Math.max(ans,j-i);
			}else{
				charSet.remove(str.char(i++));
			}
		}
		return ans;
	}
}

//
public static Node revLinkedList(Node head){
	if(head == null || head.next == null){
			return head;
	}else{
		Node current = head;
		Node next = null;
		Node previous = null;
		while(current != null){
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		return previous;
	}
}

//chunck reverseLinkedList

public static Node chunckLinkedList(Node head,int k){
	if(head == null || head.next == null){
			return head;
	}else{
		Node current = head;
		Node next = null;
		Node previosu = null;
		int count = k;
		while(current != null && count-->0){
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		
		if(next!=null){
			head.next = chunckLinkedList(next,k);
		}
		
		return previosu;
	}
}
//merge sort 
public static int[] merge(int[] left,int[] right){
	int lIndex =0;
	int rIndex =0;
	int[] result = new result[left.length+right.length];
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

public boolean isBst(TreeNode root){
	if(root == null)
		return true;
	else
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

public void inOrder(TreeNode root,List<Integer> lst){
		if(root.left!=null)
		inOrder(root.left,lst);
		lst.add(root.data);
		if(root.right!=null)
		inOrder(root.right,lst);
}


public static void bfs(TreeNode root){
	if(root == null)
		System.out.println("Tree is empty");
	else{
			Queue<TreeNode> q = new LinkedList<>();
			a.add(root);
			while(!q.isEmpty()){
				TreeNode node = q.poll();
				System.out.print(node.data);
				if(node.left!=null)
					q.add(node.left);
				if(node.right!=null)
					a.add(node.right);
			}
	}
}

public static int maxSumLevel(TreeNode root){
	if(root == null)
		return 0;
	else{
		
		int result = root.data;
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		while(!q.isEmpty()){
			int sum =0;
			
			int count = q.size();
			while(count-->0){
				TreeNode node = q.poll();
				sum = sum+node.data;
				if(node.left!=null)
					q.add(node.left);
				if(node.right!=null)
					a.add(node.right);
			}
			result = Math.max(result,sum);
		}
		return result;
	}
}


public static int maxSubArray(int[] arr) {
	if(arr==null) {
		return arr;
	}
	else if(arr.length==1) {
		return arr[0];
	}
	else{
		max_so_far = Integer.MIN_VALUE;
		curr_max = a[0];
		for(int i=1;i<arr.length;i++){
			curr_max = Math.max(a[i],curr_max+a[i]);
			max_so_far = Math.max(max_so_far,curr_max);
		}
		return max_so_far;
	}
}

//permutations of a strings

public static List<String> permutations(String str,int l,int r,List<String> lst){
	if(l==r)
		lst.add(str);
	else {
		for(int i=0;i<str.length();i++){
			str = swap(str,l,i);
			permutations(str,l+i,r,lst);
			str = swap(str,l,i);
		}
	}
	return lst;
}

public static String swap(String str,int l,int r){
	char[] tempArr = str.toCharArray();
	char temp = tempArr[l];
	tempArr[l] = tempArr[r];
	tempArr[r] = temp;
	return String.valueOf(tempArr);
	
}

public static int[] qucikSort(int[] arr) {
	int(arr==null || arr.length ==1)
		return arr;
	else{
		qs(arr,0,arr.length-1);
		return arr;
	}
}

public static void QS(int[] arr,int left,int right){
	int i=left;
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
			int temp = a[i];
			a[i] = a[j];
			a[j] = temp;
			i++;
			j--;
		}
	}
	if(i<right)
		QS(arr,i,right);
	 if(left<j)
		 QS(arr,left,j);
	
}

public static int[] merge(int[] left,int[] right){
	int lIndex =0;
	int rIndex =0;
	int i=0;
	int[] result = new int[left.length+right.length];
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

public static int secondMaxElement(int[] arr){
	if(arr==null)
		return 0;
	else if(arr.length==1)
		return arr[0];
	else{
		int max1 =arr[0];
		int max2 = arr[0];
		for(int i=0;i<arr.length;i++){
			if(arr[i]>max1){
				max2 = max1;
				max1 = a[i];
			}else if(arr[i]<max1&&arr[i]>max2){
				max2 = arr[i];
			}
		}
		return max2;
	}	
}

public static List<String> permute(String str,int l,int r,List<String> lst){
	if(l==r)
		lst.add(str);
	else{
		for(int i=0;i<str.length;i++){
			str = swap(str,l,i);
			permute(str,l+1,r,lst);
			str = swap(str,l,i);
		}
	}
	return lst;
}

public static String swap(String str,int i,int j){
	char[] tempArr = str.toCharArray();
	char temp = tempArr[i];
	tempArr[i] = tempArr[j];
	tempArr[j] = temp;
	retrun String.valueOf(tempArr);
}

public static int maxSumInArray(int[] arr){
	if(arr==null)
		return 0;
	else if(arr.length == 1)
		return arr[0];
	else {
		int max_so_far = Inter.MIN_VALUE;
		int curr_max =0;
		for(int i=0;i<arr.length;i++){
			curr_max = Math.max(a[i],curr_max+a[i]);
			max_so_far = Math.max(curr_max,max_so_far);
		}
		return max_so_far;
	}
}

public static int maxLenghtSubString(String str){
	if(str==null)
		return 0;
	else{
		int ans =0;
		int i=0,j=0;
		Set<Character> set = new HashSet<>();
		while(i<str.length()&&j<str.length()){
			if(!set.contains(str.charAt(j))){
				set.add(str.charAt(j++));
				ans = Math.max(ans,j-i);
			}else{
				set.remove(str.charAt(i++));
			}
		}
		return ans;
	}
}


public static int[] quickSort(int[] arr){
	if(arr==null||arr.length==1){
		return arr;
	}else {
		qs(arr,0,arr.length-1);
	}
	return arr;
}

public static void qa(int[] arr,int left,int right)
{
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
			int temp = a[i];
			a[i] = a[j];
			a[j] = temp;
			i++;
			j--;
		}
	}
	if(left<j){
		qs(arr,left,j);
	}
	if(i<right){
		qs(arr,i,right);
	}
	
		
}

public static int[] merge(int[] left,int[] right){
	int lIndex =0;
	int rIndex =0;
	int[] result = new int[left.length+right.length];
	int i=0;
	while(lIndex<left.length&&rIndex<right.length){
		if(arr[lIndex]<arr[rIndex]){
			result[i++] = arr[lIndex++]; 
		}else{
			result[i++] = arr[rIndex++];
		}
	}
	while(lIndex<left.length){
		result[i++] = arr[lIndex++];
	}
	while(rIndex<right.length){
		result[i++] = arr[rIndex++];
	}
	return result;
}

//Max Sum in Array
public static int maxSumSubArray(int[] arr){
	if(arr==null){
		return 0;
	}else if(arr.length == 1){
		return a[0];
	}else {
		int curr_max =0;
		int max_so_far = Integer.MIN_VALUE;
		for(int i=0;i<arr.length;i++){
			curr_max = Math.max(a[i],curr_max+a[i]);
			max_so_far = Math.max(max_so_far,curr_max);
		}
		return max_so_far;
	}
}

//permute 
public static List<String> permutations(String str){
	List<String> lst = new ArrayList<>();
	if(str == null){
		return lst;
	}else{
		permute(st,0,str.length-1,lst);
		return lst;
	}
}

public static void permute(Sring str,int l,int r,List<String> lst) {
	if(l==r){
		lst.add(str);
	}else {
		for(int i=0;i<str.length;i++){
			str = swap(str,l,i);
			permute(str,l+1,r,lst);
			str = swap(str,l,i);
		}
	}
}

public static String swap(String str,int i,int j){
	char[] tempArr = str.toCharArray();
	char temp = tempArr[i];
	tempArr[i]= tempArr[j];
	tempArr[j] temp;
	return String.valueOf(tempArr);
}

public static int fab(int n) {
	if(n==0)
		return 0;
	else if(n==1)
		return 1;
	else
		return fab(n-1)+fab(n-2);
}

public static int[] fab(int n){
	int[] result = new int[n+1];
	result[0] =0;
	result[1] = 1;
	for(int i=2;i<=n;i++){
		result[i] = result[i-1]+result[i-2];
	}
	return result[n];
}

public static int maxLengthSubString(String str){
	if(str== null){
		retrun 0;
	}else{
		Set<Character> set = new HashSet<>();
		int i=0;
		int j=0;
		int ans =0;
		while(i<str.length()&&j<str.length()){
			if(!set.contains(str.charAt(j))){
				set.add(str.charAt(j++));
				ans = Math.max(ans,j-i);
			}else{
				set.remove(str.charAt(i++));
			}
		}
		return ans;
	}
}

public static Node reverse(Node head)
{
		if(head == null)
			return head;
		else if(head.next = null)
			return head;
		else{
				Node previous = null;
				Node current = head;
				Node next = null;
				while(current!=null){
					next = current.next;
					current.next = previous;
					previous = current;
					current = next;
				}
				retrun previous;
		}
}

public static Node chunckReverse(Node head,int k){
	if(head == null || k == 0 || head.next == null){
		retun head;
	}else {
		Node current = head;
		Node previous = null;
		Node next = null;
		int count = k;
		while(current!=null && count-->0){
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		
		if(next != null){
			head.next = chunckReverse(next,k);
		}
		return previous;
	}
}


public static int heightOfTree(TreeNode root){
	if(root == null)
	{
			retrun 0;
	}else{
		int leftTreeHeight = heightOfTree(root.left);
		int rightTreeHeight = heightOfTree(root.right);
		if(leftTreeHeight>rightTreeHeight)
			return 1+leftTreeHeight;
		else
			return 1+rightTreeHeight;
	}
}

public static int heightTreeNonRec(TreeNode root){
	if(root == null){
		retun 0;
	}else{
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		int height = 0;
		while(!queue.isEmpty()){
			int count = queue.size();
			height++;
			while(count-->0){
				TreeNode temp = queue.poll();
				if(temp.left!=null)
					queue.add(temp.left);
				if(temp.right!=null)
					queue.add(temp.right);
			}
		}		
		return height;
	}
}

public static void inOrder(TreeNode root){
	if(root == null){
		System.out.println("Tree is empty");
	}else{
		if(root.left!=null)
			inOrder(root.left);
		System.out.println(root.data);
		if(root.right!=null)
			inOder(root.right);
	}
}
public static void preOrder(TreeNode root){
	if(root ==null){
		System.out.println("Tree is empty");
	}else{
		System.out.println(root.data);
		if(root.left!=null)
			preOrder(root.left);
		if(root.right!=null)
			preOrder(root.right);
	}
}
public static void postOrder(TreeNode root){
	if(root == null)
		System.out.println("Tree is Empty");
	else{
		if(root.left!=null)
			postOrder(root.left);
		if(root.right!=null)
			postOrder(root.right);
		System.out.println(root.data);
	}
}
public static void BFS(TreeNode root){
	if(root == null){
		System.out.println("Tree is empty");
	}else{
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		if(!queue.isEmpty()){
			TreeNode temp = queue.poll();
			System.out.println(temp.data);
			if(temp.left!=null)
				queue.add(temp.left);
			if(temp.right!=null)
				queue.add(temp.right);
		}
	}
}

public static void DFS(TreeNode root){
	if(root == null){
		System.out.println("Tree is empty");
	}else {
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while(!stack.isEmpty()){
			TreeNode temp = stack.pop();
			System.out.println(temp.data);
			if(temp.left!=null)
				stack.push(temp.left);
			if(temp.right!=null)
				stack.push(temp.right);
		}
	}
}

public static boolean isMirrored(TreeNode left,TreeNode right){
	if(left == null && right == null){
		return true;
	}else{
		if(left!=null && right!=null && left.data == right.data){
			return (isMirrored(left.left,right.right)&&isMirrored(left.right,right.left));
		}
		return false;
	}
	
}

public static void BFS(TreeNode root){
	if(root == null){
		System.out.println("Tree is empty");
	}else{
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()){
			TreeNode temp = queue.poll();
			System.out.println(temp.data);
			if(temp.left!=null){
				queue.add(temp.left);
			}
			if(temp.right!=null){
				queue.add(temp.right);
			}
		}
	}
}

public static int maxSumAtLevel(TreeNode root)
{
		if(root == null){
			return 0;
		}else{
			Queue<TreeNode> queue = new LinkedList<>();
			queue.add(root);
			int max = root.data;
			while(!queue.isEmpty()){
				int count = queue.size();
				int sum =0;
				while(count-->0){
					TreeNode temp = queue.poll();
					sum += temp.data;
					if(temp.left!=null)
						queue.add(temp.left);
					if(temp.right!=null)
						queue.add(temp.right);
				}
				max = Math.max(max,sum);
			}
			return max;
		}
}

public static void sumOfNodesAtEachLevel(TreeNode root){
	if(root == null){
		System.out.println("Tree is empty");
	}else {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		int i=1;
		while(!queue.isEmpty()){
			int count = queue.size();
			int sum = 0;
			while(count-->0){
				TreeNode temp = queue.poll();
				sum+=temp.data;
				if(temp.left!=null)
					queue.add(temp.left);
				if(temp.right!=null)
					queue.add(temp.right);
			}
			System.out.println("Sum of Nodes at level->"+(i++)+" is->"+sum);
		}
	}
}
public static int revNum(int num){
		if(num >= 0 && num < 10)
				return num;
		else{
			int result = 0;
			while(num>0){
				result = result*10+num%10;
				num = num/10;
			}
			return result;
		}
	}


public static int revNum(int num){
	if(num >= 0 && num < 10)
			return numm;
	else{
		int resul = 0;
		while(num>0){
			result = result*10+num%10;
			num = num/10;
		}
		retun result;
	}
}

public static boolean anagrams(String str1,String str2){
	if(str1.equals(str2)){
		return true;
	}else{
		char[] s1 = str1.toCharArray();
		char[] s2 = str2.toCharArray();
		Arrays.sort(s1);
		Arryas.sort(s2);
		retrun Arrays.equals(s1,s2);
	}
}

public static int maxSumAtLevel(TreeNode root){
	if(root == null)
		return 0;
	else{
			Queue<TreeNode> queue = new LinkedList<>();
			queue.add(root);
			int max = root.data;
			while(!queue.isEmpty()){
				int count = queue.size();
				int sum = 0
				while(count-->0){
					TreeNode temp = queue.poll();
					sum+=temp.data;
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

Class Singleton{
	private static Singleton singleton = new Singleton();
	
	private Singleton(){
		System.out.println("Calling constructor....");
	}
	
	private static Singleton getInstance(){
		return singleton;
	}
}

//Breaking it using Reflection API
public static break singletonReflectionAPI(){
	Class clazz = Class.forName("paramters.Singleton");
	Constructors ctor = clazz.getDeclaredConstructors();
	ctor.setAccessible(true);
	Singleton s3 = ctor.newInstance();
}

public int closeValueInBST(TreeNode root,int target){
	int ret = root.data;
	while(root!=null){
		if(Mat.abs(target-root.data)<Math.abs(target-ret)){
			ret = root.data;
		}
		root = (target>root.data)?root.right:root.left;
	}
	return ret;
}

public static int[] insertionSort(int[] arr){
		if(arr==null){
			return arr;
		}else if(arr.length==1){
			return arr;
		}else{
			int key =0,j=0;
			for(int i=1;i<arr.length;i++){
				key = arr[i];
				j = i-1;
				while(j>=0&&arr[j]>key){
					arr[j+1]= arr[j];
							j--;
				}
				arr[j+1]= key;
			}
			return arr;
		}
	}

public int[] bubbleSort(int[] arr){
	if(arr==null){
		return arr;
	}else if(arr.length==1){
		return 1;
	}else{
		for(int i=0;i<arr.length;i++){
			for(int j=1;j<arr.length-i;j++){
				if(arr[j-1]>a[j]){
					swap(arr,j-1,j);
				}
			}
		}
		return arr;
	}
}

public int countValNum(TreeNode root,int target){
	int returnValue = root.data;
	while(root!=null){
		if(Mat.abs(target-root.data)<Math.abs(target-returnValue)){
			returnValue = root.data;
		}
		root = (target>root.data)?root.right:root.left;
	}
	return returnValue;
}

public int[] inerstSort(int[] arr){
	for(int i=1;i<n;i++){
		int j=i-1;
		int key = arr[i];
		while(j>=0&&arr[j]>key){
			arr[j+1] = arr[j];
			j--;
		}
		a[j+1] = key;
		
	}
	return arr;
}

public boolean isOneEditDistance(String s, String t) {
    if(Math.abs(s.length()-t.length()) > 1) return false;
    if(s.length() == t.length()) return isOneModify(s,t);
    if(s.length() > t.length()) return isOneDel(s,t);
    return isOneDel(t,s);
}
public boolean isOneDel(String s,String t){
    for(int i=0,j=0;i<s.length() && j<t.length();i++,j++){
        if(s.charAt(i) != t.charAt(j)){
            return s.substring(i+1).equals(t.substring(j));
        }
    }
    return true;
}
public boolean isOneModify(String s,String t){
    int diff =0;
    for(int i=0;i<s.length();i++){
        if(s.charAt(i) != t.charAt(i)) diff++;
    }
    return diff==1;
}
