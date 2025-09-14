package com.wellsfargo.counselor.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "trade")
public class Trade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trade_id")
    private Long tradeId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "holding_id", nullable = false)
    private Holding holding;

    @Column(nullable = false, length = 8) // e.g., BUY / SELL
    private String tradeType;

    @Column(nullable = false)
    private LocalDate tradeDate;

    @Column(nullable = false, precision = 18, scale = 4)
    private BigDecimal price;

    @Column(nullable = false, precision = 18, scale = 6)
    private BigDecimal quantity;

    @Column(precision = 18, scale = 4)
    private BigDecimal fees;

    protected Trade() {}

    public Trade(Long tradeId,
                 Holding holding,
                 String tradeType,
                 LocalDate tradeDate,
                 BigDecimal price,
                 BigDecimal quantity,
                 BigDecimal fees) {
        this.tradeId = tradeId;
        this.holding = holding;
        this.tradeType = tradeType;
        this.tradeDate = tradeDate;
        this.price = price;
        this.quantity = quantity;
        this.fees = fees;
    }

    public Long getTradeId() { return tradeId; } // no setter for id

    public Holding getHolding() { return holding; }
    public void setHolding(Holding holding) { this.holding = holding; }

    public String getTradeType() { return tradeType; }
    public void setTradeType(String tradeType) { this.tradeType = tradeType; }

    public LocalDate getTradeDate() { return tradeDate; }
    public void setTradeDate(LocalDate tradeDate) { this.tradeDate = tradeDate; }

    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }

    public BigDecimal getQuantity() { return quantity; }
    public void setQuantity(BigDecimal quantity) { this.quantity = quantity; }

    public BigDecimal getFees() { return fees; }
    public void setFees(BigDecimal fees) { this.fees = fees; }
}