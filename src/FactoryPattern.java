interface Product {
    void display();
}

//Clase concrete care implementează interfața Product
class ConcreteProduct1 implements Product {
    @Override
    public void display() {
        System.out.println("ConcreteProduct1");
    }
}

class ConcreteProduct2 implements Product {
    @Override
    public void display() {
        System.out.println("ConcreteProduct2");
    }
}

// Clasa Factory care va crea produsele
class ProductFactory {
    public Product createProduct(String productType) {
        switch (productType) {
            case "1":
                return new ConcreteProduct1();
            case "2":
                return new ConcreteProduct2();
            default:
                throw new IllegalArgumentException("Invalid product type");
        }
    }
}
public class FactoryPattern {
    public static void main(String[] args) {
        ProductFactory factory = new ProductFactory();

        Product product1 = factory.createProduct("1");
        product1.display();

        Product product2 = factory.createProduct("2");
        product2.display();

        //Product product3 = factory.createProduct("3");
    }
}