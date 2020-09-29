package com.zichen.homework2;

import java.io.File;
import java.io.IOException;

public class DeleteFiles {

    public static void main(String[] args) {
        String rootPath = "./src/com/zichen/homework2/test";
        String folderPath = "./src/com/zichen/homework2/test/test1";
        String filePath1 = "./src/com/zichen/homework2/test/test1/test2.txt";
        String filePath2 = "./src/com/zichen/homework2/test/test1.txt";
        try {
            createFolder(folderPath);
            createFile(filePath1);
            createFile(filePath2);
        } catch (IOException e) {
            e.printStackTrace();
        }
        deleteAllFiles(new File(rootPath));
    }

    public static void createFolder(String path) throws IOException {
        File file = new File(path);
        if(!file.exists()){
            file.mkdirs();
            System.out.println("目录创建成功！");
        }else{
            System.out.println("目录已存在！");
        }

    }

    public static void createFile(String path) throws IOException {
        File file = new File(path);
        if(!file.exists()){
            file.createNewFile();
            System.out.println("文件创建成功！");
        }else{
            System.out.println("文件已存在！");
        }
    }

    public static void deleteAllFiles(File rootFile){
       if(!rootFile.exists()){
           return;
       }

       File[] files = rootFile.listFiles();
       for(File file : files){
           if(file.isFile()){
               System.out.println("删除"+file.getName());
               file.delete();
            }else if(file.isDirectory()){
               deleteAllFiles(file);
            }
       }
       System.out.println("删除"+rootFile.getName());
       rootFile.delete();
    }
}
