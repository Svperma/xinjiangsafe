package com.dsib.entity;

import java.io.Serializable;
import java.util.Date;

public class GgNews implements Serializable  {
    private String docid;

    private String title;

    private String doctype;

    private Date publishdate;

    private String creator;

    private Date createdate;

    private String flag;

    private String remark;

    private String imagepath;

    private String isindex;

    private String isrecommend;

    private String istop;

    private String decription;

    private String displayno;

    private String expectno;

    private String varstatus;

    private String doccontent;

    public String getDocid() {
        return docid;
    }

    public void setDocid(String docid) {
        this.docid = docid == null ? null : docid.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getDoctype() {
        return doctype;
    }

    public void setDoctype(String doctype) {
        this.doctype = doctype == null ? null : doctype.trim();
    }

    public Date getPublishdate() {
        return publishdate;
    }

    public void setPublishdate(Date publishdate) {
        this.publishdate = publishdate;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag == null ? null : flag.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getImagepath() {
        return imagepath;
    }

    public void setImagepath(String imagepath) {
        this.imagepath = imagepath == null ? null : imagepath.trim();
    }

    public String getIsindex() {
        return isindex;
    }

    public void setIsindex(String isindex) {
        this.isindex = isindex == null ? null : isindex.trim();
    }

    public String getIsrecommend() {
        return isrecommend;
    }

    public void setIsrecommend(String isrecommend) {
        this.isrecommend = isrecommend == null ? null : isrecommend.trim();
    }

    public String getIstop() {
        return istop;
    }

    public void setIstop(String istop) {
        this.istop = istop == null ? null : istop.trim();
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription == null ? null : decription.trim();
    }

    public String getDisplayno() {
        return displayno;
    }

    public void setDisplayno(String displayno) {
        this.displayno = displayno == null ? null : displayno.trim();
    }

    public String getExpectno() {
        return expectno;
    }

    public void setExpectno(String expectno) {
        this.expectno = expectno == null ? null : expectno.trim();
    }

    public String getVarstatus() {
        return varstatus;
    }

    public void setVarstatus(String varstatus) {
        this.varstatus = varstatus == null ? null : varstatus.trim();
    }

    public String getDoccontent() {
        return doccontent;
    }

    public void setDoccontent(String doccontent) {
        this.doccontent = doccontent == null ? null : doccontent.trim();
    }
}
