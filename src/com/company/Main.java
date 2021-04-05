package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String filePath = "C:\\Users\\mleko\\Desktop\\test\\text.txt";
        DataOutputStream dataOutputStream = null;
        DataInputStream dataInputStream = null;
        List<Integer> dataUrodzin = new ArrayList<>();
        List<Integer> wyczytanaDataUrodzin = new ArrayList<>();
        Scanner skaner = new Scanner(System.in);
        napelnijListe(dataUrodzin, skaner);
        zapiszDateBinarnie(filePath, dataUrodzin);
        wczytajDateZPliku(filePath, wyczytanaDataUrodzin);
        System.out.println(wyczytanaDataUrodzin);
    }

    private static void wczytajDateZPliku(String filePath, List<Integer> wyczytanaDataUrodzin) {
        DataInputStream dataInputStream;
        try {
            dataInputStream = new DataInputStream(new FileInputStream(filePath));
            for (int i = 0; i < 3; i++) {
                wyczytanaDataUrodzin.add(dataInputStream.readInt());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void zapiszDateBinarnie(String filePath, List<Integer> dataUrodzin) {
        DataOutputStream dataOutputStream;
        try {
            dataOutputStream = new DataOutputStream(new FileOutputStream(filePath));
            for (int number : dataUrodzin
            ) {
                dataOutputStream.writeInt(number);
            }
            dataOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    private static void napelnijListe(List<Integer> dataUrodzin, Scanner skaner) {
        System.out.println("podaj dzien urodzin");
        dataUrodzin.add(skaner.nextInt());
        System.out.println("podaj miesiac urodzin");
        dataUrodzin.add(skaner.nextInt());
        System.out.println("podaj rok urodzin");
        dataUrodzin.add(skaner.nextInt());
    }
}
