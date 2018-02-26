
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


public boolean isMirror(TreeNode root){
	return isMirror(root,root);
}
public boolean isMirror(TreeNode left,TreeNode right){
	if(left==null&&right==null){
		return true;
	}else if(left.data!=right.data){
		return false;
	}else{
		
			if(left!=null&&right!=null&&left.data==right.data){
				return isMirror(left.left,right.right)&&isMirror(left.right,right.left);
			}else{
			return false;
			}
	}
}

public int noOfWays(int[] arr,int sum)
{
		int[] ways = new int[sum+1];
		Arrays.fill(ways,0);
		ways[0] = 0;
		for(int num:arr)
		{
				for(int i=0;i<=sum;i++){
					if(i>=num){
						ways[i]+=ways[i-num];
					}
				}
		}
		return ways[sum];
}

public int[] insertionSort(int[] a){
	if(a==null)
		return a;
	else if(a.length==1){
		return a;
	}else{
		int key =0;
		int j =0;
		for(int i=1;i<a.length;i++)
		{
				int key = a[i];
				int j= i-1;
				while(j>=0&&a[j]>key){
					a[j+1] =a[j];
					j--;
				}
				a[j+1] = key; 
		}
		return arr;
	}
}

//LCS longest common sequence in two strings
public int lcs(String s1,String s2){
	if(s1==null||s2==null){
		return 0;
	}else{
		List<Character> list = new ArrayList<>();
		return lcs(s1,s2,s1.length(),s2.length(),list);
	}
}

public int lcs(String s1,String s2,int m,int n,List<Character> lst)
{
		if(m==0||n==0){
			return 0;
		}else if(s1.charAt(m-1)==s2.charAt(n-1)){
			lst.add(s1.charAt(m-1));
			return 1+lcs(s1,s2,m-1,n-1,lst);
		}else{
			return Math.max(lcs(s1,s2,m-1,n),lcs(s1,s2,m,n-1));
		}
			
}

public int maxSumInArray(int[] arr){
	if(arr==null){
		return 0;
	}else if(arr.length==1){
		return arr[0];
	}else{
		int curr_max =0;
		int max_so_far = Integer.MIN_VALUE;
		for(int i=0;i<arr.length;i++){
			curr_max = Math.max(arr[i],curr_max+arr[i]);
			max_so_far = Math.max(curr_max,max_so_far);
		}
		return max_so_far;
	}
}

public int lengthOfMaxSubString(String str){
	if(str == null){
		return 0;
	}else{
		Set<Character> set = new HashSet<>();
		int max = 0;
		String result ="";
		int i=0,j=0,n=str.length();
		while(i<n&&j<n){
			if(!set.contains(str.charAt(j++))){
				set.add(str.charAt(j++));
				if(max<j-i){
					result = getString(set);
					max = j-i;
				}
			}else{
				set.remove(str.charAt(i));
				i++;
			}
		}
		System.out.println(result);
		return max;
	}
}

public boolean isMirror(TreeNode root){
	if(root == null){
		return true;
	}else{
		return isMirror(root,root);
	}
}
public boolean isMirror(TreeNode leftRoot,TreeNode rightRoot){
	if(leftRoot==null && rightRoot==null){
		return true;
	}else if(leftRoot.data!=rightRoot.data){
		return false;
	}else{
		
		if(leftRoot!=null&&rightRoot!=null&&leftRoot.data==rightRoot.data){
			return isMirror(leftRoot.left,rightRoot.right)&&isMirror(leftRoot.right,rightRoot.left);
		}
		return false;
	}
}

public int heightOfTree(TreeNode root){
	if(root == null){
		return 0;
	}else if(root.left==null && root.right==null){
		return 1;
	}else{
		int lHeight = height(root.left);
		int rHeight = height(root.right);
		if(lHeight>rHeight)
			return 1+lHeight;
		else
			return 1+rHeight;
	}
}

