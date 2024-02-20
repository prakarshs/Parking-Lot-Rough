package org.LLD.Entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.LLD.Constants.Enums.SlotState;
import org.LLD.Constants.Enums.VehicleType;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ParkingSlots {
    private Integer parkingSlotId;
    private VehicleType slotType;
    private SlotState slotState;
}
