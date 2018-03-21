package com.dsib.webService.AZX.ClaimGet.service;

public class AZXClaimGetServicePortTypeProxy implements com.dsib.webService.AZX.ClaimGet.service.AZXClaimGetServicePortType {
  private String _endpoint = null;
  private com.dsib.webService.AZX.ClaimGet.service.AZXClaimGetServicePortType aZXClaimGetServicePortType = null;
  
  public AZXClaimGetServicePortTypeProxy() {
    _initAZXClaimGetServicePortTypeProxy();
  }
  
  public AZXClaimGetServicePortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initAZXClaimGetServicePortTypeProxy();
  }
  
  private void _initAZXClaimGetServicePortTypeProxy() {
    try {
      aZXClaimGetServicePortType = (new com.dsib.webService.AZX.ClaimGet.service.AZXClaimGetServiceLocator()).getAZXClaimGetServiceSOAP11port_http();
      if (aZXClaimGetServicePortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)aZXClaimGetServicePortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)aZXClaimGetServicePortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (aZXClaimGetServicePortType != null)
      ((javax.xml.rpc.Stub)aZXClaimGetServicePortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.dsib.webService.AZX.ClaimGet.service.AZXClaimGetServicePortType getAZXClaimGetServicePortType() {
    if (aZXClaimGetServicePortType == null)
      _initAZXClaimGetServicePortTypeProxy();
    return aZXClaimGetServicePortType;
  }
  
  public com.dsib.webService.AZX.ClaimGet.dto.xsd.ClaimGetResponse service(com.dsib.webService.AZX.ClaimGet.dto.xsd.ClaimGetRequest request) throws java.rmi.RemoteException{
    if (aZXClaimGetServicePortType == null)
      _initAZXClaimGetServicePortTypeProxy();
    return aZXClaimGetServicePortType.service(request);
  }
  
  
}