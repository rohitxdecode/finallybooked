package com.ecommerce.vendorservice;

import com.ecommerce.vendorservice.address.Address;
import com.ecommerce.vendorservice.address.AddressRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class VendorService
{
    private final VendorRepository vendorRepository;
    private final AddressRepository addressRepository;

    public VendorService(VendorRepository vendorRepository, AddressRepository addressRepository)
    {
        this.vendorRepository = vendorRepository;
        this.addressRepository = addressRepository;
    }

    long save(VendorDto vendorDto)
    {
        var vendor = new Vendor();
        vendor.setName(vendorDto.name());
        vendor.setEmail(vendorDto.email());
        vendor.setMobile(vendorDto.mobile());

        var address = new Address();
        var addressDto = vendorDto.address();
        address.setUnit(addressDto.unit());
        address.setLevel(addressDto.level());
        address.setBuilding(addressDto.building());
        address.setArea(addressDto.area());
        address.setCity(addressDto.city());
        address.setProvince(addressDto.province());
        address.setCountry(addressDto.country());
        address.setPostalCode(addressDto.postalCode());
        address.setLandmark(addressDto.landmark());
        vendor.setAddress(addressRepository.save(address));
        return vendorRepository.save(vendor).getId();
    }


}
