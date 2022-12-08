package leetcode.question0355;

import java.util.*;

public class Twitter {

    private static int timestamp = 0;

    private static class Tweet {
        private int id;
        private int time;
        private Tweet next;

        public Tweet(int id, int time) {
            this.id = id;
            this.time = time;
        }
    }

    private static class User {
        private int id;
        private Set<Integer> followed;
        private Tweet head;

        public User(int userId) {
            followed = new HashSet<>();
            this.id = userId;
            this.follow(this.id);
        }

        private void follow(int userId) {
            followed.add(userId);
        }

        private void unfollow(int userId) {
            if (userId != this.id) {
                followed.remove(userId);
            }
        }

        private void post(int tweetId) {
            Tweet tweet = new Tweet(tweetId, timestamp++);
            tweet.next = head;
            head = tweet;
        }
    }

    private Map<Integer, User> key2User = new HashMap<>();

    public Twitter() {
    }

    public void postTweet(int userId, int tweetId) {
        if (!key2User.containsKey(userId)) {
            User user = new User(userId);
            user.post(tweetId);
            key2User.put(userId, user);
        } else {
            key2User.get(userId).post(tweetId);
        }
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        if (!key2User.containsKey(userId)) {
            return res;
        }

        Set<Integer> followed = key2User.get(userId).followed;
        PriorityQueue<Tweet> pq = new PriorityQueue<>(followed.size(), (a ,b) -> b.time - a.time);
        for (int followId : followed) {
            Tweet tweet = key2User.get(followId).head;
            if (tweet != null) {
                pq.add(tweet);
            }
        }
        while (!pq.isEmpty()) {
            if (res.size() == 10) {
                return res;
            }
            Tweet tweet = pq.poll();
            res.add(tweet.id);
            if (tweet.next != null) {
                pq.offer(tweet.next);
            }
        }

        return res;
    }

    public void follow(int followerId, int followeeId) {
        if (!key2User.containsKey(followerId)) {
            key2User.put(followerId, new User(followerId));
        }
        if (!key2User.containsKey(followeeId)) {
            key2User.put(followeeId, new User(followeeId));
        }
        key2User.get(followerId).follow(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (key2User.containsKey(followerId) && key2User.containsKey(followeeId)) {
            key2User.get(followerId).unfollow(followeeId);
        }
    }
}
