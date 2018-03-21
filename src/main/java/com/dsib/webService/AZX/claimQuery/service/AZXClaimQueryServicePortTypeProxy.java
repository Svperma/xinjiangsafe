package com.dsib.webService.AZX.claimQuery.service;

import java.rmi.RemoteException;

import com.dsib.webService.AZX.claimQuery.dto.xsd.ClaimQueryRequest;
import com.dsib.webService.AZX.claimQuery.dto.xsd.ClaimQueryResponse;

public class AZXClaimQueryServicePortTypeProxy implements com.dsib.webService.AZX.claimQuery.service.AZXClaimQueryServicePortType {
  private String _endpoint = null;
  private com.dsib.webService.AZX.claimQuery.service.AZXClaimQueryServicePortType aZXClaimQueryServicePortType = null;
  
  public AZXClaimQueryServicePortTypeProxy() {
    _initAZXClaimQueryServicePortTypeProxy();
  }
  
  public AZXClaimQueryServicePortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initAZXClaimQueryServicePortTypeProxy();
  }
  
  private void _initAZXClaimQueryServicePortTypeProxy() {
    try {
      aZXClaimQueryServicePortType = (new com.dsib.webService.AZX.claimQuery.service.AZXClaimQueryServiceLocator()).getAZXClaimQueryServiceSOAP11port_http();
      if (aZXClaimQueryServicePortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)aZXClaimQueryServicePortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)aZXClaimQueryServicePortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (aZXClaimQueryServicePortType != null)
      ((javax.xml.rpc.Stub)aZXClaimQueryServicePortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.dsib.webService.AZX.claimQuery.service.AZXClaimQueryServicePortType getAZXClaimQueryServicePortType() {
    if (aZXClaimQueryServicePortType == null)
      _initAZXClaimQueryServicePortTypeProxy();
    return aZXClaimQueryServicePortType;
  }

@Override
public ClaimQueryResponse service(ClaimQueryRequest request)
		throws RemoteException {
	// TODO Auto-generated method stub
	return null;
}
  
  
}