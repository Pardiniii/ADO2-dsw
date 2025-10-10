package br.com.carstore.dto;

import java.util.List;

public class CarResponseBody {

    public CarResponseBody(){}

    public CarResponseBody(List<CarDTO> cars){
        this.cars = cars;
    }

    public List<CarDTO> cars;
}
