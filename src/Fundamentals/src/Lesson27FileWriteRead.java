import javax.sound.sampled.*;
import java.io.*;
import java.time.LocalDate;
import java.util.Scanner;

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
        playWavSample();
    }

    static void playWavSample() {
        String filePath = "Supercar Engine Revving.wav";
        File file = new File(filePath);

        try (
                Scanner input = new Scanner(System.in);
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file)
        ) {

            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            String userResponse = "";
            String message = """
                    Press P to play audio,
                    Press S to stop audio,
                    Press R to reset audio,
                    Press Q to quit
                    
                    What is your choice->
                    """;
            while (!userResponse.equals("q")) {

                System.out.println(message);
                userResponse = input.nextLine().toLowerCase();

                switch (userResponse) {
                    case "s" -> clip.stop();
                    case "r" -> clip.setMicrosecondPosition(0);
                    case "p" -> clip.start();
                    case "q" -> clip.close();
                    default -> System.out.println("Wrong choice");
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found: " + ex.getMessage());
        } catch (IOException | UnsupportedAudioFileException | LineUnavailableException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Goodbye!");
        }
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
