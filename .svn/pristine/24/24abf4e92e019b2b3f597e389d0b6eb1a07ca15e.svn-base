package com.dsib.webService.AZX.manualUnderwriteAfterSingle.service;

import java.rmi.RemoteException;

import com.dsib.webService.AZX.manualUnderwriteAfterSingle.dto.xsd.ManualUnderwriteAfterSingleRequest;
import com.dsib.webService.AZX.manualUnderwriteAfterSingle.dto.xsd.ManualUnderwriteAfterSingleResponse;

public class AZXManualUnderwriteAfterSingleServicePortTypeProxy implements com.dsib.webService.AZX.manualUnderwriteAfterSingle.service.AZXManualUnderwriteAfterSingleServicePortType {
  private String _endpoint = null;
  private com.dsib.webService.AZX.manualUnderwriteAfterSingle.service.AZXManualUnderwriteAfterSingleServicePortType aZXManualUnderwriteAfterSingleServicePortType = null;
  
  public AZXManualUnderwriteAfterSingleServicePortTypeProxy() {
    _initAZXManualUnderwriteAfterSingleServicePortTypeProxy();
  }
  
  public AZXManualUnderwriteAfterSingleServicePortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initAZXManualUnderwriteAfterSingleServicePortTypeProxy();
  }
  
  private void _initAZXManualUnderwriteAfterSingleServicePortTypeProxy() {
    try {
      aZXManualUnderwriteAfterSingleServicePortType = (new com.dsib.webService.AZX.manualUnderwriteAfterSingle.service.AZXManualUnderwriteAfterSingleServiceLocator()).getAZXManualUnderwriteAfterSingleServiceSOAP11port_http();
      if (aZXManualUnderwriteAfterSingleServicePortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)aZXManualUnderwriteAfterSingleServicePortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)aZXManualUnderwriteAfterSingleServicePortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (aZXManualUnderwriteAfterSingleServicePortType != null)
      ((javax.xml.rpc.Stub)aZXManualUnderwriteAfterSingleServicePortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.dsib.webService.AZX.manualUnderwriteAfterSingle.service.AZXManualUnderwriteAfterSingleServicePortType getAZXManualUnderwriteAfterSingleServicePortType() {
    if (aZXManualUnderwriteAfterSingleServicePortType == null)
      _initAZXManualUnderwriteAfterSingleServicePortTypeProxy();
    return aZXManualUnderwriteAfterSingleServicePortType;
  }

//@Override
//public ManualUnderwriteAfterSingleResponse service(
//		ManualUnderwriteAfterSingleRequest request) throws RemoteException {
//	// TODO Auto-generated method stub
//	return null;
//}
  
  public ManualUnderwriteAfterSingleResponse service(
		  ManualUnderwriteAfterSingleRequest request) throws RemoteException {
	  if (aZXManualUnderwriteAfterSingleServicePortType == null)
		  _initAZXManualUnderwriteAfterSingleServicePortTypeProxy();
	    return aZXManualUnderwriteAfterSingleServicePortType.service(request);
  }
  
  
}