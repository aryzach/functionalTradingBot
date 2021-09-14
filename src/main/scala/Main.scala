
import com.ib.client.Types.{BarSize, DurationUnit, SecType, WhatToShow}
//import scala.concurrent.duration.Duration
import com.tictactec.ta.lib._
import org.ta4j.core._

import com.larroy.ibclient.{IBClient}
import scala.concurrent.{Await, Future}
import scala.concurrent.duration.Duration


//import ib._
import contracts._
import datetime._


object Main {
  def main(args: Array[String]): Unit = {

    import scala.concurrent.Await
    import scala.concurrent.duration.Duration
    import com.larroy.ibclient.{IBClient}

    val ibc = new IBClient("localhost", 7496, 3)
    //ibc.disconnect()
    Await.result(ibc.reconnect(), Duration.Inf) 

    //val ibc = IB.connect() 

    val unqualifiedContract = Contracts.suggestStock()

    // not sure if I need but here to remember: ibc.tickPrice and ibc.tickSize


    val startTime = Datetime.startTime
    val endTime = Datetime.endTime
    //val h = block(ibc.historicalData(unqualifiedContract, endTime, 20, DurationUnit.DAY, BarSize._15_mins, WhatToShow.MIDPOINT, false))
    val res2 = Await.result(ibc.historicalData(Contracts.suggestCash(), endTime, 120, DurationUnit.SECOND, BarSize._5_mins, WhatToShow.MIDPOINT, false), Duration.Inf)
    println("________________________________________________________________________________________________")
    println(res2)

    // run res2 through OBV, then buy or sell

    // from python code -- order = ibs.LimitOrder('BUY', quantity, '%s' % limit_price, account=account, tif='GTC')
    // case class Buy(override val kind: Kind, override val quantity: Int)
    import com.larroy.ibclient.order.{Buy, Sell}
    import com.larroy.ibclient.order.kind.{Limit}
    val buyOrder = new Buy(new Limit(800), 1, Some("DU3987932"))
    val sellOrder = new Sell(new Limit(1.00), 1, Some("DU3987932"))

    //this is JAVA native API client.placeOrder(nextOrderId++, ContractSamples.USStock(), OrderSamples.LimitOrder("SELL", 1, 50));
    // this is IBClient
    ibc.placeOrder(unqualifiedContract, sellOrder)


    ibc.disconnect()

  }
}
