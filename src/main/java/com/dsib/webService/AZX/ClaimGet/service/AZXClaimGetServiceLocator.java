/**
 * AZXClaimGetServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.dsib.webService.AZX.ClaimGet.service;

import com.dsib.util.PropertiesUtil;

public class AZXClaimGetServiceLocator extends org.apache.axis.client.Service implements com.dsib.webService.AZX.ClaimGet.service.AZXClaimGetService {

    public AZXClaimGetServiceLocator() {
    }


    public AZXClaimGetServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public AZXClaimGetServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for AZXClaimGetServiceSOAP11port_http
    private java.lang.String AZXClaimGetServiceSOAP11port_http_address = PropertiesUtil.getPropertiesValue("DSIB-ClaimGet");
    public java.lang.String getAZXClaimGetServiceSOAP11port_httpAddress() {
        return AZXClaimGetServiceSOAP11port_http_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String AZXClaimGetServiceSOAP11port_httpWSDDServiceName = "AZXClaimGetServiceSOAP11port_http";

    public java.lang.String getAZXClaimGetServiceSOAP11port_httpWSDDServiceName() {
        return AZXClaimGetServiceSOAP11port_httpWSDDServiceName;
    }

    public void setAZXClaimGetServiceSOAP11port_httpWSDDServiceName(java.lang.String name) {
        AZXClaimGetServiceSOAP11port_httpWSDDServiceName = name;
    }

    public com.dsib.webService.AZX.ClaimGet.service.AZXClaimGetServicePortType getAZXClaimGetServiceSOAP11port_http() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(AZXClaimGetServiceSOAP11port_http_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getAZXClaimGetServiceSOAP11port_http(endpoint);
    }

    public com.dsib.webService.AZX.ClaimGet.service.AZXClaimGetServicePortType getAZXClaimGetServiceSOAP11port_http(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.dsib.webService.AZX.ClaimGet.service.AZXClaimGetServiceSOAP11BindingStub _stub = new com.dsib.webService.AZX.ClaimGet.service.AZXClaimGetServiceSOAP11BindingStub(portAddress, this);
            _stub.setPortName(getAZXClaimGetServiceSOAP11port_httpWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setAZXClaimGetServiceSOAP11port_httpEndpointAddress(java.lang.String address) {
        AZXClaimGetServiceSOAP11port_http_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.dsib.webService.AZX.ClaimGet.service.AZXClaimGetServicePortType.class.isAssignableFrom(serviceEndpointInterface)) {
                com.dsib.webService.AZX.ClaimGet.service.AZXClaimGetServiceSOAP11BindingStub _stub = new com.dsib.webService.AZX.ClaimGet.service.AZXClaimGetServiceSOAP11BindingStub(new java.net.URL(AZXClaimGetServiceSOAP11port_http_address), this);
                _stub.setPortName(getAZXClaimGetServiceSOAP11port_httpWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("AZXClaimGetServiceSOAP11port_http".equals(inputPortName)) {
            return getAZXClaimGetServiceSOAP11port_http();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://service.ClaimGet.AZX.webService.dsib.com", "AZXClaimGetService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://service.ClaimGet.AZX.webService.dsib.com", "AZXClaimGetServiceSOAP11port_http"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("AZXClaimGetServiceSOAP11port_http".equals(portName)) {
            setAZXClaimGetServiceSOAP11port_httpEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
