package com.crudrepo.user;

import com.crudrepo.user.exceptions.InvalidJWTException;
import com.crudrepo.user.exceptions.UnauthorizedException;
import com.crudrepo.user.model.JWTResponse;
import com.crudrepo.user.model.TransferDetails;
import com.crudrepo.user.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.GeneralSecurityException;

@RestController
@RequestMapping("/transfers")
public class TransferController {
    @Autowired
    TransferService transferService;

    @PutMapping()
    public ResponseEntity<?> createTransfer(@RequestBody TransferDetails transferDetails,
                                            @RequestHeader(name = "Authorization") JWTResponse jwtResponse)
            throws InvalidJWTException, GeneralSecurityException, UnauthorizedException {
        transferService.checkUserAuthorization(jwtResponse, transferDetails.getSrcIban());
        if (transferService.sendMoney(transferDetails.getDestIban(), transferDetails.getSrcIban(), transferDetails.getAmount())) {
            return new ResponseEntity<>("Money successfully transferred.", HttpStatus.OK);
        }
        return new ResponseEntity<>("Insufficient funds.", HttpStatus.BAD_REQUEST);
    }
}
