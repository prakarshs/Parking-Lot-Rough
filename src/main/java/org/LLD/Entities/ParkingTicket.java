package org.LLD.Entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.LLD.Constants.Enums.VehicleType;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ParkingTicket {
    private String parkingTicketId;
    private VehicleType vehicleType;
    private String vehicleRegNumber;
    private Date ticketIssuedAt;
    private ParkingSlots parkingSlot;
}
