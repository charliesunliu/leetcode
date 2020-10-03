//import java.util.HashMap;
//
//public class ReadWriteLock {
//
//
//    private Thread writer = null;
//    private HashMap<Thread, Integer> reader = new HashMap<>();
//    private int writerWaiting = 0;
//    private int writerAccess = 0;
//
//    public synchronized void lockRead() throws InterruptedException{
//        Thread currentT = Thread.currentThread();
//        while (! canRead(currentT)){
//            wait();
//        }
//        reader.put(currentT, reader.getOrDefault(currentT, 0) + 1);
//    }
//
//    private synchronized boolean canRead(Thread thread){
//        if (isWriter(thread)) return true;
//        if (hasWriter(thread)) return false;
//        if (isReader(thread)) return true;
//        if (writerWaiting > 0) return false;
//        return true;
//    }
//
//    public synchronized void unlockRead(){
//        Thread currenT = Thread.currentThread();
//        reader.put(currenT, reader.get(currenT) - 1);
//        if (reader.get(currenT) == 0){
//            reader.remove(currenT);
//        }
//        notifyAll();
//    }
//
//    public synchronized void lockWrite()throws InterruptedException{
//        Thread currentT = Thread.currentThread();
//        writerWaiting++;
//        while (!canWrite(currentT)){
//            wait();
//        }
//        writerWaiting--;
//        writerAccess++;
//        writer = currentT;
//    }
//
//    private synchronized boolean canWrite(Thread thread){
//        if (writer == thread) return true;
//        if (reader.size() == 1 && reader.get(thread) != null) return true;
//        if (reader.size() > 1) return false;
//        if (writer != null) return false;
//        return true;
//    }
//
//    public synchronized void unlockWrite(){
//        writerAccess--;
//        if (writerAccess == 0){
//            writer = null;
//        }
//        notifyAll();
//    }
//
//}
