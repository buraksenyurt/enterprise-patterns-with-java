package SOLID.SingleResponsibility.End;

import java.io.IOException;

import SOLID.SingleResponsibility.Common.Subscriber;

public class SubscriberController {
    private SubscriberRepositoryService repositoryService = new SubscriberRepositoryService();
    private SubscriberMapper mapper = new SubscriberMapper();
    
    public String createSubscriber(String jsonValue) throws IOException {
        Subscriber subscriber = mapper.mapFromJson(jsonValue);
        SubscriberValidator validator = new SubscriberValidator();
        boolean isValid = validator.validate(subscriber);
        
        if(!isValid) {
            return "ERROR";
        }

        repositoryService.save(subscriber);
        
        return "SUCCESS";
    }    
}
