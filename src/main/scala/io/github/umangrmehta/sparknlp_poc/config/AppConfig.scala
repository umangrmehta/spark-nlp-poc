package io.github.umangrmehta.sparknlp_poc.config

trait AppConfig {
	val appName: String = "Spark-NLP-PoC"
	val executionEnv:String = try sys.env("env")
	catch {
		case e: Exception => "local"
	}
}
