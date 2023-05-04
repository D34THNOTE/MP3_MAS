package models.multiAspect;

public class AudiophileHeadphones extends Headphones {

    private int driverSize_millimeters, impedance_ohms;

    public AudiophileHeadphones(ConnectionMethod connectionMethod, String manufacturer, String modelName, int cableLength, String connectorType, int bluetoothRange,
                                int driverSize, int impedance) {
        super(connectionMethod, manufacturer, modelName, cableLength, connectorType, bluetoothRange);

        setDriverSize_millimeters(driverSize);
        setImpedance_ohms(impedance);
    }

    public int getDriverSize_millimeters() {
        return driverSize_millimeters;
    }

    public void setDriverSize_millimeters(int driverSize_millimeters) {
        if(driverSize_millimeters < 1) throw new IllegalArgumentException("Driver size cannot be smaller than 1mm");

        this.driverSize_millimeters = driverSize_millimeters;
    }

    public int getImpedance_ohms() {
        return impedance_ohms;
    }

    public void setImpedance_ohms(int impedance_ohms) {
        if(impedance_ohms < 1) throw new IllegalArgumentException("Impedance cannot be smaller than 1ohm");

        this.impedance_ohms = impedance_ohms;
    }
}
