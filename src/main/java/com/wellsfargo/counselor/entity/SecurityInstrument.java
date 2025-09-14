package com.wellsfargo.counselor.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "security_instrument")
public class SecurityInstrument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "security_id")
    private Long securityId;

    @Column(nullable = false, length = 40, unique = true)
    private String symbol;   // e.g., AAPL

    @Column(nullable = false, length = 160)
    private String name;     // e.g., Apple Inc.

    @Column(nullable = false, length = 40)
    private String category; // Equity, Bond, ETF, etc.

    @Column(length = 8)
    private String currency; // e.g., USD

    // JPA needs a no-args constructor
    protected SecurityInstrument() {}

    // All-args constructor (id can be null)
    public SecurityInstrument(Long securityId, String symbol, String name, String category, String currency) {
        this.securityId = securityId;
        this.symbol = symbol;
        this.name = name;
        this.category = category;
        this.currency = currency;
    }

    public Long getSecurityId() { return securityId; } // no setter for id

    public String getSymbol() { return symbol; }
    public void setSymbol(String symbol) { this.symbol = symbol; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getCurrency() { return currency; }
    public void setCurrency(String currency) { this.currency = currency; }
}