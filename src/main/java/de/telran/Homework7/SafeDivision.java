package de.telran.Homework7;

import java.util.Optional;
@FunctionalInterface
public interface SafeDivision {
    Optional<Double> divide(int a, int b);
}
