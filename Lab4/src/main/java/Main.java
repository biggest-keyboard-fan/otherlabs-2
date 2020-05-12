import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicLong;

public class Main {
    static File file;
    static Thread readThread,writeThread;
    static int waitMs = 50;
    static AtomicLong lastAction = new AtomicLong(System.currentTimeMillis());
    public static void main(String[] args) throws Exception {

        file = new File("write.txt");
        if(file.exists()) file.delete();
        file.createNewFile();

        readThread = new Thread(()->{
            try {
                for (int i = 0; i < 5; i++) {
                    try (Scanner scanner = new Scanner(new FileInputStream(file)).useDelimiter("\\Z")) {
                        System.out.println("Reading: "+(scanner.hasNext() ? scanner.next() : "File is empty"));
                        System.out.println(" "+(lastAction.getAndSet(System.currentTimeMillis()) - System.currentTimeMillis()));
                    }
                    Thread.sleep(waitMs * 2);
                }
            }catch (Exception e){e.printStackTrace();}
        });
        writeThread = new Thread(()->{
            int count = 0;
            try{
                for (int i = 0; i < 5; i++) {
                    try(FileWriter writer = new FileWriter(file)){
                        writer.write(count++ +"");
                        System.out.println("Writing");
                        System.out.println(" "+(lastAction.getAndSet(System.currentTimeMillis()) - System.currentTimeMillis()));
                    }
                    Thread.sleep(waitMs*2);
                }
            }catch (Exception e){e.printStackTrace();}
        });

        writeThread.start();
        Thread.sleep(waitMs);
        readThread.start();
    }
}
