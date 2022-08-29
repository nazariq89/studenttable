package com.zariqmattproject.studenttable.model;


import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

public abstract class AuditAbstract {
    @CreatedDate
    private Date createdOn ;


    @LastModifiedDate
    private Date modifiedOn;


        //Getter
    public Date getCreatedOn() {
        return createdOn;
    }

    public Date getModifiedOn() {
        return modifiedOn;
    }


    //setter
    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public void setModifiedOn(Date modifiedOn) {
        this.modifiedOn = modifiedOn;
    }
}
