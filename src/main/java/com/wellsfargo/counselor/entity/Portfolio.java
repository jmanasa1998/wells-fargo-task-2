package com.wellsfargo.counselor.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "portfolio")
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "portfolio_id")
    private Long portfolioId;

    // Each portfolio belongs to exactly one client
    @ManyToOne(optional = false)
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @Column(nullable = false, length = 120)
    private String name;

    @Column(length = 8)
    private String baseCurrency;

    @Column(nullable = false)
    private boolean isPrimary;

    @Column(length = 40)
    private String riskProfile;

    // JPA needs a no-args constructor
    protected Portfolio() {}

    // All-args constructor (initialize all fields; id can be null)
    public Portfolio(Long portfolioId, Client client, String name, String baseCurrency, boolean isPrimary, String riskProfile) {
        this.portfolioId = portfolioId;
        this.client = client;
        this.name = name;
        this.baseCurrency = baseCurrency;
        this.isPrimary = isPrimary;
        this.riskProfile = riskProfile;
    }

    public Long getPortfolioId() { return portfolioId; } // no setter for id

    public Client getClient() { return client; }
    public void setClient(Client client) { this.client = client; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getBaseCurrency() { return baseCurrency; }
    public void setBaseCurrency(String baseCurrency) { this.baseCurrency = baseCurrency; }

    public boolean isPrimary() { return isPrimary; }
    public void setPrimary(boolean primary) { isPrimary = primary; }

    public String getRiskProfile() { return riskProfile; }
    public void setRiskProfile(String riskProfile) { this.riskProfile = riskProfile; }
}