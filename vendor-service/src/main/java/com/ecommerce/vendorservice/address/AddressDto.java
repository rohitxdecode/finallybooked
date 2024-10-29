package com.ecommerce.vendorservice.address;

public record AddressDto
        (
                int unit,
                int level,
                String building,
                String area,
                String city,
                String province,
                String country,
                String postalCode,
                String landmark
        ) {}
