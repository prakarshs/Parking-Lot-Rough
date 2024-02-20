package org.LLD.Services.Parking;

import org.LLD.Constants.Enums.VehicleType;

public interface ParkingService {

    String createParkingLot(String parkingLotId, Integer numberOfFloors, Integer numberOfSlots);
    String parkVehicle(VehicleType vehicleType, String vehicleRegNumber, String vehicleColor);
}
