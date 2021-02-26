package com.zichen.step2;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class ResultReducer extends Reducer<ResultBean, NullWritable,ResultBean, NullWritable> {
    @Override
    protected void reduce(ResultBean key, Iterable<NullWritable> values, Context context) throws IOException, InterruptedException {
        for (NullWritable value : values) {
            //输出结果
            context.write(key, value);
        }
    }
}
