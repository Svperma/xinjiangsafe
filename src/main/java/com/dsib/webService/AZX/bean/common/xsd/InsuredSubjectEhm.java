/**
 * InsuredSubjectEhm.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.dsib.webService.AZX.bean.common.xsd;

public class InsuredSubjectEhm  implements java.io.Serializable {
    private java.lang.String insuredObjectPerIdentifyNumber;

    private java.lang.String insuredObjectPerIdentifyType;

    private java.lang.String insuredObjectPerName;

    private java.lang.String insuredObjectPerNo;

    public InsuredSubjectEhm() {
    }

    public InsuredSubjectEhm(
           java.lang.String insuredObjectPerIdentifyNumber,
           java.lang.String insuredObjectPerIdentifyType,
           java.lang.String insuredObjectPerName,
           java.lang.String insuredObjectPerNo) {
           this.insuredObjectPerIdentifyNumber = insuredObjectPerIdentifyNumber;
           this.insuredObjectPerIdentifyType = insuredObjectPerIdentifyType;
           this.insuredObjectPerName = insuredObjectPerName;
           this.insuredObjectPerNo = insuredObjectPerNo;
    }


    /**
     * Gets the insuredObjectPerIdentifyNumber value for this InsuredSubjectEhm.
     * 
     * @return insuredObjectPerIdentifyNumber
     */
    public java.lang.String getInsuredObjectPerIdentifyNumber() {
        return insuredObjectPerIdentifyNumber;
    }


    /**
     * Sets the insuredObjectPerIdentifyNumber value for this InsuredSubjectEhm.
     * 
     * @param insuredObjectPerIdentifyNumber
     */
    public void setInsuredObjectPerIdentifyNumber(java.lang.String insuredObjectPerIdentifyNumber) {
        this.insuredObjectPerIdentifyNumber = insuredObjectPerIdentifyNumber;
    }


    /**
     * Gets the insuredObjectPerIdentifyType value for this InsuredSubjectEhm.
     * 
     * @return insuredObjectPerIdentifyType
     */
    public java.lang.String getInsuredObjectPerIdentifyType() {
        return insuredObjectPerIdentifyType;
    }


    /**
     * Sets the insuredObjectPerIdentifyType value for this InsuredSubjectEhm.
     * 
     * @param insuredObjectPerIdentifyType
     */
    public void setInsuredObjectPerIdentifyType(java.lang.String insuredObjectPerIdentifyType) {
        this.insuredObjectPerIdentifyType = insuredObjectPerIdentifyType;
    }


    /**
     * Gets the insuredObjectPerName value for this InsuredSubjectEhm.
     * 
     * @return insuredObjectPerName
     */
    public java.lang.String getInsuredObjectPerName() {
        return insuredObjectPerName;
    }


    /**
     * Sets the insuredObjectPerName value for this InsuredSubjectEhm.
     * 
     * @param insuredObjectPerName
     */
    public void setInsuredObjectPerName(java.lang.String insuredObjectPerName) {
        this.insuredObjectPerName = insuredObjectPerName;
    }


    /**
     * Gets the insuredObjectPerNo value for this InsuredSubjectEhm.
     * 
     * @return insuredObjectPerNo
     */
    public java.lang.String getInsuredObjectPerNo() {
        return insuredObjectPerNo;
    }


    /**
     * Sets the insuredObjectPerNo value for this InsuredSubjectEhm.
     * 
     * @param insuredObjectPerNo
     */
    public void setInsuredObjectPerNo(java.lang.String insuredObjectPerNo) {
        this.insuredObjectPerNo = insuredObjectPerNo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof InsuredSubjectEhm)) return false;
        InsuredSubjectEhm other = (InsuredSubjectEhm) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.insuredObjectPerIdentifyNumber==null && other.getInsuredObjectPerIdentifyNumber()==null) || 
             (this.insuredObjectPerIdentifyNumber!=null &&
              this.insuredObjectPerIdentifyNumber.equals(other.getInsuredObjectPerIdentifyNumber()))) &&
            ((this.insuredObjectPerIdentifyType==null && other.getInsuredObjectPerIdentifyType()==null) || 
             (this.insuredObjectPerIdentifyType!=null &&
              this.insuredObjectPerIdentifyType.equals(other.getInsuredObjectPerIdentifyType()))) &&
            ((this.insuredObjectPerName==null && other.getInsuredObjectPerName()==null) || 
             (this.insuredObjectPerName!=null &&
              this.insuredObjectPerName.equals(other.getInsuredObjectPerName()))) &&
            ((this.insuredObjectPerNo==null && other.getInsuredObjectPerNo()==null) || 
             (this.insuredObjectPerNo!=null &&
              this.insuredObjectPerNo.equals(other.getInsuredObjectPerNo())));
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
        if (getInsuredObjectPerIdentifyNumber() != null) {
            _hashCode += getInsuredObjectPerIdentifyNumber().hashCode();
        }
        if (getInsuredObjectPerIdentifyType() != null) {
            _hashCode += getInsuredObjectPerIdentifyType().hashCode();
        }
        if (getInsuredObjectPerName() != null) {
            _hashCode += getInsuredObjectPerName().hashCode();
        }
        if (getInsuredObjectPerNo() != null) {
            _hashCode += getInsuredObjectPerNo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(InsuredSubjectEhm.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://common.bean.AZX.webService.dsib.com/xsd", "InsuredSubjectEhm"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("insuredObjectPerIdentifyNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("http://common.bean.AZX.webService.dsib.com/xsd", "insuredObjectPerIdentifyNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("insuredObjectPerIdentifyType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://common.bean.AZX.webService.dsib.com/xsd", "insuredObjectPerIdentifyType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("insuredObjectPerName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://common.bean.AZX.webService.dsib.com/xsd", "insuredObjectPerName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("insuredObjectPerNo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://common.bean.AZX.webService.dsib.com/xsd", "insuredObjectPerNo"));
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
