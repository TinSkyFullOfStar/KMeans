package main.scala

import breeze.linalg.{DenseVector, Matrix}

import scala.io.{Source, StdIn}
import scala.reflect.io.File


class KMeans {
  private var pileCount : Int = 7

  def this(k :Int) = {
    this()
    this.pileCount = k
  }


  def kMeansAlgorithm(): Unit ={
    val vectorArr: Array[DenseVector[Double]] = getMatrix()
    val indexs =getCoreIndex(vectorArr)
  }


  def getCoreIndex(arr: Array[DenseVector[Double]]): Array[Int] ={
    if(pileCount != -1){
      val range = Range(pileCount,arr.length-1,pileCount)
      pileCount = -1
      range.toArray
    }else{
      val range = Range(0,10)
      range.toArray
    }

  }


  def getMatrix(): Array[DenseVector[Double]] ={
    val matrixStr = Source.fromFile("d:/KMeansDataSet/test_data2.txt").getLines()
    val vectorArr = matrixStr.map(_.split("\\t")).map(vectorStr => vectorStr.map(_.toDouble))
    val arrVector = vectorArr.map(arr => DenseVector(arr)).toArray
    arrVector
  }

  def getDis(): Double ={
    val vector1 : DenseVector[Double] = DenseVector[Double]()

    0.2
  }


  def getMeans(): Double = {
    0.1
  }
}


object KMeans{
  def main(args: Array[String]): Unit = {
    val matrixStr = Source.fromFile("d:/KMeansDataSet/test_data2.txt").getLines()
    val vectorArr = matrixStr.map(_.split("\\t")).map(vectorStr => vectorStr.map(_.toDouble))
    val arrVector = vectorArr.map(arr => DenseVector(arr)).toArray
    val range = Range(7,arrVector.length,7*2)
  }
}
