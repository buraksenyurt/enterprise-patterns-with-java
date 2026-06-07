import java.util.HashMap;

public class Lesson32Hashmap {
    public static void run() {
        HashMap<String, String> container = new HashMap<>();

        container.put("IStorageService", "AwsS3StorageService");
        container.put("ILogger", "MockLogger");
        container.put("IDataContext", "AdventureWorksDbContext");
        container.put("ILogger", "SerilogConsoleLogger"); // Override

        System.out.println(container);

        System.out.println(container.get("ILogger"));

        if (container.containsKey("ILogger")) {
            System.out.println("There is a logger in DI Container");
        } else {
            System.out.println("There is no registered logger component");
        }

        System.out.println("is this container has a concrete logger spec:" + container.containsValue("MockLogger"));

        for (String key : container.keySet()) {
            System.out.println(key + " " + container.get(key));
        }
    }
}
