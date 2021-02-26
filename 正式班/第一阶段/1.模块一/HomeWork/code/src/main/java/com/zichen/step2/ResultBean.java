package com.zichen.step2;


import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

//自定义bean对象用来封装最终结果
public class ResultBean implements WritableComparable<ResultBean> {
    int rank;
    int value;

    public ResultBean() {
    }

    public ResultBean(int rank, int value) {
        this.rank = rank;
        this.value = value;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public int compareTo(ResultBean o) {
        return this.value - o.value;
    }

    @Override
    public void write(DataOutput out) throws IOException {
        out.writeInt(rank);
        out.writeInt(value);
    }

    @Override
    public void readFields(DataInput in) throws IOException {
        this.rank = in.readInt();
        this.value = in.readInt();
    }

    @Override
    public String toString() {
        return rank + "\t" + value;
    }
}
