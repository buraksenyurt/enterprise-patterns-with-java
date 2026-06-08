package SOLID.SingleResponsibility.End;

import java.io.IOException;

public class Main {
    private static final String VALID_USER_JSON = "{\"name\": \"JohnDoe\", \"email\": \"john.doe@azon.com\", \"isActive\": true}";
    private static final String INVALID_USER_JSON = "{\"name\": \"JaneDoe\", \"email\": \"wrong.email\", \"isActive\": false}";

    public static void main(String[] args) throws IOException {
        System.out.println("Single Responsibility ilkesinin doğru uygulanmış hali.");
        System.out.println("Lütfen kaynak kodlara bakınız.");

        var controller = new SubscriberController();
        String response = controller.createSubscriber(VALID_USER_JSON);
        if (!response.equalsIgnoreCase("SUCCESS")) {
            System.err.println("Failed");
        }
        System.out.println("Valid JSON received response: " + response);
        response = controller.createSubscriber(INVALID_USER_JSON);
        if (!response.equalsIgnoreCase("ERROR")) {
            System.err.println("Failed");
        }
        System.out.println("Invalid JSON received response: " + response);
    }
}
