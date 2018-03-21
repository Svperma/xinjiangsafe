package com.dsib.webService.AZX.claimPush.service;

public class AZXClaimPushServicePortTypeProxy implements com.dsib.webService.AZX.claimPush.service.AZXClaimPushServicePortType {
  private String _endpoint = null;
  private com.dsib.webService.AZX.claimPush.service.AZXClaimPushServicePortType aZXClaimPushServicePortType = null;
  
  public AZXClaimPushServicePortTypeProxy() {
    _initAZXClaimPushServicePortTypeProxy();
  }
  
  public AZXClaimPushServicePortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initAZXClaimPushServicePortTypeProxy();
  }
  
  private void _initAZXClaimPushServicePortTypeProxy() {
    try {
      aZXClaimPushServicePortType = (new com.dsib.webService.AZX.claimPush.service.AZXClaimPushServiceLocator()).getAZXClaimPushServiceSOAP11port_http();
      if (aZXClaimPushServicePortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)aZXClaimPushServicePortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)aZXClaimPushServicePortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (aZXClaimPushServicePortType != null)
      ((javax.xml.rpc.Stub)aZXClaimPushServicePortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.dsib.webService.AZX.claimPush.service.AZXClaimPushServicePortType getAZXClaimPushServicePortType() {
    if (aZXClaimPushServicePortType == null)
      _initAZXClaimPushServicePortTypeProxy();
    return aZXClaimPushServicePortType;
  }
  
  public com.dsib.webService.AZX.entry.dto.GPIC.AZXClaimPush.xsd.Response service(com.dsib.webService.AZX.entry.dto.GPIC.AZXClaimPush.xsd.Request request) throws java.rmi.RemoteException{
    if (aZXClaimPushServicePortType == null)
      _initAZXClaimPushServicePortTypeProxy();
    return aZXClaimPushServicePortType.service(request);
  }
  
  
}