package com.ecommerce.vendorservice;

import com.ecommerce.vendorservice.address.Address;
import com.ecommerce.vendorservice.address.AddressDto;
import com.ecommerce.vendorservice.address.AddressRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
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
        Vendor vendor = new Vendor();
        vendor.setName(vendorDto.name());
        vendor.setEmail(vendorDto.email());
        vendor.setMobile(vendorDto.mobile());

        Address address = new Address();
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

    List<VendorDto> findAll()
    {
        return vendorRepository.findAllByOrderByName()
                .stream()
                .map(vendor -> mapToVendorDto(vendor))
                .collect(Collectors.toList());
    }

    Optional<VendorDto> findById(long id)
    {
        Vendor vendor = vendorRepository.findById(id).get();
        return Optional.of(mapToVendorDto(vendor));
    }

    List<VendorDto> findByName(String name)
    {
        return vendorRepository.findByNameContainingIgnoreCase(name)
                .stream()
                .map(vendor -> mapToVendorDto(vendor))
                .collect(Collectors.toList());
    }

    long update(long id, VendorDto vendorDto)
    {
        Vendor vendor = vendorRepository.findById(id).get();

        if(!Optional.ofNullable(vendorDto.name()).isEmpty())
            vendor.setName(vendorDto.name());
        if(!Optional.ofNullable(vendorDto.email()).isEmpty())
            vendor.setEmail(vendorDto.email());
        if(!Optional.ofNullable(vendorDto.mobile()).isEmpty())
            vendor.setMobile(vendorDto.mobile());


        var addressDto = vendorDto.address();
        if(addressDto!=null)
        {
            Address address = vendor.getAddress();

            if (!Optional.ofNullable(addressDto.unit()).isEmpty())
                address.setUnit(addressDto.unit());
            if (!Optional.ofNullable(addressDto.level()).isEmpty())
                address.setLevel(addressDto.level());
            if (!Optional.ofNullable(addressDto.building()).isEmpty())
                address.setBuilding(addressDto.building());
            if (!Optional.ofNullable(addressDto.area()).isEmpty())
                address.setArea(addressDto.area());
            if (!Optional.ofNullable(addressDto.city()).isEmpty())
                address.setCity(addressDto.city());
            if (!Optional.ofNullable(addressDto.province()).isEmpty())
                address.setProvince(addressDto.province());
            if (!Optional.ofNullable(addressDto.country()).isEmpty())
                address.setCountry(addressDto.country());
            if (!Optional.ofNullable(addressDto.postalCode()).isEmpty())
                address.setPostalCode(addressDto.postalCode());
            if (!Optional.ofNullable(addressDto.landmark()).isEmpty())
                address.setLandmark(addressDto.landmark());

            vendor.setAddress(addressRepository.save(address));
        }
        return vendorRepository.save(vendor).getId();
    }

    void deleteById(long id)
    {
        vendorRepository.deleteById(id);
    }

    private VendorDto mapToVendorDto(Vendor vendor)
    {
        return new VendorDto
                (
                        vendor.getName(),
                        vendor.getEmail(),
                        vendor.getMobile(),
                        new AddressDto
                                (
                                        vendor.getAddress().getUnit(),
                                        vendor.getAddress().getLevel(),
                                        vendor.getAddress().getBuilding(),
                                        vendor.getAddress().getArea(),
                                        vendor.getAddress().getCity(),
                                        vendor.getAddress().getProvince(),
                                        vendor.getAddress().getCountry(),
                                        vendor.getAddress().getPostalCode(),
                                        vendor.getAddress().getLandmark()
                                )
                );
    }

}
