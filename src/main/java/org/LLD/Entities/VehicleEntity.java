package org.LLD.Entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.LLD.Constants.Enums.VehicleType;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VehicleEntity {
    private String vehicleRegNumber;
    private VehicleType vehicleType;
    private String color;
}
