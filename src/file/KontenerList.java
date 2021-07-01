package file;

import Exception.NoKontenerException;
import model.*;
import java.io.*;
import java.util.Random;

public class KontenerList {
    private Kontener kontenerTab[];
    private int count;


    public KontenerList(int count) {
        this.count = count;
        kontenerTab = new Kontener[count];
        for (int i = 0; i < count; i++) {
            kontenerTab[i] = generateKontener(KontenerType.getRandom(),i);
        }
    }

    private Kontener generateKontener(KontenerType type, int i) {
        switch (type){

            case VEHICLEKONTENER:
                return new VehicleKontener(i,generateWeight(),generateWidth(),generateHeight(),generateLength(), generateProductNumber(), generateColor(), generatePower(), countForCars(), generateSecret());

            case FREEZERKONTENER:
                return new FreezerKontener(i,generateWeight(),generateWidth(),generateHeight(),generateLength(),generateProductNumber(), generateColor(), generatePower(),
                      typeOfFoodGenerator(), temperatureGenerator(), coolingChecker());

            case HERMETICKONTENER:
                return new HermeticKontener(i,generateWeight(),generateWidth(),generateHeight(),generateLength(),generateProductNumber(), generateColor(), generatePower(),
                        generateNitrogenKoncentration());

            case POWDERKONTENER:
                return new PowderKontener(i, generateWeight(), generateWidth(), generateHeight(), generateLength(), generateProductNumber(), generateColor(), generatePower(), powderLoader() , generateHatches());

            case TANKKONTENER:
                return new TankKontener(i, generateWeight(), generateWidth(), generateHeight(), generateLength(), generateProductNumber(),generateColor(), generatePower(), vacumGenerator(), generateSubstance());

            case WASTEKONTENER:
                return new WasteKontener(i, generateWeight(), generateWidth(), generateHeight(), generateLength(), generateProductNumber(),generateColor(), generatePower(), typeOfWaste(), isDangerous());

            case WEAPONKONTENER:
                return new WeaponKontener(i, generateWeight(), generateWidth(), generateHeight(), generateLength(), generateProductNumber(),generateColor(), generatePower(), typeOfPermissionToOpen(),generateSecret());

            case DEFAULTKONTENER:
                return new DefaultKontener(i, generateWeight(), generateWidth(), generateHeight(), generateLength(), generateProductNumber(),generateColor(), generatePower(), generateRandomProduct());

            default:
                throw new NoKontenerException(type);
        }
    }

    public void saveToFile(String fileName) throws IOException {
        File file = new File(fileName);

        try{
            FileOutputStream fos = new FileOutputStream(file);
            BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(fos));

            for (Kontener k : kontenerTab) {
                bf.write(k.toString());
                bf.newLine();
            }
            bf.close();
        } catch (FileNotFoundException exp){
            System.out.println("Not found file.txt" + file.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Problem with reading file.txt" + file.getAbsolutePath());
        }
    }

