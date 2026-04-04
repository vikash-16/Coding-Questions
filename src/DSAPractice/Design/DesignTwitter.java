package DSAPractice.Design;

import java.util.*;

public class DesignTwitter {
    public static void main(String[] args) {


        /*["Twitter","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","follow","follow","follow","follow","follow","follow","follow","follow","follow","follow","follow","follow","getNewsFeed","getNewsFeed","getNewsFeed","getNewsFeed","getNewsFeed"]
[[],[1,6765],[5,671],[3,2868],[4,8148],[4,386],[3,6673],[3,7946],[3,1445],[4,4822],[1,3781],[4,9038],[1,9643],[3,5917],[2,8847],[1,3],[1,4],[4,2],[4,1],[3,2],[3,5],[3,1],[2,3],[2,1],[2,5],[5,1],[5,2],[1],[2],[3],[4],[5]]*/
        DesignTwitter designTwitter = new DesignTwitter();
        designTwitter.postTweet(1, 6765);
        designTwitter.postTweet(5, 671);
        designTwitter.postTweet(3, 2868);
        designTwitter.postTweet(4, 8148);
        designTwitter.postTweet(4, 386);
        designTwitter.postTweet(3, 6673);
        designTwitter.postTweet(3, 7946);
        designTwitter.postTweet(3, 1445);
        designTwitter.postTweet(4, 4822);
        designTwitter.postTweet(1, 3781);
        designTwitter.postTweet(4, 9038);
        designTwitter.postTweet(1, 9643);
        designTwitter.postTweet(3, 5917);
        designTwitter.postTweet(2, 8847);

        designTwitter.follow(1, 3);
        designTwitter.follow(1, 4);
        designTwitter.follow(4, 2);
        designTwitter.follow(4, 1);
        designTwitter.follow(3, 2);
        designTwitter.follow(3, 5);
        designTwitter.follow(3, 1);
        designTwitter.follow(2, 3);
        designTwitter.follow(2, 1);
        designTwitter.follow(2, 5);
        designTwitter.follow(5, 1);
        designTwitter.follow(5, 2);
        System.out.println(designTwitter.getNewsFeed(1));
        System.out.println(designTwitter.getNewsFeed(2));
        System.out.println(designTwitter.getNewsFeed(3));
        System.out.println(designTwitter.getNewsFeed(4));
        System.out.println(designTwitter.getNewsFeed(5));

    }

    Map<Integer, ArrayDeque<Integer[]>> userFeed = new HashMap<>();
    Map<Integer, Set<Integer>> following = new HashMap<>();
    Map<Integer, Set<Integer>> followers = new HashMap<>();
    Map<Integer, ArrayDeque<Integer[]>> personalFeed = new HashMap<>();
    HashSet<String>uniqueFollow = new HashSet<>();
    Integer time = 0;

    public void postTweet(int userId, int tweetId) {
        time++;
        personalFeed.computeIfAbsent(userId, k -> new ArrayDeque<>()).add(new Integer[]{tweetId, time});
        addtweet(userId, tweetId, time);
        if (followers.containsKey(userId)) {
            for (Integer follower : followers.get(userId)) {
                addtweet(follower, tweetId, time);
            }
        }
    }

    private void addtweet(int userId, int tweetId, Integer time) {
        if (userFeed.containsKey(userId)) {
            ArrayDeque<Integer[]> queue = userFeed.getOrDefault(userId, new ArrayDeque<>());
            if (queue.size() < 10) {
                queue.addLast(new Integer[]{tweetId, time});
            } else {
                queue.removeFirst();
                queue.addLast(new Integer[]{tweetId, time});
            }
        } else {
            userFeed.computeIfAbsent(userId, k -> new ArrayDeque<>()).add(new Integer[]{tweetId, time});
        }
    }

    public List<Integer> getNewsFeed(int userId) {
        ArrayDeque<Integer[]> feed = userFeed.get(userId);
        if (feed != null && !feed.isEmpty()) {
            ArrayList<Integer[]> userFeed = new ArrayList<>(feed);
            userFeed.sort((a, b) -> a[1] - b[1]);
            Collections.reverse(userFeed);
            return userFeed.stream().map(a -> a[0]).toList().subList(0, Math.min(10, userFeed.size()));
        }
        return new ArrayList<>();
    }

    public void follow(int followerId, int followeeId) {
        String string = followerId + "_" + followeeId;
        if(!uniqueFollow.contains(string)) {
            following.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
            followers.computeIfAbsent(followeeId, k -> new HashSet<>()).add(followerId);
            ArrayDeque<Integer[]> integers = personalFeed.getOrDefault(followeeId, new ArrayDeque<>());
            ArrayDeque<Integer[]> integers1 = userFeed.getOrDefault(followerId, new ArrayDeque<>());
            integers1.addAll(integers);
            userFeed.put(followerId, integers1);
            uniqueFollow.add(string);
        }
    }

    public void unfollow(int followerId, int followeeId) {
        Set<Integer> followeeIdList = following.getOrDefault(followerId, new HashSet<>());
        followeeIdList.remove(followeeId);
        Set<Integer> followerList = followers.getOrDefault(followeeId, new HashSet<>());
        followerList.remove(followerId);
        ArrayDeque<Integer[]> followeefeed = personalFeed.getOrDefault(followeeId, new ArrayDeque<>());
        ArrayDeque<Integer[]> integers = userFeed.getOrDefault(followerId, new ArrayDeque<>());
        ArrayDeque<Integer[]> temp = new ArrayDeque<>();
        for (Integer[] a : integers) {
            boolean isMatch = false;
            for (Integer[] b : followeefeed) {
                if (a[0] == b[0]) {
                    isMatch = true;
                    break;
                }
            }
            if (!isMatch) {
                temp.add(a);
            }
        }
//        integers.removeAll(followeefeed);
        userFeed.replace(followerId, temp);
    }
}
