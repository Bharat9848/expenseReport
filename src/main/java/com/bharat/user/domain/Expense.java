package com.bharat.user.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * Created by BharatBh on 2/16/2017.
 */

@Entity
@Table(name = "expense")
public class Expense implements Serializable{

    @Id
    @Column(name="user_id")
    private int id;

    private double amount;

    private String detail;

    @Temporal(TemporalType.TIMESTAMP)
    private Date localDateTime;

    @MapsId
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Expense(Double amount, String detail) {
        this.amount = amount;
        this.detail = detail;
    }

    public Expense() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public String getDetail() {
        return detail;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(Date localDateTime) {
        this.localDateTime = localDateTime;
    }
}
