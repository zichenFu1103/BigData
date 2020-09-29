package com.zichen.homework3;

import java.io.*;

public class Copy {

    public synchronized void copyFolder(String oldPath, String newPath){
        File oldFolder = new File(oldPath);
        File newFolder = new File(newPath);

        if(!oldFolder.exists()){
            System.out.println("原文件夹不存在！");
            return;
        }

        if(!newFolder.exists()){
            newFolder.mkdirs();
            System.out.println("复制目录"+newFolder.getName());
        }

        File[] files = oldFolder.listFiles();
        for(File f : files){
            if(f.isFile()){
                copyFile(f.getAbsolutePath(), newFolder.getAbsolutePath()+"/"+f.getName());
                System.out.println("复制文件"+f.getName());
            }else if(f.isDirectory()){
                copyFolder(f.getAbsolutePath(), newFolder.getAbsolutePath()+"/"+f.getName());
            }
        }

    }

    public void copyFile(String oldPath, String newPath)  {
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(oldPath));
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(newPath));
            byte[] arr = new byte[8192];
            int res = 0;
            while((res = bufferedInputStream.read(arr)) != -1){
                bufferedOutputStream.write(arr, 0, res);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(bufferedOutputStream != null){
                try {
                    bufferedOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(bufferedInputStream != null){
                try {
                    bufferedInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
