package com.zipcoder.cryptonator_api.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by leon on 1/22/18.
 */
@Entity
public class Foo {

    @Id
    @Size(min = 2, max = 2)
    private String base; // ticker
    @Size(min = 2, max = 2)
    private String target; // value in specific money (usd/cad)
    private Double price; // current price ######.#######
    private Double volume; // 24-hour volume
    private String markets;
    private Date timeStamp;
    private Boolean success;
    private Error error;

    public Foo() {
    }

    public Foo(String base, String target,
               Double price, Double volume,
               String markets, Date timeStamp,
               Boolean success, Error error) {
        this.base = base;
        this.target = target;
        this.price = price;
        this.volume = volume;
        this.markets = markets;
        this.timeStamp = timeStamp;
        this.success = success;
        this.error = error;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public String getMarkets() {
        return markets;
    }

    public void setMarkets(String markets) {
        this.markets = markets;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }
}
