package com.zichen.step1;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;


public class SortReducer extends Reducer<IntWritable, NullWritable, IntWritable, NullWritable> {
    @Override
    protected void reduce(IntWritable key, Iterable<NullWritable> values, Context context) throws IOException, InterruptedException {
        for (NullWritable value : values) {
            context.write(key, NullWritable.get());
        }
    }
}
