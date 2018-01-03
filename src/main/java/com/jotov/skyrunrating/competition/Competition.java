package com.jotov.skyrunrating.competition;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Competition {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private Date date;
    private int maxPoints;
    private int meterDistance;
    private int meterDisplacement;

    public Competition() {}

    public Competition(int id,
                       String name,
                       Date description,
                       Integer meterDistance,
                       Integer meterDisplacement,
                       Integer maxPoints) {
        this.id = id;
        this.name = name;
        date = description;
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

    public Date getDescription() {
        return date;
    }

    public void setDescription(Date date) {
        this.date = date;
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
