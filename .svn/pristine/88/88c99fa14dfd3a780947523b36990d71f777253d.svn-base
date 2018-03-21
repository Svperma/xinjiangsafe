/**
 * AZXClaimQueryServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.dsib.webService.AZX.claimQuery.service;

import com.dsib.util.PropertiesUtil;

public class AZXClaimQueryServiceLocator extends org.apache.axis.client.Service implements com.dsib.webService.AZX.claimQuery.service.AZXClaimQueryService {

    public AZXClaimQueryServiceLocator() {
    }


    public AZXClaimQueryServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public AZXClaimQueryServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for AZXClaimQueryServiceSOAP11port_http
    private java.lang.String AZXClaimQueryServiceSOAP11port_http_address = PropertiesUtil.getPropertiesValue("DSIB-claimQuery");

    public java.lang.String getAZXClaimQueryServiceSOAP11port_httpAddress() {
        return AZXClaimQueryServiceSOAP11port_http_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String AZXClaimQueryServiceSOAP11port_httpWSDDServiceName = "AZXClaimQueryServiceSOAP11port_http";

    public java.lang.String getAZXClaimQueryServiceSOAP11port_httpWSDDServiceName() {
        return AZXClaimQueryServiceSOAP11port_httpWSDDServiceName;
    }

    public void setAZXClaimQueryServiceSOAP11port_httpWSDDServiceName(java.lang.String name) {
        AZXClaimQueryServiceSOAP11port_httpWSDDServiceName = name;
    }

    public com.dsib.webService.AZX.claimQuery.service.AZXClaimQueryServicePortType getAZXClaimQueryServiceSOAP11port_http() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(AZXClaimQueryServiceSOAP11port_http_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getAZXClaimQueryServiceSOAP11port_http(endpoint);
    }

    public com.dsib.webService.AZX.claimQuery.service.AZXClaimQueryServicePortType getAZXClaimQueryServiceSOAP11port_http(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.dsib.webService.AZX.claimQuery.service.AZXClaimQueryServiceSOAP11BindingStub _stub = new com.dsib.webService.AZX.claimQuery.service.AZXClaimQueryServiceSOAP11BindingStub(portAddress, this);
            _stub.setPortName(getAZXClaimQueryServiceSOAP11port_httpWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setAZXClaimQueryServiceSOAP11port_httpEndpointAddress(java.lang.String address) {
        AZXClaimQueryServiceSOAP11port_http_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.dsib.webService.AZX.claimQuery.service.AZXClaimQueryServicePortType.class.isAssignableFrom(serviceEndpointInterface)) {
                com.dsib.webService.AZX.claimQuery.service.AZXClaimQueryServiceSOAP11BindingStub _stub = new com.dsib.webService.AZX.claimQuery.service.AZXClaimQueryServiceSOAP11BindingStub(new java.net.URL(AZXClaimQueryServiceSOAP11port_http_address), this);
                _stub.setPortName(getAZXClaimQueryServiceSOAP11port_httpWSDDServiceName());
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
        if ("AZXClaimQueryServiceSOAP11port_http".equals(inputPortName)) {
            return getAZXClaimQueryServiceSOAP11port_http();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://service.claimQuery.AZX.webService.dsib.com", "AZXClaimQueryService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://service.claimQuery.AZX.webService.dsib.com", "AZXClaimQueryServiceSOAP11port_http"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("AZXClaimQueryServiceSOAP11port_http".equals(portName)) {
            setAZXClaimQueryServiceSOAP11port_httpEndpointAddress(address);
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
