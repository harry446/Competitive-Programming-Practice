package second;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SegmentTreeDynamicRangeMinimumTest {

	static int[] nums;
	static int[] tree;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		
		String[] temp1 = br.readLine().split(" ");
		int N = Integer.parseInt(temp1[0]);
		int M = Integer.parseInt(temp1[1]);
		nums = new int[N];
		tree = new int[2*(N+2)];
		
		
		for (int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		
		build(2*(N+2), 0, N);	//the tree[] index starts at 1. The 0 and N are the beginning and ending index of nums
		
		for (int i=0; i<M; i++) {
			String[] S = br.readLine().split(" ");
			int idx = Integer.parseInt(S[1]);
			int value = Integer.parseInt(S[2]);
			
			if (S[0] == "M") {
				update(1, 0, N, idx, value);
			}
			else {
				
			}
		}
	}

	public static void build (int node, int start, int end) {
		if (start == end) {
			tree[node] = nums[start];
		}
		else {
			int mid = (start+end)/2;
			build(2*node, start, mid);
			build(2*node+1, mid+1, end);
			tree[node] = tree[2*node] + tree[2*node+1];
		}
	}
	
	public static void update (int node, int start, int end, int index, int val) {
		if (start == end) {
			tree[node] = val;
			nums[index] = val;
			return;
		}
		
		int mid = (start + end)/2;
		if (start <= index && index <= mid) {
			//if the value to be updated is on the left child
			update(2*node, start, mid, index, val);
		}
		else {
			//if the value to be updated is on the right child
			update(2*node, start, mid, index, val);
		}
		
		//update internal nodes as well (nodes above the updated node)
		tree[node] = tree[2*node] + tree[2*node+1];
	}
	
	public static void query (int node, int start, int end, int l, int r) {
		
		//If the range given is completely outside
		if (r < start || end < l) {
			
		}
	}
	
	
}
