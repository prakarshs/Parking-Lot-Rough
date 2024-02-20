package org.LLD.Services.Ticket;

import org.LLD.Constants.Enums.VehicleType;
import org.LLD.Entities.ParkingSlots;
import org.LLD.Entities.ParkingTicket;
import org.LLD.Entities.VehicleEntity;
import org.LLD.Services.Parking.ParkingService;

public interface TicketService {

    ParkingTicket generateTicket(ParkingSlots slot, VehicleEntity vehicle, String parkingLotId);

}
