package SOLID.SrpIdeal;

import SOLID.SrpCommon.Database;
import SOLID.SrpCommon.Subscriber;

public class SubscriberRepositoryService {
    private Database db = new Database();

    public void save(Subscriber subscriber) {
        db.save(subscriber);
    }
}
