package org.javaturk.oofp.ch03.erp;

import org.javaturk.oofp.ch03.compatibility.AverageFootballPlayer;

public class ErpTest {
    public static void main(String[] args) {

        Computer computer = new Computer("12332", "InventoryPc", 3200, 100, "Apple", "Mac Air 2020");
        ClothProduct clothProduct = new ClothProduct("CP123", "BlueSweat", 20, 2.5, new Location("London Depot", "London"),"Men", "m"  );
        ConsultancyProduct consultProduct = new ConsultancyProduct("CoPro123123", "Java Education", 1000, 150, new Location("Zoom", "Online"), new Consultant("Akın", "ITU", "Java EE"),"Java Programming" );

        AbstractProduct [] productArray = new AbstractProduct[3];
        productArray[0] = computer;
        productArray[1] = clothProduct;
        productArray[2] = consultProduct;

        for( AbstractProduct product : productArray) {
            product.setPrice(123);
            product.gift();
            product.getGiftedInfo();
        }

    }




}
