package file;

import model.Kontener;

public class Algorytm {
    private int layer = 5;
    private int width = 50;
    private int length = 60;
    private Kontener[][][] result = new Kontener[layer][width][length];


    public Kontener[] sort(Kontener kontenerTab[]){
        for (int i = 0; i < kontenerTab.length-1; i++) {
            for (int j = i + 1; j < kontenerTab.length; j++) {
                if (kontenerTab[i].getWeight() < kontenerTab[j].getWeight()){

                    Kontener tmp = kontenerTab[i];
                    kontenerTab[i] = kontenerTab[j];
                    kontenerTab[j] = tmp;
                }
            }
        }
        return kontenerTab;
    }

    private double calculateWeightSum(Kontener kontenerTab[]){
        double sum = 0;
        for (int i = 0; i < kontenerTab.length ; i++) {
            sum += kontenerTab[i].getWeight();
        }

        return sum;
    }

    public Kontener[][][]  putToArray3D(Kontener kontenerTab[]){
        int skip = kontenerTab.length/length;
        double sum = calculateWeightSum(kontenerTab);
        System.out.println("Sum: " + (long)sum);

        double layerAvg = sum / layer;
        double widthAvg = layerAvg / width;

        double tmp = 0;

        System.out.println("layerAvg -" + (long)layerAvg);
        System.out.println("widthavg - " + (long)widthAvg);

        for (int j = 0; j < layer; j++) {
            for (int k = 0; k < width; k++) {
                int indexStart = j*50+k;
                for (int l = 0; l < length; l++) {
                    result[j][k][l] = kontenerTab[indexStart];
                    indexStart += skip;
                }
            }
        }
       return result;
    }

    public void getInfo(){
        for (int i = 0; i < result.length; i++) {
            double sumLayer = 0;
            for (int j = 0; j < result[i].length; j++) {
                double sum = 0;
                for (int k = 0; k <result[i][j].length; k++) {
                    sum = sum + result[i][j][k].getWeight();
                }
                System.out.println("wysokosc: " + i + " rzad: " + j + " suma wag w dlugosci: " + sum);
                sumLayer += sum;
            }
            System.out.println("wysokosc - suma: " + (int)sumLayer);
        }
    }
}
