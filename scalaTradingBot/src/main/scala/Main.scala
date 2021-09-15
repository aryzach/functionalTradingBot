
//import com.tictactec.ta.lib._
//import org.ta4j.core._

import scala.concurrent.{Await}
import scala.concurrent.duration.Duration
import com.ib.client.Types.{BarSize}


import ib._
import contracts._
import datetime._
import orders._
import provider._


object Main {
  def testScript(): Unit = {
    val account = "DU3987932"

    val ibc = IB.connect()

    val unqualifiedContract = Contracts.suggestStock()

    val historicalDataFuture = Provider.pullHistoricalBars(ibc, unqualifiedContract, Datetime.endTime, BarSize._5_mins)

    val historicalData = Await.result(historicalDataFuture, Duration.Inf)

    // run historical data through OBV, then conditionally buy or sell

    val sellOrder = Orders.suggestSellOrder

    Orders.buy(ibc, account, unqualifiedContract, 1)

    ibc.disconnect()

  }

  def main(args: Array[String]): Unit = {
    testScript()

  }
}
