package com.partha.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * https://leetcode.com/problems/design-twitter/
 * @author partha
 *
 */
public class DesignTweeter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}



	/**
	 * https://www.youtube.com/watch?v=pNichitDD2E
	 * @author partha
	 *
	 */
	class Twitter {

		int count =0;

		Map<Integer,Set<Integer>> followmap;
		Map<Integer,List<Tweet>> tweetmap;


		class Tweet{
			int tweetId;
			int seq;

			public Tweet(int tweetId,int seq){
				this.tweetId = tweetId;
				this.seq = seq;
			}
		}

		public Twitter() {
			followmap = new HashMap();
			tweetmap = new HashMap();
		}

		public void postTweet(int userId, int tweetId) {
			Tweet tweet = new Tweet(tweetId,count++);
			if(tweetmap.containsKey(userId)){
				tweetmap.get(userId).add(tweet);
			}else{
				List<Tweet> list = new ArrayList();
				list.add(tweet);
				tweetmap.put(userId,list);
			}
		}

		public List<Integer> getNewsFeed(int userId) {
			//[seq,tweetId,userId,lastReadIndex]
			PriorityQueue<int[]> queue = new PriorityQueue<int[]>((a,b) -> {return b[0] - a[0];}); 
			List<Integer> result = new ArrayList();
			Set<Integer> followees = followmap.get(userId);

			//adding self to follower list
			if(followees!=null){
				followees.add(userId); 
			}else{
				Set<Integer> set = new HashSet();
				set.add(userId);
				followees = set;
			}


			//the below is basically merge K-sortedList algo
			for(int followee: followees){
				if(tweetmap.containsKey(followee)){
					List<Tweet> tweetList = tweetmap.get(followee);
					Tweet lastTweet = tweetList.get(tweetList.size()-1);
					int[] arr = new int[]{lastTweet.seq, lastTweet.tweetId , followee, tweetList.size()-1};
					queue.add(arr);
				}
			}

			int n=0;
			while(!queue.isEmpty() && n<10){
				int[] arr = queue.remove();
				result.add(arr[1]);
				n++;
				List<Tweet> list = tweetmap.get(arr[2]);
				if(arr[3]-1>=0){
					Tweet lastTweet = list.get(arr[3]-1);
					queue.add(new int[]{lastTweet.seq, lastTweet.tweetId , arr[2], arr[3]-1});
				}          
			}
			return result;
		}

		public void follow(int followerId, int followeeId) {
			if(followmap.containsKey(followerId)){
				followmap.get(followerId).add(followeeId);
			}else{
				Set<Integer> set = new HashSet();
				set.add(followeeId);
				followmap.put(followerId, set);
			}

		}

		public void unfollow(int followerId, int followeeId) {
			if(followmap.containsKey(followerId) && followmap.get(followerId).contains(followeeId))
				followmap.get(followerId).remove(followeeId);
		}
	}

	/**
	 * Your Twitter object will be instantiated and called as such:
	 * Twitter obj = new Twitter();
	 * obj.postTweet(userId,tweetId);
	 * List<Integer> param_2 = obj.getNewsFeed(userId);
	 * obj.follow(followerId,followeeId);
	 * obj.unfollow(followerId,followeeId);
	 */

}
