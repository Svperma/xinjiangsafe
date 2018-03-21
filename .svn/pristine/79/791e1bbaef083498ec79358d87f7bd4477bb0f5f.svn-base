/**
 * AZXManualUnderwriteAfterSingleServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.dsib.webService.AZX.manualUnderwriteAfterSingle.service;

import com.dsib.util.PropertiesUtil;

public class AZXManualUnderwriteAfterSingleServiceLocator extends org.apache.axis.client.Service implements com.dsib.webService.AZX.manualUnderwriteAfterSingle.service.AZXManualUnderwriteAfterSingleService {

    public AZXManualUnderwriteAfterSingleServiceLocator() {
    }


    public AZXManualUnderwriteAfterSingleServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public AZXManualUnderwriteAfterSingleServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for AZXManualUnderwriteAfterSingleServiceSOAP11port_http
    private java.lang.String AZXManualUnderwriteAfterSingleServiceSOAP11port_http_address = PropertiesUtil.getPropertiesValue("DSIB-manualUnderwriteAfterSingle");

    public java.lang.String getAZXManualUnderwriteAfterSingleServiceSOAP11port_httpAddress() {
        return AZXManualUnderwriteAfterSingleServiceSOAP11port_http_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String AZXManualUnderwriteAfterSingleServiceSOAP11port_httpWSDDServiceName = "AZXManualUnderwriteAfterSingleServiceSOAP11port_http";

    public java.lang.String getAZXManualUnderwriteAfterSingleServiceSOAP11port_httpWSDDServiceName() {
        return AZXManualUnderwriteAfterSingleServiceSOAP11port_httpWSDDServiceName;
    }

    public void setAZXManualUnderwriteAfterSingleServiceSOAP11port_httpWSDDServiceName(java.lang.String name) {
        AZXManualUnderwriteAfterSingleServiceSOAP11port_httpWSDDServiceName = name;
    }

    public com.dsib.webService.AZX.manualUnderwriteAfterSingle.service.AZXManualUnderwriteAfterSingleServicePortType getAZXManualUnderwriteAfterSingleServiceSOAP11port_http() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(AZXManualUnderwriteAfterSingleServiceSOAP11port_http_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getAZXManualUnderwriteAfterSingleServiceSOAP11port_http(endpoint);
    }

    public com.dsib.webService.AZX.manualUnderwriteAfterSingle.service.AZXManualUnderwriteAfterSingleServicePortType getAZXManualUnderwriteAfterSingleServiceSOAP11port_http(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.dsib.webService.AZX.manualUnderwriteAfterSingle.service.AZXManualUnderwriteAfterSingleServiceSOAP11BindingStub _stub = new com.dsib.webService.AZX.manualUnderwriteAfterSingle.service.AZXManualUnderwriteAfterSingleServiceSOAP11BindingStub(portAddress, this);
            _stub.setPortName(getAZXManualUnderwriteAfterSingleServiceSOAP11port_httpWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setAZXManualUnderwriteAfterSingleServiceSOAP11port_httpEndpointAddress(java.lang.String address) {
        AZXManualUnderwriteAfterSingleServiceSOAP11port_http_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.dsib.webService.AZX.manualUnderwriteAfterSingle.service.AZXManualUnderwriteAfterSingleServicePortType.class.isAssignableFrom(serviceEndpointInterface)) {
                com.dsib.webService.AZX.manualUnderwriteAfterSingle.service.AZXManualUnderwriteAfterSingleServiceSOAP11BindingStub _stub = new com.dsib.webService.AZX.manualUnderwriteAfterSingle.service.AZXManualUnderwriteAfterSingleServiceSOAP11BindingStub(new java.net.URL(AZXManualUnderwriteAfterSingleServiceSOAP11port_http_address), this);
                _stub.setPortName(getAZXManualUnderwriteAfterSingleServiceSOAP11port_httpWSDDServiceName());
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
        if ("AZXManualUnderwriteAfterSingleServiceSOAP11port_http".equals(inputPortName)) {
            return getAZXManualUnderwriteAfterSingleServiceSOAP11port_http();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://service.manualUnderwriteAfterSingle.AZX.webService.dsib.com", "AZXManualUnderwriteAfterSingleService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://service.manualUnderwriteAfterSingle.AZX.webService.dsib.com", "AZXManualUnderwriteAfterSingleServiceSOAP11port_http"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("AZXManualUnderwriteAfterSingleServiceSOAP11port_http".equals(portName)) {
            setAZXManualUnderwriteAfterSingleServiceSOAP11port_httpEndpointAddress(address);
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
