package org.LLD.Services.Find;

import org.LLD.Constants.Enums.VehicleType;
import org.LLD.Entities.ParkingSlots;
import org.LLD.Repositories.ParkingSlotRepository;

public interface FindingService {
    ParkingSlots findFreeParkingSlotType(VehicleType vehicleType, ParkingSlotRepository parkingSlotRepository);
}
