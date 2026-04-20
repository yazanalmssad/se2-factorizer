package de.factorizer;

import java.util.List;

/**
 * Interface of a singleton component that factorizes numbers
 * into prime factors.
 */
public interface Factorizer {

    public void run(String[] args);

    public List<Long> factorize(Long n);

    static Factorizer getInstance() {
        return FactorizerImpl.getInstance();
    }
} 