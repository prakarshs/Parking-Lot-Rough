package org.LLD.Repositories;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.LLD.Constants.Enums.VehicleType;
import org.LLD.Entities.ParkingLots;

import java.util.HashMap;
import java.util.Map;
@Data

@NoArgsConstructor
@Builder
public class ParkingSlotRepository {
    private Map<VehicleType,Map<String,ParkingLots> > parkingLotsMap = new HashMap<>();

    ParkingSlotRepository(Map<VehicleType,Map<String,ParkingLots> > parkingLotsMap) {
        for (VehicleType vehicleType : VehicleType.values()) {
            parkingLotsMap.put(vehicleType, new HashMap<>());
        }
        this.parkingLotsMap=parkingLotsMap;
    }
}
