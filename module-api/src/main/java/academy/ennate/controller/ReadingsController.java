package academy.ennate.controller;

import academy.ennate.GeoLocation;
import academy.ennate.entity.Readings;
import academy.ennate.service.ReadingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Method;
import java.util.List;

@RestController
@RequestMapping(value = "/readings")
@Api(value = "Controller for inserting and retrieving vehicle readings")
public class ReadingsController {
    @Autowired
    ReadingService service;

    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "method to insert readings")
    public void insertReadings(@RequestBody Readings reading){
        service.insertReadings(reading);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "method to retrieve all vehicles' readings")
    public List<Readings> listReadings(){
        return service.getReadings();
    }

    @RequestMapping(method = RequestMethod.GET, value = "{vin}")
    @ApiOperation(value = "method to return a vehicle's geolocations within last 'min' minutes")
    public List<GeoLocation> getVehicleInfo(@PathVariable String vin,@RequestParam(value = "within", required = true) Integer min) {
        return service.getVehicleInfo(vin, min);
    }
}
