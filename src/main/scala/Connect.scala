/*
import logging
import ib_insync as ibs

from crypto import CryptoConnection

def connect(contract_type=None, client_id=11):
if contract_type == 'crypto':
return CryptoConnection()

ib = ibs.IB()
ib_gateway_port = 4002
ib_gateway_port_live = 4001
trader_workstation_port = 7496
# ib.connect('127.0.0.1', ib_gateway_port_live, clientId=client_id)  # IB Gateway
# ib.connect('127.0.0.1', ib_gateway_port, clientId=client_id)  # IB Gateway
# logger=logging.getLogger().setLevel(logging.DEBUG)
ib.connect('127.0.0.1', trader_workstation_port, clientId=client_id, timeout=20)  # Trader Workstation
return ib
*/
/*
import com.larroy.ibclient.{IBClient}

object IBClient {
  def connect(): IBClient = {
    val ibc = new IBClient("localhost", 7496, 3)
    //ibc.disconnect()
    Await.result(ibc.reconnect(), Duration.Inf) 
    return ibc
  }
}
*/
