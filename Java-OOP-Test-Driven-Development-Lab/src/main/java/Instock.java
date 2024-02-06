import jdk.jshell.spi.ExecutionControl;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Instock implements ProductStock {
   private List<Product> products;

    public Instock() {
        this.products = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return this.products.size();
    }

    @Override
    public boolean contains(Product product) {
        return this.products.contains(product);
    }

    @Override
    public void add(Product product) {
        this.products.add(product);
    }

    @Override
    public void changeQuantity(String product, int quantity) {
       for(Product p:this.products){
           if(p.label.equals(product)){
               p.setQuantity(quantity);
               return;
           }
       }
       throw new IllegalArgumentException();
    }

    @Override
    public Product find(int index) {
       if(index>this.products.size())
           throw new IndexOutOfBoundsException();
       return products.get(index);
    }

    @Override
    public Product findByLabel(String label) {
        for(Product p:products){
            if(p.getLabel().equals(label))
                return p;
        }
        throw new IllegalArgumentException();
    }

    @Override
    public Iterable<Product> findFirstByAlphabeticalOrder(int count) {
       return this.products.stream().sorted().limit(count).collect(Collectors.toList());
    }

    @Override
    public Iterable<Product> findAllInRange(double lo, double hi) {
           return products.stream().filter(e->e.getPrice()>=lo && e.getPrice()<=hi).collect(Collectors.toList());
    }

    @Override
    public Iterable<Product> findAllByPrice(double price) {
       return products.stream().filter(e->e.getPrice()==price).collect(Collectors.toList());
    }

    @Override
    public Iterable<Product> findFirstMostExpensiveProducts(int count) {
        if(products.size()<count)
            throw new IllegalArgumentException();
        return products.stream().sorted(Comparator.comparing(Product::getPrice)).limit(count).collect(Collectors.toList());
    }

    @Override
    public Iterable<Product> findAllByQuantity(int quantity) {
        return products.stream().filter(e->e.getQuantity()==quantity).collect(Collectors.toList());
    }

    @Override
    public Iterator<Product> iterator() {
        return products.listIterator();
    }
}
