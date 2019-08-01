package co.edureka.aggregate;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.*;

import java.util.Arrays;
import java.util.Date;
import java.util.Properties;
import java.util.stream.Collectors;

/**
 * Created on 21-Dec-17.
 */
public class AnalyseTrend
{
    public static void main(String[] args) throws InterruptedException {
        Properties props = new Properties();
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, "streams-example");
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.56.101:9101");
        props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG,Serdes.String().getClass().getName());
        props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG,Serdes.String().getClass().getName());
        props.put(StreamsConfig.COMMIT_INTERVAL_MS_CONFIG,"1000");

        KStreamBuilder  builder = new KStreamBuilder ();
        KStream<String, String> source = builder.stream("my-first-topic");

        source.selectKey((k,v) -> v.contains("android")?"android":"ios")
              .groupByKey()
              .count(TimeWindows.of(60000))
              .toStream((window,val)-> window.window().start()+ "::"+ window.key())
              .map((k,v) -> KeyValue.pair(k,v))
                .to(new Serdes.StringSerde(),new Serdes.LongSerde(),"aggregated-topic");

        KafkaStreams streams = new KafkaStreams(builder,props);
        streams.cleanUp();
        streams.start();
        Runtime.getRuntime().addShutdownHook(new Thread(streams::close));
    }
}