package SOLID.DependencyInversion.Begin;

import java.io.IOException;

import SOLID.DependencyInversion.Common.Data;

public class Main {
    public static void main(String[] args) throws IOException {
        Data sampleData = new Data(1001, "SOLID ilkelerini öğreniyorum.");
        DataInspectorService dataInspectorService = new DataInspectorService();
        dataInspectorService.writeData(sampleData, "output.data");
    }
}
