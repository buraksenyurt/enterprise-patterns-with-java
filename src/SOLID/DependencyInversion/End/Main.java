package SOLID.DependencyInversion.End;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import SOLID.DependencyInversion.Common.Data;

public class Main {
    public static void main(String[] args) {
        System.out.println("Dependency Inversion Principle ideal bir şekilde uygulanmış hali:");
        System.out.println("Lütfen kod içeriğini inceleyin.");

        DataInspectorService dataInspectorService = new DataInspectorService();
        Data sampleData = new Data(1001, "SOLID ilkelerini öğreniyorum.");

        // Json formatında bir dosyaya yazdırmak istersek.
        try (PrintWriter writer = new PrintWriter(new FileWriter("output.json"))) {
            JsonFormatter jsonFormatter = new JsonFormatter();
            dataInspectorService.writeData(sampleData, jsonFormatter, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // CSV formatında bir dosyaya yazdırmak istersek.
        try (PrintWriter writer = new PrintWriter(new FileWriter("output.csv"))) {
            CsvFormatter csvFormatter = new CsvFormatter('|');
            dataInspectorService.writeData(sampleData, csvFormatter, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // XML formatında bir dosyaya yazdırmak istersek.
        try (PrintWriter writer = new PrintWriter(new FileWriter("output.xml"))) {
            XmlFormatter xmlFormatter = new XmlFormatter();
            dataInspectorService.writeData(sampleData, xmlFormatter, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // JSON çıktıyı terminal penceresine yazdırmak istersek.
        try (PrintWriter writer = new PrintWriter(System.out)) {
            JsonFormatter jsonFormatter = new JsonFormatter();
            dataInspectorService.writeData(sampleData, jsonFormatter, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
