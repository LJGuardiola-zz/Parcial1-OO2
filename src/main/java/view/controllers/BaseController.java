package view.controllers;

import model.FuelStation;

public abstract class BaseController {

    protected FuelStation fuelStation;

    public void setFuelStation(FuelStation fuelStation) {
        this.fuelStation = fuelStation;
    }

}
