package com.dsib.webService.AZX.insuranceSingleQuery.service;

public class AZXInsuranceSingleQueryServicePortTypeProxy implements com.dsib.webService.AZX.insuranceSingleQuery.service.AZXInsuranceSingleQueryServicePortType {
  private String _endpoint = null;
  private com.dsib.webService.AZX.insuranceSingleQuery.service.AZXInsuranceSingleQueryServicePortType aZXInsuranceSingleQueryServicePortType = null;
  
  public AZXInsuranceSingleQueryServicePortTypeProxy() {
    _initAZXInsuranceSingleQueryServicePortTypeProxy();
  }
  
  public AZXInsuranceSingleQueryServicePortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initAZXInsuranceSingleQueryServicePortTypeProxy();
  }
  
  private void _initAZXInsuranceSingleQueryServicePortTypeProxy() {
    try {
      aZXInsuranceSingleQueryServicePortType = (	new com.dsib.webService.AZX.insuranceSingleQuery.service.AZXInsuranceSingleQueryServiceLocator()).getAZXInsuranceSingleQueryServiceSOAP11port_http();
      if (aZXInsuranceSingleQueryServicePortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)aZXInsuranceSingleQueryServicePortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)aZXInsuranceSingleQueryServicePortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (aZXInsuranceSingleQueryServicePortType != null)
      ((javax.xml.rpc.Stub)aZXInsuranceSingleQueryServicePortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.dsib.webService.AZX.insuranceSingleQuery.service.AZXInsuranceSingleQueryServicePortType getAZXInsuranceSingleQueryServicePortType() {
    if (aZXInsuranceSingleQueryServicePortType == null)
      _initAZXInsuranceSingleQueryServicePortTypeProxy();
    return aZXInsuranceSingleQueryServicePortType;
  }
  
  public com.dsib.webService.AZX.insuranceSingleQuery.dto.xsd.InsuranceSingleQueryResponse service(com.dsib.webService.AZX.insuranceSingleQuery.dto.xsd.InsuranceSingleQueryRequest request) throws java.rmi.RemoteException{
    if (aZXInsuranceSingleQueryServicePortType == null)
      _initAZXInsuranceSingleQueryServicePortTypeProxy();
    return aZXInsuranceSingleQueryServicePortType.service(request);
  }
  
  
}