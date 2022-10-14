package outils;

import java.util.ArrayList;

public class Row {

    private Float Class_attribute;
    private Float T3_resin;
    private Float thyroxin;
    private Float triodothyronine;
    private Float TSH;
    private Float Max_TSH;

    public Row(ArrayList<Float> line) {
        Class_attribute = (line.get(0));
        T3_resin = (line.get(1));
        thyroxin = (line.get(2));
        triodothyronine = (line.get(3));
        TSH = (line.get(4));
        Max_TSH = (line.get(5));
    }

    public Float getValueOfAttr(String nameAttr){

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
    public Float getClass_attribute() {
        return Class_attribute;
    }

    public void setClass_attribute(Float class_attribute) {
        Class_attribute = class_attribute;
    }

    public Float getT3_resin() {
        return T3_resin;
    }

    public void setT3_resin(Float t3_resin) {
        T3_resin = t3_resin;
    }

    public Float getThyroxin() {
        return thyroxin;
    }

    public void setThyroxin(Float thyroxin) {
        this.thyroxin = thyroxin;
    }

    public Float getTriodothyronine() {
        return triodothyronine;
    }

    public void setTriodothyronine(Float triodothyronine) {
        this.triodothyronine = triodothyronine;
    }

    public Float getTSH() {
        return TSH;
    }

    public void setTSH(Float TSH) {
        this.TSH = TSH;
    }

    public Float getMax_TSH() {
        return Max_TSH;
    }

    public void setMax_TSH(Float max_TSH) {
        Max_TSH = max_TSH;
    }








}