public int closeValue(TreeNode root,int target){
	if(root == null){
		return 0;
	}else{
		int returnValue = root.data;
		TreeNode temp = root;
		while(temp!=null){
		
			if(Math.abs(target-root.data)<Math.abs(target-returnValue)){
				returnValue = root.data;
			}
		
			temp = target>temp.data?temp.right:temp.left;
		}
	}
}

public int[] merge(int[] left,int[] right)
{
		int lIndex =0;
		int rIndex = 0;
		int i=0;
		int[] result = new int[left.length+right+length];
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

public List<String> permutations(String str){
	List<String> lst = new ArrayList<>();
	if(str == null){
		return lst
	}else{
		permute(str,0,str.length()-1,lst);
		return lst;
	}
}

public void permute(String str,int l,int r,List<String> lst){
	if(l==r){
		lst.add(str);
	}else{
	for(int i=1;i<str.length();i++}{
		str= swap(str,l,i);
		permute(str,l+1,r,lst)
		str= swap(str,l,i);
		}
	}
}

public String swap(String str,int i,int j){
	char[] tempArr = str.toCharArray();
	char temp = tempArr[i];
	tempArr[i] = tempArr[j];
	tempArr[j] = temp;
	retrun String.valueOf(tempArr);
}


//singleton Reflection API
public static void reflectionAPI(){
	Class clazz = Class.forName("Singleton");
	Constructor ctor = clazz.getDelecredConstructors();
	ctor.setAccessible(true);
	Singleton s = ctor.getInstance();
}

public static int[] insertionSort(int[] arr){
	if(arr==null){
		return arr;
	}else if(arr.length==1){
		return arr;
	}else{
		int j=0;int key =0;
		for(int i=1;i<arr.length;i++){
			j =i-1;
			key = arr[i];
			while(j>=0 && arr[j]>key){
				arr[j+1] = a[j];
				j--;
			}
			a[j+1] = key;
		}
	}
	return arr;
}

public static Set<String> permutations(String str){
	if(str == null){
		return new HashSet<>();
	}else{
		Set<String> set = new HashSet<>()
		permute(str,0,str.length()-1,set);
	}
}

public static void permute(String s,int l,int r,Set<String> set){
	if(l==r){
		set.add(s);
	}else{
		for(int i=0;i<s.length();i++){
			s = swap(str,l,i);
			permute(str,l+1,r,set);
			s = swap(str,l,i);
		}
	}
}

public static String swap(String s,int i,int j){
	char[] cTemp = s.toCharArray();
	char temp = cTemp[i];
	cTemp[i] = cTemp[j];
	cTemp[j] = temp;
	return String.value(cTemp);
}

public int countWays(int[] coins,int amount){
	int[] countWays = new int[amount+1];
	Arrays.fill(countWays,0);
	countWays[0] =1;
	for(int coin:coins){
		for(int i=1;i<countWays.length;i++){
			if(i>=coin){
				countWays[i]+=countWays[i-coin];
			}
		}
	}
	return countWays[amount];
}

public int lengthOfLongestSubStringWithOutRepeatingChars(String str){
	if(str == null{
		return 0;
	}else if(str.length()==1){
		return 1;
	}else{
		Set<Character> set = new HashSet<>();
		int i=0;int j=0;
		int n = str.length();
		int ans =0;
		while(i<n&&j<n){
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

public int[] merge(int[] left,int[] right){
	int lIndex =0;
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

public int count1Bits(int num){
	if(num<=0){
		return 0;
	}else{
		int count =0;
		while(num>0){
			if(num%2==1){
				count++;
			}
			num = num/2;
		}
		return count;
	}
}

//Depth of a tree
public int heightOfTree(TreeNode root){
	if(root == null){
		return 0;
	}else if(root.left==null && root.right == null){
		return 1;
	}else{
		int lheight = heightOfTree(root.left);
		int rheight = heightOfTree(root.right);
		return lheight>rheight?1+lheight:1+rheight;
	}
}

//DFS
public void printDFS(TreeNode root){
	if(root==null){
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
				stack.push(temp.right);
			}
		}
	}
}

//BFS
public void printBFS(TreeNode root){
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

//closest number in Tree
public int closetNumber(TreeNode root,int target){
	if(root == null){
		return null;
	}else{
		int ret = root.data;
		while(root!=null){
			if(Math.abs(target-root.data)<Math.abs(target-ret)){
				ret = root.data;
			}
			root = target>root.data?root.right:root.left;
		}
		return ret;
	}
}

//mirrored
public boolean isMirror(TreeNode root){
	if(root == null){
		return true;
	}else{
		isMirror(root,root);
	}
}
private boolean isMirror(TreeNode left,TreeNode right){
	if(left==null&&right==null){
		return true;
	}else{
		if(left!=null&&right!=null&&left.data==right.data){
			return isMirror(left.left&&right.right)&&isMirror(left.right&&right.left);
		}
		return false;
	}
}

//Trees
public void inorder(TreeNode root)
{
		if(root==null){
			Sysout("Tree is empty");
		}else{
			if(root.left!=null)
				inorder(root.left);
			System.out.prtinln(root.data);
			if(root.right!=null)
				inorder(root.right);
		}
}

public void preorder(TreeNode root)
{
	if(root==null){
		Sysyout("Tree is empty");
	}else{
		System.out.println(root.data);
		if(root.left!=null)
			preorder(root.left);
		if(root.right!=null)
			preorder(root.right);
	}
}

public void postorder(TreeNode root){
	if(root==null){
		System.out.prtinln("Tree is empty");
	}else{
		if(root.left!=null)
			postorder(root.left);
		if(root.right!=null)
			postorder(root.right);
		System.out.println(root.data);
	}
}

public int height(TreeNode root){
	if(root==null){
		return 0;
	}else{
		int lHeight = height(root.left);
		int rHeight = height(root.right);
		if(lHeight>rHeight)
			return 1+lHeight;
		else
			return 1+rHeight;
	}
}

public void DFS(TreeNode root){
	if(root==null){
		Systemo.out.println("Tree is empty");
	}else{
		Stack<TreeNode> stack = new LinkedList<>();
		stack.add(root);
		while(!stack.isEmpty()){
			TreeNode temp = stack.poll();
			Sysout(temp.data);
			if(temp.left!=null)
				stack.add(temp.left);
			if(temp.right!=null)
				stack.add(temp.right);
		}
	}
}

public void BFS(TreeNode root){
	if(root==null){
		System.out.prtinln("Tree is Empty");
	}else{
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()){
			TreeNode temp = queue.poll();
			System.out.prtinln(temp.data);
			if(temp.left!=null)
				queue.add(temp.left);
			if(temp.right!=null)
				queue.add(temp.right);
		}
	}
}

public int LevelOrderTraverser(TreeNode root){
	if(root==null){
		System.out.println("Tree is Empty");
		return 0;
	}else{
		int max = Intger.MIN_VALUE;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()){
			TreeNode temp = queue.poll();
			int count = queue.size();
			int sum =0;
			while(count>0){
				system.out.print(temp.data);
				sum+=temp.data;
				if(temp.left!=null)
					queue.add(temp.left);
				if(temp.right!=null)
					queue.add(temp.right);
				count--;
			}
			max = Math.max(sum,max);
		}
		return max;
	}
}

public int closeValue(TreeNode root,int target){
	if(root==null||target == null){
		return 0;
	}else{
		int closeVal = root.data;
		while(root!=null){
			if(Math.abs(target-root.data)<Math.abs(target-closeVal)){
				closeVal = root.data;
			}
			root = target>root.data?root.right:root.left;
		}
		return closeVal;
	}	
}

public boolean isMirror(TreeNode root){
	if(root == null){
		return true;
	}else{
		return isMirror(root,root);
	}
}
public boolean isMirror(TreeNode left,TreeNode right){
	if(left==null&&right==null){
		reutn true;
	}else{
		if(left!=null&&right!=null&&left.data==right.data){
			return isMirror(left.left,right.right)&&isMirror(left.right,right.left);
		}
		return false;
	}
}

public boolean isTreeBalanced(TreeNode root){
	if(root == null){
		return true;
	}else{
		int lHeight = height(root.left);
		int rHeight = height(root.right);
		return (Math.abs(lHeight-rHeight)>1)?false:true;	
			
	}
}

class BSTUtility{
	private int prev = null;
	
	public boolean isBST(TreeNode root){
		if(root == null){
			return true;
		}else if(root.left==null&&root.right==null){
			return true;
		}else{
			if(root.left!=null)
				isBST(root.left);			
			if(prev!=null&&root.data<=prev){
				return false;
			}	
				prev = root.data;
			
			if(root.right!=null){
				isBst(root.right);
			}
			return true;
		}
	}
}

public void printPermute(String str){
	if(str==null){
		System.out.println("Empty String");
	}else{
		Set<String> set = new HashSet<>();
		permute(str,0,str.length()-1,set);
		printset(set);
	}
}

public void permute(String str,int l,int r,Set<String> set){
	if(l==r){
		set.add(str);
	}else{
		for(int i=1;i<str.length();i++){
			str = swap(str,l,i);
			permute(str,l+1,r,set);
			str = swap(str,l,i);
		}
	}
}

public String swap(String str,int i,int j){
	char[] tempChar = str.toCharArray();
	char temp = tempChar[i];
	tempChar[i] = tempChar[j];	
	tempChar[j] = temp;
	return String.valueOf(tempChar);
}

public void printset(Set<String> set)
{
		for(String str:set){
			System.out.println(str);
		}
}

public boolean isPalindrome(String str){
	int count =0;
	for(int i=0,j=str.length()-1,i<str.length()&&j>0;i++,j--){
		if(str.charAt(i)!=str.charAt(j)){
			count++;
		}
	}
	return count==1;
}

public boolean isAnagaram(String str1,String str2){
	char[] c1 = str1.toCharArray();
	char[] c2 = str2.toCharArray();
	Arrays.sort(c1);
	Arrays.sort(c2);
	return Arrays.equals(c2);
}

public String LCS(String s1,String s2){
	if(s1==null||s2=null){
		return null;
	}else{
		List<Character> list = new ArrayLst<>();
		lcs(s1,s2,s1.length()-1,s2.length()-1,lst);
		return lst.toString();
	}
}

public int lcs(String s1,String s2,int m,int n,List<Character> lst){
	if(s1.charAt(m)==s2.charAt(n)){
		lst.add(s1.charAt(m));
		return 1+lcs(s1,s2,m-1,n-1,lst);
	}else{
		return Math.max(lcs(s1,s2,m-1,n,lst),lcs(s1,s2,m,n-1,lst));
	}
}

public int countWays(int[] coins,int amount){
	int cobminations = new int[amount+1];
	combinations[0] =1;
	for(int coin:coins){
		for(int i=1;i<amount+1;i++){
			if(i>=coin){
				combinations[i]+ = combinations[i-coin];
			}
		}
	}
	return combinations[amount];
}

public int smallDiffArrays(int[] arr1,int[] arr2){
	Arrays.sort(arr1);
	Arrays.sort(arr2);
	int smallDiff = Integer.MAX_VALUE;
	int i=0;
	int j=0;
	while(i<arr1.length&&j<arr2.length){
		if(Math.abs(arr1[i]-arr2[j])<smallDiff){
			smallDiff = Math.abs(arr1[i]-arr2[j]);
		}
		
		if(arr1[i]>arr2[j]){
			i++;
		}else{
			j++;
		}
	}
	return smallDiff;
}

public int max1(int[] arr){
	int max1 =Integer.MIN_VALUE;
	for(int i:arr)
	{
			if(i>max1);
			max1= i;
	}
	return max1;
}	

public int max2(int[] arr){
	int max1 = Integer.MIN_VALUE;
	int max2 = Integer.MIN_VALUE;
	for(int i:arr){
		if(i>max1){
			max2 = max1;
			max1 = i;
		}else if(i<max1&&i>max2){
			max2 = i;
		}		
	}
	return max2;
}

public int Fab(int n)
{
	int[] temp = new int[n+1];
	temp[0] =0;
	temp[1] = 1;
	
	for(int i=2;i<temp.length;i++){
		temp[i] = temp[i-1]+temp[i-2];
	}
	return temp[n];
}

public int maxLengthSubString(String str){
	if(str == null){
		return 0;
	}else{
		Set<Character> set = new HashSet<>();
		int i=0,j=0;
		int max_length = Integer.MIN_VALUE;
		while(i<str.length&&j<str.length){
			if(!set.contains(str.charAt(j))){
				set.add(str.charAt(j++));
				max = Math.max(max,j-i);
			}else{
				set.remove(str.charAt(i++));
			}
		}
		return max_length;
	}
}

public int maxSumInArray(int[] arr){
	if(arr==null){
		return 0;
	}else{
		int max_sum = Intger.MIN_VALUE;
		int curr_max = 0;
		for(int i=0;i<arr.length;i++){
		curr_max = Math.max(a[i],a[i]+curr_max);
		max_sum = Math.max(max_sum,curr_max);
		}
		return max_sum;
	}
}

public void printSumOfEachDepth(TreeNode root)
{
		if(root==null){
			sysout("tree is empty");
		}else{
			Stack<TreeNode> stack = new Stack();
			stack.push(root);
			while(!stack.isEmpty()){
				int size = stack.size();
				int sum =0;
				while(size>0){
					TreeNode temp = stack.pop();
					sum+=temp.data;
					if(temp.left!=null)
						stack.push(temp.left);
					if(temp.right!=null)
						stack.push(temp.right);
					size--;
				}
				System.out.println("Sum of nodes of this depth is "+sum);
			}
		}
}

public Node chunkReverse(Node head,int n){
	if(head==null){
		return head;
	}else if(head.next == null){
		return null;
	}else{
		Node prev = null;
		Node next = null;
		Node current = head;
		int count =n;
		while(count>0&&current!=null){
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
			count--;
		}
		if(next!=null){
			head.next = chunkReverse(next,k);
		}
		return previous;
	}
}

public int countWays(int[] arr,int sum){
	int[] result = new int[sum+1];
	for(int i:arr){
		for(int j=0;j<sum+1;j++){
			if(j>=i)
			result[j] += result[j-i]; 
	}
	return arr[sum];
}

public static boolean istPalindrom(char[] word){
  int i1 = 0;
  int i2 = word.length - 1;
  while (i2 > i1) {
      if (word[i1] != word[i2]) {
          return false;
      }
      ++i1;
      --i2;
  }
  return true;
}

public boolean isPalindrome(String str){
	Char[] c = str.toCharArray();
	int l=0;
	int r = str.length()-1;
	while(r>l){
		if(c[l]!=c[r])
			retrun false;
		l++;
		r--;
	}
		return true;
}

public void qucikSort(int[] arr){
	QS(int[] arr,0,arr.length-1);
}


public void QS(int[] arr,int left,int right){
	int i=left;
	int j=right;;
	int pivotal = arr[left+(right-left)/2];
	while(i<j){
		while(arr[i]<pivotal){
			i++;
		}
	while(arr[j]>pivotal){
		j--;
	}
	if(i<=j){
		swap(arr,i,j);
		i++;
		j--;
		}
	}
	if(i<right)
		QS(arr,i,right);
	if(left<j)
		QS(arr,left,j);
}

public int max_sum(int[] arr){
	if(arr==null)
		return 0;
	else if(arr.length==1)
		return arr[0];
	else
		int curr_max = 0;
		int max_so_far = Integer.MIN_VALUE;
		for(int i=0;i<arr.length;i++)
		{
			curr_max = Math.max(arr[i],arr[i]+curr_max);
			max_so_far = Math.max(max_so_far,curr_max);
		}
		return max_so_far;
}

public int mind_diff_two_arrays(int[] arr1,int[] arr2){
	Arrays.sort(arr1);
	Arrays.sort(arr2);
	int min_diff = Integer.MAX_VALUE;
	while(i<arr1.length&&j<arr2.length){
		if(Math.abs(arr1[i]-arr2[j])<min_diff){
			min_diff = Math.abs(arr1[i]-arr2[j])
		}
		
		if(arr1[i]>arr2[j]){
			i++;
		}else{
			j++;
		}
	}
}

public int max2(int[] arr){
	if(arr==null){
		return 0;
	}else if(arr.length ==1){
		return arr[0];
	}else{
		int max1 = Integer.MIN_VALUE;
		int max2 =  Integer.MIN_VALUE;
		for(int i:arr){
			if(i>max1){
				max2 = max1;
				max1 = i;
			}else if(i<max1 && i>max2){
				max2 = i;
			}
		}
		return max2;
	}
}

public int min2(int[] arr){
	if(arr==null){
		return 0;
	}else if(arr.length ==1){
		return arr[0];
	}else{
		int min1 = Integer.MAX_VALUE;
		int min2 = Integer.MAX_VALUE;
		for(int i:arr){
			if(i<min1){
				min2 = min1;
				min1 = i;
			}else if(i>min1 && i<min2){
				min2 = i;
			}
		}
		return min2;
	}
}

public boolean hasDuplicates(int[] arr){
	if(arr==null)
		return false;
	else if(arr.length==1)
		return false;
	else{
		Arrays.sort(arr);
		for(int i=1;i<arr.length;i++){
			if(arr[i-1]==a[i]){
				return true;
			}
		}
		return false;
	}
}

public int[] merge(int[] left,int[] right){
	int lIndex =0;
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

public int countWays(int[] coint,int amount){
	int[] ways = new int[amount+1];
	ways[0] = 1;
	for(int coin:coins){
		for(int i=1;i<amount;i++){
			if(i>=coin){
				ways[i]+ = ways[i-coins];
			}
		}
	}
	return ways[amount];
}

public int[] swapTwoNumbers(int[] arr1,int[] arr2){
	Arrays.sort(arr1);
	Arrays.sort(arr2);
	Integer target = findTarget(arr1,arr2);
	int diff = Integer.MIN_VALUE;
	int i=0,j=0;
	while(i<arr1.length&&j<arr2.length){
		if(arr1[i]-arr2[j]==target){
			return new int[]{arr1[i],arr2[j]};
		}else if(arr1[i]-arr2[j]<target){
			i++;
		}else{
			j++;
		}
		
	}
}

public int findTarget(int[] arr1,int[] arr2){
	int sum1 = Integer.MIN_VALUE;
	int sum2 = Integer.MIN_VALUE;
	for(int i:arr1){
		sum1+=i;
	}
	for(int k:arr2){
		sum2+=k;
	}
	
	if((sum1-sum2)%2!=0) return null;
	else return (sum1-sum2)/2;
}

public void printPairs(int[] arr,int target){
	Arrays.sort(arr);
	int i=0;
	int j=arr.length-1;
	while(i<j){
		if(arr[i]+arr[j]==target){
			System.out.println(arr[i]+"--->"+arr[j]);
		}
		i++;
		j--;
	}else{
		if(arr[i]+arr[j]<target)
			i++;
		else
			j--;
	}
}

Integer is palindrome
printing value in diagonal of matrix

//Matrix
public static void printDiagnoal(int[][] matrix){
	for(int i=0,j=0;i<3&&j<3;i++,j++){
		System.out.println(matrix[i][j]);
	}
}

public static void printMatrix(int[][] matrix){
	for(int i=0;i<3;i++){
		for(int j=0;j<3;j++){
			System.out.print(matrix[i][j]+"\t");	
		}
		System.out.println();
	}
}

public static void printRowSum(int[][] matrix,int row){
	row = row -1;
	int sum =0;
	for(int i=0;i<3;i++){
		sum+=matrix[row][i];			
	}
	System.out.println("Sum of given row is->"+sum);
}

public static void printColSum(int[][] matrix,int col){		
	col = col-1;
	int sum =0;
	for(int i=0;i<3;i++){
		sum+=matrix[i][col];			
	}
	System.out.println("Sum of given col is->"+sum);
	
}

