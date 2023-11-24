package SongsExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int songCount = Integer.parseInt(scanner.nextLine());

        List<Song> songs = new ArrayList<>();

        for (int i = 1; i <= songCount; i++) {

            String input = scanner.nextLine();

            String[] splittedInput = input.split("_");

            String typeList = splittedInput[0];
            String name = splittedInput[1];
            String time = splittedInput[2];

            Song song = new Song(typeList, name, time);
            songs.add(song);


        }

        String typePrint = scanner.nextLine();


        for (Song song : songs) {

            if (typePrint.equals("all")) {

                for (Song song1 : songs) {
                    System.out.printf("%s%n", song1.getSongName());
                }
                break;

            } else if (song.getTypeList().equals(typePrint)) {
                System.out.printf("%s%n", song.getSongName());

            }
        }
    }
}
