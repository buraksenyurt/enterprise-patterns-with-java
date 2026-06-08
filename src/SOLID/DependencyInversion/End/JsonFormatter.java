package SOLID.DependencyInversion.End;

import SOLID.DependencyInversion.Common.Data;

public class JsonFormatter implements Formatter {
    @Override
    public String format(Data data) {
        // Burada gerçeken JSON formatlama işlemi yapılan bir kütüphane kullandığımızı
        // varsayalım.
        String json = "{ \"id\": " + data.getId() + ", \"content\": \"" + data.getContent() + "\", \"createdAt\": \""
                + data.getCreatedAt() + "\" }";
        return json;
    }

}
