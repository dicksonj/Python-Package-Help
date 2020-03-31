import os
from pyspark import SparkConf,SparkContext
from pyspark.sql import HiveContext
from pyspark.context import SparkContext
from pyspark.sql.session import SparkSession

# from pyspark.sql import SQLContext
# sqlContext = SQLContext(sc)

sc = SparkContext('local')
spark = SparkSession(sc)

properties = {"user": "<username>", "password": "<password>", "driver": "com.microsoft.sqlserver.jdbc.SQLServerDriver"}
url="jdbc:sqlserver://awsiot.crk9fc7env5h.us-east-1.rds.amazonaws.com:1433"

spark.read.format("jdbc")    .options(url=url, dbtable="baz", **properties)    .load()



## spark-submit
#  spark-submit --master yarn --conf spark.executor.instances=10 --name sample_spark s3://iotdataanalytics/test_spark.py