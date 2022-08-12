@Amazon
Feature: Amazon Senaryosu

  Background: kullanici amazon web sayfasına erisim saglamali
    Given kullanici "amazonUrl" anasayfasina gider
    And kullanici "amazonUrl" anasayfasinin acildigini kontrol eder
    #calistigim PC'de cerezler acilmadigi icin yoruma alindi.
    #And kullanici cerez tercihlerinden cerezleri kabul et secenegini secer
    Given kullanici siteye login olur


    Scenario: kullanici amazon web sayfasina login olabilmeli
      And kullanici login oldugunu kontrol eder

    Scenario: kullanici belirli bir kategoride urun aratip favori listesine ekleyebilmeli
      Given kullanici kategoriler bolumunden "Computers" secenegini secer
      And kullanici arama kutusuna "msi" yazar ve arama yapar
      And kullanici "Computers" seceneginin secili oldugunu kontrol eder
      And kullanici arama sonuclarinin "msi" icerdigini kontrol eder
      Then kullanici arama sonuc sayfasindan ikinci sayfaya gider
      And kullanici ikinci sayfanin acildigini kontrol eder
      Then kullanici acilan sayfada ikinci urunu favori listesie ekler
      And kullanici ikinci urunun favori listesine eklendigini kontrol eder

    Scenario: kullanici favori listesine ekledigi urunu silebilmeli
        Given kullanici favori listen sayfasina gider
        And kullanici favori listem sayfasinin acildigini kontrol eder
        Then kullanici eklenen urunu favori listesinden siler
        And kullanici silme isleminin gerceklestigini kontrol eder
        And kullanici hesabim bolumunden cikis islemi yapar
        And kullanici cikis isleminin yapildigini kontrol eder

