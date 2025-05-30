package org.example.models;

import java.util.*;

public class Grocery {
    public static List<String> groceryList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);


   public void startGrocery() {
       int choice = 0;
       do {
           System.out.println("Yapılmak istenen operasyonu seçin. (0 = çıkış, 1 = ekleme, 2 = çıkarma) ");
           choice = scanner.nextInt();
           scanner.nextLine();
           switch (choice) {
               case 1:
                   System.out.println("Eklenmesini istediğiniz elemanları giriniz");
                   String itemsToAdd = scanner.nextLine();
                   addItems(itemsToAdd);
                   printSorted();
                   break;
               case 2:
                   System.out.println("Çıkarılmasını istediğiniz elemanları giriniz");
                   String itemsToRemove = scanner.nextLine();
                   removeItems(itemsToRemove);
                   printSorted();
                   break;

           }

       }
       while (choice != 0);
       scanner.close();
   }

        public static void removeItems (String itemsToRemove){
            String[] splitItems = itemsToRemove.split(",");
            for(String item: splitItems){
                item = item.trim();
                if(!checkItemsInList(item)){
                    System.out.println("Girilen item listede mevcut değil. " + item);
                }else{
                    groceryList.remove(item);
                }
            }
            sortItems();
        }

       public static void addItems(String itemsToAdd){
        String[] splitItems = itemsToAdd.split(",");
        for(String item: splitItems){
            item = item.trim();
            if(Grocery.checkItemsInList(item)){
                System.out.println("Girilen item listede mevcut: " + item);
            }else{
                groceryList.add(item);
            }
        }
        sortItems();
       }
       public static boolean checkItemsInList(String item){
            return groceryList.contains(item);
       }
        public static void printSorted(){
            sortItems();
            System.out.println("Mevcut pazar listesi: ");
            for(String item: groceryList){
                System.out.println(item);
            }
        }
        public static void sortItems(){
            Collections.sort(groceryList);
        }
   }

