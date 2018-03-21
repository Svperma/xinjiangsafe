/**
 * InsuranceSingleQueryRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.dsib.webService.AZX.insuranceSingleQuery.dto.xsd;

public class InsuranceSingleQueryRequest  implements java.io.Serializable {
    private com.dsib.webService.AZX.insuranceSingleQuery.dto.common.xsd.ApplicantEhm applicantEhm;

    private com.dsib.webService.AZX.insuranceSingleQuery.dto.common.xsd.MainEhm mainEhm;

    private java.lang.String primaryKey;

    private java.lang.String requestType;

    public InsuranceSingleQueryRequest() {
    }

    public InsuranceSingleQueryRequest(
           com.dsib.webService.AZX.insuranceSingleQuery.dto.common.xsd.ApplicantEhm applicantEhm,
           com.dsib.webService.AZX.insuranceSingleQuery.dto.common.xsd.MainEhm mainEhm,
           java.lang.String primaryKey,
           java.lang.String requestType) {
           this.applicantEhm = applicantEhm;
           this.mainEhm = mainEhm;
           this.primaryKey = primaryKey;
           this.requestType = requestType;
    }


    /**
     * Gets the applicantEhm value for this InsuranceSingleQueryRequest.
     * 
     * @return applicantEhm
     */
    public com.dsib.webService.AZX.insuranceSingleQuery.dto.common.xsd.ApplicantEhm getApplicantEhm() {
        return applicantEhm;
    }


    /**
     * Sets the applicantEhm value for this InsuranceSingleQueryRequest.
     * 
     * @param applicantEhm
     */
    public void setApplicantEhm(com.dsib.webService.AZX.insuranceSingleQuery.dto.common.xsd.ApplicantEhm applicantEhm) {
        this.applicantEhm = applicantEhm;
    }


    /**
     * Gets the mainEhm value for this InsuranceSingleQueryRequest.
     * 
     * @return mainEhm
     */
    public com.dsib.webService.AZX.insuranceSingleQuery.dto.common.xsd.MainEhm getMainEhm() {
        return mainEhm;
    }


    /**
     * Sets the mainEhm value for this InsuranceSingleQueryRequest.
     * 
     * @param mainEhm
     */
    public void setMainEhm(com.dsib.webService.AZX.insuranceSingleQuery.dto.common.xsd.MainEhm mainEhm) {
        this.mainEhm = mainEhm;
    }


    /**
     * Gets the primaryKey value for this InsuranceSingleQueryRequest.
     * 
     * @return primaryKey
     */
    public java.lang.String getPrimaryKey() {
        return primaryKey;
    }


    /**
     * Sets the primaryKey value for this InsuranceSingleQueryRequest.
     * 
     * @param primaryKey
     */
    public void setPrimaryKey(java.lang.String primaryKey) {
        this.primaryKey = primaryKey;
    }


    /**
     * Gets the requestType value for this InsuranceSingleQueryRequest.
     * 
     * @return requestType
     */
    public java.lang.String getRequestType() {
        return requestType;
    }


    /**
     * Sets the requestType value for this InsuranceSingleQueryRequest.
     * 
     * @param requestType
     */
    public void setRequestType(java.lang.String requestType) {
        this.requestType = requestType;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof InsuranceSingleQueryRequest)) return false;
        InsuranceSingleQueryRequest other = (InsuranceSingleQueryRequest) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.applicantEhm==null && other.getApplicantEhm()==null) || 
             (this.applicantEhm!=null &&
              this.applicantEhm.equals(other.getApplicantEhm()))) &&
            ((this.mainEhm==null && other.getMainEhm()==null) || 
             (this.mainEhm!=null &&
              this.mainEhm.equals(other.getMainEhm()))) &&
            ((this.primaryKey==null && other.getPrimaryKey()==null) || 
             (this.primaryKey!=null &&
              this.primaryKey.equals(other.getPrimaryKey()))) &&
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
        if (getApplicantEhm() != null) {
            _hashCode += getApplicantEhm().hashCode();
        }
        if (getMainEhm() != null) {
            _hashCode += getMainEhm().hashCode();
        }
        if (getPrimaryKey() != null) {
            _hashCode += getPrimaryKey().hashCode();
        }
        if (getRequestType() != null) {
            _hashCode += getRequestType().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(InsuranceSingleQueryRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://dto.insuranceSingleQuery.AZX.webService.dsib.com/xsd", "InsuranceSingleQueryRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("applicantEhm");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dto.insuranceSingleQuery.AZX.webService.dsib.com/xsd", "applicantEhm"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://common.dto.insuranceSingleQuery.AZX.webService.dsib.com/xsd", "ApplicantEhm"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mainEhm");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dto.insuranceSingleQuery.AZX.webService.dsib.com/xsd", "mainEhm"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://common.dto.insuranceSingleQuery.AZX.webService.dsib.com/xsd", "MainEhm"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("primaryKey");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dto.insuranceSingleQuery.AZX.webService.dsib.com/xsd", "primaryKey"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("requestType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dto.insuranceSingleQuery.AZX.webService.dsib.com/xsd", "requestType"));
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
