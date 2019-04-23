package plift;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;

public class class_weightplate {
    public int count50 = 0;
    public int count25 = 0;
    public int count20 = 0;
    public int count15 = 0;
    public int count10 = 0;
    public int count5 = 0;
    public int count2_5 = 0;
    public int count1_25 = 0;
    public int count0_5 = 0;
    public int count0_25 = 0;

    public void SetBarWeights(double attempt_weight){
        double def_weight = attempt_weight - 20;

        while(def_weight >= 100){
            def_weight = def_weight - 100;
            count50 = count50 + 2;
        }

        while(def_weight >= 50){
            def_weight = def_weight - 50;
            count25 = count25 + 2;
        }

        while(def_weight >= 40){
            def_weight = def_weight - 40;
            count20 = count20 + 2;
        }

        while(def_weight >= 30){
            def_weight = def_weight - 30;
            count15 = count15 + 2;
        }

        while(def_weight >= 20){
            def_weight = def_weight - 20;
            count10 = count10 + 2;
        }

        while(def_weight >= 10){
            def_weight = def_weight - 10;
            count5 = count5 + 2;
        }

        while(def_weight >= 4){
            def_weight = def_weight - 4;
            count2_5 = count2_5 + 2;
        }

        while(def_weight >= 2.5){
            def_weight = def_weight - 2.5;
            count1_25 = count1_25 + 2;
        }

        while (def_weight >= 1){
            def_weight = def_weight - 1;
            count0_5 = count0_5 + 2;
        }

        while (def_weight >= 0.5){
            def_weight = def_weight - 0.5;
            count0_25 = count0_25 + 2;
        }

    }


}