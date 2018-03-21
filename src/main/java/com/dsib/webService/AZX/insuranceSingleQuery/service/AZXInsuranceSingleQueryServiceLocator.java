/**
 * AZXInsuranceSingleQueryServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.dsib.webService.AZX.insuranceSingleQuery.service;

import com.dsib.util.PropertiesUtil;

public class AZXInsuranceSingleQueryServiceLocator extends org.apache.axis.client.Service implements com.dsib.webService.AZX.insuranceSingleQuery.service.AZXInsuranceSingleQueryService {

    public AZXInsuranceSingleQueryServiceLocator() {
    }


    public AZXInsuranceSingleQueryServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public AZXInsuranceSingleQueryServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for AZXInsuranceSingleQueryServiceSOAP11port_http
    private java.lang.String AZXInsuranceSingleQueryServiceSOAP11port_http_address = PropertiesUtil.getPropertiesValue("DSIB-insuranceSingleQuery");

    public java.lang.String getAZXInsuranceSingleQueryServiceSOAP11port_httpAddress() {
        return AZXInsuranceSingleQueryServiceSOAP11port_http_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String AZXInsuranceSingleQueryServiceSOAP11port_httpWSDDServiceName = "AZXInsuranceSingleQueryServiceSOAP11port_http";

    public java.lang.String getAZXInsuranceSingleQueryServiceSOAP11port_httpWSDDServiceName() {
        return AZXInsuranceSingleQueryServiceSOAP11port_httpWSDDServiceName;
    }

    public void setAZXInsuranceSingleQueryServiceSOAP11port_httpWSDDServiceName(java.lang.String name) {
        AZXInsuranceSingleQueryServiceSOAP11port_httpWSDDServiceName = name;
    }

    public com.dsib.webService.AZX.insuranceSingleQuery.service.AZXInsuranceSingleQueryServicePortType getAZXInsuranceSingleQueryServiceSOAP11port_http() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(AZXInsuranceSingleQueryServiceSOAP11port_http_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getAZXInsuranceSingleQueryServiceSOAP11port_http(endpoint);
    }

    public com.dsib.webService.AZX.insuranceSingleQuery.service.AZXInsuranceSingleQueryServicePortType getAZXInsuranceSingleQueryServiceSOAP11port_http(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.dsib.webService.AZX.insuranceSingleQuery.service.AZXInsuranceSingleQueryServiceSOAP11BindingStub _stub = new com.dsib.webService.AZX.insuranceSingleQuery.service.AZXInsuranceSingleQueryServiceSOAP11BindingStub(portAddress, this);
            _stub.setPortName(getAZXInsuranceSingleQueryServiceSOAP11port_httpWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setAZXInsuranceSingleQueryServiceSOAP11port_httpEndpointAddress(java.lang.String address) {
        AZXInsuranceSingleQueryServiceSOAP11port_http_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.dsib.webService.AZX.insuranceSingleQuery.service.AZXInsuranceSingleQueryServicePortType.class.isAssignableFrom(serviceEndpointInterface)) {
                com.dsib.webService.AZX.insuranceSingleQuery.service.AZXInsuranceSingleQueryServiceSOAP11BindingStub _stub = new com.dsib.webService.AZX.insuranceSingleQuery.service.AZXInsuranceSingleQueryServiceSOAP11BindingStub(new java.net.URL(AZXInsuranceSingleQueryServiceSOAP11port_http_address), this);
                _stub.setPortName(getAZXInsuranceSingleQueryServiceSOAP11port_httpWSDDServiceName());
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
        if ("AZXInsuranceSingleQueryServiceSOAP11port_http".equals(inputPortName)) {
            return getAZXInsuranceSingleQueryServiceSOAP11port_http();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://service.insuranceSingleQuery.AZX.webService.dsib.com", "AZXInsuranceSingleQueryService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://service.insuranceSingleQuery.AZX.webService.dsib.com", "AZXInsuranceSingleQueryServiceSOAP11port_http"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("AZXInsuranceSingleQueryServiceSOAP11port_http".equals(portName)) {
            setAZXInsuranceSingleQueryServiceSOAP11port_httpEndpointAddress(address);
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
