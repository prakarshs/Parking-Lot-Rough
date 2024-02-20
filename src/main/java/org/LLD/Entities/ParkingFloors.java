package org.LLD.Entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.LLD.Constants.Enums.VehicleType;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ParkingFloors {
    private Integer parkingFloorId;
    private Map<VehicleType, Map<String,ParkingSlots>> parkingSlots;
}
