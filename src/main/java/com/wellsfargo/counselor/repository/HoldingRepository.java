package com.wellsfargo.counselor.repository;

import com.wellsfargo.counselor.entity.Holding;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HoldingRepository extends JpaRepository<Holding, Long> {
    List<Holding> findByPortfolio_PortfolioId(Long portfolioId);
    List<Holding> findBySecurity_SecurityId(Long securityId);
}