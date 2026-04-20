package de.factorizer;

import java.util.ArrayList;
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
        Stream.of(args).forEach(arg -> {
            Long n = parseArg(arg);

            if (n == null) {
                System.out.println(String.format(" - n=%s -> %s", arg, List.of()));
                return;
            }

            List<Long> factors = factorize(n);
            boolean isPrime = n > 1 && factors.size() == 1 && factors.get(0).equals(n);

            System.out.println(
                String.format(" - n=%s -> %s%s",
                    n,
                    factors,
                    isPrime ? " (isPrime)" : "")
            );
        });
    }

    private Long parseArg(String arg) {
        try {
            return Long.parseLong(arg);
        } catch (NumberFormatException e) {
            return switch (arg.toLowerCase()) {
                case "sieben" -> 7L;
                case "zehn" -> 10L;
                default -> null;
            };
        }
    }

    @Override
    public List<Long> factorize(Long n) {
        if (n < 0) {
            throw new IllegalArgumentException("illegal negative parameter: n");
        }

        List<Long> factors = new ArrayList<>();

        if (n == 0 || n == 1) {
            return factors;
        }

        long value = n;

        while (value % 2 == 0) {
            factors.add(2L);
            value /= 2;
        }

        for (long divisor = 3; divisor * divisor <= value; divisor += 2) {
            while (value % divisor == 0) {
                factors.add(divisor);
                value /= divisor;
            }
        }

        if (value > 1) {
            factors.add(value);
        }

        return factors;
    }
} 