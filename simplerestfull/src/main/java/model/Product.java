/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author lenovo
 */

//Nama Kelas
public class Product {
   //Variabel bertipe data string, dengan nama "id"
   private String id;
   //Variabel bertipe data string, dengan nama "id"
   private String name;
   //Variabel dengan nama price
   private int price;
   private int number;
   private int total;
   

   
   //Konstruktor untuk melakukan set dan get (ambil) data - bagian id dan nama productnya
   public String getId() {
      return id;
   }
   public void setId(String id) {
      this.id = id;
   }
   public String getName() {
      return name;
   }
   public void setName(String name) {
      this.name = name;
   }
   
   public int getPrice() {
      return price;
   }
   public void setPrice(int price) {
      this.price = price;
   }
   
   public int getNumber() {
      return number;
   }
   public void setNumber(int number) {
      this.number = number;
   }

    public int getTotal() {
        return total;
    }

    public void setTotal() {
        //total = price * number;
        this.total = price * number;
    }
   
   

   
   

    
}
