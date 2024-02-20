package org.LLD.Services.Parking;

import org.LLD.Constants.Enums.SlotState;
import org.LLD.Constants.Enums.VehicleType;
import org.LLD.Entities.ParkingFloors;
import org.LLD.Entities.ParkingSlots;
import org.LLD.Repositories.ParkingFloorRepository;
import org.LLD.Repositories.ParkingSlotRepository;
import org.LLD.Services.Find.FindingService;
import org.LLD.Services.Find.FindingServiceIMPL;

import java.util.HashMap;
import java.util.Map;

public class ParkingServiceIMPL implements ParkingService{

    Map<VehicleType, Map<Integer, ParkingSlots>> preDefinedMap = new HashMap<>();
    FindingService findingService = new FindingServiceIMPL();
    ParkingSlotRepository parkingSlotRepository = new ParkingSlotRepository(preDefinedMap);
    ParkingFloorRepository parkingFloorRepository = new ParkingFloorRepository();

    @Override
    public String createParkingLot(String parkingLotId, Integer numberOfFloors, Integer numberOfSlots) {
        int slotIndex = 1;
        for (int floor = 1; floor <= numberOfFloors; floor++){
            Map<Integer, ParkingSlots> floorSlotMap = new HashMap<>();
            for (int slot = 1; slot <= numberOfSlots; slot++){
                ParkingSlots parkingSlot = ParkingSlots.builder()
                        .parkingSlotId(slot)
                        .slotState(SlotState.free)
                        .slotType(VehicleType.CAR)
                        .build();
                
                if(slot == 1){
                    parkingSlot.setSlotType(VehicleType.TRUCK);
                } else if (slot == 2 || slot ==3) {
                    parkingSlot.setSlotType(VehicleType.BIKE);
                }
                parkingSlotRepository.getParkingSlotsMap().get(parkingSlot.getSlotType()).put(slotIndex,parkingSlot);
                slotIndex++;
                floorSlotMap.put(parkingSlot.getParkingSlotId(),parkingSlot);
            }
            ParkingFloors parkingFloor = ParkingFloors.builder()
                    .parkingFloorId(floor)
                    .parkingSlots(floorSlotMap)
                    .build();
            parkingFloorRepository.getParkingFloorsMap().put(floor,parkingFloor);
        }

        return "Created parking lot with "+ parkingFloorRepository.getParkingFloorsMap().size() + " floors and "+ numberOfSlots +" slots per floor";
    }

    @Override
    public String parkVehicle(VehicleType vehicleType, String vehicleRegNumber, String vehicleColor) {

        ParkingSlots parkingSlot = findingService.findFreeParkingSlotType(vehicleType,parkingSlotRepository);

        return null;
    }
}
