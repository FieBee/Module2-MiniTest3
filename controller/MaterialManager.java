package controller;
import model.Material;

import java.util.LinkedList;
import java.util.Scanner;
import view.Client;

public class MaterialManager {

    public static LinkedList<Material> arr = new LinkedList<>();


    public static void addMaterial(Material material){
        arr.add(material);
    }


    public static int checkId(LinkedList<Material> arr, String option){
        Scanner input = new Scanner(System.in);
        int id;
        do {
            System.out.println(option);
            id = input.nextInt();
        }while (id >= arr.size() || id < 0);
        return id;
    }

    public static void displayArrays(LinkedList<Material> arr){
        System.out.println("Danh sách sản phẩm:");
        for (Material product : arr) {
            System.out.println(product);
        }
    }

    public static void deleteElement(LinkedList<Material> arr, int index){
        arr.remove(index);
    }


    public static void exchangeRateDifference(LinkedList<Material> arr){

        for (Material element: arr
             )
            System.out.println("  "+arr.indexOf(element) +"   Sản phẩm: "+ element.getName()+ "   Giá ban đầu: " + element.getAmount() + "    Sau chiết khấu: " + element.getRealMoney());

    }






}



