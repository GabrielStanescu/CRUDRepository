package com.crudrepo.user;

import com.crudrepo.user.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transfers")
public class TransferController {
    @Autowired
    TransferService transferService;

    @PutMapping()
    public ResponseEntity<?> transfer(@RequestHeader(name = "srcIban") String src,
                                      @RequestHeader(name = "amount") Double amount,
                                      @RequestParam("dest") String dest) {
         if (transferService.sendMoney(dest, src, amount)) {
             return new ResponseEntity<>(HttpStatus.OK);
         }
         return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
