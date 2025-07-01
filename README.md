# 🚗 Rentify: Java Tabanlı Araç Kiralama Sistemi

Bu proje, farklı yaş gruplarındaki kişilerin çeşitli araç türlerini kiralayabildiği basit ve modüler bir **Java tabanlı araç kiralama sistemidir**. Proje nesne yönelimli programlama (OOP) prensiplerine göre tasarlanmıştır.

## 🎯 Amaç

- Farklı kullanıcı tipleri (GençKisi, OlgunKisi) tanımlayarak kiralama koşullarının değişimini yönetmek.
- Araç çeşitliliği (Otomobil, Minibüs, TicariAraç) ile esnek bir kiralama sistemi sunmak.
- `KiralamaFirmasi` üzerinden kullanıcı-araç ilişkisini yürütmek.

## 🛠️ Kullanılan Teknolojiler

- Java 8+
- Nesne Yönelimli Programlama (OOP)
- Komut satırı (CLI) üzerinden test

## 📁 Sınıf Yapısı

| Sınıf Adı          | Açıklama |
|--------------------|----------|
| `Kisi`             | Soyut kişi sınıfı |
| `GencKisi`         | Genç kullanıcılar için alt sınıf |
| `OlgunKisi`        | Yaşça büyük kullanıcılar için alt sınıf |
| `Araba`            | Temel araç sınıfı |
| `Otomobil`         | Otomobil türünde araç |
| `Minibus`          | Minibüs türünde araç |
| `TicariArac`       | Ticari araç türü |
| `KiralamaFirmasi`  | Kiralama işlemlerini yürüten ana sınıf |
| `test`             | Uygulamanın çalışmasını test eden ana sınıf |

## ▶️ Çalıştırma

1. Java kurulu olduğundan emin olun.
2. Tüm `.java` dosyalarını aynı klasöre yerleştirin.
3. Aşağıdaki komutu çalıştırarak `test.java` dosyasını derleyin:

```bash
javac *.java
java test
