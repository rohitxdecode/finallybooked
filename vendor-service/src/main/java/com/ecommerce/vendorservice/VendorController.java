package com.ecommerce.vendorservice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vendor")
public class VendorController
{
    private final VendorService vendorService;

    public VendorController(VendorService vendorService)
    {
        this.vendorService = vendorService;
    }

    @PostMapping
    public ResponseEntity save(@RequestBody VendorDto vendorDto)
    {
        return ResponseEntity.status(HttpStatus.OK)
                            .body(vendorService.save(vendorDto));
    }

}
