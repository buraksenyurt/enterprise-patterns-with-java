package SOLID.SingleResponsibility.End;

import SOLID.SingleResponsibility.Common.Database;
import SOLID.SingleResponsibility.Common.Subscriber;

public class SubscriberRepositoryService {
    private Database db = new Database();

    public void save(Subscriber subscriber) {
        db.save(subscriber);
    }
}
