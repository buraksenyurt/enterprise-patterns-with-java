package SOLID.SingleResponsibility.End;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import SOLID.SingleResponsibility.Common.Subscriber;

public class SubscriberValidator {

    public boolean validate(Subscriber subscriber) {
        return isValidSubscriber(subscriber);
    }

    private boolean isValidSubscriber(Subscriber subscriber) {
        if (!isExist(subscriber.getName())) {
            return false;
        }
        subscriber.setName(subscriber.getName().trim());

        if (!isValidAlphaNumeric(subscriber.getName())) {
            return false;
        }
        if (subscriber.getEmail() == null || subscriber.getEmail().trim().length() == 0) {
            return false;
        }
        subscriber.setEmail(subscriber.getEmail().trim());
        if (!isValidEmail(subscriber.getEmail())) {
            return false;
        }
        return true;
    }

    private boolean isExist(String value) {
        return value != null && value.trim().length() > 0;
    }

    private boolean isValidAlphaNumeric(String value) {
        Pattern pattern = Pattern.compile("[^A-Za-z0-9]");
        Matcher matcher = pattern.matcher(value);
        return !matcher.find();
    }

    private boolean isValidEmail(String value) {
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher matcher = pattern.matcher(value);
        return matcher.find();
    }

}
