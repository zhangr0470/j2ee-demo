package com.j2ee.demo.main;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Created by rihai on 6/22/2017.
 */
@Component("threadPoolTest")
public class ThreadPoolTest {

    @Resource
    private ThreadPoolTaskExecutor taskExecutor;

    public void start() {
        System.out.printf("start\n");
        List<Future<Long>> futureList = new ArrayList<Future<Long>>();
        for (int i = 0; i < 10; i++) {
            final int temp = i;
            Future<Long> future = taskExecutor.submit(new Callable<Long>() {
                public Long call() throws Exception {
                    //Thread.sleep(10000);
                    Long threadid = Thread.currentThread().getId();
                    System.out.printf(String.format("threadid:%s,param:%s\n", threadid, temp));
                    return threadid;
                }
            });
            futureList.add(future);
        }
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (Future<Long> future : futureList) {

            try {
                System.out.printf(future.get().toString());
                System.out.printf("\n");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("end\n");
    }
}
