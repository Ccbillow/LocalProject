package org.example.auz.concurrent;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CompletableFutureTest1 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println(Thread.currentThread().getName() + ", " + "start...");

        CompletableFuture<String> comboText = CompletableFuture.supplyAsync(() -> {
                    //可以注释掉做快速返回 start
                    try {
                        TimeUnit.SECONDS.sleep(3);
                    } catch (InterruptedException e) {
                        throw new IllegalStateException(e);
                    }
                    System.out.println(Thread.currentThread().getName() + ", " + "异步执行...");
                    //可以注释掉做快速返回 end
                    return "赞";
                })
                .thenApply(first -> {
                    System.out.println(Thread.currentThread().getName() + ", " + "对主线程来说，非阻塞");
                    return first + ", 在看";
                })
                .thenApply(second -> second + ", 转发");

        System.out.println(Thread.currentThread().getName() + ", " + "主线程没有阻塞");
        System.out.println(Thread.currentThread().getName() + ", " + "test");
        System.out.println(Thread.currentThread().getName() + ", " + comboText.get() + ", 主线程依然阻塞获取结果....");
        System.out.println(Thread.currentThread().getName() + ", " + "test1");
        System.out.println(Thread.currentThread().getName() + ", " + "test2");
        System.out.println(Thread.currentThread().getName() + ", " + "test3");
        System.out.println(Thread.currentThread().getName() + ", " + "test4");
    }
}
