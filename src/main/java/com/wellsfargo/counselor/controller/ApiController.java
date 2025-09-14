package com.wellsfargo.counselor.controller;

import com.wellsfargo.counselor.entity.*;
import com.wellsfargo.counselor.repository.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    private final FinancialAdvisorRepository advisorRepo;
    private final ClientRepository clientRepo;
    private final PortfolioRepository portfolioRepo;
    private final SecurityInstrumentRepository securityRepo;
    private final HoldingRepository holdingRepo;
    private final TradeRepository tradeRepo;

    public ApiController(FinancialAdvisorRepository advisorRepo,
                         ClientRepository clientRepo,
                         PortfolioRepository portfolioRepo,
                         SecurityInstrumentRepository securityRepo,
                         HoldingRepository holdingRepo,
                         TradeRepository tradeRepo) {
        this.advisorRepo = advisorRepo;
        this.clientRepo = clientRepo;
        this.portfolioRepo = portfolioRepo;
        this.securityRepo = securityRepo;
        this.holdingRepo = holdingRepo;
        this.tradeRepo = tradeRepo;
    }

    // ---- Advisors & Clients ----
    @GetMapping("/advisors")
    public List<Advisor> getAdvisors() {
        return advisorRepo.findAll();
    }

    @GetMapping("/advisors/{advisorId}/clients")
    public List<Client> getClientsForAdvisor(@PathVariable Long advisorId) {
        return clientRepo.findByAdvisor_AdvisorId(advisorId);
    }

    // ---- Clients & Portfolios ----
    @GetMapping("/clients")
    public List<Client> getClients() {
        return clientRepo.findAll();
    }

    @GetMapping("/clients/{clientId}")
    public ResponseEntity<Client> getClient(@PathVariable Long clientId) {
        return clientRepo.findById(clientId).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/clients/{clientId}/portfolios")
    public List<Portfolio> getPortfoliosForClient(@PathVariable Long clientId) {
        return portfolioRepo.findByClient_ClientId(clientId);
    }

    // ---- Portfolios & Holdings ----
    @GetMapping("/portfolios/{portfolioId}")
    public ResponseEntity<Portfolio> getPortfolio(@PathVariable Long portfolioId) {
        return portfolioRepo.findById(portfolioId).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/portfolios/{portfolioId}/holdings")
    public List<Holding> getHoldingsForPortfolio(@PathVariable Long portfolioId) {
        return holdingRepo.findByPortfolio_PortfolioId(portfolioId);
    }

    // ---- Securities & Holdings ----
    @GetMapping("/securities")
    public List<SecurityInstrument> getSecurities() {
        return securityRepo.findAll();
    }

    @GetMapping("/securities/{securityId}")
    public ResponseEntity<SecurityInstrument> getSecurity(@PathVariable Long securityId) {
        return securityRepo.findById(securityId).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/securities/{securityId}/holdings")
    public List<Holding> getHoldingsForSecurity(@PathVariable Long securityId) {
        return holdingRepo.findBySecurity_SecurityId(securityId);
    }

    // ---- Holdings & Trades ----
    @GetMapping("/holdings/{holdingId}")
    public ResponseEntity<Holding> getHolding(@PathVariable Long holdingId) {
        return holdingRepo.findById(holdingId).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/holdings/{holdingId}/trades")
    public List<Trade> getTradesForHolding(@PathVariable Long holdingId) {
        return tradeRepo.findByHolding_HoldingId(holdingId);
    }

    @GetMapping("/trades")
    public List<Trade> getTrades() {
        return tradeRepo.findAll();
    }
}