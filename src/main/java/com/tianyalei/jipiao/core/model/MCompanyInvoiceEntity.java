package com.tianyalei.jipiao.core.model;

import com.tianyalei.jipiao.core.model.base.BaseEntity;

import javax.persistence.Basic;
import javax.persistence.Column;

/**
 * @author wuweifeng wrote on 2018/11/1.
 */
//@Entity
//@Table(name = "M_CompanyInvoice", catalog = "")
public class MCompanyInvoiceEntity extends BaseEntity {
    private Integer companyId;
    private String invoiceProject;
    private String invoiceName;
    private String invoiceDuty;
    private String depositBank;
    private String bankCard;


    @Basic
    @Column(name = "CompanyID")
    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    @Basic
    @Column(name = "InvoiceProject")
    public String getInvoiceProject() {
        return invoiceProject;
    }

    public void setInvoiceProject(String invoiceProject) {
        this.invoiceProject = invoiceProject;
    }

    @Basic
    @Column(name = "InvoiceName")
    public String getInvoiceName() {
        return invoiceName;
    }

    public void setInvoiceName(String invoiceName) {
        this.invoiceName = invoiceName;
    }

    @Basic
    @Column(name = "InvoiceDuty")
    public String getInvoiceDuty() {
        return invoiceDuty;
    }

    public void setInvoiceDuty(String invoiceDuty) {
        this.invoiceDuty = invoiceDuty;
    }

    @Basic
    @Column(name = "DepositBank")
    public String getDepositBank() {
        return depositBank;
    }

    public void setDepositBank(String depositBank) {
        this.depositBank = depositBank;
    }

    @Basic
    @Column(name = "BankCard")
    public String getBankCard() {
        return bankCard;
    }

    public void setBankCard(String bankCard) {
        this.bankCard = bankCard;
    }


}
