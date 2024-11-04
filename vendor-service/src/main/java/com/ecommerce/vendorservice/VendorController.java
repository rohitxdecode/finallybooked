package com.ecommerce.vendorservice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(vendorService.save(vendorDto));
    }

    @GetMapping
    public ResponseEntity<List<VendorDto>> findAll()
    {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(vendorService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VendorDto> findById(@PathVariable long id)
    {
        return vendorService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<VendorDto>> findByName(@PathVariable String name)
    {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(vendorService.findByName(name));
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable long id, @RequestBody VendorDto vendorDto)
    {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(vendorService.update(id, vendorDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id)
    {
        vendorService.deleteById(id);
        return ResponseEntity
                .noContent()
                .build();
    }


}
