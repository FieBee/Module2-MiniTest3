package controller;
import model.Material;

import java.util.LinkedList;
import java.util.Scanner;

public class MaterialManager {

    public MaterialManager() {
    }

    public static LinkedList<Material> arr = new LinkedList<>();


    public void addMaterial(Material material){
        arr.add(material);
    }


    public int checkId(LinkedList<Material> arr, String option){
        Scanner input = new Scanner(System.in);
        int id;
        do {
            System.out.println(option);
            id = input.nextInt();
        }while (id >= arr.size() || id < 0);
        return id;
    }

    public void displayArrays(LinkedList<Material> arr){
        System.out.println("Danh sách sản phẩm:");
        for (Material product : arr) {
            System.out.println(product);
        }
    }

    public void deleteElement(LinkedList<Material> arr, int index){
        arr.remove(index);
    }


    public void exchangeRateDifference(LinkedList<Material> arr){

        for (Material element: arr
             )
            System.out.println("  "+arr.indexOf(element) +"   Sản phẩm: "+ element.getName()+ "   Giá ban đầu: " + element.getAmount() + "    Sau chiết khấu: " + element.getRealMoney());

    }


}



