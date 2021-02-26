package com.zichen.step2;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;


//利用step1的结果，那最终结果封装到bean对象当中
public class ResultMapper extends Mapper<LongWritable, Text, ResultBean, NullWritable> {
    ResultBean bean = new ResultBean();
    //更新排名情况
    int count = 0;
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String str = value.toString();
        count++;
        bean.setRank(count);
        bean.setValue(Integer.parseInt(str));
        //把bean对象作为key值直接输出
        context.write(bean, NullWritable.get());
    }
}
