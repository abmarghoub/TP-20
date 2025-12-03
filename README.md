# TP 20 : Architecture Micro-services avec RestTemplate

## 1. Objectif du TP

* Découverte de services avec **Eureka Server**
* Routage dynamique avec **Spring Cloud Gateway**
* Communication inter-services via **RestTemplate**
* Persistance des données avec **MySQL / JPA**
* Création de deux microservices indépendants :
  * **SERVICE-CLIENT**
  * **SERVICE-CAR** (qui consomme SERVICE-CLIENT)
* Structuration des configs (YAML), logs et gestion des timeouts

---

## 2. Architecture du TP


### 2.1  Stack technologique

| Composant                | Technologie / Version        |
| ------------------------ | ---------------------------- |
| Service Discovery        | Spring Cloud Eureka          |
| API Gateway              | Spring Cloud Gateway         |
| Communication interne    | RestTemplate                 |
| Microservices            | Spring Boot                  |
| Base de données          | MySQL + Spring Data JPA      |
| Langage                  | Java                         |

---

### 2.2 Structure du projet

**Eureka-server**<br>
<img width="446" height="392" alt="image" src="https://github.com/user-attachments/assets/c1a092c4-bb70-433e-a15b-925398be6477" />

**Gateway**<br>
<img width="374" height="486" alt="image" src="https://github.com/user-attachments/assets/9fd6c06b-2d1c-4ec6-aafa-cf7c84ac1b1f" />

**service-client**<br>
<img width="542" height="699" alt="image" src="https://github.com/user-attachments/assets/c05cd914-c246-467d-b59d-d7ffe891e621" />

**service-car**<br>
<img width="544" height="681" alt="image" src="https://github.com/user-attachments/assets/a72011e5-9922-4e85-a618-171aa8b8f370" />

---

## 3. Résultat attendu

###  *Eureka Server – Services enregistrés*
`http://localhost:8761/`
<img width="870" height="708" alt="image" src="https://github.com/user-attachments/assets/ed0b2c34-02d0-48b7-8153-40d6af151b3a" />

###  *Gateway*
`http://localhost:8888/client-service/api/client`
<img width="534" height="444" alt="image" src="https://github.com/user-attachments/assets/4ffebd5a-67ea-48c5-9b8f-c9d64ff5b378" />

`http://localhost:8888/sevice-car/api/car`
<img width="627" height="761" alt="image" src="https://github.com/user-attachments/assets/001937ce-daed-46d8-bc49-418227232522" />

###  *Client-Service – Liste des clients*
`http://localhost:8081/api/client`
<img width="624" height="498" alt="image" src="https://github.com/user-attachments/assets/0efa25af-c7bd-435f-928b-b2cab0a05230" />

###  *Car-Service – Liste des voitures*
`http://localhost:8082/api/car`
<img width="529" height="752" alt="image" src="https://github.com/user-attachments/assets/06c27afb-07a0-4228-8e9c-34ec635b5422" />


---
## Auteur
**Réalisé par :** Abla MARGHOUB<br>
**Encadré par :** Pr. Mohamed LACHGAR<br>
**Module :** Techniques de Programmation Avancée<br>
**Cours :** Architecture Microservices : Conception, Déploiement et Orchestration<br>
**Établissement :** École Normale Supérieure - Université Cadi Ayyad<br>
