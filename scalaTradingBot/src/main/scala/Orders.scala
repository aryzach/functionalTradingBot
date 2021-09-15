package orders 

import com.larroy.ibclient.order.{Buy, Sell}
import com.larroy.ibclient.order.kind.{Limit}
import com.ib.client.Contract 
import com.larroy.ibclient.{IBClient}


object Orders {

  val suggestBuyOrder  = new Buy(new Limit(800), 1, Some("DU3987932"))
  val suggestSellOrder = new Sell(new Limit(1.00), 1, Some("DU3987932"))

  def limit(price: Double): Limit = new Limit(price)

  def buy(ibc: IBClient, account: String, contract: Contract, quantity: Int, numTicks: Int = 2): Unit = {
    val limitPrice = 800 // tmp for testing, need to actually implement
    val limitOrder = limit(limitPrice)
    val buyOrder: Buy = new Buy(limitOrder, quantity, Some(account))
    ibc.placeOrder(contract, buyOrder)
  }

  def sell(ibc: IBClient, account: String, contract: Contract, quantity: Int, numTicks: Int = 2): Unit = {
    val limitPrice = 800 // tmp for testing, need to actually implement
    val limitOrder = limit(limitPrice)
    val sellOrder: Sell = new Sell(limitOrder, quantity, Some(account))
    ibc.placeOrder(contract, sellOrder)
  }

}
