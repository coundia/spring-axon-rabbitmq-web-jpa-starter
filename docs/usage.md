curl -X POST 'http://127.0.0.1:8094/api/v1/commands/sale' \
-H 'accept: application/json' \
-F 'quantity=1' \
-F 'totalPrice=2' \
-F 'facture=@/Users/pcoundia/Desktop/CV/CV_PAPA_COUNDIA_JAVA_FR.pdf;type=application/pdf'
