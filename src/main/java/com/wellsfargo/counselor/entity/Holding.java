package com.wellsfargo.counselor.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(
        name = "holding",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_portfolio_security", columnNames = {"portfolio_id", "security_id"})
        }
)
public class Holding {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "holding_id")
    private Long holdingId;

    // Each holding belongs to exactly one portfolio
    @ManyToOne(optional = false)
    @JoinColumn(name = "portfolio_id", nullable = false)
    private Portfolio portfolio;

    // Each holding refers to exactly one security
    @ManyToOne(optional = false)
    @JoinColumn(name = "security_id", nullable = false)
    private SecurityInstrument security;

    // How many units are held
    @Column(nullable = false, precision = 18, scale = 6)
    private BigDecimal quantity;

    // Average cost per unit
    @Column(nullable = false, precision = 18, scale = 4)
    private BigDecimal avgCost;

    // When the initial position was opened
    @Column(nullable = false)
    private LocalDate purchaseDate;

    protected Holding() {}

    public Holding(Long holdingId,
                   Portfolio portfolio,
                   SecurityInstrument security,
                   BigDecimal quantity,
                   BigDecimal avgCost,
                   LocalDate purchaseDate) {
        this.holdingId = holdingId;
        this.portfolio = portfolio;
        this.security = security;
        this.quantity = quantity;
        this.avgCost = avgCost;
        this.purchaseDate = purchaseDate;
    }

    public Long getHoldingId() { return holdingId; } // no setter for id

    public Portfolio getPortfolio() { return portfolio; }
    public void setPortfolio(Portfolio portfolio) { this.portfolio = portfolio; }

    public SecurityInstrument getSecurity() { return security; }
    public void setSecurity(SecurityInstrument security) { this.security = security; }

    public BigDecimal getQuantity() { return quantity; }
    public void setQuantity(BigDecimal quantity) { this.quantity = quantity; }

    public BigDecimal getAvgCost() { return avgCost; }
    public void setAvgCost(BigDecimal avgCost) { this.avgCost = avgCost; }

    public LocalDate getPurchaseDate() { return purchaseDate; }
    public void setPurchaseDate(LocalDate purchaseDate) { this.purchaseDate = purchaseDate; }
}