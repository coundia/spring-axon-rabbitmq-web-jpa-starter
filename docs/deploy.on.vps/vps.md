# 🚀 Déploiement de l'application BizyHub

Ce document décrit étape par étape le processus de déploiement de l'application **BizyHub** (Spring Boot + MySQL +
RabbitMQ) sur un serveur Ubuntu.

---

## 1. ✅ Prérequis système

- Ubuntu 20.04+ (VPS ou serveur dédié)
- Java 17
- MySQL 8
- RabbitMQ
- Port 8080 ouvert (ou reverse proxy configuré)
- Git, Maven (optionnel si jar déjà compilé)

---

# build

./mvnw clean package -DskipTests

## 2. 🧱 Installation des dépendances

```bash
sudo apt update
sudo apt install openjdk-17-jdk mysql-server rabbitmq-server nginx unzip -y
java -version


sudo mysql -u root -p

CREATE DATABASE bizyhub_prod CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
CREATE USER 'bizyhub_user'@'localhost' IDENTIFIED BY 'votre_mot_de_passe';
GRANT ALL PRIVILEGES ON bizyhub_prod.* TO 'bizyhub_user'@'localhost';
FLUSH PRIVILEGES;
EXIT;

sudo rabbitmqctl add_user pcoundia pcoundia
sudo rabbitmqctl set_permissions -p / pcoundia ".*" ".*" ".*"


scp target/bizyhub.jar user@your-server:/home/user/

#    Configuration de l'application

cd /home/user
java -jar bizyhub.jar --spring.config.location=file:/home/user/application-prod.properties

# Créer /etc/systemd/system/bizyhub.service :
 

[Unit]
Description=BizyHub Application
After=network.target

[Service]
User=user
ExecStart=/usr/bin/java -jar /home/user/bizyhub.jar --spring.config.location=file:/home/user/application-prod.properties
SuccessExitStatus=143
Restart=always
RestartSec=5

[Install]
WantedBy=multi-user.target

# Reload systemd to apply changes

sudo systemctl daemon-reload
sudo systemctl enable bizyhub
sudo systemctl start bizyhub
sudo systemctl status bizyhub


# 8.   Reverse proxy NGINX (optionnel)

server {
    listen 80;
    server_name votre-domaine.com;

    location / {
        proxy_pass http://localhost:8080;
        proxy_set_header Host $host;
        proxy_set_header X-Real-IP $remote_addr;
    }
}


sudo ln -s /etc/nginx/sites-available/bizyhub /etc/nginx/sites-enabled/
sudo nginx -t && sudo systemctl reload nginx

sudo apt install certbot python3-certbot-nginx -y
sudo certbot --nginx -d votre-domaine.com



https://cloud.megastore.sn/swagger-ui/index.html