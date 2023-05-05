package models.abstractPolymorphism;

public class Table extends Product{

    private Double height_centimeters, length_centimeters, width_centimeters, weight_kilograms;

    public Table(String productName, Double prince,
                 Double height, Double length, Double width, Double weight) {
        super(productName, prince);

        setHeight_centimeters(height);
        setLength_centimeters(length);
        setWidth_centimeters(width);
        setWeight_kilograms(weight);
    }

    public Double getHeight_centimeters() {
        return height_centimeters;
    }

    public void setHeight_centimeters(Double height_centimeters) {
        if(height_centimeters == null) throw new IllegalArgumentException("Table's height is required");
        if(height_centimeters < 0.00) throw new IllegalArgumentException("Table's height cannot be a negative number");

        this.height_centimeters = height_centimeters;
    }

    public Double getLength_centimeters() {
        return length_centimeters;
    }

    public void setLength_centimeters(Double length_centimeters) {
        if(length_centimeters == null) throw new IllegalArgumentException("Table's length is required");
        if(length_centimeters < 0.00) throw new IllegalArgumentException("Table's length cannot be a negative number");

        this.length_centimeters = length_centimeters;
    }

    public Double getWidth_centimeters() {
        return width_centimeters;
    }

    public void setWidth_centimeters(Double width_centimeters) {
        if(width_centimeters == null) throw new IllegalArgumentException("Table's width is required");
        if(width_centimeters < 0.00) throw new IllegalArgumentException("Table's width cannot be a negative number");

        this.width_centimeters = width_centimeters;
    }

    public Double getWeight_kilograms() {
        return weight_kilograms;
    }

    public void setWeight_kilograms(Double weight_kilograms) {
        if(weight_kilograms == null) throw new IllegalArgumentException("Table's weight is required");
        if(weight_kilograms < 0.00) throw new IllegalArgumentException("Table's weight cannot be a negative number");

        this.weight_kilograms = weight_kilograms;
    }

    @Override
    public boolean isProductionStandard() {
        return this.height_centimeters >= 50 && this.width_centimeters >= 50 && this.length_centimeters >= 50 &&
                this.weight_kilograms >= 5 && this.weight_kilograms <= 45.00; // range 5-45
    }
}