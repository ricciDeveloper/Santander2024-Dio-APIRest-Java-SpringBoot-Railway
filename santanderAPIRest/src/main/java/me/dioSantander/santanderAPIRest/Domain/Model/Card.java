package me.dioSantander.santanderAPIRest.Domain.Model;

import jakarta.persistence.*;

import java.math.BigDecimal;
/**
 * @Author João Victor Ricci
 */
@Entity(name = "tb_card")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String number;
    /**
     * notação de escala em 2 decimais, para até 11 inteiros
     * ex: 99.999.999.999,99
     */
    @Column(name = "additional_limit", precision = 13, scale = 2)
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

    public BigDecimal getLimit() {
        return limit;
    }

    public void setLimit(BigDecimal limit) {
        this.limit = limit;
    }
}
