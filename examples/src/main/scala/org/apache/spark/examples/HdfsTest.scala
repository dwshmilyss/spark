/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

// scalastyle:off println
package org.apache.spark.examples

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.SparkSession


object HdfsTest {

  /** Usage: HdfsTest [file] */
  def main(args: Array[String]) {
    //    if (args.length < 1) {
    //      System.err.println("Usage: HdfsTest <file>")
    //      System.exit(1)
    //    }
    val spark = SparkSession
      .builder
      .master("local")
      .appName("HdfsTest")
      .getOrCreate()
    val file = spark.read.text("hdfs://master01:9000/a.txt").rdd
    //    val conf = new SparkConf()
    //    conf.setMaster("local[*]").setAppName("HdfsTest")
    //    val sc = new SparkContext(conf)
    //    val file = sc.textFile("hdfs://master01:9000/a.txt")
    println(file.count())
    //    val mapped = file.map(s => s.length).cache()
    //    for (iter <- 1 to 10) {
    //      val start = System.currentTimeMillis()
    //      for (x <- mapped) { x + 2 }
    //      val end = System.currentTimeMillis()
    //      println("Iteration " + iter + " took " + (end-start) + " ms")
    //    }
    spark.stop()
    //    sc.stop()
  }
}

// scalastyle:on println
