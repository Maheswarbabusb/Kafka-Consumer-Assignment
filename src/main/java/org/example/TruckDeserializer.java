package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Deserializer;

import java.io.IOException;

public class TruckDeserializer implements Deserializer<Truck> {

    @Override
    public Truck deserialize(String s, byte[] bytes) {

        Truck truck=null;
        String string=new String(bytes);
        ObjectMapper objectMapper=new ObjectMapper();
        try {
            truck= objectMapper.readValue(bytes, Truck.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return truck;

    }
}
