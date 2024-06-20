package me.dioSantander.santanderAPIRest.Domain.Model;

import jakarta.persistence.*;

import java.math.BigDecimal;

/**
 * @Author João Victor Ricci
 */
@Entity(name = "tb_account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * Conta unica, setup aplicado na anotação unique true.
     */
    @Column(unique = true)
    private String number;
    private String agency;
    /**
     * notação de escala em 2 decimais, para até 11 inteiros
     * ex: 99.999.999.999,99
     */
    @Column(scale = 2, precision = 13)
    private BigDecimal balance;
    @Column(name = "additional_limit",scale = 13, precision = 2)

    private BigDecimal limit;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getLimit() {
        return limit;
    }

    public void setLimit(BigDecimal limit) {
        this.limit = limit;
    }
}
