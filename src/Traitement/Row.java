package Traitement;

import java.util.ArrayList;
import java.util.Vector;

public class Row {

    private Double Class_attribute;
    private Double T3_resin;
    private Double thyroxin;
    private Double triodothyronine;
    private Double TSH;
    private Double Max_TSH;

    public Row(Vector<Double> line) {
        Class_attribute = (line.get(0));
        T3_resin = (line.get(1));
        thyroxin = (line.get(2));
        triodothyronine = (line.get(3));
        TSH = (line.get(4));
        Max_TSH = (line.get(5));
    }

    public Double getValueOfAttr(String nameAttr){

        if (nameAttr.equals("T3_resin")) {
            return this.getT3_resin();
        } else if (nameAttr.equals("thyroxin")) {
            return this.getThyroxin();
        } else if (nameAttr.equals("triodothyronine")) {
            return this.getTriodothyronine();
        } else if (nameAttr.equals("thyroid-stimulating hormone")) {
            return this.getTSH();
        } else if (nameAttr.equals("Maximal absolute difference of TSH")) {
            return this.getMax_TSH();
        }
        return null;
    }
    public Double getClass_attribute() {
        return Class_attribute;
    }

    public void setClass_attribute(Double class_attribute) {
        Class_attribute = class_attribute;
    }

    public Double getT3_resin() {
        return T3_resin;
    }

    public void setT3_resin(Double t3_resin) {
        T3_resin = t3_resin;
    }

    public Double getThyroxin() {
        return thyroxin;
    }

    public void setThyroxin(Double thyroxin) {
        this.thyroxin = thyroxin;
    }

    public Double getTriodothyronine() {
        return triodothyronine;
    }

    public void setTriodothyronine(Double triodothyronine) {
        this.triodothyronine = triodothyronine;
    }

    public Double getTSH() {
        return TSH;
    }

    public void setTSH(Double TSH) {
        this.TSH = TSH;
    }

    public Double getMax_TSH() {
        return Max_TSH;
    }

    public void setMax_TSH(Double max_TSH) {
        Max_TSH = max_TSH;
    }








}
