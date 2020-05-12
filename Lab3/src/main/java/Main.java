import java.io.*;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    static volatile AtomicInteger
            activeThread = new AtomicInteger(0);
    static AtomicInteger writeCount = new AtomicInteger(0);
    public static void main(String[] args) throws IOException {
        File writeFile = new File("write.txt");
        if(writeFile.exists()) writeFile.delete();
        writeFile.createNewFile();
        //TODO: create & clear file on start
        Thread[] threads = new Thread[2];
        for (int i = 0; i < 2; i++) {
            //Create effectively final index variable
            int finalI = i;
            threads[i] = new Thread(()->{
                while (true){
                    try {
                        Thread.sleep(30);
                        if (activeThread.get() == finalI) {
                            if (activeThread.get() == -1) break;
                            String fileContent;
                            try (Scanner scanner = new Scanner(new FileInputStream(writeFile)).useDelimiter("\\Z")) {
                                fileContent = scanner.hasNext() ? scanner.next() : "";
                            }
                            try (FileWriter writer = new FileWriter(writeFile);) {
                                String writeText = fileContent + "\n" + writeCount.get();
                                System.out.println(finalI+" Writing to file");
                                writer.write(writeText);
                            }
                            activeThread.set(finalI == 0 ? 1 : 0);
                            if (writeCount.incrementAndGet() == 20) activeThread.set(-1);
                    }
                    }
                    catch (Exception e) { e.printStackTrace(); }
                }
            });
        }
        Arrays.stream(threads).forEach(Thread::start);
    }
}
