package api.parkinglot;

import com.dreamteam.parkshark.domain.parkinglot.ParkingLot;
import com.dreamteam.parkshark.service.parkinglot.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/parkinglots")

public class ParkingLotController {

    private final ParkingLotDtoMapper parkingLotDtoMapper;
    private final ParkingLotService parkingLotService;

    @Autowired
    public ParkingLotController(ParkingLotDtoMapper parkingLotDtoMapper, ParkingLotService parkingLotService) {
        this.parkingLotDtoMapper = parkingLotDtoMapper;
        this.parkingLotService = parkingLotService;
    }


    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ParkingLotDto createParkingLot(@RequestBody ParkingLotDto parkingLotDto) {
        ParkingLot parkingLotToCreate = parkingLotDtoMapper.toParkingLot(parkingLotDto);
        parkingLotService.createParkingLot(parkingLotToCreate);
        return parkingLotDtoMapper.toParkingLotDto(parkingLotToCreate);
    }
}
