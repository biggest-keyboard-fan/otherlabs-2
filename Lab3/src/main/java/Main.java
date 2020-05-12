import java.io.*;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    static volatile AtomicInteger
            activeThread = new AtomicInteger(0);
    static AtomicInteger writeCount = new AtomicInteger(0);
    static BufferedWriter writer;
    static Thread[] threads;
    static int waitTime = 30;
    public static void main(String[] args) throws IOException, InterruptedException {
        File writeFile = new File("write.txt");
        if(writeFile.exists()) writeFile.delete();
        writeFile.createNewFile();
        writer = new BufferedWriter(new FileWriter(writeFile));
        threads = new Thread[2];
        for (int i = 0; i < 2; i++) {
            //Create effectively final index variable
            int finalI = i;
            threads[i] = new Thread(()->{
                try {
                    for (int j = 0; j < 20; j++) {
                        String writeText = "\n" + writeCount.getAndIncrement();
                        System.out.println(finalI+" Writing to file "+new Date().getTime());
                        writer.write(writeText);
                        Thread.sleep(waitTime*2);
                    }
                }
                catch (Exception e) { e.printStackTrace(); }
            });
        }
        Arrays.stream(threads).forEach((t)->{
            try {
                t.start();
                Thread.sleep(waitTime);
            }catch (InterruptedException ignored){}
        });
        Thread.sleep(waitTime*20*2+500);
        try { writer.close(); }
        catch (IOException e) { e.printStackTrace(); }
    }
}
