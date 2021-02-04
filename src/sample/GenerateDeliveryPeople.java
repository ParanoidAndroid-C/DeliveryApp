package sample;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class GenerateDeliveryPeople {
    private ArrayList<DeliveryPerson> deliveryPeople = new ArrayList<DeliveryPerson>();
    private DeliveryPerson p;

    public DeliveryPerson getP() {
        return p;
    }

    public GenerateDeliveryPeople() {
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader("deliveryPeople.txt"));
            deliveryPeople = readData(in);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        p = getDeliveryPerson();

    }

    public DeliveryPerson getDeliveryPerson() {
        Random random = new Random();
        return deliveryPeople.get(random.nextInt(7));
    }

    public ArrayList<DeliveryPerson> readData(BufferedReader aFile) throws IOException {
        ArrayList <DeliveryPerson> deliveryPeople = new ArrayList<DeliveryPerson>();
        while (aFile.ready()) {
            String s1 = aFile.readLine();
            String[] s = s1.split(",");
            DeliveryPerson d = new DeliveryPerson(s[0], Double.parseDouble(s[1]), Integer.parseInt(s[2]));
            deliveryPeople.add(d);
        }
        return deliveryPeople;
    }

    public void update(DeliveryPerson d, int r) throws IOException {
        BufferedReader aFile = new BufferedReader(new FileReader("deliveryPeople.txt"));
        StringBuffer info = new StringBuffer("");

        while (aFile.ready()) {
            String s1 = aFile.readLine();
            String[] s = s1.split(",");
            if (s[0].equals(d.getUsername())) {
                d.setRating((Double.parseDouble(s[1]) * d.getRatingCnt() + r)/(d.getRatingCnt()+1));
                s[1] = String.format("%.1f", d.getRating());
                d.setRatingCnt(Integer.parseInt(s[2])+1);
                s[2] = String.valueOf(d.getRatingCnt());
            }
            info.append(s[0] + ',' + s[1] +',' + s[2]+'\n');
        }
       writeData(info.toString());
    }

    public void writeData(String info) throws IOException {
        FileWriter myWriter = new FileWriter("deliveryPeople.txt");
        myWriter.write(info);
        myWriter.close();
    }

}
