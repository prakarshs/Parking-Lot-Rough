package org.LLD.Helper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.LLD.Services.Display.DisplayService;
import org.LLD.Services.Display.DisplayServiceIMPL;
import org.LLD.Services.Parking.ParkingService;
import org.LLD.Services.Parking.ParkingServiceIMPL;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AutowireService {
    DisplayService displayService = new DisplayServiceIMPL();
    ParkingService parkingService = new ParkingServiceIMPL();
}
