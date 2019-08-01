package co.edureka.twitter;

import co.edureka.kafka.KafkaPublisher;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;

/**
 * Created on 30-03-2017.
 */
public class TweetListener implements StatusListener
{

    @Override
    public void onStatus(Status status)
    {
        String tweet = status.getText().toLowerCase();
        String userId = status.getUser().getScreenName();
        if(tweet.contains("android") || tweet.contains("ios"))
        {
            System.out.println("Tweet>>> @" + userId + " - " + tweet);
            KafkaPublisher.send(userId, tweet);
        }
    }

    @Override
    public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice)
    {

    }

    @Override
    public void onTrackLimitationNotice(int i)
    {

    }

    @Override
    public void onScrubGeo(long l, long l1)
    {

    }

    @Override
    public void onStallWarning(StallWarning stallWarning)
    {

    }

    @Override
    public void onException(Exception e)
    {

    }
}