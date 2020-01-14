package com.example.KafkaProject.service;

import com.example.KafkaProject.entity.Employee;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Properties;
import java.io.IOException;

public class Producer
{
    private String TopicName="users";
    public static void produce(String brokers, String topicName,Employee employee) throws IOException
    {

        // Set properties used to configure the producer
        Properties properties = new Properties();
        // Set the brokers (bootstrap servers)
        properties.setProperty("bootstrap.servers", brokers);
        // Set how to serialize key/value pairs
        properties.setProperty("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
        properties.setProperty("value.serializer","org.apache.kafka.connect.json.JsonSerializer");
        // specify the protocol for SSL Encryption This is needed for secure clusters
        //properties.setProperty(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, "SASL_PLAINTEXT");

        KafkaProducer producer = new KafkaProducer(properties);
        ObjectMapper objectMapper = new ObjectMapper();

        try {


            JsonNode jsonNode = objectMapper.valueToTree(employee);
            ProducerRecord rec = new ProducerRecord(topicName, jsonNode);
            producer.send(rec);

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            producer.close();
        }
    }
}