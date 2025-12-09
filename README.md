
# Kargonomi Android SDK (Unofficial)
⚠️ **Warning:**  
This project is **not an official SDK**. It has been developed by Deeplab Studio to help developers easily integrate with Kargonomi APIs. SDK functionalities are based on the [Kargonomi API documentation](https://www.kargonomi.com.tr/help/api-dokumantasyonu/kargonomi-api/). Deeplab Studio is **not responsible** for any issues that may arise during usage.

---

## About

This SDK provides a convenient way for Android developers to integrate with the Kargonomi API. **It is not officially supported**, and Deeplab Studio assumes no responsibility for its use in production.

---

## Initialization
- You can obtain an API key by sending a request email to **support@kargonomi.com.tr**.

**Java**
```java
Kargonomi.init("API_KEY");
```

**Kotlin**
```kotlin
Kargonomi.init("API_KEY")
```

---

## Address – List of States

**Java**
```java
Kargonomi.Address
    .stateList(states -> System.out.println("States: " + states))
    .onError(err -> System.out.println("ERROR: " + err.getMessage()));
```

**Kotlin**
```kotlin
Kargonomi.Address.stateList { states ->
    println("States: $states")
}.onError { err ->
    println("ERROR: ${err.message}")
}
```

---

## Address – List of Cities

**Java**
```java
Kargonomi.Address
    .cityList(34, cities -> System.out.println("Cities: " + cities))
    .onError(err -> System.out.println("ERROR: " + err.getMessage()));
```

**Kotlin**
```kotlin
Kargonomi.Address.cityList(34) { cities ->
    println("Cities: $cities")
}.onError { err ->
    println("ERROR: ${err.message}")
}
```

---

## Warehouses

**Java**
```java
Kargonomi.Warehouses
    .list(warehouses -> System.out.println("Warehouses: " + warehouses))
    .onError(err -> System.out.println("ERROR: " + err.getMessage()));
```

**Kotlin**
```kotlin
Kargonomi.Warehouses.list { warehouses ->
    println("Warehouses: $warehouses")
}.onError { err ->
    println("ERROR: ${err.message}")
}
```

---

## Shipments – List

**Java**
```java
Kargonomi.Shipments
    .list(1)
    .onSuccess(list -> System.out.println("Number of shipments: " + list.getData().size()))
    .onError(err -> System.out.println(err.getMessage()));
```

**Kotlin**
```kotlin
Kargonomi.Shipments.list(1)
    .onSuccess { list -> println("Number of shipments: ${list.data.size}") }
    .onError { err -> println(err.message) }
```

---

## Shipment Details

**Java**
```java
Kargonomi.Shipments
    .detail("1805405")
    .onSuccess(data -> System.out.println(data))
    .onError(err -> System.out.println(err.getMessage()));
```

**Kotlin**
```kotlin
Kargonomi.Shipments.detail("123456789")
    .onSuccess { data -> println(data) }
    .onError { err -> println(err.message) }
```

---

## Create Shipment

**Java**
```java
CreateShipmentRequest req = new CreateShipmentRequest();
req.shipment.sender_name = "Test Sender";
req.shipment.sender_email = "test@example.com";
req.shipment.sender_phone = "5555555555";
req.shipment.sender_address = "Test Address";
req.shipment.sender_state_id = "34";
req.shipment.sender_city_id = "828";

req.shipment.buyer_name = "Test Buyer";
req.shipment.buyer_phone = "5555555555";
req.shipment.buyer_address = "Buyer Street XYZ";
req.shipment.buyer_state_id = "66";
req.shipment.buyer_city_id = "662";
req.shipment.buyer_email = "buyer@example.com";

CreateShipmentRequest.PackageItem item = new CreateShipmentRequest.PackageItem();
item.content = "Mini Mesh";
item.desi = "1";

req.shipment.packages = List.of(item);

Kargonomi.Shipments.create(req)
    .onSuccess(result -> System.out.println("Created: " + result))
    .onError(err -> System.out.println("ERROR: " + err.getMessage()));
```

**Kotlin**
```kotlin
val req = CreateShipmentRequest().apply {
    shipment.sender_name = "Test Sender"
    shipment.sender_email = "test@example.com"
    shipment.sender_phone = "5555555555"
    shipment.sender_address = "Test Address"
    shipment.sender_state_id = "34"
    shipment.sender_city_id = "828"

    shipment.buyer_name = "Test Buyer"
    shipment.buyer_phone = "5555555555"
    shipment.buyer_address = "Buyer Street XYZ"
    shipment.buyer_state_id = "66"
    shipment.buyer_city_id = "662"
    shipment.buyer_email = "buyer@example.com"

    shipment.packages = listOf(
        CreateShipmentRequest.PackageItem().apply {
            content = "Mini Mesh"
            desi = "1"
        }
    )
}

Kargonomi.Shipments.create(req)
    .onSuccess { result -> println("Created: $result") }
    .onError { err -> println("ERROR: ${err.message}") }
```

---

## Update Shipment

**Java**
```java
Kargonomi.Shipments.update("123456789", req)
    .onSuccess(detail -> System.out.println("Updated: " + detail))
    .onError(err -> err.printStackTrace());
```

**Kotlin**
```kotlin
Kargonomi.Shipments.update("123456789", req)
    .onSuccess { detail -> println("Updated: $detail") }
    .onError { err -> err.printStackTrace() }
```

---

## Delete Shipment

**Java**
```java
Kargonomi.Shipments.delete("123456789")
    .onSuccess(v -> System.out.println("Deleted"))
    .onError(e -> System.out.println(e.getMessage()));
```

**Kotlin**
```kotlin
Kargonomi.Shipments.delete("123456789")
    .onSuccess { println("Deleted") }
    .onError { e -> println(e.message) }
```

---

## Cancel Shipment

**Java**
```java
Kargonomi.Shipments.cancel("123456789")
    .onSuccess(result -> System.out.println("Shipment canceled."))
    .onError(e -> System.out.println(e.getMessage()));
```

**Kotlin**
```kotlin
Kargonomi.Shipments.cancel("123456789")
    .onSuccess { println("Shipment canceled.") }
    .onError { e -> println(e.message) }
```

---

## Price Comparison

**Java**
```java
Kargonomi.Shipments.priceCompare("123456789")
    .onSuccess(result -> {
        for (var p : result.shipping_provider_with_price) {
            System.out.println(p.name + " (" + p.slug + ") → " + p.price + " TL");
        }
    })
    .onError(Throwable::printStackTrace);
```

**Kotlin**
```kotlin
Kargonomi.Shipments.priceCompare("123456789")
    .onSuccess { result ->
        result.shipping_provider_with_price.forEach { p ->
            println("${p.name} (${p.slug}) → ${p.price} TL")
        }
    }
    .onError { it.printStackTrace() }
```

---

## Confirm Price

**Java**
```java
Kargonomi.Shipments.confirmPrice("123456789", "7")
    .onSuccess(v -> System.out.println("Shipment successfully confirmed!"))
    .onError(e -> System.out.println(e.getMessage()));
```

**Kotlin**
```kotlin
Kargonomi.Shipments.confirmPrice("123456789", "7")
    .onSuccess { println("Shipment successfully confirmed!") }
    .onError { e -> println(e.message) }
```

---

## User Credit

**Java**
```java
Kargonomi.User.credit()
    .onSuccess(res -> System.out.println("Credit balance: " + res.data.credit))
    .onError(e -> System.out.println(e.getMessage()));
```

**Kotlin**
```kotlin
Kargonomi.User.credit()
    .onSuccess { res -> println("Credit balance: ${res.data.credit}") }
    .onError { e -> println(e.message) }
```

---

### Developer
[Uğur ALTINSOY](https://github.com/uguraltinsoy)

### Social
[![Twitter](https://img.shields.io/badge/twitter-%231DA1F2.svg?&style=for-the-badge&logo=twitter&logoColor=white)](https://twitter.com/uguraltnsy)  
[![Instagram](https://img.shields.io/badge/instagram-%23E4405F.svg?&style=for-the-badge&logo=instagram&logoColor=white)](https://www.instagram.com/ugur.altnsy)  
[![Linkedin](https://img.shields.io/badge/linkedin-%230077B5.svg?&style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/uğur-altınsoy/)

