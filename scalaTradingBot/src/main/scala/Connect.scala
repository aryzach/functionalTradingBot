package ib

import com.larroy.ibclient.{IBClient}
import scala.concurrent.{Await, Future}
import scala.concurrent.duration.Duration

object IB {
  def block[A](f: Future[A]): A = {
    Await.result(f, Duration.Inf)
  }


  def connect(): IBClient = {
    val ibc = new IBClient("localhost", 7496, 3)
    Await.result(ibc.reconnect(), Duration.Inf) 
    return ibc
  }
}

