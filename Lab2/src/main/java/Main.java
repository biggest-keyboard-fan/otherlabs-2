import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    private static boolean debugLogging = false;
    static AtomicInteger totalResets = new AtomicInteger(0);

    public static void main(String[] args) {
        //https://stackoverflow.com/a/2965808
        //LinkedList is used to support remove() method
        //List array is used to support cross thread access to the list
        final List<String>[] words = new List[]{new LinkedList<>(Arrays.asList("first", "second", "third", "fourth"))};
        Thread[] threads = new Thread[4];
        for (int threadI = 0; threadI < 4; threadI++) {
            //Make threadI effectively final
            int threadIndex = threadI;
            threads[threadI] = new Thread(() -> {
                if(debugLogging) System.out.println("Entered thread "+threadIndex);
                while (true) {
                    try { Thread.sleep(10); } catch (InterruptedException e) { e.printStackTrace(); }
                    synchronized (words[0]){
                        if(words[0].size()-1 == threadIndex){
                            String word = words[0].get(0);
                            words[0].remove(0);
                            System.out.print(debugLogging ? Thread.currentThread() + "(" + threadIndex + "):" + word + "\n" : word);
                            if (words[0].size() == 0 && totalResets.incrementAndGet() < 3) {
                                if (debugLogging) System.out.println("Resetting list");
                                words[0] = new LinkedList<>(Arrays.asList("first", "second", "third", "fourth"));
                            }
                            else if (totalResets.get() == 3){
                                System.out.println("Threads are done working");
                                System.exit(0);
                            }
                        }
                    }
                }

            });
        }
        Arrays.stream(threads).forEach(Thread::start);
    }
}
