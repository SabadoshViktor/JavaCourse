package de.telran.processors.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class FeedbackController {

    @PostMapping("feedback")
    public ResponseEntity postFeedback(@RequestParam String firstName,
                                       @RequestParam String lastName,
                                       @RequestParam String email,
                                       @RequestParam String mesage,
                                       @RequestParam(required = false) boolean gdprCheckBox){
        return new ResponseEntity("Hello "
                + firstName + " "
                + lastName + "Your email is: " +  email+ gdprCheckBox + mesage, HttpStatus.OK
        );

    }
}
