//package com.larroy.ibclient

import com.larroy._
import com.ib.client.Types.{BarSize, DurationUnit, SecType, WhatToShow}
import scala.concurrent.{Await, Future}
import scala.concurrent.duration.Duration


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
    Await.result(ibc.connect(), Duration.Inf) 
    val unqualifiedContract = new FutureContract("C", "", "CFE")
    //val unqualifiedContract = new StockContract("TSLA")

    //val qualifiedContract = Await.result(ibc.contractDetails(unqualifiedContract), Duration.Inf) // this gets contractID
    //
    // not sure if I need but here to remember: ibc.tickPrice and ibc.tickSize
    println("here")

    import scala.concurrent.duration._
    import org.joda.time._
    import com.ib.client.Types.DurationUnit
    import com.ib.client.Types.WhatToShow

    val startDate = new DateTime(2021, 4, 10, 15, 0).toDate
    val endDate = new DateTime(2021, 4, 13, 15, 0).toDate
    val h = block(ibc.historicalData(unqualifiedContract, endDate, 20, DurationUnit.DAY, BarSize._15_mins, WhatToShow.MIDPOINT, false))
    println("________________________________________________________________________________________________")
    println(h)

  }
}
