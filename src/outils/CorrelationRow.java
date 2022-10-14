package outils;

import java.util.ArrayList;

public class CorrelationRow {
    private String attribute;
    private Float T3_resin;
    private Float thyroxin;
    private Float triodothyronine;
    private Float TSH;
    private Float Max_TSH;


    public CorrelationRow(String attr){
        this.attribute = attr;
    }
    public CorrelationRow(String attr,ArrayList<Float> values){
        this.attribute = attr;
        T3_resin = (values.get(0));
        thyroxin = (values.get(1));
        triodothyronine = (values.get(2));
        TSH = (values.get(3));
        Max_TSH = (values.get(4));
    }

    public CorrelationRow(String attr, Float t3_resin, Float thyroxin, Float triodothyronine, Float TSH, Float max_TSH) {
        this.attribute = attr;
        T3_resin = t3_resin;
        this.thyroxin = thyroxin;
        this.triodothyronine = triodothyronine;
        this.TSH = TSH;
        Max_TSH = max_TSH;
    }

    public String getAttribute() {
        return attribute;
    }

    public Float getT3_resin() {
        return T3_resin;
    }

    public Float getThyroxin() {
        return thyroxin;
    }

    public Float getTriodothyronine() {
        return triodothyronine;
    }

    public Float getTSH() {
        return TSH;
    }

    public Float getMax_TSH() {
        return Max_TSH;
    }

    public void setAttribute(String attr) {
        this.attribute = attr;
    }

    public void setT3_resin(Float t3_resin) {
        T3_resin = t3_resin;
    }

    public void setThyroxin(Float thyroxin) {
        this.thyroxin = thyroxin;
    }

    public void setTriodothyronine(Float triodothyronine) {
        this.triodothyronine = triodothyronine;
    }

    public void setTSH(Float TSH) {
        this.TSH = TSH;
    }

    public void setMax_TSH(Float max_TSH) {
        Max_TSH = max_TSH;
    }
    public void setAttrOf(String nameAttr,Float cc){

        if (nameAttr.equals("T3_resin")) {
            this.setT3_resin(cc);
        } else if (nameAttr.equals("thyroxin")) {
            this.setThyroxin(cc);
        } else if (nameAttr.equals("triodothyronine")) {
            this.setTriodothyronine(cc);
        } else if (nameAttr.equals("thyroid-stimulating hormone")) {
            this.setTSH(cc);
        } else if (nameAttr.equals("Maximal absolute difference of TSH")) {
            this.setMax_TSH(cc);
        }
    }

}
