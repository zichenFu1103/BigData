package com.zichen.step1;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

//step1的目的是把这三个文件合并成一个文件，并升序排列
public class SortDriver {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        try {
            Job job = Job.getInstance(configuration, "SortDriver");

            job.setJarByClass(SortDriver.class);
            job.setMapperClass(SortMapper.class);
            job.setReducerClass(SortReducer.class);

            job.setMapOutputKeyClass(IntWritable.class);
            job.setMapOutputValueClass(NullWritable.class);

            job.setOutputKeyClass(IntWritable.class);
            job.setOutputValueClass(NullWritable.class);


            //验证时，修改合适路径
            FileInputFormat.setInputPaths(job, new Path("/Users/zichenfu/Desktop/HomeWork/inputData"));
            FileOutputFormat.setOutputPath(job, new Path("/Users/zichenfu/Desktop/HomeWork/outputData"));

            boolean flag = job.waitForCompletion(true);

            System.exit(flag ? 0 : 1);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
