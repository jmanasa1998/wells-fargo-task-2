package com.wellsfargo.counselor.repository;

import com.wellsfargo.counselor.entity.Trade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TradeRepository extends JpaRepository<Trade, Long> {
    List<Trade> findByHolding_HoldingId(Long holdingId);
}