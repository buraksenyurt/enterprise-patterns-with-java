package SOLID.SingleResponsibility.End;

import java.io.IOException;

import SOLID.SingleResponsibility.Common.ObjectMapper;
import SOLID.SingleResponsibility.Common.Subscriber;

public class SubscriberMapper {
    public Subscriber mapFromJson(String jsonValue) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(jsonValue, Subscriber.class);
    }
}
