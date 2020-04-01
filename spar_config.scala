
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf
import org.apache.spark.sql.SQLContext
import org.apache.spark.mllib.clustering.{KMeans, KMeansModel}
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types.{StructType,StructField,StringType}
import org.apache.spark.sql.Row
import scala.collection.mutable.WrappedArray
import org.apache.spark.sql.functions.{udf, lit}
import System.nanoTime
import org.apache.hadoop._
import org.apache.hadoop.mapreduce._
import org.apache.hadoop.io._
import scala.collection.JavaConversions._
import org.apache.spark._
import org.apache.hadoop.io.{LongWritable, MapWritable, Text, BooleanWritable}
import org.apache.hadoop.mapreduce.{InputFormat => NewInputFormat, Job => NewHadoopJob}
import java.text.SimpleDateFormat
import java.util._
import java.util.HashMap
import java.lang.Math
import org.apache.spark.sql.types.DateType
import org.apache.spark.sql.functions._
import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat


object App {
  def main(args: Array[String]) {
    val logFile = "/root/spark/README.md"
    val conf = new SparkConf().setAppName("EventLogApp").setMaster("spark://ec2-52-73-43-87.compute-1.amazonaws.com:7077")
                              .set("spark.cores.max", "8").set("spark.executor.memory", "15g")
    val sc = new SparkContext(conf)
    val sqlContext = new SQLContext(sc)
    

