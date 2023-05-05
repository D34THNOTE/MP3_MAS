package models.abstractPolymorphism;

public class Oven extends Product{

    private Double powerConsumption_watts, capacity_liters, minTemp_celcius, maxTemp_celcius;

    public Oven(String productName, Double prince,
                Double powerConsumption, Double capacity, Double minTemp, Double maxTemp) {
        super(productName, prince);

        setPowerConsumption_watts(powerConsumption);
        setCapacity_liters(capacity);
        setMinTemp_celcius(minTemp);
        setMaxTemp_celcius(maxTemp);
    }

    public Double getPowerConsumption_watts() {
        return powerConsumption_watts;
    }

    public void setPowerConsumption_watts(Double powerConsumption_watts) {
        if(powerConsumption_watts == null) throw new IllegalArgumentException("Oven's power consumption is required");
        if(powerConsumption_watts < 0.00) throw new IllegalArgumentException("Oven's power consumption cannot be a negative number");

        this.powerConsumption_watts = powerConsumption_watts;
    }

    public Double getCapacity_liters() {
        return capacity_liters;
    }

    public void setCapacity_liters(Double capacity_liters) {
        if(capacity_liters == null) throw new IllegalArgumentException("Oven's capacity is required");
        if(capacity_liters < 0.00) throw new IllegalArgumentException("Oven's capacity cannot be a negative number");

        this.capacity_liters = capacity_liters;
    }

    public Double getMinTemp_celcius() {
        return minTemp_celcius;
    }

    public void setMinTemp_celcius(Double minTemp_celcius) {
        if(minTemp_celcius == null) throw new IllegalArgumentException("Oven's minimum temperature is required");
        if(minTemp_celcius < 0.00) throw new IllegalArgumentException("Oven's minimum temperature cannot be a negative number");

        this.minTemp_celcius = minTemp_celcius;
    }

    public Double getMaxTemp_celcius() {
        return maxTemp_celcius;
    }

    public void setMaxTemp_celcius(Double maxTemp_celcius) {
        if(maxTemp_celcius == null) throw new IllegalArgumentException("Oven's maximum temperature is required");
        if(maxTemp_celcius < 0.00) throw new IllegalArgumentException("Oven's maximum temperature cannot be a negative number");

        this.maxTemp_celcius = maxTemp_celcius;
    }

    @Override
    public boolean isProductionStandard() {
        return this.powerConsumption_watts >= 500.00 && this.powerConsumption_watts <= 4000.00 && // power consumption range 500-4000
                this.capacity_liters >= 20.00 &&
                this.minTemp_celcius >= 50.00 && this.minTemp_celcius <= 80.00 && //min temp range 50-80
                this.maxTemp_celcius <= 300.00 && this.maxTemp_celcius >= 200.00; // max temp range 200-300
    }
}
