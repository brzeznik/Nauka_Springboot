# System Zarządzania Uczelnią (Simple University Management System)

Ten projekt to prosta aplikacja RESTful API napisana w Spring Boot, stworzona w celu nauki i eksplorowania możliwości tego frameworka, w szczególności Spring Data JPA, warstw serwisowych oraz budowania RESTowych kontrolerów.

## Cel Projektu

Głównym celem tego projektu było:
* Zrozumienie podstaw Spring Boot.
* Praktyczne zastosowanie Spring Data JPA do zarządzania danymi w bazie danych.
* Budowanie warstw aplikacyjnych (Kontroler, Serwis, Repozytorium).
* Tworzenie i obsługa RESTful API dla różnych zasobów.
* Obsługa relacji między encjami w bazie danych.

## Technologie

* **Spring Boot**: Framework do szybkiego tworzenia samodzielnych, produkcyjnych aplikacji opartych na Springu.
* **Spring Data JPA**: Upraszcza implementację warstwy dostępu do danych, oferując abstrakcje do interakcji z bazą danych (w tym przypadku H2 w pamięci do celów deweloperskich, łatwo konfigurowalne pod PostgreSQL/MySQL).
* **Hibernate**: Implementacja JPA używana przez Spring Data JPA do mapowania obiektowo-relacyjnego (ORM).
* **RESTful API**: Architektura do tworzenia usług sieciowych, wykorzystująca standardowe metody HTTP (GET, POST, PUT, DELETE).
* **H2 Database**: Lekka baza danych działająca w pamięci, używana do celów deweloperskich i testowych.
* **Java 17+**: Język programowania.
* **Maven**: Narzędzie do zarządzania zależnościami i budowania projektu.

## Struktura Projektu

Projekt jest zorganizowany zgodnie z popularnym wzorcem trójwarstwowym (Controller-Service-Repository), co jest standardową praktyką w aplikacjach Spring Boot.

    * `com.projekty.projekt1`: Główny pakiet aplikacji.
    * **`Projekt1Application.java`**: Główna klasa startowa aplikacji Spring Boot.
    * **`Konfig.java`**: (Prawdopodobnie) klasa konfiguracyjna Springa, która może zawierać bean'y inicjalizujące dane lub inne ustawienia.
    * **`_Entity_` (np. `Student.java`, `Przedmiot.java`, `Nauczyciel.java`, `Oceny.java`)**: Klasy reprezentujące encje w bazie danych. Zawierają mapowanie pól na kolumny tabel oraz definicje relacji (`@OneToMany`, `@ManyToOne`).
    * **`_Repository_` (np. `Repozytorium.java` (dla Student), `PrzedmiotRepo.java`, `NauczycielRepo.java`, `Ocenarepo.java`)**: Interfejsy rozszerzające `JpaRepository`, odpowiedzialne za operacje CRUD (Create, Read, Update, Delete) na encjach, z pominięciem implementacji.
    * **`_Request_` (np. `StudentRequest.java`, `PrzedmiotRequest.java`, `NauczycielRequest.java`, `OcenaRequest.java`)**: Klasy DTO (Data Transfer Object) używane do przekazywania danych z żądań HTTP do warstwy serwisowej i kontrolerów. Ułatwiają walidację i hermetyzację danych.
    * **`_Service_` (np. `Studentuslugi.java`, `Przedmiotuslugi.java`, `NauczycielUslugi.java`, `Ocenauslugi.java`)**: Klasy warstwy biznesowej (`@Service`). Zawierają logikę biznesową aplikacji, operują na danych z repozytoriów i mogą wykonywać walidację.
    * **`_Kontroler_` (np. `Kontroler.java` (dla Student), `PrzedmiotKontroler.java`, `NauczycielKontroler.java`, `Ocenakontroler.java`)**: Klasy kontrolerów REST (`@RestController`). Obsługują żądania HTTP, mapują ścieżki URL i wywołują odpowiednie metody z warstwy serwisowej. Zwracają odpowiedzi w formacie JSON.

