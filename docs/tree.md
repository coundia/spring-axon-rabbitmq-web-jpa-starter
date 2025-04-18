tree src
src
├── main
│ ├── java
│ │ └── com
│ │ └── groupe2cs
│ │ └── bizyhub
│ │ ├── BizyhubApplication.java
│ │ ├── shared
│ │ │ ├── application
│ │ │ │ └── ApiResponseDto.java
│ │ │ └── infrastructure
│ │ │ ├── FileStorageService.java
│ │ │ ├── FileStorageServiceImpl.java
│ │ │ └── rabbitMq
│ │ │ └── RabbitMqConfig.java
│ │ └── transactions
│ │ ├── application
│ │ │ ├── command
│ │ │ │ ├── CreateTransactionCommand.java
│ │ │ │ ├── DeleteTransactionCommand.java
│ │ │ │ └── UpdateTransactionCommand.java
│ │ │ ├── dto
│ │ │ │ ├── TransactionPagedResponse.java
│ │ │ │ ├── TransactionRequest.java
│ │ │ │ └── TransactionResponse.java
│ │ │ ├── mapper
│ │ │ │ └── TransactionMapper.java
│ │ │ ├── query
│ │ │ │ ├── FindAllTransactionQuery.java
│ │ │ │ ├── FindByTransactionAmountQuery.java
│ │ │ │ ├── FindByTransactionIdQuery.java
│ │ │ │ └── FindByTransactionReferenceQuery.java
│ │ │ ├── queryHandler
│ │ │ │ ├── FindAllTransactionQueryHandler.java
│ │ │ │ ├── FindByTransactionAmountHandler.java
│ │ │ │ ├── FindByTransactionIdHandler.java
│ │ │ │ └── FindByTransactionReferenceHandler.java
│ │ │ └── usecase
│ │ │ ├── TransactionCreateApplicationService.java
│ │ │ ├── TransactionDeleteApplicationService.java
│ │ │ ├── TransactionReadApplicationService.java
│ │ │ └── TransactionUpdateApplicationService.java
│ │ ├── domain
│ │ │ ├── TransactionAggregate.java
│ │ │ ├── event
│ │ │ │ ├── TransactionCreatedEvent.java
│ │ │ │ ├── TransactionDeletedEvent.java
│ │ │ │ └── TransactionUpdatedEvent.java
│ │ │ ├── exception
│ │ │ │ ├── TransactionAmountNotValid.java
│ │ │ │ ├── TransactionIdNotValid.java
│ │ │ │ ├── TransactionNotFoundException.java
│ │ │ │ └── TransactionReferenceNotValid.java
│ │ │ └── valueObject
│ │ │ ├── TransactionAmount.java
│ │ │ ├── TransactionId.java
│ │ │ └── TransactionReference.java
│ │ ├── infrastructure
│ │ │ ├── entity
│ │ │ │ └── Transaction.java
│ │ │ ├── rabbitMq
│ │ │ │ ├── TransactionEventConsumer.java
│ │ │ │ ├── TransactionEventPublisher.java
│ │ │ │ └── TransactionRabbitMqConfig.java
│ │ │ └── repository
│ │ │ └── TransactionRepository.java
│ │ └── presentation
│ │ └── controller
│ │ ├── AddTransactionController.java
│ │ ├── DeleteTransactionController.java
│ │ ├── FindByAmountTransactionController.java
│ │ ├── FindByIdTransactionController.java
│ │ ├── FindByReferenceTransactionController.java
│ │ ├── TransactionListController.java
│ │ └── UpdateTransactionController.java
│ └── resources
│ ├── application-test.properties
│ └── application.properties
└── test
└── java
└── com
└── groupe2cs
└── bizyhub
├── BizyhubApplicationTests.java
├── presentation
│ └── controller
│ └── StatusControllerTest.java
├── shared
│ ├── BaseIntegrationTests.java
│ └── BaseUnitTests.java
└── transactions
├── application
│ └── CreateTransactionCommandTest.java
├── domain
│ └── TransactionAggregateTests.java
└── presentation
└── controller
├── TransactionCreateControllerIntegrationTest.java
├── TransactionDeleteControllerIntegrationTest.java
├── TransactionFindAllControllerIntegrationTest.java
├── TransactionFindByIdControllerIntegrationTest.java
├── TransactionFixtures.java
└── TransactionUpdateControllerIntegrationTest.java

42 directories, 61 files
❰pcoundia❙~/projects/spring-axon-rabbitmq-web-jpa-starter(git:main)❱✔≻ 
