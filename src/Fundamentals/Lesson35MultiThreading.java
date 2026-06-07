public class Lesson35MultiThreading {
    public static void run() {

        String[] logFiles = { "WarehouseLogs.log", "SalesLogs.log", "InventoryLogs.log","SystemLogs.log" };

        for (String logFile : logFiles) {
            Thread logParserThread = new Thread(new LogParserRunnable(logFile));
            logParserThread.start();
        }

        System.out.println("Main thread sonlanıyor. Log dosyaları ayrıştırılmaya devam ediyor...Bitene kadar buradayız.");
    }
}
