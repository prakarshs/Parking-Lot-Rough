package org.LLD.Repositories;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.LLD.Entities.ParkingSlots;

import java.util.HashMap;
import java.util.Map;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ParkingSlotRepository {
    private Map<String, ParkingSlots> parkingSlotsMap = new HashMap<>();


}
