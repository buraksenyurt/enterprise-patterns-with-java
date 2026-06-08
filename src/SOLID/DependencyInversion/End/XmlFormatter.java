package SOLID.DependencyInversion.End;

public class XmlFormatter implements Formatter {

    @Override
    public String format(SOLID.DependencyInversion.Common.Data data) {
        // Burada gerçeken XML formatlama işlemi yapılan bir kütüphane kullandığımızı
        // varsayalım.
        String xml = "<data>" +
                "<id>" + data.getId() + "</id>" +
                "<content>" + data.getContent() + "</content>" +
                "<createdAt>" + data.getCreatedAt() + "</createdAt>" +
                "</data>";
        return xml;
    }

}
