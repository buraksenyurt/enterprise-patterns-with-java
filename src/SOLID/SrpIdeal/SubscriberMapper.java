package SOLID.SrpIdeal;

import java.io.IOException;

import SOLID.SrpCommon.ObjectMapper;
import SOLID.SrpCommon.Subscriber;

public class SubscriberMapper {
    public Subscriber mapFromJson(String jsonValue) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(jsonValue, Subscriber.class);
    }
}
