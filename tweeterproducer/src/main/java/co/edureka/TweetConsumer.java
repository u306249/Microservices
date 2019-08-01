package co.edureka;

import co.edureka.twitter.TweetListener;
import twitter4j.*;


/**
 * Created on 30/3/17.
 */
public class TweetConsumer
{
    public static void main(String[] args) throws TwitterException
    {
        TwitterStream twitterStream = new TwitterStreamFactory().getInstance();

        // Adding Listener to consume tweets
        StatusListener listener = new TweetListener();
        twitterStream.addListener(listener);

        // filtering tweets that has content "android" or "iphone"
        FilterQuery filterQuery = new FilterQuery();
        filterQuery.track("android","ios");

        // applying the filter
        twitterStream.filter(filterQuery);
    }
}