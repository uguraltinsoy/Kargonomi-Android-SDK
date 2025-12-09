package com.deeplabstudio.kargonomi;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.deeplabstudio.kargonomisdk.Kargonomi;
import com.deeplabstudio.kargonomisdk.KargonomiCallback;
import com.deeplabstudio.kargonomisdk.Models.Address.City;
import com.deeplabstudio.kargonomisdk.Models.Address.State;
import com.deeplabstudio.kargonomisdk.Models.Shipment.CreateShipmentRequest;
import com.deeplabstudio.kargonomisdk.Models.Shipment.ShipmentListResponse;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        Kargonomi.init("API_KEY");

        /*Kargonomi.Address
                .stateList(states -> {
                    System.out.println("İller: " + states);
                })
                .onError(err -> {
                    System.out.println("HATA: " + err.getMessage());
                });

        Kargonomi.Address
                .cityList(34, cities -> {
                    System.out.println("İlçeler: " + cities);
                })
                .onError(err -> {
                    System.out.println("HATA: " + err.getMessage());
                });*/

        /*Kargonomi.Warehouses
                .list(warehouses -> {
                    System.out.println("Depolar: " + warehouses);
                })
                .onError(err -> {
                    System.out.println("HATA: " + err.getMessage());
                });*/

        /*Kargonomi.Shipments
                .list(1)
                .onSuccess(list -> System.out.println(list.getData().size()))
                .onError(err -> System.out.println(err.getMessage()));*/

        /*Kargonomi.Shipments
                .detail("1805405")
                .onSuccess(data -> System.out.println(data))
                .onError(err -> System.out.println(err.getMessage()));*/

        /*CreateShipmentRequest req = new CreateShipmentRequest();
        // ------------------
        // Gönderici (OPSİYONEL → warehouse_id yoksa doldurman gerekir)
        // ------------------
        req.shipment.sender_name = "Test Sender";          // OPSİYONEL
        req.shipment.sender_email = "test@example.com";    // OPSİYONEL
        req.shipment.sender_phone = "5555555555";          // OPSİYONEL
        req.shipment.sender_address = "Test Address";      // OPSİYONEL
        req.shipment.sender_state_id = "34";               // OPSİYONEL
        req.shipment.sender_city_id = "828";               // OPSİYONEL
        //req.shipment.warehouse_id = "65290";            // OPSİYONEL (bunu yazarsan yukarıdakilere gerek yok)

        // ------------------
        // Alıcı (ZORUNLU ALANLAR)
        // ------------------
        req.shipment.buyer_name = "Test Buyer";            // ZORUNLU
        req.shipment.buyer_phone = "5555555555";           // ZORUNLU
        req.shipment.buyer_address = "Buyer Street XYZ";   // ZORUNLU
        req.shipment.buyer_state_id = "66";                // ZORUNLU
        req.shipment.buyer_city_id = "662";                // ZORUNLU

        // Opsiyonel alıcı bilgiler
        req.shipment.buyer_email = "buyer@example.com";
        req.shipment.buyer_tax_number = "";
        req.shipment.buyer_tax_place = "";

        // ------------------
        // Paketler (en az 1 tane → ZORUNLU)
        // ------------------
        CreateShipmentRequest.PackageItem item = new CreateShipmentRequest.PackageItem();
        item.content = "Mini Mesh";     // OPSİYONEL
        item.desi = "1";                // ZORUNLU

        req.shipment.packages = List.of(item);

        Kargonomi.Shipments.create(req).onSuccess(result -> {
            System.out.println("Oluşturuldu: " + result);
        }).onError(err -> {
            System.out.println("HATA: " + err.getMessage());
        });*/


        /*CreateShipmentRequest req = new CreateShipmentRequest();
        req.shipment = new CreateShipmentRequest.Shipment();

        // --- ZORUNSUZ ALANLAR (warehouse_id yoksa optional) ---
        req.shipment.sender_name = "Test Sender";        // optional
        req.shipment.sender_email = "test@example.com";  // optional
        req.shipment.sender_phone = "5555555555";        // optional
        req.shipment.sender_address = "Test adres";      // optional
        req.shipment.sender_state_id = "34";               // optional
        req.shipment.sender_city_id = "828";               // optional
        req.shipment.warehouse_id = null;                // optional

        // --- ZORUNLU ALANLAR ---
        req.shipment.buyer_name = "John Doe";            // required
        req.shipment.buyer_phone = "5554443322";         // required
        req.shipment.buyer_address = "Alıcı adresi";     // required
        req.shipment.buyer_state_id = "34";                // required
        req.shipment.buyer_city_id = "828";                // required

        // Paket
        CreateShipmentRequest.PackageItem item = new CreateShipmentRequest.PackageItem();
        item.content = "Mini Mesh";   // optional
        item.desi = "1";                // required

        req.shipment.packages = List.of(item); // required (en az 1)

        // 🔧 UPDATE ÇAĞRISI
        Kargonomi.Shipments
                .update("123456789", req)
                .onSuccess(detail -> {
                    System.out.println("Güncellendi: " + detail);
                })
                .onError(err -> {
                    err.printStackTrace();
                });*/


        /*Kargonomi.Shipments
                .delete("123456789")
                .onSuccess(v -> System.out.println("Silindi"))
                .onError(e -> System.out.println(e.getMessage()));*/

        /*Kargonomi.Shipments
                .cancel("123456789")
                .onSuccess(result -> System.out.println("Gönderi iptal edildi."))
                .onError(e -> System.out.println(e.getMessage()));*/

        /*Kargonomi.Shipments
                .priceCompare("123456789")
                .onSuccess(result -> {
                    for (var p : result.shipping_provider_with_price) {
                        System.out.println(p.name + " (" + p.slug + ") → " + p.price + " TL"
                        );
                    }
                })
                .onError(Throwable::printStackTrace);*/

        /*Kargonomi.Shipments
                .confirmPrice("123456789", "7")
                .onSuccess(v -> System.out.println("Gönderi başarıyla onaylandı!"))
                .onError(e -> System.out.println(e.getMessage()));*/

        /*Kargonomi.User
                .credit()
                .onSuccess(res -> System.out.println("Kredi bakiyesi: " + res.data.credit))
                .onError(e -> System.out.println(e.getMessage()));*/

    }
}