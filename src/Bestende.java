import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bestende {
    public static void main(String[] args) {

        List<Daten> list =new ArrayList<>();

        list.add(new Daten("lathesh",7.0));
        list.add(new Daten("rash",7.0));
        list.add(new Daten("lathesh",7.0));
        list.add(new Daten("lathesh",7.0));
        list.add(new Daten("maju",7.0));
        list.add(new Daten("maju",7.0));

        Map<String,Double> hashMap = new HashMap<>();

        for (int i = 0; i < list.size(); i++) {

            hashMap.put(list.get(i).getName(),hashMap.getOrDefault(list.get(i).getName(),0.0)+list.get(i).getCount());

        }


        for (Map.Entry<String,Double> entry : hashMap.entrySet())
            System.out.println("Key = " + entry.getKey() +
                    ", Value = " + entry.getValue());

    }
}

class Daten {
    private String name;
    private double count;

    public Daten(String name, double count) {
        this.name = name;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCount() {
        return count;
    }

    public void setCount(double count) {
        this.count = count;
    }
}
