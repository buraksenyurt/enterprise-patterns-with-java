package SOLID.DependencyInversion.End;

import java.io.IOException;
import java.io.PrintWriter;

import SOLID.DependencyInversion.Common.Data;

public class DataInspectorService {
    public void writeData(Data data, Formatter formatter, PrintWriter writer) throws IOException {

        String formattedData = formatter.format(data);
        writer.println(formattedData);
        writer.flush();
    }
}