## Jak uruchomić projekt

1.  **Sklonuj repozytorium:**
    ```bash
    git clone <URL_TWOJEGO_REPOZYTORIUM>
    cd projekt1
    ```
2.  **Zbuduj projekt za pomocą Mavena:**
    ```bash
    mvn clean install
    ```
3.  **Uruchom aplikację:**
    ```bash
    mvn spring-boot:run
    ```
    Aplikacja zostanie uruchomiona domyślnie na porcie 8080.

## Dostępne Endpointy API

Poniżej przedstawiono podstawowe endpointy dostępne w aplikacji:

### Studenci (`/api/v1/student`)
* `GET /api/v1/student`: Pobiera listę wszystkich studentów.
* `POST /api/v1/student`: Dodaje nowego studenta. Oczekuje obiektu JSON z `imie`, `nazwisko`, `email`, `wiek`.
* `DELETE /api/v1/student/{studentId}`: Usuwa studenta o podanym ID.
* `PUT /api/v1/student/{studentId}`: Edytuje dane studenta o podanym ID. Oczekuje obiektu JSON z opcjonalnymi polami do zmiany (`imie`, `nazwisko`, `email`, `wiek`).

### Przedmioty (`/api/v1/przedmiot`)
* `GET /api/v1/przedmiot`: Pobiera listę wszystkich przedmiotów.
* `POST /api/v1/przedmiot`: Dodaje nowy przedmiot. Oczekuje obiektu JSON z `nazwa`, `itn`.
* `DELETE /api/v1/przedmiot/{przedmiotId}`: Usuwa przedmiot o podanym ID.
* `PUT /api/v1/przedmiot/{przedmiotId}`: Edytuje nazwę przedmiotu o podanym ID. Oczekuje obiektu JSON z `nazwa`, `itn`.

### Nauczyciele (`/api/v1/nauczyciel`)
* `GET /api/v1/nauczyciel`: Pobiera listę wszystkich nauczycieli.
* `POST /api/v1/nauczyciel`: Dodaje nowego nauczyciela. Oczekuje obiektu JSON z `imie`, `nazwisko`, `przedmiotid`.
* `DELETE /api/v1/nauczyciel/{nauczycielId}`: Usuwa nauczyciela o podanym ID.
* `PUT /api/v1/nauczyciel/{nauczycielId}`: Edytuje dane nauczyciela o podanym ID. Oczekuje obiektu JSON z opcjonalnymi polami do zmiany (`imie`, `nazwisko`, `przedmiotid`).

### Oceny (`/api/v1/oceny`)
* `GET /api/v1/oceny`: Pobiera listę wszystkich ocen.
* `POST /api/v1/oceny`: Dodaje nową ocenę. Oczekuje obiektu JSON z `ocena` (wartość od 1 do 6), `przedmiot` (ID przedmiotu) i `student` (ID studenta).
* `DELETE /api/v1/oceny/{ocenaId}`: Usuwa ocenę o podanym ID.
* `PUT /api/v1/oceny/{ocenaId}`: Edytuje istniejącą ocenę. Oczekuje obiektu JSON z opcjonalnymi polami do zmiany (`ocena`, `przedmiot`, `student`).

## Nauczanie i Rozwój

Ten projekt był doskonałą okazją do praktycznej nauki Spring Boot. Przez jego tworzenie mogłem zgłębić takie koncepcje jak:
* Inwersja kontroli (IoC) i wstrzykiwanie zależności (DI) w Springu.
* Zarządzanie transakcjami za pomocą `@Transactional`.
* Tworzenie i używanie klas DTO do bezpiecznego przekazywania danych.
* Walidacja danych wejściowych.
* Modelowanie relacji encji w JPA (`@ManyToOne`, `@OneToMany`).
* Obsługa wyjątków w kontrolerach.

Projekt ten stanowi solidne podstawy do dalszego rozwoju umiejętności w ekosystemie Spring.
