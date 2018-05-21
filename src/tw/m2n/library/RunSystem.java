package tw.m2n.library;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import tw.m2n.library.model.Library;
import tw.m2n.library.model.Reader;

/**
 * @author moon
 *
 */
public class RunSystem {
    public static void main(String[] args) {
        Library lib = new Library();
        ScheduledExecutorService scheduled = Executors.newScheduledThreadPool(3);
        
        scheduled.scheduleAtFixedRate(new Reader(lib, "Uno"), 0, 1, TimeUnit.SECONDS);
        scheduled.scheduleAtFixedRate(new Reader(lib, "Two"), 0, 1, TimeUnit.SECONDS);
        scheduled.scheduleAtFixedRate(new Reader(lib, "San"), 0, 1, TimeUnit.SECONDS);
        
//        ExecutorService tp = Executors.newFixedThreadPool(3);
//        
//        tp.execute(new Reader(lib, "Uno"));
//        tp.execute(new Reader(lib, "Two"));
//        tp.execute(new Reader(lib, "San"));
    }
}
