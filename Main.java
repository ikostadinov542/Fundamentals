import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();

        List<String> fragile = new ArrayList<>();
        List<String> flamable = new ArrayList<>();

        while (n-- > 0) {

            String[] data = input.split("\\s+");
            String carModel = data[0];
            Engine engine = new Engine(Integer.parseInt(data[1]), Integer.parseInt(data[2]));
            Cargo cargo = new Cargo(Integer.parseInt(data[3]), data[4]);

            double[] tiresPressure = {
                    Double.parseDouble(data[5]),
                    Double.parseDouble(data[7]),
                    Double.parseDouble(data[9]),
                    Double.parseDouble(data[11])};
            int[] tiresAge = {
                    Integer.parseInt(data[6]),
                    Integer.parseInt(data[8]),
                    Integer.parseInt(data[10]),
                    Integer.parseInt(data[12])};

            Tires tires = new Tires(tiresPressure, tiresAge);

            int currCarPower = engine.getPower();
            if (currCarPower > 250) {
                flamable.add(carModel);
            }

            for (double tire : tiresPressure) {
                if (tire < 1) {
                    fragile.add(carModel);
                    break;
                }
            }


            input = scanner.nextLine();

        }

        switch (input) {
            case "fragile":
                fragile.forEach(System.out::println);
                break;

            case "flamable":
                flamable.forEach(System.out::println);
                break;
        }


    }
}