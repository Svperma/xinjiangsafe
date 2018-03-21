/**
 * Response.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.dsib.webService.AZX.entry.dto.GPIC.AZXClaimPush.xsd;

public class Response  implements java.io.Serializable {
    private com.dsib.webService.AZX.claimPush.dto.common.xsd.ClaimEhm[] claimEhms;

    private java.lang.String requestType;

    private java.lang.String responseCode;

    private java.lang.String responseName;

    public Response() {
    }

    public Response(
           com.dsib.webService.AZX.claimPush.dto.common.xsd.ClaimEhm[] claimEhms,
           java.lang.String requestType,
           java.lang.String responseCode,
           java.lang.String responseName) {
           this.claimEhms = claimEhms;
           this.requestType = requestType;
           this.responseCode = responseCode;
           this.responseName = responseName;
    }


    /**
     * Gets the claimEhms value for this Response.
     * 
     * @return claimEhms
     */
    public com.dsib.webService.AZX.claimPush.dto.common.xsd.ClaimEhm[] getClaimEhms() {
        return claimEhms;
    }


    /**
     * Sets the claimEhms value for this Response.
     * 
     * @param claimEhms
     */
    public void setClaimEhms(com.dsib.webService.AZX.claimPush.dto.common.xsd.ClaimEhm[] claimEhms) {
        this.claimEhms = claimEhms;
    }

    public com.dsib.webService.AZX.claimPush.dto.common.xsd.ClaimEhm getClaimEhms(int i) {
        return this.claimEhms[i];
    }

    public void setClaimEhms(int i, com.dsib.webService.AZX.claimPush.dto.common.xsd.ClaimEhm _value) {
        this.claimEhms[i] = _value;
    }


    /**
     * Gets the requestType value for this Response.
     * 
     * @return requestType
     */
    public java.lang.String getRequestType() {
        return requestType;
    }


    /**
     * Sets the requestType value for this Response.
     * 
     * @param requestType
     */
    public void setRequestType(java.lang.String requestType) {
        this.requestType = requestType;
    }


    /**
     * Gets the responseCode value for this Response.
     * 
     * @return responseCode
     */
    public java.lang.String getResponseCode() {
        return responseCode;
    }


    /**
     * Sets the responseCode value for this Response.
     * 
     * @param responseCode
     */
    public void setResponseCode(java.lang.String responseCode) {
        this.responseCode = responseCode;
    }


    /**
     * Gets the responseName value for this Response.
     * 
     * @return responseName
     */
    public java.lang.String getResponseName() {
        return responseName;
    }


    /**
     * Sets the responseName value for this Response.
     * 
     * @param responseName
     */
    public void setResponseName(java.lang.String responseName) {
        this.responseName = responseName;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Response)) return false;
        Response other = (Response) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.claimEhms==null && other.getClaimEhms()==null) || 
             (this.claimEhms!=null &&
              java.util.Arrays.equals(this.claimEhms, other.getClaimEhms()))) &&
            ((this.requestType==null && other.getRequestType()==null) || 
             (this.requestType!=null &&
              this.requestType.equals(other.getRequestType()))) &&
            ((this.responseCode==null && other.getResponseCode()==null) || 
             (this.responseCode!=null &&
              this.responseCode.equals(other.getResponseCode()))) &&
            ((this.responseName==null && other.getResponseName()==null) || 
             (this.responseName!=null &&
              this.responseName.equals(other.getResponseName())));
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
        if (getClaimEhms() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getClaimEhms());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getClaimEhms(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getRequestType() != null) {
            _hashCode += getRequestType().hashCode();
        }
        if (getResponseCode() != null) {
            _hashCode += getResponseCode().hashCode();
        }
        if (getResponseName() != null) {
            _hashCode += getResponseName().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Response.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://AZXClaimPush.GPIC.dto.entry.AZX.webService.dsib.com/xsd", "Response"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("claimEhms");
        elemField.setXmlName(new javax.xml.namespace.QName("http://AZXClaimPush.GPIC.dto.entry.AZX.webService.dsib.com/xsd", "claimEhms"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://common.dto.claimPush.AZX.webService.dsib.com/xsd", "ClaimEhm"));
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("requestType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://AZXClaimPush.GPIC.dto.entry.AZX.webService.dsib.com/xsd", "requestType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("responseCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://AZXClaimPush.GPIC.dto.entry.AZX.webService.dsib.com/xsd", "responseCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("responseName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://AZXClaimPush.GPIC.dto.entry.AZX.webService.dsib.com/xsd", "responseName"));
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
