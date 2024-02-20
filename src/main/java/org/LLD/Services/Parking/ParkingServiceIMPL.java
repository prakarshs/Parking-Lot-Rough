package org.LLD.Services.Parking;

import org.LLD.Constants.Enums.SlotState;
import org.LLD.Constants.Enums.VehicleType;
import org.LLD.Entities.*;
import org.LLD.Helper.AutowireService;
import org.LLD.ParkingLot;
import org.LLD.Repositories.ParkingFloorRepository;
import org.LLD.Repositories.ParkingLotRepository;
import org.LLD.Repositories.ParkingSlotRepository;
import org.LLD.Services.Find.FindingService;
import org.LLD.Services.Find.FindingServiceIMPL;

import java.util.HashMap;
import java.util.Map;

public class ParkingServiceIMPL implements ParkingService{

    Map<VehicleType, Map<Integer, ParkingSlots>> preDefinedMap = new HashMap<>();
    AutowireService autowireService = new AutowireService();
    ParkingSlotRepository parkingSlotRepository = new ParkingSlotRepository(preDefinedMap);
    ParkingFloorRepository parkingFloorRepository = new ParkingFloorRepository();
    ParkingLotRepository parkingLotRepository = new ParkingLotRepository();

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
                        .parkingLotId(parkingLotId)
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

        ParkingLots parkingLot = ParkingLots.builder()
                .parkingLotId(parkingLotId)
                .parkingFloors(parkingFloorRepository.getParkingFloorsMap())
                .build();

        return "Created parking lot with "+ parkingFloorRepository.getParkingFloorsMap().size() + " floors and "+ numberOfSlots +" slots per floor";
    }

    @Override
    public String parkVehicle(VehicleType vehicleType, String vehicleRegNumber, String vehicleColor) {

        VehicleEntity vehicle = VehicleEntity.builder()
                .vehicleRegNumber(vehicleRegNumber)
                .vehicleType(vehicleType)
                .color(vehicleColor)
                .build();


        ParkingSlots parkingSlot = autowireService.getFindingService().findFreeParkingSlotType(vehicleType,parkingSlotRepository);
        if(parkingSlot!=null){
           ParkingTicket ticket = autowireService.getTicketService().generateTicket(parkingSlot,vehicle,parkingSlot.getParkingLotId());
           parkingSlot.setSlotState(SlotState.occupied);
           return "Parked Vehicle. Ticket ID: "+ ticket.getParkingTicketId();
        }
        else return null;
    }
}
