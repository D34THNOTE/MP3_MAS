package models.multiAspect;

import java.util.EnumSet;

public abstract class Headphones {

    private String manufacturer, modelName;

    private ConnectionMethod connectionMethod;

    // Wired
    private int cableLength_centimeters;
    private String connectorType;

    // Wireless
    private int bluetoothRange_meters;

    public Headphones(ConnectionMethod connectionMethod,
                      String manufacturer, String modelName, // Common
                      int cableLength, String connectorType, // Wired
                      int bluetoothRange) // Wireless
    {
        setConnectionMethod(connectionMethod);
        setManufacturer(manufacturer);
        setModelName(modelName);

        switch (connectionMethod) {
            case WIRED -> {
                setCableLength_centimeters(cableLength);
                setConnectorType(connectorType);
            }
            case WIRELESS -> setBluetoothRange_meters(bluetoothRange);
        }
    }



    public ConnectionMethod getConnectionMethod() {
        return connectionMethod;
    }

    private void setConnectionMethod(ConnectionMethod connectionMethod) { // private, cannot change the type of the used connection
        if(connectionMethod == null) throw new IllegalArgumentException("Type of the connection method is required");
        if(!EnumSet.of(ConnectionMethod.WIRED, ConnectionMethod.WIRELESS).contains(connectionMethod))
            throw new IllegalArgumentException("Invalid connection method");

        this.connectionMethod = connectionMethod;
    }



    // COMMON

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        if(manufacturer == null || manufacturer.isBlank()) throw new IllegalArgumentException("Headphone's manufacturer is required");

        this.manufacturer = manufacturer;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        if(modelName == null || modelName.isBlank()) throw new IllegalArgumentException("Headphone's model name is required");

        this.modelName = modelName;
    }



    // WIRED

    public int getCableLength_centimeters() {
        if(!connectionMethod.equals(ConnectionMethod.WIRED)) throw new IllegalArgumentException("Selected headphones aren't of wired type");

        return cableLength_centimeters;
    }

    public void setCableLength_centimeters(int cableLength_centimeters) {
        if(!connectionMethod.equals(ConnectionMethod.WIRED)) throw new IllegalArgumentException("Selected headphones aren't of wired type");

        if(cableLength_centimeters < 1) throw new IllegalArgumentException("Cable length cannot be shorter than 1cm");

        this.cableLength_centimeters = cableLength_centimeters;
    }

    public String getConnectorType() {
        if(!connectionMethod.equals(ConnectionMethod.WIRED)) throw new IllegalArgumentException("Selected headphones aren't of wired type");

        return connectorType;
    }

    public void setConnectorType(String connectorType) {
        if(!connectionMethod.equals(ConnectionMethod.WIRED)) throw new IllegalArgumentException("Selected headphones aren't of wired type");

        if(connectorType == null || connectorType.isBlank()) throw new IllegalArgumentException("Wired headphone's connector type is required");

        this.connectorType = connectorType;
    }



    // WIRELESS

    public int getBluetoothRange_meters() {
        if(!connectionMethod.equals(ConnectionMethod.WIRELESS)) throw new IllegalArgumentException("Selected headphones aren't of wireless type");

        return bluetoothRange_meters;
    }

    public void setBluetoothRange_meters(int bluetoothRange_meters) {
        if(!connectionMethod.equals(ConnectionMethod.WIRELESS)) throw new IllegalArgumentException("Selected headphones aren't of wireless type");

        if(bluetoothRange_meters < 1) throw new IllegalArgumentException("Bluetooth range cannot be shorter than 1 meter");

        this.bluetoothRange_meters = bluetoothRange_meters;
    }
}
