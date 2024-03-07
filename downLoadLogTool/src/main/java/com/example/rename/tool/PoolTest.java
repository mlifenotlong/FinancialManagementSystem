package com.example.rename.tool;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.concurrent.*;

public class PoolTest {

    public static void run(String serverMessage, HttpSession session,String filename,String servername) {
        //poolTest
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(
                8,
                50,
                3,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()

        );

        try {
            for (int i = 0; i < 10; i++) {

                int finalI = i;
                poolExecutor.execute(() -> {
                    try {
                        //testRun
                        GetLog.runit(serverMessage,session,filename,servername);
//                        TimeUnit.SECONDS.sleep(1);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    printInfo(poolExecutor, finalI + "");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            poolExecutor.shutdown();
        }
    }

    public static void printInfo(ThreadPoolExecutor executor, String name) {
        BlockingQueue<Runnable> queue = executor.getQueue();
        System.out.println(Thread.currentThread().getName() + "--->" + name + "<----" +
                " core: " + executor.getCorePoolSize() +
                " threadCount: " + executor.getActiveCount() +
                " MaxThreadSize: " + executor.getMaximumPoolSize() +
                " TaskCount " + executor.getCompletedTaskCount() +
                " QueueSize: " + (queue.size() + queue.remainingCapacity()) +
                " now QueueSize " + queue.size() +
                " Queue RemainSize: " + queue.remainingCapacity()
        );
    }

}
