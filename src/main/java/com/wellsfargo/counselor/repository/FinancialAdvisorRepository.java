package com.wellsfargo.counselor.repository;

import com.wellsfargo.counselor.entity.Advisor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FinancialAdvisorRepository extends JpaRepository<Advisor, Long> {}