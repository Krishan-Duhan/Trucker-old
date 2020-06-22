package academy.ennate.controller;

import academy.ennate.entity.Vehicles;
import academy.ennate.service.VehicleService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "vehicles")
//@Api(value = "VehiclesController")
public class VehiclesController {

    @Autowired
    VehicleService service;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Vehicles> findAll(){
        return service.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Vehicles findOne(@PathVariable("id") String vid){
        return service.findOne(vid);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void loadVehicles(@RequestBody Vehicles[] vehicles){
        service.loadVehicles(vehicles);
    }
}
