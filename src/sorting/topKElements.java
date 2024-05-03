// Motivation : How do we compute the top k in ranking for Information Retrieval? 
// Author     : 
// Solution   : Efficient way of computing the top k. A binary min heap is a complete binary 
//            : tree in which each node's value is less than the values of its children. 


// 	      10             10
//	     /  \           /  \
//	    20  100       15    30
//	   /		     /  \   / \
//	  30		    40  50 100 40

import java.util.*;

class Solution {
	public int[] topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		for(int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		PriorityQueue<Map.Entry<Integer,Integer>> pq = 
		new PriorityQueue<>((e1, e2) -> e2.getValue() - e1.getValue());

		for (Map.Entry entry : map.entrySet()) {
			pq.add(entry);
		}
		int [] ans = new int[k];
		for (int i = 0; i < k; i++) {
			ans[i] = pq.poll().getKey();
		}
		return ans;
	}
}

public class main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = {1, 1, 1, 2, 2, 3};
		int k = 2;

		int[] result = solution.topKFrequent(nums, k);

		System.out.println("Top " + k + " frequent elements: ");
		for (int num : result) {
			System.out.println(num);
		}
	}
}













