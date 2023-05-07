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
        if(powerConsumption_watts <= 0.00) throw new IllegalArgumentException("Oven's power consumption cannot be a negative number");

        this.powerConsumption_watts = powerConsumption_watts;
    }

    public Double getCapacity_liters() {
        return capacity_liters;
    }

    public void setCapacity_liters(Double capacity_liters) {
        if(capacity_liters == null) throw new IllegalArgumentException("Oven's capacity is required");
        if(capacity_liters <= 0.00) throw new IllegalArgumentException("Oven's capacity cannot be a negative number");

        this.capacity_liters = capacity_liters;
    }

    public Double getMinTemp_celcius() {
        return minTemp_celcius;
    }

    public void setMinTemp_celcius(Double minTemp_celcius) {
        if(minTemp_celcius == null) throw new IllegalArgumentException("Oven's minimum temperature is required");
        if(minTemp_celcius <= 0.00) throw new IllegalArgumentException("Oven's minimum temperature cannot be a negative number");

        this.minTemp_celcius = minTemp_celcius;
    }

    public Double getMaxTemp_celcius() {
        return maxTemp_celcius;
    }

    public void setMaxTemp_celcius(Double maxTemp_celcius) {
        if(maxTemp_celcius == null) throw new IllegalArgumentException("Oven's maximum temperature is required");
        if(maxTemp_celcius <= 0.00) throw new IllegalArgumentException("Oven's maximum temperature cannot be a negative number");

        this.maxTemp_celcius = maxTemp_celcius;
    }

    @Override
    public boolean isProductionStandard() {
        boolean isProductionStandard =
                this.powerConsumption_watts >= 500.00 && this.powerConsumption_watts <= 4000.00 && // power consumption range 500-4000
                this.capacity_liters >= 20.00 &&
                this.minTemp_celcius >= 50.00 && this.minTemp_celcius <= 80.00 && //min temp range 50-80
                this.maxTemp_celcius <= 300.00 && this.maxTemp_celcius >= 200.00;// max temp range 200-300
        if(isProductionStandard) return true;
        else {
            StringBuilder message = new StringBuilder("This product does not meet the production standards because: \n");
            if(this.powerConsumption_watts < 500 || this.powerConsumption_watts > 4000)
                message.append("Power consumption is ").append(this.powerConsumption_watts).append("W, power consumption is required to be in the 500-4000W range \n");

            if(this.capacity_liters < 20)
                message.append("Capacity is ").append(this.capacity_liters).append("L when the minimum required capacity is 20L \n");

            if(this.minTemp_celcius < 50 || this.minTemp_celcius > 80)
                message.append("Minimum temperature is ").append(this.minTemp_celcius).append("°C, the minimum temperature is required to be in the 50-80°C range \n");

            if(this.maxTemp_celcius < 200 || this.maxTemp_celcius > 300)
                message.append("Maximum temperature is ").append(this.maxTemp_celcius).append("°C, the maximum temperature is required to be in the 200-300°C range \n");

            System.out.println(message);
            return false;
        }
    }
}
