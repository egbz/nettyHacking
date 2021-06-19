package org.egbz.nettyHacking;

import io.netty.util.concurrent.*;

/**
 * @author egbz
 * @date 2021/6/19
 */
public class PromiseDemo {
    public static void main(String[] args) {

        // 构造线程池
        EventExecutor executor = new DefaultEventExecutor();

        // 创建 DefaultPromise 实例
        Promise promise = new DefaultPromise(executor);

        // 下面给这个 promise 添加两个 listener
        promise.addListener(new GenericFutureListener<Future<Integer>>() {
            @Override
            public void operationComplete(Future future) throws Exception {
                if (future.isSuccess()) {
                    System.out.println("任务结束, 结果: " + future.get());
                } else {
                    System.out.println("任务失败, 异常: " + future.cause());
                }
            }
        }).addListener(new GenericFutureListener<Future<Integer>>() {
            @Override
            public void operationComplete(Future future) throws Exception {
                System.out.println("[over] ---------------");
            }
        });

        executor.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }

                // 设置 promise 的结果
                 promise.setFailure(new RuntimeException());
//                promise.setSuccess(42);
            }
        });

        // main 线程阻塞等待执行结果
        try {
            // sync() 会重新抛出异常, await() 不会
//            promise.sync();
            promise.await();
        } catch (InterruptedException e) {
        }

    }

}
