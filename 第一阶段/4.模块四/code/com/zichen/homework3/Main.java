package com.zichen.homework3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        String oldPath = "./src/com/zichen/homework3/copy";
        String newPath = "./src/com/zichen/homework3/paste";
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.execute(new CopyThread(oldPath, newPath));
        executorService.shutdown();
    }
}
