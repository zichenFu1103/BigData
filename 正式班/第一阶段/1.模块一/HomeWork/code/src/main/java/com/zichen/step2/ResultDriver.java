package com.zichen.step2;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class ResultDriver {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();

        try {
            Job job = Job.getInstance(configuration, "ResultDriver");

            job.setJarByClass(ResultDriver.class);
            job.setMapperClass(ResultMapper.class);
            job.setReducerClass(ResultReducer.class);

            job.setMapOutputKeyClass(ResultBean.class);
            job.setMapOutputValueClass(NullWritable.class);

            job.setOutputKeyClass(ResultBean.class);
            job.setOutputValueClass(NullWritable.class);

            //验证时，修改合适路径
            FileInputFormat.setInputPaths(job, new Path("/Users/zichenfu/Desktop/HomeWork/outputData"));
            FileOutputFormat.setOutputPath(job, new Path("/Users/zichenfu/Desktop/HomeWork/resultData"));

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
