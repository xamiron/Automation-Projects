package utility;

public class threadSleep {
    public static final long waitTime = DataReader.getIntValue("loginOtpPageWaitTime", "config");

    public static void threadsleep() {
        try {
            Thread.sleep(waitTime);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } // Random delay between 2-5 seconds

    }

    public static void threadsleep(long waittime) {
        try {
            Thread.sleep(waittime);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } // Random delay between 2-5 seconds

    }

}