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

        while(def_weight >= 50){
            def_weight = def_weight - 50;
            count50++;
        }

        while(def_weight >= 25){
            def_weight = def_weight - 25;
            count25++;
        }

        while(def_weight >= 20){
            def_weight = def_weight - 20;
            count20++;
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

        while(def_weight >= 2.5){
            def_weight = def_weight - 2.5;
            count2_5++;
        }

        while(def_weight >= 1.25){
            def_weight = def_weight - 1.25;
            count1_25++;
        }

        while (def_weight >= 0.5){
            def_weight = def_weight - 0.5;
            count0_5++;
        }

        while (def_weight >= 0.25){
            def_weight = def_weight - 0.25;
            count0_25++;
        }
        FXCollections.observableArrayList("50KG Weights: " + count50,"25KG Weights: " + count25);
    }


}