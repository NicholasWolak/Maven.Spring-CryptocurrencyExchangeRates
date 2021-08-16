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
}
