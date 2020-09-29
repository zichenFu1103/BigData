package com.zichen.homework1;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class ReadList {
    public static List<Student> readList(String path) {
        ObjectInputStream in = null;
        List<Student> listStudents =null;

        try {
            in = new ObjectInputStream(new FileInputStream(path));
            Object obj = in.readObject();
            listStudents = (List<Student>)obj;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return listStudents;
    }
}
