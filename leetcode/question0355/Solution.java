package leetcode.question0355;

import org.junit.jupiter.api.Test;

public class Solution {

    @Test
    void test() {
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 5); // 用户 1 发送了一条新推文 (用户 id = 1, 推文 id = 5)
        twitter.postTweet(1, 7); // 用户 1 发送了一条新推文 (用户 id = 1, 推文 id = 7)
        twitter.postTweet(1, 8); // 用户 1 发送了一条新推文 (用户 id = 1, 推文 id = 8)
        twitter.postTweet(1, 9); // 用户 1 发送了一条新推文 (用户 id = 1, 推文 id = 9)
        twitter.getNewsFeed(1);  // 用户 1 的获取推文应当返回一个列表，其中包含一个 id 为 5 的推文
        twitter.follow(1, 2);    // 用户 1 关注了用户 2
        twitter.postTweet(2, 6); // 用户 2 发送了一个新推文 (推文 id = 6)
        twitter.getNewsFeed(1);  // 用户 1 的获取推文应当返回一个列表，其中包含两个推文，id 分别为 -> [6, 5] 。推文 id 6 应当在推文 id 5 之前，因为它是在 5 之后发送的
        twitter.unfollow(1, 2);  // 用户 1 取消关注了用户 2
        twitter.getNewsFeed(1);  // 用户 1 获取推文应当返回一个列表，其中包含一个 id 为 5 的推文。因为用户 1 已经不再关注用户 2
    }
}
