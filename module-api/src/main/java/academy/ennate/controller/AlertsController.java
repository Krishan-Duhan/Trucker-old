package academy.ennate.controller;

import academy.ennate.entity.Alerts;
import academy.ennate.service.AlertsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/alerts")
@Api(value="Controller for handling alerts")
public class AlertsController {
    @Autowired
    private AlertsService service;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "method to find all alerts of given severity within last given hours")
    public List<Alerts> findAlertsBySeverity(@RequestParam(value = "severity") String severity, @RequestParam(value = "within") Integer hours){
        return service.findAlertsBySeverity(severity, hours);
    }

    @RequestMapping(method = RequestMethod.GET, value = "{vin}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Alerts> findAlertsByVin(@PathVariable("vin") String vin){
        return service.findAlertsByVin(vin);
    }
}
