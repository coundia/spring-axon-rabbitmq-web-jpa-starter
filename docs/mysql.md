sudo cp /etc/mysql/mysql.conf.d/mysqld.cnf{,.bak.$(date +%F)}
sudo sed -i -E 's/^(log_bin|log-bin|log_bin_index|log-bin-index)\b.*/# &/' /etc/mysql/mysql.conf.d/mysqld.cnf



sudo systemctl stop mysql || sudo systemctl stop mariadb
sudo rm -f /var/lib/mysql/binlog.* /var/lib/mysql/binlog.index 2>/dev/null
sudo systemctl start mysql || sudo systemctl start mariadb

mysql -e "RESET MASTER;"   # seulement si pas de GTID/replication à conserver
