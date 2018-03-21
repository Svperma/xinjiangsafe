/**
 * InsuranceSingleQueryResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.dsib.webService.AZX.insuranceSingleQuery.dto.xsd;

public class InsuranceSingleQueryResponse  implements java.io.Serializable {
    private java.lang.String actualPremium;

    private java.lang.String censorContent;

    private java.lang.String errorNo;

    private com.dsib.webService.AZX.bean.common.xsd.ItemKindEhm[] itemKindEhmarry;

    private java.lang.String primaryKey;

    private java.lang.String proposalNo;

    private java.lang.String proposalState;

    private java.lang.String requestType;

    private java.lang.String responseCode;

    private java.lang.String responseName;

    private java.lang.String sendDateTime;

    private java.lang.String spreadsheetPremium;

    public InsuranceSingleQueryResponse() {
    }

    public InsuranceSingleQueryResponse(
           java.lang.String actualPremium,
           java.lang.String censorContent,
           java.lang.String errorNo,
           com.dsib.webService.AZX.bean.common.xsd.ItemKindEhm[] itemKindEhmarry,
           java.lang.String primaryKey,
           java.lang.String proposalNo,
           java.lang.String proposalState,
           java.lang.String requestType,
           java.lang.String responseCode,
           java.lang.String responseName,
           java.lang.String sendDateTime,
           java.lang.String spreadsheetPremium) {
           this.actualPremium = actualPremium;
           this.censorContent = censorContent;
           this.errorNo = errorNo;
           this.itemKindEhmarry = itemKindEhmarry;
           this.primaryKey = primaryKey;
           this.proposalNo = proposalNo;
           this.proposalState = proposalState;
           this.requestType = requestType;
           this.responseCode = responseCode;
           this.responseName = responseName;
           this.sendDateTime = sendDateTime;
           this.spreadsheetPremium = spreadsheetPremium;
    }


    /**
     * Gets the actualPremium value for this InsuranceSingleQueryResponse.
     * 
     * @return actualPremium
     */
    public java.lang.String getActualPremium() {
        return actualPremium;
    }


    /**
     * Sets the actualPremium value for this InsuranceSingleQueryResponse.
     * 
     * @param actualPremium
     */
    public void setActualPremium(java.lang.String actualPremium) {
        this.actualPremium = actualPremium;
    }


    /**
     * Gets the censorContent value for this InsuranceSingleQueryResponse.
     * 
     * @return censorContent
     */
    public java.lang.String getCensorContent() {
        return censorContent;
    }


    /**
     * Sets the censorContent value for this InsuranceSingleQueryResponse.
     * 
     * @param censorContent
     */
    public void setCensorContent(java.lang.String censorContent) {
        this.censorContent = censorContent;
    }


    /**
     * Gets the errorNo value for this InsuranceSingleQueryResponse.
     * 
     * @return errorNo
     */
    public java.lang.String getErrorNo() {
        return errorNo;
    }


    /**
     * Sets the errorNo value for this InsuranceSingleQueryResponse.
     * 
     * @param errorNo
     */
    public void setErrorNo(java.lang.String errorNo) {
        this.errorNo = errorNo;
    }


    /**
     * Gets the itemKindEhmarry value for this InsuranceSingleQueryResponse.
     * 
     * @return itemKindEhmarry
     */
    public com.dsib.webService.AZX.bean.common.xsd.ItemKindEhm[] getItemKindEhmarry() {
        return itemKindEhmarry;
    }


    /**
     * Sets the itemKindEhmarry value for this InsuranceSingleQueryResponse.
     * 
     * @param itemKindEhmarry
     */
    public void setItemKindEhmarry(com.dsib.webService.AZX.bean.common.xsd.ItemKindEhm[] itemKindEhmarry) {
        this.itemKindEhmarry = itemKindEhmarry;
    }

    public com.dsib.webService.AZX.bean.common.xsd.ItemKindEhm getItemKindEhmarry(int i) {
        return this.itemKindEhmarry[i];
    }

    public void setItemKindEhmarry(int i, com.dsib.webService.AZX.bean.common.xsd.ItemKindEhm _value) {
        this.itemKindEhmarry[i] = _value;
    }


    /**
     * Gets the primaryKey value for this InsuranceSingleQueryResponse.
     * 
     * @return primaryKey
     */
    public java.lang.String getPrimaryKey() {
        return primaryKey;
    }


    /**
     * Sets the primaryKey value for this InsuranceSingleQueryResponse.
     * 
     * @param primaryKey
     */
    public void setPrimaryKey(java.lang.String primaryKey) {
        this.primaryKey = primaryKey;
    }


    /**
     * Gets the proposalNo value for this InsuranceSingleQueryResponse.
     * 
     * @return proposalNo
     */
    public java.lang.String getProposalNo() {
        return proposalNo;
    }


    /**
     * Sets the proposalNo value for this InsuranceSingleQueryResponse.
     * 
     * @param proposalNo
     */
    public void setProposalNo(java.lang.String proposalNo) {
        this.proposalNo = proposalNo;
    }


    /**
     * Gets the proposalState value for this InsuranceSingleQueryResponse.
     * 
     * @return proposalState
     */
    public java.lang.String getProposalState() {
        return proposalState;
    }


    /**
     * Sets the proposalState value for this InsuranceSingleQueryResponse.
     * 
     * @param proposalState
     */
    public void setProposalState(java.lang.String proposalState) {
        this.proposalState = proposalState;
    }


    /**
     * Gets the requestType value for this InsuranceSingleQueryResponse.
     * 
     * @return requestType
     */
    public java.lang.String getRequestType() {
        return requestType;
    }


    /**
     * Sets the requestType value for this InsuranceSingleQueryResponse.
     * 
     * @param requestType
     */
    public void setRequestType(java.lang.String requestType) {
        this.requestType = requestType;
    }


    /**
     * Gets the responseCode value for this InsuranceSingleQueryResponse.
     * 
     * @return responseCode
     */
    public java.lang.String getResponseCode() {
        return responseCode;
    }


    /**
     * Sets the responseCode value for this InsuranceSingleQueryResponse.
     * 
     * @param responseCode
     */
    public void setResponseCode(java.lang.String responseCode) {
        this.responseCode = responseCode;
    }


    /**
     * Gets the responseName value for this InsuranceSingleQueryResponse.
     * 
     * @return responseName
     */
    public java.lang.String getResponseName() {
        return responseName;
    }


    /**
     * Sets the responseName value for this InsuranceSingleQueryResponse.
     * 
     * @param responseName
     */
    public void setResponseName(java.lang.String responseName) {
        this.responseName = responseName;
    }


    /**
     * Gets the sendDateTime value for this InsuranceSingleQueryResponse.
     * 
     * @return sendDateTime
     */
    public java.lang.String getSendDateTime() {
        return sendDateTime;
    }


    /**
     * Sets the sendDateTime value for this InsuranceSingleQueryResponse.
     * 
     * @param sendDateTime
     */
    public void setSendDateTime(java.lang.String sendDateTime) {
        this.sendDateTime = sendDateTime;
    }


    /**
     * Gets the spreadsheetPremium value for this InsuranceSingleQueryResponse.
     * 
     * @return spreadsheetPremium
     */
    public java.lang.String getSpreadsheetPremium() {
        return spreadsheetPremium;
    }


    /**
     * Sets the spreadsheetPremium value for this InsuranceSingleQueryResponse.
     * 
     * @param spreadsheetPremium
     */
    public void setSpreadsheetPremium(java.lang.String spreadsheetPremium) {
        this.spreadsheetPremium = spreadsheetPremium;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof InsuranceSingleQueryResponse)) return false;
        InsuranceSingleQueryResponse other = (InsuranceSingleQueryResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.actualPremium==null && other.getActualPremium()==null) || 
             (this.actualPremium!=null &&
              this.actualPremium.equals(other.getActualPremium()))) &&
            ((this.censorContent==null && other.getCensorContent()==null) || 
             (this.censorContent!=null &&
              this.censorContent.equals(other.getCensorContent()))) &&
            ((this.errorNo==null && other.getErrorNo()==null) || 
             (this.errorNo!=null &&
              this.errorNo.equals(other.getErrorNo()))) &&
            ((this.itemKindEhmarry==null && other.getItemKindEhmarry()==null) || 
             (this.itemKindEhmarry!=null &&
              java.util.Arrays.equals(this.itemKindEhmarry, other.getItemKindEhmarry()))) &&
            ((this.primaryKey==null && other.getPrimaryKey()==null) || 
             (this.primaryKey!=null &&
              this.primaryKey.equals(other.getPrimaryKey()))) &&
            ((this.proposalNo==null && other.getProposalNo()==null) || 
             (this.proposalNo!=null &&
              this.proposalNo.equals(other.getProposalNo()))) &&
            ((this.proposalState==null && other.getProposalState()==null) || 
             (this.proposalState!=null &&
              this.proposalState.equals(other.getProposalState()))) &&
            ((this.requestType==null && other.getRequestType()==null) || 
             (this.requestType!=null &&
              this.requestType.equals(other.getRequestType()))) &&
            ((this.responseCode==null && other.getResponseCode()==null) || 
             (this.responseCode!=null &&
              this.responseCode.equals(other.getResponseCode()))) &&
            ((this.responseName==null && other.getResponseName()==null) || 
             (this.responseName!=null &&
              this.responseName.equals(other.getResponseName()))) &&
            ((this.sendDateTime==null && other.getSendDateTime()==null) || 
             (this.sendDateTime!=null &&
              this.sendDateTime.equals(other.getSendDateTime()))) &&
            ((this.spreadsheetPremium==null && other.getSpreadsheetPremium()==null) || 
             (this.spreadsheetPremium!=null &&
              this.spreadsheetPremium.equals(other.getSpreadsheetPremium())));
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
        if (getActualPremium() != null) {
            _hashCode += getActualPremium().hashCode();
        }
        if (getCensorContent() != null) {
            _hashCode += getCensorContent().hashCode();
        }
        if (getErrorNo() != null) {
            _hashCode += getErrorNo().hashCode();
        }
        if (getItemKindEhmarry() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getItemKindEhmarry());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getItemKindEhmarry(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getPrimaryKey() != null) {
            _hashCode += getPrimaryKey().hashCode();
        }
        if (getProposalNo() != null) {
            _hashCode += getProposalNo().hashCode();
        }
        if (getProposalState() != null) {
            _hashCode += getProposalState().hashCode();
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
        if (getSendDateTime() != null) {
            _hashCode += getSendDateTime().hashCode();
        }
        if (getSpreadsheetPremium() != null) {
            _hashCode += getSpreadsheetPremium().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(InsuranceSingleQueryResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://dto.insuranceSingleQuery.AZX.webService.dsib.com/xsd", "InsuranceSingleQueryResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("actualPremium");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dto.insuranceSingleQuery.AZX.webService.dsib.com/xsd", "actualPremium"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("censorContent");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dto.insuranceSingleQuery.AZX.webService.dsib.com/xsd", "censorContent"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("errorNo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dto.insuranceSingleQuery.AZX.webService.dsib.com/xsd", "errorNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("itemKindEhmarry");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dto.insuranceSingleQuery.AZX.webService.dsib.com/xsd", "itemKindEhmarry"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://common.bean.AZX.webService.dsib.com/xsd", "ItemKindEhm"));
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("primaryKey");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dto.insuranceSingleQuery.AZX.webService.dsib.com/xsd", "primaryKey"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("proposalNo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dto.insuranceSingleQuery.AZX.webService.dsib.com/xsd", "proposalNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("proposalState");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dto.insuranceSingleQuery.AZX.webService.dsib.com/xsd", "proposalState"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("requestType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dto.insuranceSingleQuery.AZX.webService.dsib.com/xsd", "requestType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("responseCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dto.insuranceSingleQuery.AZX.webService.dsib.com/xsd", "responseCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("responseName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dto.insuranceSingleQuery.AZX.webService.dsib.com/xsd", "responseName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sendDateTime");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dto.insuranceSingleQuery.AZX.webService.dsib.com/xsd", "sendDateTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("spreadsheetPremium");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dto.insuranceSingleQuery.AZX.webService.dsib.com/xsd", "spreadsheetPremium"));
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
