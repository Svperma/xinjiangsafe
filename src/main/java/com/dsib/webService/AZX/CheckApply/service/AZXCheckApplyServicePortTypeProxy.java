package com.dsib.webService.AZX.CheckApply.service;

public class AZXCheckApplyServicePortTypeProxy implements com.dsib.webService.AZX.CheckApply.service.AZXCheckApplyServicePortType {
  private String _endpoint = null;
  private com.dsib.webService.AZX.CheckApply.service.AZXCheckApplyServicePortType aZXCheckApplyServicePortType = null;
  
  public AZXCheckApplyServicePortTypeProxy() {
    _initAZXCheckApplyServicePortTypeProxy();
  }
  
  public AZXCheckApplyServicePortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initAZXCheckApplyServicePortTypeProxy();
  }
  
  private void _initAZXCheckApplyServicePortTypeProxy() {
    try {
      aZXCheckApplyServicePortType = (new com.dsib.webService.AZX.CheckApply.service.AZXCheckApplyServiceLocator()).getAZXCheckApplyServiceSOAP11port_http();
      if (aZXCheckApplyServicePortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)aZXCheckApplyServicePortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)aZXCheckApplyServicePortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (aZXCheckApplyServicePortType != null)
      ((javax.xml.rpc.Stub)aZXCheckApplyServicePortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.dsib.webService.AZX.CheckApply.service.AZXCheckApplyServicePortType getAZXCheckApplyServicePortType() {
    if (aZXCheckApplyServicePortType == null)
      _initAZXCheckApplyServicePortTypeProxy();
    return aZXCheckApplyServicePortType;
  }
  
  public com.dsib.webService.AZX.CheckApply.dto.xsd.CheckApplyResponse service(com.dsib.webService.AZX.CheckApply.dto.xsd.CheckApplyRequest request) throws java.rmi.RemoteException{
    if (aZXCheckApplyServicePortType == null)
      _initAZXCheckApplyServicePortTypeProxy();
    return aZXCheckApplyServicePortType.service(request);
  }
  
  
}