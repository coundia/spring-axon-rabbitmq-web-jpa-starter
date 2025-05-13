 1894  ls
 1895  ls bizyhub-1.0.0.jar
 1896  pwd
 1897  cat run.sh
 1898  nano log.sh
 1899  sh log.sh
 1900  sudo nano /etc/nginx/sites-available/bizyhub.groupe2cs.com
 1901  sudo nano /etc/nginx/sites-available/cloud.pcoundia.com
 1902  sudo ln -s /etc/nginx/sites-available/cloud.pcoundia.com /etc/nginx/sites-enabled/
 1903  sudo nginx -t
 1904  sudo systemctl reload nginx
 1905  sudo apt install certbot python3-certbot-nginx -y
 1906  sudo certbot --nginx -d cloud.pcoundia.com
 1907  sudo nano /etc/nginx/sites-available/cloud.megastore.sn
 1908  sudo ln -s /etc/nginx/sites-available/cloud.megastore.sn /etc/nginx/sites-enabled/
 1909  sudo nginx -t
 1910  sudo systemctl reload nginx
 1911  sudo apt install certbot python3-certbot-nginx -y
 1912  sudo certbot --nginx -d cloud.megastore.sn
 1913  sudo apt install certbot python3-certbot-nginx -y
 1914  sudo certbot --nginx -d cloud.pcoundia.com