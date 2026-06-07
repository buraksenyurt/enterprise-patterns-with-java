package SOLID.SrpCommon;

import java.util.HashMap;
import java.util.Map;

public class Database {
    private static final Map<String, Subscriber> IN_MEMORY_STORAGE = new HashMap<>();

    public void save(Subscriber user) {
        synchronized (IN_MEMORY_STORAGE) {
            IN_MEMORY_STORAGE.put(user.getName(), user);
        }
    }

    public Subscriber getSubscriber(String name) {
        synchronized (IN_MEMORY_STORAGE) {
            return IN_MEMORY_STORAGE.get(name);
        }
    }
}
