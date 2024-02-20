package org.LLD.Services.Ticket;

import org.LLD.Entities.ParkingSlots;
import org.LLD.Entities.ParkingTicket;
import org.LLD.Entities.VehicleEntity;

import java.time.Instant;
import java.util.Date;

public class TicketServiceIMPL implements TicketService{
    @Override
    public ParkingTicket generateTicket(ParkingSlots slot, VehicleEntity vehicle, String parkingLotId) {
        return ParkingTicket.builder()
                .vehicleRegNumber(vehicle.getVehicleRegNumber())
                .vehicleType(vehicle.getVehicleType())
                .ticketIssuedAt(Date.from(Instant.now()))
                .parkingSlot(slot)
                .parkingTicketId(parkingLotId+"_"+slot.getParkingSlotId())
                .build();
    }

}
