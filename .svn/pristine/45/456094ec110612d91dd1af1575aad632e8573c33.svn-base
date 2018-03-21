/**
 * ApplicantEhm.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.dsib.webService.AZX.insuranceSingleQuery.dto.common.xsd;

public class ApplicantEhm  implements java.io.Serializable {
    private java.lang.String appliName;

    private java.lang.String identifyNumber;

    public ApplicantEhm() {
    }

    public ApplicantEhm(
           java.lang.String appliName,
           java.lang.String identifyNumber) {
           this.appliName = appliName;
           this.identifyNumber = identifyNumber;
    }


    /**
     * Gets the appliName value for this ApplicantEhm.
     * 
     * @return appliName
     */
    public java.lang.String getAppliName() {
        return appliName;
    }


    /**
     * Sets the appliName value for this ApplicantEhm.
     * 
     * @param appliName
     */
    public void setAppliName(java.lang.String appliName) {
        this.appliName = appliName;
    }


    /**
     * Gets the identifyNumber value for this ApplicantEhm.
     * 
     * @return identifyNumber
     */
    public java.lang.String getIdentifyNumber() {
        return identifyNumber;
    }


    /**
     * Sets the identifyNumber value for this ApplicantEhm.
     * 
     * @param identifyNumber
     */
    public void setIdentifyNumber(java.lang.String identifyNumber) {
        this.identifyNumber = identifyNumber;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ApplicantEhm)) return false;
        ApplicantEhm other = (ApplicantEhm) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.appliName==null && other.getAppliName()==null) || 
             (this.appliName!=null &&
              this.appliName.equals(other.getAppliName()))) &&
            ((this.identifyNumber==null && other.getIdentifyNumber()==null) || 
             (this.identifyNumber!=null &&
              this.identifyNumber.equals(other.getIdentifyNumber())));
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
        if (getAppliName() != null) {
            _hashCode += getAppliName().hashCode();
        }
        if (getIdentifyNumber() != null) {
            _hashCode += getIdentifyNumber().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ApplicantEhm.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://common.dto.insuranceSingleQuery.AZX.webService.dsib.com/xsd", "ApplicantEhm"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("appliName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://common.dto.insuranceSingleQuery.AZX.webService.dsib.com/xsd", "appliName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("identifyNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("http://common.dto.insuranceSingleQuery.AZX.webService.dsib.com/xsd", "identifyNumber"));
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
