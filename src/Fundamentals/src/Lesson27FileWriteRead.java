import java.io.*;
import java.time.LocalDate;

public class Lesson27FileWriteRead {
    public static void run() {
        /*
         küçük boyutlu metinsel içerikler için FileWriter, büyük boyutlu metinsel içerikler için BufferedWriter,
         resim, ses, video gibi binary içerikler için FileOutputStream ve log mesajları gibi rapor içerikleri gibi
         yapısal veriler (structured data) için PrintWriter sınıflarının kullanılması tavsiye ediliyor.

         Text bazlı dosya içeriklerini satır satır okumak için BufferedReader ve FileReader'ın birlikte kullanılması
         öneriliyor.
         Binary dosyaları okurken FileInputStream kullanılıyor.

         Çok büyük dosyalarda (large files) okuma ve yazma işlemleri yapacaksak RandomAccessFile sınıfı kullanılıyor.
        */
        fileWriterSample();
        fileReaderSample();
    }

    static void fileReaderSample() {
        String file = "lesson27.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            System.out.println("Opening file " + file);
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException ex) {
            System.err.println("File not found " + ex.getMessage());
        } catch (IOException ex) {
            System.err.println("Error opening file: " + ex.getMessage());
        }
    }

    static void fileWriterSample() {
        String file = "lesson27.txt";
        String content = """
                This is a lesson 27.
                We are learning the Java programming language with samples.
                
                yay!
                """;

        try (FileWriter writer = new FileWriter(file)) {

            writer.write(content);
            writer.write("\n");
            writer.write(LocalDate.now().toString());
            writer.write("\n");
            writer.flush();

        } catch (FileNotFoundException ex) { // Hatalı bir path verildiğinde buraya düşmesi gerekir
            System.err.println(ex);
        } catch (IOException ex) { // Herhangi bir sebeple dosyaya yazamadığında buraya düşmesi beklenir
            System.err.println(ex.getMessage());
        }
    }
}
