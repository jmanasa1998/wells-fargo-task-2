package com.wellsfargo.counselor.repository;
import java.util.List;
import com.wellsfargo.counselor.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
    List<Client> findByAdvisor_AdvisorId(Long advisorId);
}