package io.github.umangrmehta.sparknlp_poc.util

import io.github.umangrmehta.sparknlp_poc.config.AppConfig
import org.apache.spark.sql.SparkSession

object SparkUtil extends AppConfig {
	def getSession: SparkSession = {
		val spark = executionEnv match {
			case "cluster" => SparkSession.builder.appName(appName).master("yarn").getOrCreate()
			case _ => SparkSession.builder.appName(appName).master("local[*]").getOrCreate()
		}

		val hadoopConfig = spark.sparkContext.hadoopConfiguration
		hadoopConfig.set("fs.file.impl", classOf[org.apache.hadoop.fs.LocalFileSystem].getName)

		spark
	}
}
