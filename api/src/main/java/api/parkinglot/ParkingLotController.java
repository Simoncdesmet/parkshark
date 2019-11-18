package api.parkinglot;

import com.dreamteam.parkshark.domain.parkinglot.ParkingLot;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/parkinglots")
public class ParkingLotController {


    @PostMapping(consumes = "application/json",produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void createParkingLot(@RequestBody ParkingLotDto parkingLotDto) {

    }
}
