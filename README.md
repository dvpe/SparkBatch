#Avro to Parquet with Spark

This project reads files in avro format and it saves in parquet format.
It is possible to read a entire folder with several files.


# Usage
Once we package the project with maven (mvn package), we have three jars:
- SparkBatch-1.0-SNAPSHOT.jar: original jar
- SparkBatch-1.0-SNAPSHOT-Standalone.jar: complete jar with all dependencies
- SparkBatch-1.0-SNAPSHOT-Avro.jar: original plus avro library. It is possible to deploy this jar to Spark cluster

Run in standalone mode:
java -jar SparkBatch-1.0-SNAPSHOT-Standalone.jar inputFile/inputFolder outputFolder </br>
Example: <i>java -jar SparkBatch-1.0-SNAPSHOT-Standalone.jar hdfs://127.0.1.1:9000/user/root/prueba/avrofiles hdfs://127.0.1.1:9000/user/root/prueba/twitter.parquet</i></br>

Run in cluster mode:
spark-submit --master mode  --class com.datio.core.AvroToParquetHdfs SparkBatch-1.0-SNAPSHOT-Avro.jar inputFile/inputFolder outputFolder </br>
Example: <i>spark-submit --master local[4]  --class com.datio.core.AvroToParquetHdfs SparkBatch-1.0-SNAPSHOT-Avro.jar hdfs://127.0.1.1:9000/user/root/prueba/avrofiles hdfs://127.0.1.1:9000/user/root/prueba/twitter.parquet </i></br>
