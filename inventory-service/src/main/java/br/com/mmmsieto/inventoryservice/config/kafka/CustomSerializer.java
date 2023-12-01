package br.com.mmmsieto.inventoryservice.config.kafka;


import br.com.mmmsieto.inventoryservice.adapters.out.message.SaleMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Serializer;
import org.hibernate.type.SerializationException;

public class CustomSerializer implements Serializer<SaleMessage> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public byte[] serialize(String s, SaleMessage saleMessage)  {
        try {
            if (saleMessage == null) {
                return null;
            }
            return objectMapper.writeValueAsBytes(saleMessage);

        } catch (Exception e) {
            throw new SerializationException("Error serializing value", e);
        }
    }

}