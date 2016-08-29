package com.datio.core;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.SparkConf;
import org.apache.spark.sql.DataFrame;
import org.apache.spark.sql.DataFrameReader;
import org.apache.spark.sql.SQLContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class AvroToParquetHdfs{
    private static Logger slf4jLogger = LoggerFactory.getLogger(AvroToParquetHdfs.class);
    public static void main(String[] args) throws InterruptedException {
        if(args==null || args.length != 2)
        {
            slf4jLogger.info("Usage is: java program inputAvroFile outputParquetFile");
            System.exit(0);
        }
        String input = args[0];
        String output  = args[1];
        SparkConf conf = new SparkConf();
        JavaSparkContext sc = new JavaSparkContext(conf);
        SQLContext sqlContext = new SQLContext(sc);
        DataFrameReader dfr = sqlContext.read().format("com.databricks.spark.avro");
        DataFrame df = dfr.load(input);
        df.write().parquet(output);
    }
}
