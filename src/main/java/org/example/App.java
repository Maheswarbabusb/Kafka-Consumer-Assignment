package org.example;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.protocol.types.Field;

import java.time.Duration;
import java.util.Collection;
import java.util.Collections;
import java.util.Properties;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers","localhost:9092");
        properties.put("key.deserializer",
                "org.apache.kafka.common.serialization.StringDeserializer");

       properties.put("value.deserializer",
                "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("group.id", "truck-partitioned-group");

        KafkaConsumer<String, String> consumer=new KafkaConsumer<>(properties);

        consumer.subscribe(Collections.singletonList("Truck-Partitioned-Topic"));

        ConsumerRecords<String, String> poll = consumer.poll(Duration.ofSeconds(20));

        for(ConsumerRecord<String, String> kaf:poll){

            System.out.println(kaf.key());
            System.out.println(kaf.value());
            System.out.println(kaf.partition());
//                    getId());
//            System.out.println(kaf.value().getLongitude());
//            System.out.println(kaf.value().getLatitude());
        }

       // System.out.println( "Hello World!" );
    }
}
