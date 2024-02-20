package org.LLD.Repositories;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.LLD.Constants.Enums.VehicleType;
import org.LLD.Entities.ParkingSlots;

import java.util.HashMap;
import java.util.Map;
@Data
@NoArgsConstructor
@Builder
public class ParkingSlotRepository {
    private Map<VehicleType, Map<Integer, ParkingSlots>> parkingSlotsMap = new HashMap<>();

    public ParkingSlotRepository(Map<VehicleType, Map<Integer, ParkingSlots>> parkingSlotsMap){

        for(VehicleType vehicleType: VehicleType.values()){
            parkingSlotsMap.put(vehicleType,new HashMap<>());
        }

        this.parkingSlotsMap=parkingSlotsMap;
    }
}
