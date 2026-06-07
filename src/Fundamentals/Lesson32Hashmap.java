import java.util.HashMap;

public class Lesson32Hashmap {
    public static void run() {
        HashMap<String, String> container = new HashMap<>();

        container.put("IStorageService", "AwsS3StorageService");
        container.put("ILogger", "MockLogger");
        container.put("IDataContext", "AdventureWorksDbContext");
        container.put("ILogger", "SerilogConsoleLogger"); // Daha önce tanımladığımız ILogger'ı yeni Value ile eziyoruz.

        System.out.println(container);

        System.out.println(container.get("ILogger"));

        if (container.containsKey("ILogger")) {
            System.out.println("DI Container içerisinde ILogger bileşeni kayıtlı: " + container.get("ILogger"));
        } else {
            System.out.println("DI Container içerisinde ILogger bileşeni kayıtlı değil.");
        }

        System.out.println("DI Container içerisinde MockLogger bileşeni kayıtlı mı: " + container.containsValue("MockLogger"));

        for (String key : container.keySet()) {
            System.out.println(key + " " + container.get(key));
        }
    }
}
