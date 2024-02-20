package org.LLD.Services.Parking;

import org.LLD.Constants.Enums.SlotState;
import org.LLD.Constants.Enums.VehicleType;
import org.LLD.Entities.ParkingFloors;
import org.LLD.Entities.ParkingSlots;
import org.LLD.Repositories.ParkingFloorRepository;
import org.LLD.Repositories.ParkingSlotRepository;

import java.util.HashMap;
import java.util.Map;

public class ParkingServiceIMPL implements ParkingService{

    ParkingSlotRepository parkingSlotRepository = new ParkingSlotRepository();
    ParkingFloorRepository parkingFloorRepository = new ParkingFloorRepository();

    @Override
    public String createParkingLot(String parkingLotId, Integer numberOfFloors, Integer numberOfSlots) {
        for (int floor = 1; floor <= numberOfFloors; floor++){
            Map<String, ParkingSlots> floorSlotMap = new HashMap<>();
            for (int slot = 1; slot <= numberOfSlots; slot++){
                ParkingSlots parkingSlot = ParkingSlots.builder()
                        .parkingSlotId(floor+ "_" +slot)
                        .slotState(SlotState.free)
                        .slotType(VehicleType.CAR)
                        .build();
                
                if(slot == 1){
                    parkingSlot.setSlotType(VehicleType.TRUCK);
                } else if (slot == 2 || slot ==3) {
                    parkingSlot.setSlotType(VehicleType.BIKE);
                }
                parkingSlotRepository.getParkingSlotsMap().put(parkingSlot.getParkingSlotId(),parkingSlot);
                floorSlotMap.put(parkingSlot.getParkingSlotId(),parkingSlot);
            }
            ParkingFloors parkingFloor = ParkingFloors.builder()
                    .parkingFloorId(floor)
                    .parkingSlots(floorSlotMap)
                    .build();
            parkingFloorRepository.getParkingFloorsMap().put(floor,parkingFloor);
        }

        return "Created parking lot with "+ parkingFloorRepository.getParkingFloorsMap().size() + " floors and "+ parkingSlotRepository.getParkingSlotsMap().size()/parkingFloorRepository.getParkingFloorsMap().size() +" slots per floor";
    }
}
