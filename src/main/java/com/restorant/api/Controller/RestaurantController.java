package com.restorant.api.Controller;

import java.util.List;

import com.restorant.api.Model.Sipariş;
import com.restorant.api.Service.IRestaurantService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/rest/api/res")
@CrossOrigin(origins = "http://localhost:5173")
public class RestaurantController {

    private final IRestaurantService restaurantService;

    public RestaurantController(IRestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }



    @PostMapping("/save")
    public Sipariş saveSiparis(@RequestBody Sipariş siparis) {
        return restaurantService.saveSiparis(siparis);
    }


    @GetMapping("/list")
    public List<Sipariş> getAllSiparis() {
        return restaurantService.getAllSiparis();
    }


   @GetMapping("/list/{id}")
    public Sipariş getSiparisById(@PathVariable Integer id) {
        return restaurantService.getSiparisById(id);
    }


    @DeleteMapping("/delete/{id}")
    public void deleteSiparis(@PathVariable Integer id) {
        restaurantService.deleteSiparis(id);
    }


    @PutMapping("/update/{id}")
    public Sipariş updateSiparis(@PathVariable Integer id, @RequestBody Sipariş updatesiparis) {
        return restaurantService.updateSiparis(id, updatesiparis);
    }
    @GetMapping("/masaNo/{masaNo}")
    public Sipariş findByMasaNo(@PathVariable Integer masaNo) {
        return restaurantService.findByMasaNo(masaNo)
                .orElseThrow(() -> new RuntimeException("Sipariş bulunamadı!"));
    }

    @GetMapping("/garsonı/{garsonisim}")
    public Sipariş findByGarsonIsim(@PathVariable String garsonisim) {
        return restaurantService.findByGarsonIsim(garsonisim).orElseThrow(() -> new RuntimeException("Böyle bir garson yok "));
    }

}
