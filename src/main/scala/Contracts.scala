package contracts

import com.ib.client.Types.{BarSize, DurationUnit, SecType, WhatToShow}
import com.larroy.ibclient.contract.{CashContract, FutureContract, GenericContract, StockContract}

object Contracts {

def suggestForex(): GenericContract = new GenericContract(SecType.CASH, "EURUSD")

def suggestFuture(): FutureContract = new FutureContract("C", "", "CFE")

def suggestStock(): StockContract = new StockContract("TSLA")

def suggestCash(): CashContract = new CashContract("EUR","EUR.USD")

//val qualifiedContract = Await.result(ibc.contractDetails(unqualifiedContract), Duration.Inf) // this gets contractID

}
