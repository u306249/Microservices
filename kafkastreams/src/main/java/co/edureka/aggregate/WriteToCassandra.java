package co.edureka.aggregate;

import co.edureka.util.CassandraConnector;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.sql.Date;
import java.util.Arrays;
import java.util.Properties;

/**
 * Created on 22-Dec-17.
 */
public class WriteToCassandra
{
    public static void main(String[] args)
    {
        Properties props = new Properties();
        props.put("bootstrap.servers", "192.168.56.101:9102");
        props.put("group.id", "grp-1");
        props.put("enable.auto.commit", "true");
        props.put("auto.commit.interval.ms", "1000");
        props.put("session.timeout.ms", "30000");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.LongDeserializer");
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);

        final CassandraConnector client = new CassandraConnector();
        client.connect("192.168.56.101", 9042);

        consumer.subscribe(Arrays.asList("aggregated-topic"));
        while (true)
        {
            ConsumerRecords<String, String> records = consumer.poll(1000);
            for (ConsumerRecord<String, String> record : records)
            {
                String[] key = record.key().split("::");
                client.getSession().execute("INSERT INTO edureka.android_ios (time,category, count) " +
                                "VALUES (?, ?, ?)", new Date(Long.parseLong(key[0])),key[1],record.value());
            }
        }

    }
}
