package com.zichen.homework3;

public class CopyThread implements Runnable{

    private String oldPath;
    private String newPath;

    public CopyThread(String oldPath, String newPath){
        this.oldPath = oldPath;
        this.newPath = newPath;
    }

    @Override
    public void run() {
        Copy copy = new Copy();
        copy.copyFolder(oldPath, newPath);
    }
}
