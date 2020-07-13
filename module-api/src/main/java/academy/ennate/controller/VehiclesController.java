package academy.ennate.controller;

import academy.ennate.entity.Vehicles;
import academy.ennate.service.VehicleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/vehicles")
@Api(value = "Vehicle related endpoints")
public class VehiclesController {
    @Autowired
    VehicleService service;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "finds all vehicles", notes = "returns a list of all vehicles")
    public List<Vehicles> findAll(){
        return service.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value="find a vehicle by its vid", notes = "returns a vehicle object")
    public Vehicles findOne(@PathVariable("id") String vid){
        return service.findOne(vid);
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ApiOperation(value = "puts array of vehicles objects in database")
    public void loadVehicles(@RequestBody Vehicles[] vehicles){
        service.loadVehicles(vehicles);
    }
}
