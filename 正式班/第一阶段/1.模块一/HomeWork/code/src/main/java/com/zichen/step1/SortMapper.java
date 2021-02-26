package com.zichen.step1;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

//利用map和reduce阶段的排序特性，把数值作为key，mapreduce会把key排序输出。
public class SortMapper extends Mapper <LongWritable, Text, IntWritable, NullWritable> {
    IntWritable k = new IntWritable();
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String str = value.toString();
        k.set(Integer.parseInt(str));
        context.write(k,NullWritable.get());
    }
}
