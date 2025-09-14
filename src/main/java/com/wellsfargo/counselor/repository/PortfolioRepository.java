package com.wellsfargo.counselor.repository;

import com.wellsfargo.counselor.entity.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PortfolioRepository extends JpaRepository<Portfolio, Long> {
    List<Portfolio> findByClient_ClientId(Long clientId);
}