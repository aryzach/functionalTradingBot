package provider

import com.larroy.ibclient.{IBClient}
import com.larroy.ibclient.{Bar}
import com.ib.client.Contract 
import com.ib.client.Types.{BarSize, DurationUnit, SecType, WhatToShow}
import java.util.{ArrayList, Collections, Date}
import scala.concurrent.{Await, Future}


object Provider {

  def pullHistoricalBars(ibc: IBClient, contract: Contract, endDate: Date, barSize: BarSize, use_rth: Boolean = true): 
  Future[IndexedSeq[Bar]] =  {

    val duration: Int = 120
    val durationUnit: DurationUnit = DurationUnit.SECOND
    val whatToShow: WhatToShow = WhatToShow.MIDPOINT // should this be .TRADES ?? it is in python

    return ibc.historicalData(
      contract, 
      endDate, 
      duration, 
      durationUnit, 
      barSize, 
      whatToShow, 
      rthOnly=use_rth)
  }


}


