package guru.springframework.spring5webapp.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import guru.springframework.spring5webapp.services.MiscellaneousService;

@RestController
public class MiscellaneousController {
    private MiscellaneousService service;


    public MiscellaneousController(MiscellaneousService service){
        this.service = service;
    }
    
    @RequestMapping("/info")
    public ResponseEntity<?> getInformation() {
        String response = service.getInformation();
        return new ResponseEntity<String>(response, HttpStatus.OK);
    }
}
