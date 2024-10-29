package com.ecommerce.vendorservice;

import com.ecommerce.vendorservice.address.Address;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Entity
public class Vendor
{
    @Id
    @GeneratedValue
    private long id;

    @NotNull
    private String name;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY)
    private Address address;

    private String email;

    @NotNull
    private long mobile;

    @NotNull
    private String createdBy;

    @CreationTimestamp
    private Instant createdAt;

    private String updatedBy;

    @UpdateTimestamp
    private Instant updatedAt;

    public Vendor(){}
    public Vendor(long id, String name, Address address, String email, long mobile, String createdBy, Instant createdAt, String updatedBy, Instant updatedAt)
    {
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.mobile = mobile;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
        this.updatedBy = updatedBy;
        this.updatedAt = updatedAt;
    }

    public long getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Address getAddress()
    {
        return address;
    }

    public void setAddress(Address address)
    {
        this.address = address;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public long getMobile()
    {
        return mobile;
    }

    public void setMobile(long mobile)
    {
        this.mobile = mobile;
    }

    public Instant getCreatedAt()
    {
        return createdAt;
    }

    public Instant getUpdatedAt()
    {
        return updatedAt;
    }

    public String getCreatedBy()
    {
        return createdBy;
    }

    public void setCreatedBy(String createdBy)
    {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy()
    {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy)
    {
        this.updatedBy = updatedBy;
    }
}
