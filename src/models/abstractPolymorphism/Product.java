package models.abstractPolymorphism;

public abstract class Product {

    private String productName;

    private Double prince;

    public Product(String productName, Double prince) {
        setProductName(productName);
        setPrince(prince);
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        if(productName == null || productName.isBlank()) throw new IllegalArgumentException("Product's name is required");

        this.productName = productName;
    }

    public Double getPrince() {
        return prince;
    }

    public void setPrince(Double prince) {
        if(prince == null) throw new IllegalArgumentException("Product's price is required");
        if(prince < 0.00) throw new IllegalArgumentException("Price cannot be a negative number");

        this.prince = prince;
    }

    public abstract boolean isProductionStandard();
}
