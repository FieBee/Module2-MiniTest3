package view;

import controller.MaterialManager;
import model.CrispyFlour;
import model.Material;
import model.Meat;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Scanner;




public class Client {


    private static final LinkedList<Material> arr = MaterialManager.arr;

    public static void main(String[] args) {
        MaterialManager hoangHa = new MaterialManager();
        extracted(arr, hoangHa);
    }

    static {
        Meat meat1 = new Meat("0", "Thịt loại 1", LocalDate.now().plusDays(2), 100, 3);
        Meat meat2 = new Meat("1", "Thịt loại 2", LocalDate.now().plusDays(3), 100, 3);
        Meat meat3 = new Meat("2", "Thịt loại 3", LocalDate.now().plusDays(4), 100,3);
        Meat meat4 = new Meat("3", "Thịt loại 4", LocalDate.now().plusDays(6), 100, 3);
        Meat meat5 = new Meat("4", "Thịt loại 5", LocalDate.now().plusDays(7), 100, 3);
        CrispyFlour crispyFlour1 = new CrispyFlour("5", "Bột mì loại 1", LocalDate.now().plusDays(50), 140, 7);
        CrispyFlour crispyFlour2 = new CrispyFlour("6", "Bột mì loại 2", LocalDate.now().plusDays(100), 140, 4);
        CrispyFlour crispyFlour3 = new CrispyFlour("7", "Bột mì loại 3", LocalDate.now().plusDays(150), 140, 2);
        CrispyFlour crispyFlour4 = new CrispyFlour("8", "Bột mì loại 4", LocalDate.now().plusDays(200), 140, 3);
        CrispyFlour crispyFlour5 = new CrispyFlour("9", "Bột mì loại 5", LocalDate.now().plusDays(300), 1000, 10);

        arr.add(meat1);
        arr.add(meat2);
        arr.add(meat3);
        arr.add(meat4);
        arr.add(meat5);
        arr.add(crispyFlour1);
        arr.add(crispyFlour2);
        arr.add(crispyFlour3);
        arr.add(crispyFlour4);
        arr.add(crispyFlour5);

    }


    private static void show(MaterialManager materialManager){
        materialManager.displayArrays(arr);
    }



    private static void extracted(LinkedList<Material> arr, MaterialManager materialManager) {
        Scanner input = new Scanner(System.in);
        int selectOption;
        do {
            System.out.println("------------------------------");
            System.out.println("Chọn thao tác: ");
            System.out.println("   1. Thêm sản phẩm.");
            System.out.println("   2. Sửa thông tin sản phẩm theo id.");
            System.out.println("   3. Xoá sản phẩm theo id.");
            System.out.println("   4. Hiển thị danh sách sản phẩm.");
            System.out.println("   5. Thông tin chiết khấu chênh lệch. ");
            System.out.println("   0. Thoát khỏi chương trình. ");
            System.out.println("------------------------------");
            selectOption = input.nextInt();

            switch (selectOption){
                case 0:
                    System.out.println("Bye!");
                    return;
                case 1:
                    System.out.println("Chọn thao tác");
                    System.out.println("1. Thêm sản phẩm meat");
                    System.out.println("2. Thêm sản phẩm CispyFlour");
                    int option = input.nextInt();

                    switch (option){
                        case 1: addMeat(materialManager); break;
                        case 2: addCrispyFlour(materialManager); break;
                        default:
                            System.out.println("Không hợp lệ!!!");
                            extracted(arr,materialManager);
                    }
                    break;

                case 2: setProductId(arr);break;
                case 3: deleteMaterial(materialManager);break;
                case 4: show(materialManager);break;
                case 5: materialManager.exchangeRateDifference(arr);break;
                default:
                    System.out.println("Tính năng chưa phát triển...!");
            }
        }while(true) ;
    }


    public static void addMeat(MaterialManager materialManager ){
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập id cho sản phẩm Meat:");
        String id = input.nextLine();

        System.out.println("Nhập tên sản phẩm:");
        String name = input.nextLine();

        System.out.println("Nhập hạn sử dụng còn lại (ngày):");
        int hsd = input.nextInt();

        LocalDate localDate = LocalDate.now().plusDays(hsd);

        System.out.println("Nhập giá sản phẩm:");
        int cost = input.nextInt();

        System.out.println("Nhập trọng lượng sản phẩm:");
        int weight = input.nextInt();
        System.out.println("Thêm thành công ");


        Meat meat = new Meat(id, name, localDate, cost, weight);
        System.out.println(meat);
        materialManager.addMaterial(meat);
    }

    public static void addCrispyFlour(MaterialManager materialManager){
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập id cho sản phẩm CrispyFlour:");
        String id = input.nextLine();

        System.out.println("Nhập tên sản phẩm:");
        String name = input.nextLine();

        System.out.println("Nhập hạn sử dụng còn lại (ngày):");
        int hsd = input.nextInt();
        LocalDate localDate = LocalDate.now().plusDays(hsd);

        System.out.println("Nhập giá sản phẩm:");
        int cost = input.nextInt();

        System.out.println("Nhập chất lượng sản phẩm:");
        int quantity = input.nextInt();
        System.out.println("Thêm thành công ");

        CrispyFlour crispyFlour = new CrispyFlour(id, name, localDate, cost, quantity);
        System.out.println(crispyFlour);
        materialManager.addMaterial(crispyFlour);
    }

    public static void setProductId(LinkedList<Material> arr){
        Scanner input = new Scanner(System.in);
        int id = new MaterialManager().checkId(arr, "Nhập ID sản phẩm muốn sửa: ");

        Material material = arr.get(id);

        System.out.println("Nhập lại tên sản phẩm");
        material.setName(input.nextLine());

        System.out.println("Nhập lại giá sản phẩm");
        material.setCost(input.nextInt() );

        System.out.println("Sửa thành công: "+ material);

    }


    public static void deleteMaterial(MaterialManager materialManager){
        Scanner input = new Scanner(System.in);

        System.out.println("Nhập ID nguyên liệu cần xóa: ");
        int index = input.nextInt();

        System.out.println("Đã xóa thành công: " +arr.get(index));
        System.out.println();

        materialManager.deleteElement(arr, index);
    }
}

