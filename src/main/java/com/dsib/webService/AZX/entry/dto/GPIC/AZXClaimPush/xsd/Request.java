/**
 * Request.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.dsib.webService.AZX.entry.dto.GPIC.AZXClaimPush.xsd;

public class Request  implements java.io.Serializable {
    private com.dsib.webService.AZX.entry.dto.GPIC.AZXClaimPush.common.xsd.ClaimEhm[] claimEhm;

    private java.lang.String requestType;

    public Request() {
    }

    public Request(
           com.dsib.webService.AZX.entry.dto.GPIC.AZXClaimPush.common.xsd.ClaimEhm[] claimEhm,
           java.lang.String requestType) {
           this.claimEhm = claimEhm;
           this.requestType = requestType;
    }


    /**
     * Gets the claimEhms value for this Request.
     * 
     * @return claimEhms
     */
    public com.dsib.webService.AZX.entry.dto.GPIC.AZXClaimPush.common.xsd.ClaimEhm[] getClaimEhm() {
        return claimEhm;
    }


    /**
     * Sets the claimEhms value for this Request.
     * 
     * @param claimEhms
     */
    public void setClaimEhm(com.dsib.webService.AZX.entry.dto.GPIC.AZXClaimPush.common.xsd.ClaimEhm[] claimEhm) {
        this.claimEhm = claimEhm;
    }

    public com.dsib.webService.AZX.entry.dto.GPIC.AZXClaimPush.common.xsd.ClaimEhm getClaimEhm(int i) {
        return this.claimEhm[i];
    }

    public void setClaimEhm(int i, com.dsib.webService.AZX.entry.dto.GPIC.AZXClaimPush.common.xsd.ClaimEhm _value) {
        this.claimEhm[i] = _value;
    }


    /**
     * Gets the requestType value for this Request.
     * 
     * @return requestType
     */
    public java.lang.String getRequestType() {
        return requestType;
    }


    /**
     * Sets the requestType value for this Request.
     * 
     * @param requestType
     */
    public void setRequestType(java.lang.String requestType) {
        this.requestType = requestType;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Request)) return false;
        Request other = (Request) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.claimEhm==null && other.getClaimEhm()==null) || 
             (this.claimEhm!=null &&
              java.util.Arrays.equals(this.claimEhm, other.getClaimEhm()))) &&
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
        if (getClaimEhm() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getClaimEhm());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getClaimEhm(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getRequestType() != null) {
            _hashCode += getRequestType().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Request.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://AZXClaimPush.GPIC.dto.entry.AZX.webService.dsib.com/xsd", "Request"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("claimEhms");
        elemField.setXmlName(new javax.xml.namespace.QName("http://AZXClaimPush.GPIC.dto.entry.AZX.webService.dsib.com/xsd", "claimEhms"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://common.AZXClaimPush.GPIC.dto.entry.AZX.webService.dsib.com/xsd", "ClaimEhm"));
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("requestType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://AZXClaimPush.GPIC.dto.entry.AZX.webService.dsib.com/xsd", "requestType"));
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
