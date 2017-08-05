package main.scala

import breeze.linalg.{DenseVector, Matrix, sum}
import breeze.numerics.{pow, sqrt}
import sun.security.krb5.internal.crypto.Des

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
  }


  def getMatrix(): Array[DenseVector[Double]] ={
    val matrixStr = Source.fromFile("d:/KMeansDataSet/test_data2.txt").getLines()
    val vectorArr = matrixStr.map(_.split("\\t")).map(vectorStr => vectorStr.map(_.toDouble))
    val arrVector = vectorArr.map(arr => DenseVector(arr)).toArray
    arrVector
  }


  def initCore(arr: Array[DenseVector[Double]]): Array[DenseVector[Double]] ={
    val range = Range(pileCount,arr.length-1,pileCount)
    pileCount = -1
    val coreArr = range.map(index => arr(index))
    coreArr.toArray
  }


  def getCoreArr(arr: Array[DenseVector[Double]]) :Unit={

  }


  def getDis(indexVector: DenseVector[Double],coreVectors: Array[DenseVector[Double]]): ( DenseVector[Double], Int) ={
    var dist: Double = 0.0
    var tmp: Double = 0.0
    var index: Int = 0
    var count: Int = 0

    val distVectors = coreVectors.map(_ - indexVector)

    distVectors.foreach{ vector =>
      count += 1
      vector.foreach{ elem =>
        tmp += math.pow(elem,2)
      }

      tmp = math.sqrt(tmp)
      if(dist == 0 || dist > tmp){
        dist = tmp
        tmp = 0.0
        index = count
      }
    }

    Tuple2(indexVector,index)
  }


  def getMeans(): Double = {
    0.1
  }
}


object KMeans{
  def main(args: Array[String]): Unit = {
//    val matrixStr = Source.fromFile("d:/KMeansDataSet/test_data2.txt").getLines()
//    val vectorArr = matrixStr.map(_.split("\\t")).map(vectorStr => vectorStr.map(_.toDouble))
//    val arrVector = vectorArr.map(arr => DenseVector(arr)).toArray
//    val range = Range(7,arrVector.length,7*2)


    val vector1 = DenseVector(0.5,3.3,0.4)
    val vector2 = DenseVector(3.5,7.3,5.4)

    val vector3 = vector1 + vector2
    var sum: Double = 0.0
    (vector1 - vector2).map{ x =>
      val tmp = x * x
      sum += tmp
    }

    val dist = sqrt(sum)
    println(dist)
  }
}
