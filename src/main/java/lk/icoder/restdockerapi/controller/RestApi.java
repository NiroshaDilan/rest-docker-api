package lk.icoder.restdockerapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RestApi {

    @GetMapping
    public ResponseEntity<String> healthCheck() {
        return new ResponseEntity<>("Working...", HttpStatus.OK);
    }
}
