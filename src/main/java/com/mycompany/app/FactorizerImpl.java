package com.mycompany.app;

import java.util.List;
import java.util.stream.Stream;

class FactorizerImpl implements Factorizer {

    private static Factorizer instance;

    private FactorizerImpl() {
    }

    static Factorizer getInstance() {
        if (instance == null) {
            instance = new FactorizerImpl();
        }
        return instance;
    }

    @Override
    public void run(String[] args) {
        Stream.of(args)
            .forEach(arg -> {
                System.out.println(
                    String.format(" - n=%s -> %s%s", arg, List.of(), " (isPrime)"));
            });
    }

    @Override
    public List<Integer> factorize(Integer n) {
        return List.of();
    }
} 