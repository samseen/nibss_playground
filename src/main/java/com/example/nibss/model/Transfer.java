package com.example.nibss.model;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table
public class Transfer {

    @Id
    @SequenceGenerator(
            name = "transfer_sequence",
            sequenceName = "transfer_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "transfer_sequence"
    )
    private Long id;
    private String transactionReference;
    private Double amount;
    private Double transactionFee;
    private Double billedAmount;
    private String description;
    private LocalDate createdDate;
    private String status;
    private Boolean commissionWorthy;
    private Double commission;

    public Transfer() {
    }

    public Transfer(Long id, String transactionReference, Double amount,
                    Double transactionFee, Double billedAmount,
                    String description, LocalDate createdDate,
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
                    String description, LocalDate createdDate,
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

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
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
