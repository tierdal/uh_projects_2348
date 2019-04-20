package plift;

import javafx.fxml.FXML;

import java.io.IOException;

public class plift_weightplate {
    public void setAttempt_weight(double attempt_weight) {

        double def_weight = attempt_weight - 20;

        int count50 = 0;
        int count25 = 0;
        int count20 = 0;
        int count15 = 0;
        int count10 = 0;
        int count5 = 0;
        double count2_5 = 0;
        double count1_5 = 0;
        double count0_5 = 0;
        double count0_25 = 0;

            while(def_weight >= 50){
                def_weight = def_weight - 50;
                count50++;
            }

            while(def_weight >= 25){
                def_weight = def_weight - 25;
                count25++;
            }

            while(def_weight >= 15){
                def_weight = def_weight - 15;
                count15++;
            }

            while(def_weight >= 10){
                def_weight = def_weight - 10;
                count10++;
            }

            while(def_weight >= 5){
                def_weight = def_weight - 5;
                count5++;
            }


    }




}
