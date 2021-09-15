package orders 

import com.larroy.ibclient.order.{Buy, Sell}
import com.larroy.ibclient.order.kind.{Limit}


object Orders {

  val suggestBuyOrder  = new Buy(new Limit(800), 1, Some("DU3987932"))
  val suggestSellOrder = new Sell(new Limit(1.00), 1, Some("DU3987932"))
/*
  def buy(ib: IBCLient, account: String, contract: Contract, quanitity: Int): Unit = {
    val ask = None
    while ask is None and ib.sleep(.01):
    ask = ticker.ask
    print('ask', ask)

    limit_price = ask + num_ticks * details[0].minTick

    val limitPrice = 
      val limitOrder = new Limit(

        ibc.placeOrder(

  }
  def buy(ib, account, contract, quantity, backtest=False, num_ticks=2):
  if backtest:
  print('Backtest, NOT placing BUY order', quantity, contract)
  return

  ib.qualifyContracts(contract)
  details = ib.reqContractDetails(contract)
  [ticker] = ib.reqTickers(contract)
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


  def sell(ib, account, contract, quantity, backtest=False, num_ticks=2):
  if backtest:
  print('Backtest, NOT placing SELL order', quantity, contract)
  return

  ib.qualifyContracts(contract)
  details = ib.reqContractDetails(contract)
  [ticker] = ib.reqTickers(contract)
  bid = None
  while bid is None and ib.sleep(.01):
  bid = ticker.bid
  print('bid', bid)
*/

}

