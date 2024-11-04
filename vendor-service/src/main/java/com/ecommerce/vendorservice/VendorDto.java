package com.ecommerce.vendorservice;

import com.ecommerce.vendorservice.address.AddressDto;

public record VendorDto
        (
                String name,
                String email,
                Long mobile,
                AddressDto address
        ){}
