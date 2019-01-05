package spe.spark

import java.util.HashMap
import org.apache.kafka.clients.producer.{KafkaProducer, ProducerConfig, ProducerRecord}
import scala.util.Random

/**
  * Created by Pietro.Speri on 17/12/2018.
  */

object kafkaProducer {
  def main(args: Array[String]): Unit = {
    if(args.length!=4)println(
      """The number of arguments passed to the application is not equal to 4.
        |Example:
        |KafkaWordCountProducer <metadataBrokerList> <topic> <messagesPerSec> <wordsPerMessage>
      """.stripMargin)

    val Array(brokers, topic, messagesPerSec, wordsPerMessage) = args

    def randomString(n:Int):String={
      Random.alphanumeric.take(n).mkString
    }

    val props = new HashMap[String, Object]()
    props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,brokers)
    props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer")
    props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer")

    val producer = new KafkaProducer[String, String](props)
    while(true){
		producer.wait(Random.nextLong())
		(1 to messagesPerSec.toInt).foreach(mess=>{
			val str = (1 to wordsPerMessage.toInt).map(x=>randomString(Random.nextInt(20))).mkString(" ")
			val mess = new ProducerRecord[String, String](topic,null, str)
			producer.send(mess)
			println(mess)
			})
    }
  }
}
