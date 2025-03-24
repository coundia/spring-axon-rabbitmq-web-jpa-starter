## Table of Contents

	association_value_entry  =>  	Associe un Saga à une clé (ex: orderId).
	dead_letter_entry		 =>  	Stocke les événements échoués (Dead Letter Queue).
	domain_event_entry		 =>  	Stocke tous les événements d'un agrégat (Event Sourcing).
	product					 =>  	Stocke l'état persistant d'un produit (si utilisé avec une base de données classique).
	saga_entry	 			 =>  Stocke l'état en cours des Sagas actifs.
	snapshot_event_entry	 =>  	Stocke des snapshots d'agrégats pour accélérer leur chargement.
	token_entry             =>  	Suivi des événements consommés pour éviter les doublons.

Un **Saga** est un processus transactionnel distribué qui gère des opérations sur plusieurs 
services ou agrégats en assurant la cohérence des données 
sans utiliser de verrou global ni de transaction ACID traditionnelle.

Un Saga est une classe annotée avec @Saga, et il écoute les événements avec @StartSaga et @EndSaga.

En d’autres termes, un Saga orchestre une séquence d’événements et de commandes 

pour garantir que tout se passe bien ou pour appliquer une compensation en cas d’échec.

🎯 Quand utiliser un Saga ?
✔️ Quand une transaction implique plusieurs microservices.
✔️ Quand une rollback classique n’est pas possible.
✔️ Quand il faut garantir la cohérence des données sur plusieurs systèmes.