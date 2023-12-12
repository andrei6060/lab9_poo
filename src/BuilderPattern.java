// Clasa produs care va fi construita folosind Builder Pattern
class Product_BuilderPattern {
    private String name;
    private String type;
    private int price;

    private Product_BuilderPattern(Builder builder) {
        this.name = builder.name;
        this.type = builder.type;
        this.price = builder.price;
    }

    public void display() {
        System.out.println("Product: " + name + ", Type: " + type + ", Price: " + price);
    }

    // Clasa Builder pentru a construi obiectul Product
    static class Builder {
        private String name;
        private String type;
        private int price;

        public Builder(String name, int price) {
            this.name = name;
            this.price = price;
        }

        public Builder type(String type) {
            this.type = type;
            return this;
        }

        public Product_BuilderPattern build() {
            return new Product_BuilderPattern(this);
        }
    }
}
public class BuilderPattern {
    public static void main(String[] args) {

        Product_BuilderPattern product = new Product_BuilderPattern.Builder("ExampleProduct", 100)
                //.type("ExampleType")
                .build();


        product.display();
    }
}

