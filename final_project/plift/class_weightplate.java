package plift;

public class class_weightplate {
    public void SetBarWeights(double attempt_weight){
        double def_weight = attempt_weight - 20;

        double count50 = 0;
        double count25 = 0;
        double count20 = 0;
        double count15 = 0;
        double count10 = 0;
        double count5 = 0;
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
