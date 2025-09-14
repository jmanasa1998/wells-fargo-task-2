package com.wellsfargo.counselor;

import com.wellsfargo.counselor.entity.*;
import com.wellsfargo.counselor.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class Entrypoint {

    public static void main(String[] args) {
        SpringApplication.run(Entrypoint.class, args);
    }

    @Bean
    CommandLineRunner seedData(
            FinancialAdvisorRepository advisorRepo,
            ClientRepository clientRepo,
            PortfolioRepository portfolioRepo,
            SecurityInstrumentRepository securityRepo,
            HoldingRepository holdingRepo,
            TradeRepository tradeRepo
    ) {
        return args -> {
            // Advisor
            Advisor adv = advisorRepo.save(new Advisor(
                    "Alex", "Wells", "123 Market St", "555-1234", "alex.wells@wf.com"
            ));

            // Client
            Client cli = clientRepo.save(new Client(
                    null, adv, "Rita", "Patel", "rita@example.com", "555-9876"
            ));

            // Portfolio
            Portfolio port = portfolioRepo.save(new Portfolio(
                    null, cli, "Retirement", "USD", true, "Moderate"
            ));

            // Security
            SecurityInstrument aapl = securityRepo.save(new SecurityInstrument(
                    null, "AAPL", "Apple Inc.", "Equity", "USD"
            ));

            // Holding
            Holding hold = holdingRepo.save(new Holding(
                    null, port, aapl,
                    new BigDecimal("10.000000"),
                    new BigDecimal("150.0000"),
                    LocalDate.now().minusDays(10)
            ));

            // Trades
            tradeRepo.saveAll(List.of(
                    new Trade(null, hold, "BUY",  LocalDate.now().minusDays(10), new BigDecimal("150.0000"), new BigDecimal("10.000000"), new BigDecimal("1.00")),
                    new Trade(null, hold, "SELL", LocalDate.now().minusDays(2),  new BigDecimal("180.0000"), new BigDecimal("5.000000"),  new BigDecimal("1.00"))
            ));
        };
    }
}