/**
 * InsuranceSingleRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.dsib.webService.AZX.insuranceSingle.dto.xsd;

public class InsuranceSingleRequest  implements java.io.Serializable {
    private com.dsib.webService.AZX.bean.common.xsd.ApplicantEhm applicantEhm;

    private com.dsib.webService.AZX.bean.common.xsd.InsuredEhm insuredEhm;

    private com.dsib.webService.AZX.bean.common.xsd.InsuredSubjectEhm[] insuredSubjectArray;

    private com.dsib.webService.AZX.bean.common.xsd.ItemKindEhm[] itemKindEhmArray;

    private com.dsib.webService.AZX.bean.common.xsd.MainEhm mainEhm;

    private java.lang.String primaryKey;

    private java.lang.String requestType;

    public InsuranceSingleRequest() {
    }

    public InsuranceSingleRequest(
           com.dsib.webService.AZX.bean.common.xsd.ApplicantEhm applicantEhm,
           com.dsib.webService.AZX.bean.common.xsd.InsuredEhm insuredEhm,
           com.dsib.webService.AZX.bean.common.xsd.InsuredSubjectEhm[] insuredSubjectArray,
           com.dsib.webService.AZX.bean.common.xsd.ItemKindEhm[] itemKindEhmArray,
           com.dsib.webService.AZX.bean.common.xsd.MainEhm mainEhm,
           java.lang.String primaryKey,
           java.lang.String requestType) {
           this.applicantEhm = applicantEhm;
           this.insuredEhm = insuredEhm;
           this.insuredSubjectArray = insuredSubjectArray;
           this.itemKindEhmArray = itemKindEhmArray;
           this.mainEhm = mainEhm;
           this.primaryKey = primaryKey;
           this.requestType = requestType;
    }


    /**
     * Gets the applicantEhm value for this InsuranceSingleRequest.
     * 
     * @return applicantEhm
     */
    public com.dsib.webService.AZX.bean.common.xsd.ApplicantEhm getApplicantEhm() {
        return applicantEhm;
    }


    /**
     * Sets the applicantEhm value for this InsuranceSingleRequest.
     * 
     * @param applicantEhm
     */
    public void setApplicantEhm(com.dsib.webService.AZX.bean.common.xsd.ApplicantEhm applicantEhm) {
        this.applicantEhm = applicantEhm;
    }


    /**
     * Gets the insuredEhm value for this InsuranceSingleRequest.
     * 
     * @return insuredEhm
     */
    public com.dsib.webService.AZX.bean.common.xsd.InsuredEhm getInsuredEhm() {
        return insuredEhm;
    }


    /**
     * Sets the insuredEhm value for this InsuranceSingleRequest.
     * 
     * @param insuredEhm
     */
    public void setInsuredEhm(com.dsib.webService.AZX.bean.common.xsd.InsuredEhm insuredEhm) {
        this.insuredEhm = insuredEhm;
    }


    /**
     * Gets the insuredSubjectArray value for this InsuranceSingleRequest.
     * 
     * @return insuredSubjectArray
     */
    public com.dsib.webService.AZX.bean.common.xsd.InsuredSubjectEhm[] getInsuredSubjectArray() {
        return insuredSubjectArray;
    }


    /**
     * Sets the insuredSubjectArray value for this InsuranceSingleRequest.
     * 
     * @param insuredSubjectArray
     */
    public void setInsuredSubjectArray(com.dsib.webService.AZX.bean.common.xsd.InsuredSubjectEhm[] insuredSubjectArray) {
        this.insuredSubjectArray = insuredSubjectArray;
    }

    public com.dsib.webService.AZX.bean.common.xsd.InsuredSubjectEhm getInsuredSubjectArray(int i) {
        return this.insuredSubjectArray[i];
    }

    public void setInsuredSubjectArray(int i, com.dsib.webService.AZX.bean.common.xsd.InsuredSubjectEhm _value) {
        this.insuredSubjectArray[i] = _value;
    }


    /**
     * Gets the itemKindEhmArray value for this InsuranceSingleRequest.
     * 
     * @return itemKindEhmArray
     */
    public com.dsib.webService.AZX.bean.common.xsd.ItemKindEhm[] getItemKindEhmArray() {
        return itemKindEhmArray;
    }


    /**
     * Sets the itemKindEhmArray value for this InsuranceSingleRequest.
     * 
     * @param itemKindEhmArray
     */
    public void setItemKindEhmArray(com.dsib.webService.AZX.bean.common.xsd.ItemKindEhm[] itemKindEhmArray) {
        this.itemKindEhmArray = itemKindEhmArray;
    }

    public com.dsib.webService.AZX.bean.common.xsd.ItemKindEhm getItemKindEhmArray(int i) {
        return this.itemKindEhmArray[i];
    }

    public void setItemKindEhmArray(int i, com.dsib.webService.AZX.bean.common.xsd.ItemKindEhm _value) {
        this.itemKindEhmArray[i] = _value;
    }


    /**
     * Gets the mainEhm value for this InsuranceSingleRequest.
     * 
     * @return mainEhm
     */
    public com.dsib.webService.AZX.bean.common.xsd.MainEhm getMainEhm() {
        return mainEhm;
    }


    /**
     * Sets the mainEhm value for this InsuranceSingleRequest.
     * 
     * @param mainEhm
     */
    public void setMainEhm(com.dsib.webService.AZX.bean.common.xsd.MainEhm mainEhm) {
        this.mainEhm = mainEhm;
    }


    /**
     * Gets the primaryKey value for this InsuranceSingleRequest.
     * 
     * @return primaryKey
     */
    public java.lang.String getPrimaryKey() {
        return primaryKey;
    }


    /**
     * Sets the primaryKey value for this InsuranceSingleRequest.
     * 
     * @param primaryKey
     */
    public void setPrimaryKey(java.lang.String primaryKey) {
        this.primaryKey = primaryKey;
    }


    /**
     * Gets the requestType value for this InsuranceSingleRequest.
     * 
     * @return requestType
     */
    public java.lang.String getRequestType() {
        return requestType;
    }


    /**
     * Sets the requestType value for this InsuranceSingleRequest.
     * 
     * @param requestType
     */
    public void setRequestType(java.lang.String requestType) {
        this.requestType = requestType;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof InsuranceSingleRequest)) return false;
        InsuranceSingleRequest other = (InsuranceSingleRequest) obj;
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
            ((this.insuredEhm==null && other.getInsuredEhm()==null) || 
             (this.insuredEhm!=null &&
              this.insuredEhm.equals(other.getInsuredEhm()))) &&
            ((this.insuredSubjectArray==null && other.getInsuredSubjectArray()==null) || 
             (this.insuredSubjectArray!=null &&
              java.util.Arrays.equals(this.insuredSubjectArray, other.getInsuredSubjectArray()))) &&
            ((this.itemKindEhmArray==null && other.getItemKindEhmArray()==null) || 
             (this.itemKindEhmArray!=null &&
              java.util.Arrays.equals(this.itemKindEhmArray, other.getItemKindEhmArray()))) &&
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
        if (getInsuredEhm() != null) {
            _hashCode += getInsuredEhm().hashCode();
        }
        if (getInsuredSubjectArray() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getInsuredSubjectArray());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getInsuredSubjectArray(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getItemKindEhmArray() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getItemKindEhmArray());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getItemKindEhmArray(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
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
        new org.apache.axis.description.TypeDesc(InsuranceSingleRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://dto.insuranceSingle.AZX.webService.dsib.com/xsd", "InsuranceSingleRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("applicantEhm");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dto.insuranceSingle.AZX.webService.dsib.com/xsd", "applicantEhm"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://common.bean.AZX.webService.dsib.com/xsd", "ApplicantEhm"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("insuredEhm");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dto.insuranceSingle.AZX.webService.dsib.com/xsd", "insuredEhm"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://common.bean.AZX.webService.dsib.com/xsd", "InsuredEhm"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("insuredSubjectArray");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dto.insuranceSingle.AZX.webService.dsib.com/xsd", "insuredSubjectArray"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://common.bean.AZX.webService.dsib.com/xsd", "InsuredSubjectEhm"));
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("itemKindEhmArray");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dto.insuranceSingle.AZX.webService.dsib.com/xsd", "itemKindEhmArray"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://common.bean.AZX.webService.dsib.com/xsd", "ItemKindEhm"));
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mainEhm");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dto.insuranceSingle.AZX.webService.dsib.com/xsd", "mainEhm"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://common.bean.AZX.webService.dsib.com/xsd", "MainEhm"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("primaryKey");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dto.insuranceSingle.AZX.webService.dsib.com/xsd", "primaryKey"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("requestType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dto.insuranceSingle.AZX.webService.dsib.com/xsd", "requestType"));
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
