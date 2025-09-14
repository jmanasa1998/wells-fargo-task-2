package com.wellsfargo.counselor.repository;

import com.wellsfargo.counselor.entity.SecurityInstrument;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SecurityInstrumentRepository extends JpaRepository<SecurityInstrument, Long> {}