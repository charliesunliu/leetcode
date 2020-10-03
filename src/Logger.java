import java.util.ArrayList;
import java.util.Arrays;

class Logger {
    private int lastNum;
    private ArrayList<String> queue;
    /** Initialize your data structure here. */

    public Logger() {
        lastNum = 0;
        queue = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            queue.add(null);
        }
    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
     If this method returns false, the message will not be printed.
     The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(timestamp - lastNum >= 10){
            lastNum = timestamp;
            for (int i = 0; i < 10; i++){
                queue.add(null);
            }
            queue.set(0, message);
            return true;
        }
        while(lastNum <= timestamp){
            lastNum++;
            queue.remove(queue.size() - 1);
            queue.add(null);
        }
        System.out.println(queue);
        
        for (String str : queue){
            if (str != null && str.equals(message)){
                return false;
            }
        }
        return true;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */