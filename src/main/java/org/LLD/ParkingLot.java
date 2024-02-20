package org.LLD;

import org.LLD.Helper.AutowireService;
import org.LLD.Constants.Commands;
import java.util.Scanner;

public class ParkingLot {
    public static void main(String[] args) {
        AutowireService autowireService = new AutowireService();

        Scanner scanner = new Scanner(System.in);

        while (true){

            String[] input = scanner.nextLine().trim().split(" ");

            switch (input[0]) {

                case Commands.CREATE_PARKING_LOT: {

                    System.out.println(autowireService.getParkingService().createParkingLot(input[1],Integer.parseInt(input[2]),Integer.parseInt(input[3])));

                }
                break;
                case Commands.PARK_VEHICLE: {
                    System.out.println("park");
                }
                break;
                case Commands.UNPARK_VEHICLE: {
                    System.out.println("unpark");

                }
                break;
                case Commands.DISPLAY: {
                    System.out.println("display");

                }
                break;
                default: {
                    System.out.println("!----- ERROR IN COMMAND -----!");
                }

            }

        }

    }
}