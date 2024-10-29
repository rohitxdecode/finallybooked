package com.ecommerce.vendorservice.address;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Entity
public class Address
{
    @Id
    @GeneratedValue
    private long id;

    @NotNull
    private int unit;

    private int level;

    private String building;

    @NotNull
    private String area;

    @NotNull
    private String city;

    @NotNull
    private String province;

    @NotNull
    private String country;

    @NotNull
    private String postalCode;

    private String landmark;

    @NotNull
    private String createdBy;

    @CreationTimestamp
    private Instant createdAt;

    private String updatedBy;

    @UpdateTimestamp
    private Instant updatedAt;

    public Address(){}

    public Address(long id, int unit, int level, String building, String area, String city, String province, String country, String postalCode, String landmark, String createdBy, Instant createdAt, String updatedBy, Instant updatedAt)
    {
        this.id = id;
        this.unit = unit;
        this.level = level;
        this.building = building;
        this.area = area;
        this.city = city;
        this.province = province;
        this.country = country;
        this.postalCode = postalCode;
        this.landmark = landmark;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
        this.updatedBy = updatedBy;
        this.updatedAt = updatedAt;
    }

    public long getId()
    {
        return id;
    }

    public int getUnit()
    {
        return unit;
    }

    public void setUnit(int unit)
    {
        this.unit = unit;
    }

    public int getLevel()
    {
        return level;
    }

    public void setLevel(int level)
    {
        this.level = level;
    }

    public String getBuilding()
    {
        return building;
    }

    public void setBuilding(String building)
    {
        this.building = building;
    }

    public String getArea()
    {
        return area;
    }

    public void setArea(String area)
    {
        this.area = area;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getProvince()
    {
        return province;
    }

    public void setProvince(String province)
    {
        this.province = province;
    }

    public String getCountry()
    {
        return country;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }

    public String getPostalCode()
    {
        return postalCode;
    }

    public void setPostalCode(String postalCode)
    {
        this.postalCode = postalCode;
    }

    public String getLandmark()
    {
        return landmark;
    }

    public void setLandmark(String landmark)
    {
        this.landmark = landmark;
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
