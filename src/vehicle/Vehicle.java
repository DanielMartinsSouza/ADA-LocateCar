package vehicle;

public class Vehicle {
    private String placa;
    private VehicleType vehicleType;

    public Vehicle(String placa, VehicleType vehicleType) {
        this.placa = placa;
        this.vehicleType = vehicleType;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}
