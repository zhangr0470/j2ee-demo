package com.j2ee.demo.main;

import java.util.concurrent.*;

/**
 * Created by rihai on 6/23/2017.
 */
public class ThreadPoolExceptionTest {
    public static class MyCallable implements Callable {
        private int flag = 0;
        public MyCallable(int flag) {
            this.flag = flag;
        }
        public Object call() throws Exception {
            if (this.flag == 0) {
                return "flag == 0";
            }
            else if (this.flag == 1) {
                try {
                    while (true) {
                        System.out.println("looping");
                        Thread.sleep(2000);
                    }
                } catch (InterruptedException e) {
                    System.out.println("Interrupted");
                }
                return false;
            }
            else {
                System.out.println("Bad flag value!");
                throw new Exception("Bad flag value!");
            }
        }

    }

    public static void main(String[] args) {

        MyCallable task0 = new MyCallable(0);
        MyCallable task1 = new MyCallable(1);
        MyCallable task2 = new MyCallable(2);

        ExecutorService es = Executors.newFixedThreadPool(3);
        try {
            Future future0 = es.submit(task0);
            System.out.println("task0: " + future0.get());

            Future future1 = es.submit(task1);
            Thread.sleep(5000);
            System.out.println("task1 cancelled: " + future1.cancel(true)); // 注意这时候Task在Sleep，是被Interrupted了

            Future future2 = es.submit(task2);
            Thread.sleep(20000);
            System.out.println("task2:get");
            System.out.println("task2: " + future2.get());

        } catch (ExecutionException e) {
            System.out.println("error");
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        es.shutdown();

        System.out.println("end");

    }
}
