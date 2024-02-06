package solid.calculators;

import solid.products.Product;

import java.util.List;

public interface Calculator {
    double sum(List<Product> products);
    double avr(List<Product> products);
}
