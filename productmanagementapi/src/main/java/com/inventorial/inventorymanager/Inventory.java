package com.inventorial.inventorymanager;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.sql.Timestamp;

@Entity
@Table(name = "inventory")
@JsonIgnoreProperties(ignoreUnknown = true) // Ignore unknown properties during JSON conversion
public class Inventory {

    @Id
    @Column(name = "ProductId", nullable = false)
    private String productId;
    
    @Column(name = "CompanyId", nullable = false)
    private Integer companyId;

    @Column(name = "Location")
    @JsonProperty("location")
    private String location; // Will hold JSON data as a string

    @Column(name = "ProductInfo")
    @JsonProperty("productInfo")
    private String productInfo; // Will hold JSON data as a string

    @Column(name = "UUID")
    @JsonProperty("uuid")
    private String uuid; // Will hold JSON data as a string

    @Column(name = "LastModified", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private Timestamp lastModified;

    @Column(name = "Created", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp created;

    public Inventory() {
        // Default constructor
    }

    // Getters and setters

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getProductInfo() {
        return productInfo;
    }

    public void setProductInfo(String productInfo) {
        this.productInfo = productInfo;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Timestamp getLastModified() {
        return lastModified;
    }

    public void setLastModified(Timestamp lastModified) {
        this.lastModified = lastModified;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    // Custom methods to parse JSON strings into JSON objects
    @JsonProperty("location")
    public Object getLocationJson() {
        return parseJson(location);
    }

    @JsonProperty("productInfo")
    public Object getProductInfoJson() {
        return parseJson(productInfo);
    }

    @JsonProperty("uuid")
    public Object getUuidJson() {
        return parseJson(uuid);
    }

    private Object parseJson(String jsonString) {
        try {
            return new com.fasterxml.jackson.databind.ObjectMapper().readValue(jsonString, Object.class);
        } catch (Exception e) {
            return null; // Handle JSON parsing exception
        }
    }
}
