Cette structure est une implémentation classique de l'architecture hexagonale avec DDD. 
Voici comment chaque couche s’intègre avec Axon + CQRS

src/
├── presentation/     # Couches exposant l'API (REST, GraphQL, WebSockets)
│   ├── controller/
│   ├── security/
│   └── dto/
├── application/      # Couches applicatives (CQRS - Command/Query Handlers)
│   ├── command/
│   ├── query/
│   ├── service/
│   ├── saga/
│   └── projection/
├── domain/          # Cœur métier (DDD - Aggregates, Events, Value Objects)
│   ├── model/
│   ├── aggregate/
│   ├── event/
│   ├── command/
│   ├── exception/
│   └── repository/
└── infrastructure/   # Couche technique (DB, Messaging, Security, etc.)
├── persistence/
│   ├── repository/
│   ├── entity/
│   └── projection/
├── messaging/ (RabbitMQ, Kafka)
├── config/ (Axon, Security, etc.)
├── eventstore/ (Event sourcing avec Axon)
└── security/

🔹 1️⃣ Presentation Layer (Interface utilisateur)
👉 Expose les APIs REST, WebSockets, GraphQL

Contient les Controllers Spring Boot pour exposer les endpoints.

Transforme les DTOs en objets métier et inversement.

Gère la sécurité avec Spring Security + JWT.

🔹 2️⃣ Application Layer (CQRS - Command / Query)
👉 Contient toute la logique d’application

Command Handlers : Capture les intentions de modification d’état.

Query Handlers : Récupère des données en lecture.

Sagas : Orchestre les transactions distribuées entre services.

Projections : Gère la reconstruction des vues à partir des événements.

🔹 3️⃣ Domain Layer (DDD - Business Logic)
👉 Contient le cœur métier

Aggregates : Représente les objets métier avec invariants.

Events : Contient les événements métier déclenchés par les Aggregates.

Commands : Définit les actions que les Aggregates peuvent traiter.

Repositories : Interface pour récupérer des Aggregates (Axon Event Store).

🔹 4️⃣ Infrastructure Layer (Adapters & Services)
👉 Connecte le projet aux technologies externes

Persistence : Implémente les repositories avec PostgreSQL.

Messaging : Envoie les événements à RabbitMQ / Kafka.

Security : Gère JWT et OAuth2.

EventStore : Utilise Axon Server ou PostgreSQL pour stocker les événements.