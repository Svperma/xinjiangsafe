/**
 * ClaimGetRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.dsib.webService.AZX.ClaimGet.dto.xsd;

public class ClaimGetRequest  implements java.io.Serializable {
    private com.dsib.webService.AZX.ClaimGet.dto.common.xsd.MainEhm mainEhm;

    private java.lang.String requestType;

    
    public ClaimGetRequest() {
    }

    public ClaimGetRequest(
           com.dsib.webService.AZX.ClaimGet.dto.common.xsd.MainEhm mainEhm,
           java.lang.String requestType) {
           this.mainEhm = mainEhm;
           this.requestType = requestType;
    }


    /**
     * Gets the mainEhm value for this ClaimGetRequest.
     * 
     * @return mainEhm
     */
    public com.dsib.webService.AZX.ClaimGet.dto.common.xsd.MainEhm getMainEhm() {
        return mainEhm;
    }


    /**
     * Sets the mainEhm value for this ClaimGetRequest.
     * 
     * @param mainEhm
     */
    public void setMainEhm(com.dsib.webService.AZX.ClaimGet.dto.common.xsd.MainEhm mainEhm) {
        this.mainEhm = mainEhm;
    }


    /**
     * Gets the requestType value for this ClaimGetRequest.
     * 
     * @return requestType
     */
    public java.lang.String getRequestType() {
        return requestType;
    }


    /**
     * Sets the requestType value for this ClaimGetRequest.
     * 
     * @param requestType
     */
    public void setRequestType(java.lang.String requestType) {
        this.requestType = requestType;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ClaimGetRequest)) return false;
        ClaimGetRequest other = (ClaimGetRequest) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.mainEhm==null && other.getMainEhm()==null) || 
             (this.mainEhm!=null &&
              this.mainEhm.equals(other.getMainEhm()))) &&
            ((this.requestType==null && other.getRequestType()==null) || 
             (this.requestType!=null &&
              this.requestType.equals(other.getRequestType())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getMainEhm() != null) {
            _hashCode += getMainEhm().hashCode();
        }
        if (getRequestType() != null) {
            _hashCode += getRequestType().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ClaimGetRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://dto.ClaimGet.AZX.webService.dsib.com/xsd", "ClaimGetRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mainEhm");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dto.ClaimGet.AZX.webService.dsib.com/xsd", "mainEhm"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://common.dto.ClaimGet.AZX.webService.dsib.com/xsd", "MainEhm"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("requestType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dto.ClaimGet.AZX.webService.dsib.com/xsd", "requestType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
