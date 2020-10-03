//
//import java.util.*;
//import java.util.concurrent.Callable;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//import java.util.concurrent.atomic.AtomicInteger;
//
///**
// * // This is the HtmlParser's API interface.
// * // You should not implement it, or speculate about its implementation
// * interface HtmlParser {
// *     public List<String> getUrls(String url) {}
// * }
// */
//class Solution {
//
//    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
//        return new Crawler(startUrl, htmlParser).getUrls();
//    }
//
//}
//
//class Crawler implements Runnable{
//
//    private ExecutorService executor = Executors.newFixedThreadPool(10000);
//    private HashSet<String> urls;
//    private String startUrl;
//    private HtmlParser htmlParser;
//    private Object lockOne;
//    private Object lockTwo;
//    // private AtomicInteger activeCrawlingCount;
//    private int activeCrawlingCountInt;
//
//
//    public Crawler (String startUrl, HtmlParser htmlParser) {
//        this.startUrl = startUrl;
//        this.htmlParser = htmlParser;
//        this.urls = new HashSet<>();
//        this.activeCrawlingCountInt = 1;
//        this.lockOne = new Object();
//        this.lockTwo = new Object();
//        urls.add(startUrl);
//    }
//
//    public List<String> getUrls() {
//        crawl(startUrl);
//        awaitCrawlingDone();
//        executor.shutdownNow();
//        return new ArrayList(urls);
//    }
//
//    private void crawl(String url) {
//        //System.out.println("crawl  " + url +  "  start");
//        List<String> nextUrls = htmlParser.getUrls(url);
//        for (String nextUrl: nextUrls) {
//            synchronized (this) {
//                if (getHostname(startUrl).equals(getHostname(nextUrl)) && !urls.contains(nextUrl)) {
//                    urls.add(nextUrl);
//                    activeCrawlingCountInt++;
//                    //new Thread(() -> crawl(nextUrl)).start();
//
//                    executor.execute(() -> crawl(nextUrl));
//                }
//
//
//            }
//        }
//        //System.out.println("crawl  " + url +  "  end");
//        synchronized (this) {
//            //System.out.println("activeCrawlingCountInt：" + activeCrawlingCountInt);
//            activeCrawlingCountInt--;
//            if (activeCrawlingCountInt == 0) {
//                lockTwo.notify();
//            }
//        }
//    }
//
//    private void awaitCrawlingDone() {
//        synchronized (this) {
//            while (activeCrawlingCountInt > 0){
//                try {
//                    // System.out.println("before wait");
//                    wait();
//                    // System.out.println("after wait");
//                } catch (InterruptedException ex) {
//                    System.out.println("Unexpected interruption encountered.");
//                }
//            }
//        }
//    }
//
//    private String getHostname(String Url) {
//        String[] ss = Url.split("/");
//        return ss[2];
//    }
//
//    @Override
//    public void run() {
//        //System.out.println("crawl  " + url +  "  start");
//        List<String> nextUrls = htmlParser.getUrls(url);
//        for (String nextUrl: nextUrls) {
//            synchronized (this) {
//                if (getHostname(startUrl).equals(getHostname(nextUrl)) && !urls.contains(nextUrl)) {
//                    urls.add(nextUrl);
//                    activeCrawlingCountInt++;
//                    //new Thread(() -> crawl(nextUrl)).start();
//
//                    executor.execute(() -> crawl(nextUrl));
//                }
//
//
//            }
//        }
//        //System.out.println("crawl  " + url +  "  end");
//        synchronized (this) {
//            //System.out.println("activeCrawlingCountInt：" + activeCrawlingCountInt);
//            activeCrawlingCountInt--;
//            if (activeCrawlingCountInt == 0) {
//                lockTwo.notify();
//            }
//        }
//    }
//}
//
///**
// * // This is the HtmlParser's API interface.
// * // You should not implement it, or speculate about its implementation
// * interface HtmlParser {
// *     public List<String> getUrls(String url) {}
// * }
// */
//
//class Solution {
//    public void crawl() {
//        OUTER_LOOP: while(true) {
//            String nextUrl;
//            synchronized(this) {
//                while(queue.isEmpty()) {
//                    if(workingThreads==0 && queue.isEmpty()) { //<======= exit condition
//                        break;
//                    }
//                    try {
//                        wait();
//                    } catch(InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//                nextUrl = queue.poll();
//                workingThreads++;
//            }
//            List<String> urls=getUrls(nextUrl);
//
//            synchronized(this) {
//                for(String newUrl: urls) {
//                    if(!visited.contains(newUrl)) {
//                        queue.offer(newUrl);
//                        visited.add(newUrl);
//                    }
//                }
//                workingThreads--;
//                notifyAll();
//            }
//        }
//    }
////    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
////        HashSet<String> set = new HashSet();
////        List<String> results = new LinkedList<>();
////        Queue<String> urls = new ArrayDeque<>();
////
////        set.add(startUrl);
////        urls.add(startUrl);
////
////        while (!urls.isEmpty()){
////            String currentUrl = urls.poll();
////            results.add(currentUrl);
////
////            for (String url : htmlParser.getUrls(currentUrl)){
////                if (!set.contains(url) && getHostname(startUrl).equals(getHostname(url))){
////                    set.add(url);
////                    urls.add(url);
////                }
////            }
////        }
////        return results;
////    }
//
//    private String getHostname(String Url) {
//        String[] ss = Url.split("/");
//        return ss[2];
//    }
//}