package com.dsib.webService.AZX.manualUnderwrite.service;

public class AZXManualUnderwriteServicePortTypeProxy implements com.dsib.webService.AZX.manualUnderwrite.service.AZXManualUnderwriteServicePortType {
  private String _endpoint = null;
  private com.dsib.webService.AZX.manualUnderwrite.service.AZXManualUnderwriteServicePortType aZXManualUnderwriteServicePortType = null;
  
  public AZXManualUnderwriteServicePortTypeProxy() {
    _initAZXManualUnderwriteServicePortTypeProxy();
  }
  
  public AZXManualUnderwriteServicePortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initAZXManualUnderwriteServicePortTypeProxy();
  }
  
  private void _initAZXManualUnderwriteServicePortTypeProxy() {
    try {
      aZXManualUnderwriteServicePortType = (new com.dsib.webService.AZX.manualUnderwrite.service.AZXManualUnderwriteServiceLocator()).getAZXManualUnderwriteServiceSOAP11port_http();
      if (aZXManualUnderwriteServicePortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)aZXManualUnderwriteServicePortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)aZXManualUnderwriteServicePortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (aZXManualUnderwriteServicePortType != null)
      ((javax.xml.rpc.Stub)aZXManualUnderwriteServicePortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.dsib.webService.AZX.manualUnderwrite.service.AZXManualUnderwriteServicePortType getAZXManualUnderwriteServicePortType() {
    if (aZXManualUnderwriteServicePortType == null)
      _initAZXManualUnderwriteServicePortTypeProxy();
    return aZXManualUnderwriteServicePortType;
  }
  
  public com.dsib.webService.AZX.manualUnderwrite.dto.xsd.ManualUnderwriteResponse service(com.dsib.webService.AZX.manualUnderwrite.dto.xsd.ManualUnderwriteRequest request) throws java.rmi.RemoteException{
    if (aZXManualUnderwriteServicePortType == null)
      _initAZXManualUnderwriteServicePortTypeProxy();
    return aZXManualUnderwriteServicePortType.service(request);
  }
  
  
}