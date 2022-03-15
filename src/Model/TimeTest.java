package Model;

import java.time.Duration;
import java.time.Instant;

public class TimeTest {
    static final long MEGABYTE_FACTOR = 1024L * 1024L;

    public static long testTime(Runnable exp) {
        Instant debut = Instant.now();
        exp.run();
        Instant fin = Instant.now();
        Duration timeElapsed = Duration.between(debut, fin);
        System.out.println(timeElapsed.toMillis());
        return timeElapsed.toMillis();
    }

    public static long testTimeAverage(Runnable exp, int nbTry) {
        long average = 0;
        for (int i = 0; i < nbTry; i++) {
            average += testTime(exp);
            exp.reset();
        }


        return average / nbTry;
    }

    public static double getMemoryUsage(){
        return bytesToMiB(getUsedMemory());
    }

    public static long getTotalMemory() {
        return Runtime.getRuntime().totalMemory();
    }

    private static double bytesToMiB(long bytes) {
        return ((double) bytes / MEGABYTE_FACTOR);
    }

    public static long getMaxMemory() {
        return Runtime.getRuntime().maxMemory();
    }

    public static long getUsedMemory() {
        return getTotalMemory() - getFreeMemory();
    }


    public static long getFreeMemory() {
        return Runtime.getRuntime().freeMemory();
    }
}
