package com.example.idillika;

public class ModelForBasket {

    String nameBrand;
    String descBrand;
    String priceBrand;

    public ModelForBasket( String nameBrand, String descBrand, String priceBrand ) {
        this.nameBrand=nameBrand;
        this.descBrand=descBrand;
        this.priceBrand=priceBrand;
    }

    public String getNameBrand() {
        return nameBrand;
    }

    public void setNameBrand( String nameBrand ) {
        this.nameBrand=nameBrand;
    }

    public String getDescBrand() {
        return descBrand;
    }

    public void setDescBrand( String descBrand ) {
        this.descBrand=descBrand;
    }

    public String getPriceBrand() {
        return priceBrand;
    }

    public void setPriceBrand( String priceBrand ) {
        this.priceBrand=priceBrand;
    }
}
