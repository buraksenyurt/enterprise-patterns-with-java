package SOLID.DependencyInversion.End;

public class CsvFormatter implements Formatter {

    private char separator;

    public CsvFormatter() {
        this.separator = ',';
    }

    public CsvFormatter(char separator) {
        this.separator = separator;
    }

    @Override
    public String format(SOLID.DependencyInversion.Common.Data data) {
        // Burada gerçeken CSV formatlama işlemi yapılan bir kütüphane kullandığımızı
        // varsayalım.
        String csv = data.getId() + separator + data.getContent() + separator + data.getCreatedAt();
        return csv;
    }

}
