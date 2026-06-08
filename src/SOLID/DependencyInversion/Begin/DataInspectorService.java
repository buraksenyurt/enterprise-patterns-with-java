package SOLID.DependencyInversion.Begin;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;

import SOLID.DependencyInversion.Common.Data;

public class DataInspectorService {
    public void writeData(Data data, String destination) throws IOException {
        JsonFormatter jsonFormatter = new JsonFormatter();
        try (PrintWriter writer = new PrintWriter(new FileWriter(destination))) {
            String json = jsonFormatter.format(data);
            writer.write(json);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
