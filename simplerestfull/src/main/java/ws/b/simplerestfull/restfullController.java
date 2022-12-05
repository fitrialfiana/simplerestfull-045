/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

//Nama package
package ws.b.simplerestfull;

//Import fungsi map dan hashmap
import java.util.HashMap;
import java.util.Map;


//Import kelas product dari package model. Agar variabelnya bisa diakses
import model.Product;

//Import fungsi
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author lenovo
 */

@RestController
public class restfullController {    
    private static Map<String, Product> productRepo = new HashMap<>();
    static {
        //Memasukkan secara static (2 id)
        //Membuat product bernama honey
        Product ayam = new Product();
        //Mengatur idnya "1"
        ayam.setId("1");
        //Mengatur namanya "Ayam Goreng"
        ayam.setName("Ayam Goreng");
        //Memanggil
        productRepo.put(ayam.getId(), ayam);
        
        //Membuat product bernama almond
        Product ikan = new Product();
        //Mengatur idnya "2"
        ikan.setId("2");
        //Mengatur namanya "Honeey"
        ikan.setName("Ikan Bakar");
        //Memanggil
        productRepo.put(ikan.getId(), ikan);        
    }
    
    
    //Fungsi Delete
    @RequestMapping(value = "/product/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@PathVariable("id") String id){
        productRepo.remove(id);
        //Mengembalikan nilai
        return new ResponseEntity<>("Product is deleted successfully", HttpStatus.OK);
    }
    
    
    //Update or PUT data
    @RequestMapping(value = "/product/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateProduct(@PathVariable("id") String id, @RequestBody Product product) {
        //menghapus isi data dari id sebelumnya
        productRepo.remove(id);
        //set idnya untuk perubahan
        product.setId(id);
        //Perubahan isi data terbaru
        productRepo.put(id, product);
        //Mengembalikan nilai atau menampilkan nilai
        return new ResponseEntity<>("Product is updated successfully", HttpStatus.OK);
    } 
   
    
    //Membuat method post or membuat 
    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public ResponseEntity<Object> createProduct(@RequestBody Product product) {
        productRepo.put(product.getId(), product);
        //Mengembalikan nilai
        return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
    }
    
    
    //Menampilkan isi data (id dan nama product
    @RequestMapping(value = "/product")
    public ResponseEntity<Object> getProduct() {
        //Mengembalikan nilai
        return new ResponseEntity<>(productRepo.values(), HttpStatus.OK);
    }   
    
}

   
