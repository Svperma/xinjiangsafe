package com.dsib.webService.AZX.insuranceSingle.service;

public class AZXInsuranceSingleServicePortTypeProxy implements com.dsib.webService.AZX.insuranceSingle.service.AZXInsuranceSingleServicePortType {
  private String _endpoint = null;
  private com.dsib.webService.AZX.insuranceSingle.service.AZXInsuranceSingleServicePortType aZXInsuranceSingleServicePortType = null;
  
  public AZXInsuranceSingleServicePortTypeProxy() {
    _initAZXInsuranceSingleServicePortTypeProxy();
  }
  
  public AZXInsuranceSingleServicePortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initAZXInsuranceSingleServicePortTypeProxy();
  }
  
  private void _initAZXInsuranceSingleServicePortTypeProxy() {
    try {
      aZXInsuranceSingleServicePortType = (new com.dsib.webService.AZX.insuranceSingle.service.AZXInsuranceSingleServiceLocator()).getAZXInsuranceSingleServiceSOAP11port_http();
      if (aZXInsuranceSingleServicePortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)aZXInsuranceSingleServicePortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)aZXInsuranceSingleServicePortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (aZXInsuranceSingleServicePortType != null)
      ((javax.xml.rpc.Stub)aZXInsuranceSingleServicePortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.dsib.webService.AZX.insuranceSingle.service.AZXInsuranceSingleServicePortType getAZXInsuranceSingleServicePortType() {
    if (aZXInsuranceSingleServicePortType == null)
      _initAZXInsuranceSingleServicePortTypeProxy();
    return aZXInsuranceSingleServicePortType;
  }
  
  public com.dsib.webService.AZX.insuranceSingle.dto.xsd.InsuranceSingleResponse service(com.dsib.webService.AZX.insuranceSingle.dto.xsd.InsuranceSingleRequest request) throws java.rmi.RemoteException{
    if (aZXInsuranceSingleServicePortType == null)
      _initAZXInsuranceSingleServicePortTypeProxy();
		return aZXInsuranceSingleServicePortType.service(request);
  }
  
  
}