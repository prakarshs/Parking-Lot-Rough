package org.LLD.Services.Find;

import org.LLD.Constants.Enums.SlotState;
import org.LLD.Constants.Enums.VehicleType;
import org.LLD.Entities.ParkingSlots;
import org.LLD.Repositories.ParkingSlotRepository;

import java.util.Map;

public class FindingServiceIMPL implements FindingService{
    @Override
    public ParkingSlots findFreeParkingSlotType(VehicleType vehicleType, ParkingSlotRepository parkingSlotRepository) {

        if(parkingSlotRepository.getParkingSlotsMap().containsKey(vehicleType)){
         Map<Integer, ParkingSlots> slotsWithGivenVehicle = parkingSlotRepository.getParkingSlotsMap().get(vehicleType);
         for(Map.Entry<Integer, ParkingSlots> parkingSlotsEntry : slotsWithGivenVehicle.entrySet()){
            if(parkingSlotsEntry.getValue().getSlotState() == SlotState.free)
                return parkingSlotsEntry.getValue();
         }
        }
        else{
            System.out.println("!----- The Type Of Vehicle Doesnt Exist. -----!");
        }

        return null;
    }
}
