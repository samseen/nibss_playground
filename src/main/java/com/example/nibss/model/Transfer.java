package com.example.nibss.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
@Table(name = "transaction")
public class Transfer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "transaction_reference")
    private String transactionReference;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "transaction_fee")
    private Double transactionFee;

    @Column(name = "billed_amount")
    private Double billedAmount;

    @Column(name = "description")
    private String description;

    @CreationTimestamp
    @Column(name = "created_date")
    private LocalDateTime createdDate;
    private String status;

    @Column(name = "commission_worthy")
    private Boolean commissionWorthy;

    @Column(name = "commission")
    private Double commission;

    public Transfer() {
    }

    public Transfer(Long id, String transactionReference, Double amount,
                    Double transactionFee, Double billedAmount,
                    String description, LocalDateTime createdDate,
                    String status, Boolean commissionWorthy,
                    Double commission) {
        this.id = id;
        this.transactionReference = transactionReference;
        this.amount = amount;
        this.transactionFee = transactionFee;
        this.billedAmount = billedAmount;
        this.description = description;
        this.createdDate = createdDate;
        this.status = status;
        this.commissionWorthy = commissionWorthy;
        this.commission = commission;
    }

    public Transfer(String transactionReference, Double amount,
                    Double transactionFee, Double billedAmount,
                    String description, LocalDateTime createdDate,
                    String status, Boolean commissionWorthy,
                    Double commission) {
        this.transactionReference = transactionReference;
        this.amount = amount;
        this.transactionFee = transactionFee;
        this.billedAmount = billedAmount;
        this.description = description;
        this.createdDate = createdDate;
        this.status = status;
        this.commissionWorthy = commissionWorthy;
        this.commission = commission;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTransactionReference() {
        return transactionReference;
    }

    public void setTransactionReference(String transactionReference) {
        this.transactionReference = transactionReference;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getTransactionFee() {
        return transactionFee;
    }

    public void setTransactionFee(Double transactionFee) {
        this.transactionFee = transactionFee;
    }

    public Double getBilledAmount() {
        return billedAmount;
    }

    public void setBilledAmount(Double billedAmount) {
        this.billedAmount = billedAmount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getCommissionWorthy() {
        return commissionWorthy;
    }

    public void setCommissionWorthy(Boolean commissionWorthy) {
        this.commissionWorthy = commissionWorthy;
    }

    public Double getCommission() {
        return commission;
    }

    public void setCommission(Double commission) {
        this.commission = commission;
    }

    @Override
    public String toString() {
        return "Transfer{" +
                "id=" + id +
                ", transactionReference='" + transactionReference + '\'' +
                ", amount=" + amount +
                ", transactionFee=" + transactionFee +
                ", billedAmount=" + billedAmount +
                ", description='" + description + '\'' +
                ", createdDate=" + createdDate +
                ", status='" + status + '\'' +
                ", commissionWorthy=" + commissionWorthy +
                ", commission=" + commission +
                '}';
    }
}