    public Kontener[] readFromFile(String file) {
        Kontener kontenerTabRead[] = new Kontener[count];
        try {
            String strCurrentLine;
            BufferedReader br = new BufferedReader(new FileReader(file));
            int i = 0;
            while ((strCurrentLine = br.readLine()) != null) {
                // System.out.println(strCurrentLine);
                strCurrentLine = strCurrentLine.substring(0,strCurrentLine.length()-1);
                String tabStr[] = strCurrentLine.split("\\{");
                String kontenerTypeStr = tabStr[0];
                String values[] = tabStr[1].split(",");
                KontenerType kt = KontenerType.valueOf(kontenerTypeStr);
                kontenerTabRead[i++] = create(kt, values);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return kontenerTabRead;
    }

    public void saveToFile2(String fileName) throws IOException {
        File file = new File(fileName);

        try {
            FileOutputStream fos = new FileOutputStream(file);
            BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(fos));
            int counter = 0;
            int index = 0;
            int wysokosc = 0;
            for (Kontener k : kontenerTab) {
                bf.write(k.view());
                bf.newLine();
                counter++;

                if (counter % 60 == 0 && index <= 50) {
                    index++;
                    bf.write("Szerokosc: " + index + ", " + "Wysokosc: " + wysokosc);
                    bf.newLine();
                }
                if (index == 50) {
                    wysokosc++;
                    index = 0;
                }
            }
            bf.close();
        } catch (FileNotFoundException exp) {
            System.out.println("Not found file.txt" + file.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Problem with reading file.txt" + file.getAbsolutePath());
        }
    }

    public Kontener create(KontenerType type, String values[]) {
        switch (type){
            case VEHICLEKONTENER:
                return new VehicleKontener(Integer.parseInt(values[0]),Double.parseDouble(values[1]),Double.parseDouble(values[2]),Double.parseDouble(values[3]),Double.parseDouble(values[4]), values[5], values[6], Boolean.parseBoolean(values[7]), Integer.parseInt(values[8]), Boolean.parseBoolean(values[9]));

            case FREEZERKONTENER:
                return new FreezerKontener(Integer.parseInt(values[0]),Double.parseDouble(values[1]),Double.parseDouble(values[2]),Double.parseDouble(values[3]),Double.parseDouble(values[4]), values[5], values[6], Boolean.parseBoolean(values[7]),
                        values[8], Double.parseDouble(values[9]), Boolean.parseBoolean(values[10]));

            case HERMETICKONTENER:
                return new HermeticKontener(Integer.parseInt(values[0]),
                        Double.parseDouble(values[1]),
                        Double.parseDouble(values[2]),
                        Double.parseDouble(values[3]),
                        Double.parseDouble(values[4]),
                        values[5],
                        values[6],
                        Boolean.parseBoolean(values[7]),
                        Double.parseDouble(String.valueOf(values[8])));

            case POWDERKONTENER:
                return new PowderKontener(Integer.parseInt(values[0]),
                        Double.parseDouble(values[1]),
                        Double.parseDouble(values[2]),
                        Double.parseDouble(values[3]),
                        Double.parseDouble(values[4]),
                        values[5],
                        values[6],
                        Boolean.parseBoolean(values[7]),
                        Boolean.parseBoolean(values[8]),
                        Integer.parseInt(values[9]));

            case TANKKONTENER:
                return new TankKontener(Integer.parseInt(values[0]),Double.parseDouble(values[1]),Double.parseDouble(values[2]),Double.parseDouble(values[3]),
                        Double.parseDouble(values[4]),values[5], values[6], Boolean.parseBoolean(values[7]),Boolean.parseBoolean(values[8]), values[9]);

            case WASTEKONTENER:
                return new WasteKontener(Integer.parseInt(values[0]),Double.parseDouble(values[1]),Double.parseDouble(values[2]),Double.parseDouble(values[3]),
                        Double.parseDouble(values[4]),values[5], values[6], Boolean.parseBoolean(values[7]), values[8], Boolean.parseBoolean(values[9]));

            case WEAPONKONTENER:
                return new WeaponKontener(Integer.parseInt(values[0]),Double.parseDouble(values[1]),Double.parseDouble(values[2]),Double.parseDouble(values[3]),
                        Double.parseDouble(values[4]),values[5], values[6], Boolean.parseBoolean(values[7]), values[8], Boolean.parseBoolean(values[9]));

            case DEFAULTKONTENER:
                return new DefaultKontener(Integer.parseInt(values[0]),Double.parseDouble(values[1]),Double.parseDouble(values[2]),Double.parseDouble(values[3]),
                        Double.parseDouble(values[4]),values[5], values[6], Boolean.parseBoolean(values[7]), values[8]);
            default:
                throw new NoKontenerException(type);
        }
    }


    private double generateWeight(){
        int max = 3000;
        int min = 1500;
        return generateNumber(max,min); //1-100
    }

    private double generateWidth(){
        double max = 2.5;
        double min = 2.0;
        return generateNumber(max,min);
    }

    private double generateHeight(){
        double max = 2.9;
        double min = 2.59;

        return generateNumber(max,min);
    }

    private double generateLength(){
        Random random = new Random();
        double lengthTab[] = {12.0, 6.0, 3.0};
        double tmp = 0;
        for (int i = 0; i < lengthTab.length; i++) {
            tmp = random.nextInt(lengthTab.length);
        }
        return tmp;
    }

    private String generateProductNumber(){
        double tmp = generateNumber(10000,15000);
        String str = "";
        str = str + tmp;
        return str;
    }

    private double generateNitrogenKoncentration(){
        double tmp = generateNumber(10,1);
        return tmp;
    }

    private String generateColor(){
        String colors[] = {"Black", "White", "Yellow", "Red"};
        int tmp = new Random().nextInt(colors.length);
        String random = (colors[tmp]);
        return colors[tmp];
    }

    private boolean generatePower(){
        Random rnd = new Random();
        boolean tmp = rnd.nextBoolean();
        return tmp;
    }

    private int countForCars(){
        int tmp = (int) generateLength() / 3;
        return tmp;
    }

    private boolean generateSecret(){
        if ((countForCars() == 1 && generateColor().equals("RED") || typeOfPermissionToOpen().equals("president"))){
            return true;
        }else {
            return false;
        }
    }

    private String typeOfPermissionToOpen(){
        String permission[] = {"sergeant", "ensign", "president"};
        int tmp = new Random().nextInt(permission.length);
        String random = (permission[tmp]);
        return permission[tmp];
    }

    private boolean powderLoader(){
        if (generateLength() == 12){
            return true;
        }else {
            return false;
        }
    }

    private int generateHatches(){
        int oneHatchPer = 4;
        if (generateLength() == 12) {
            return 12/oneHatchPer;
        } else if (generateLength() >= 6){
            return 6/oneHatchPer;
        }else {
            return 4/oneHatchPer;
        }
    }

    private double generateNumber(double max, double min){
        return Math.random()*(max - min) + min;
    }

    private String generateSubstance(){
        String substanceTab[] = {"Milk", "Oil", "Petrol", "Cola"};
        int tmp = new Random().nextInt(substanceTab.length);
        String random = (substanceTab[tmp]);
        return substanceTab[tmp];
    }

    private boolean vacumGenerator(){
        if (generateSubstance().equals("Cola") || generateSubstance().equals("Milk")){
            return true;
        }else {
            return false;
        }
    }

    private String typeOfFoodGenerator(){
        String foodTab[] = {"Fish", "Meat", "Bread"};
        int tmp = new Random().nextInt(foodTab.length);
        String random = (foodTab[tmp]);
        return foodTab[tmp];
    }

    private int temperatureGenerator(){
        if (typeOfFoodGenerator() == "Fish"){
            return -5;
        }else if (typeOfFoodGenerator() == "Meat"){
            return -20;
        }else
            return 10;
    }

    private boolean coolingChecker(){
        if (temperatureGenerator() < 0){
            return true;
        } else {
            return false;
        }
    }

    private String typeOfWaste(){
        String wasteTab[] = {"Chemic", "electronic", "food"};
        int tmp = new Random().nextInt(wasteTab.length);
        String random = (wasteTab[tmp]);
        return wasteTab[tmp];
    }

    private boolean isDangerous(){
        if (typeOfWaste().equals("Chemic")){
            return true;
        }else {
            return false;
        }
    }

    private String generateRandomProduct(){
        String productTab[] = {"Electronic", "Toys", "Bikes", "Cement"};
        int tmp = new Random().nextInt(productTab.length);
        String random = (productTab[tmp]);
        return productTab[tmp];
    }
}
