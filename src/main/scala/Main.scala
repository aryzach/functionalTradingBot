
import com.ib.client.Types.{BarSize, DurationUnit, SecType, WhatToShow}
import scala.concurrent.{Await, Future}
import scala.concurrent.duration.Duration
import com.tictactec.ta.lib._
import org.ta4j.core._


object Main {
  def block[A](f: Future[A]): A = {
    Await.result(f, Duration.Inf)
  }

  /*
  def buy(ibc: IBClient, account, contract, quantity, num_ticks=2) = {

    ibc.qualifyContracts(contract)
    details = ibc.reqContractDetails(contract)
    //[ticker] = ib.reqTickers(contract)
    ask = None
    while ask is None and ib.sleep(.01):
    ask = ticker.ask
    print('ask', ask)

    limit_price = ask + num_ticks * details[0].minTick
    # order = ibs.MarketOrder('BUY', quantity, account=account, tif='GTC')
    order = ibs.LimitOrder('BUY', quantity, '%s' % limit_price, account=account, tif='GTC')

    trade = ib.placeOrder(contract, order)
    ib.sleep(.1)
    print('\n\t%s\n' % pretty_string_trade(trade))
    util.slack_message('Sent BUY: %s' % pretty_string_trade(trade))
    return trade
  }
  */



  def main(args: Array[String]): Unit = {

    import scala.concurrent.Await
    import scala.concurrent.duration.Duration
    import com.larroy.ibclient.contract.{CashContract, FutureContract, GenericContract, StockContract}
    import com.larroy.ibclient.{IBClient}

    val ibc = new IBClient("localhost", 7496, 3)
    //ibc.disconnect()
    Await.result(ibc.reconnect(), Duration.Inf) 
    val unqualifiedContract = new GenericContract(SecType.CASH, "EURUSD")
    //val unqualifiedContract = new FutureContract("C", "", "CFE")
    //val unqualifiedContract = new StockContract("TSLA")

    //val qualifiedContract = Await.result(ibc.contractDetails(unqualifiedContract), Duration.Inf) // this gets contractID
    //
    // not sure if I need but here to remember: ibc.tickPrice and ibc.tickSize
    println("here")

    import org.joda.time._

    val startDate = new DateTime(2021, 4, 10, 15, 0).toDate
    val endDate = new DateTime(2021, 4, 13, 15, 0).toDate
    //val h = block(ibc.historicalData(unqualifiedContract, endDate, 20, DurationUnit.DAY, BarSize._15_mins, WhatToShow.MIDPOINT, false))
    val res2 = Await.result(ibc.historicalData(new CashContract("EUR","EUR.USD"), endDate, 120, DurationUnit.SECOND, BarSize._5_mins, WhatToShow.MIDPOINT, false), Duration.Inf)
    println("________________________________________________________________________________________________")
    println(res2)

    // run res2 through OBV, then buy or sell

    // from python code -- order = ibs.LimitOrder('BUY', quantity, '%s' % limit_price, account=account, tif='GTC')
    // case class Buy(override val kind: Kind, override val quantity: Int)
    import com.larroy.ibclient.order.{Buy, Sell}
    import com.larroy.ibclient.order.kind.{Limit}
    val buyOrder = new Buy(new Limit(1.50), 1)
    val sellOrder = new Sell(new Limit(1.00), 1)

    //this is JAVA native API client.placeOrder(nextOrderId++, ContractSamples.USStock(), OrderSamples.LimitOrder("SELL", 1, 50));
    // this is IBClient
    ibc.placeOrder(unqualifiedContract, buyOrder)


    ibc.disconnect()





  }
}
