package com.ecommerce.vendorservice;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VendorRepository extends JpaRepository<Vendor, Long>
{
    List<Vendor> findAllByOrderByName();
    List<Vendor> findByNameContainingIgnoreCase(String name);
}
