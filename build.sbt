name := "kafkaProducer"

version := "1.0"

scalaVersion := "2.10.6"



val sparkVersion="1.6.0"

libraryDependencies ++= Seq(
  //"org.apache.spark" % "spark-streaming_2.10" % sparkVersion % "provided",
  //"org.apache.spark" % "spark-core_2.10" % sparkVersion % "provided",
  //"com.typesafe.scala-logging" % "scala-logging-slf4j_2.10" % "2.1.2",
  //"org.apache.spark" % "spark-hive_2.10" % sparkVersion % "provided",
  //"commons-cli" % "commons-cli" % "1.2",
  ////"com.esotericsoftware" % "kryo" % "3.0.3",
  //"org.apache.spark" % "spark-sql_2.10" % sparkVersion % "provided",
  "org.apache.spark" % "spark-streaming-kafka_2.10" % sparkVersion
)

