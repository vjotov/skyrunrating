package com.jotov.skyrunrating.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Competition {
    @Id
    private int id;
    private String name;
    private String Description;
    private int maxPoints;
    private int meterDistance;
    private int meterDisplacement;

    public Competition() {}

    public Competition(int id,
                       String name,
                       String description,
                       Integer meterDistance,
                       Integer meterDisplacement,
                       Integer maxPoints) {
        this.id = id;
        this.name = name;
        Description = description;
        this.meterDistance = meterDistance;
        if(meterDisplacement == null)
            meterDisplacement = 0;
        this.meterDisplacement = meterDisplacement;
        if(maxPoints == null)
            maxPoints = 100;
        this.maxPoints = maxPoints;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getMaxPoints() {
        return maxPoints;
    }

    public void setMaxPoints(int maxPoints) {
        this.maxPoints = maxPoints;
    }

    public int getMeterDistance() {
        return meterDistance;
    }

    public void setMeterDistance(int meterDistance) {
        this.meterDistance = meterDistance;
    }

    public int getMeterDisplacement() {
        return meterDisplacement;
    }

    public void setMeterDisplacement(int meterDisplacement) {
        this.meterDisplacement = meterDisplacement;
    }



}
