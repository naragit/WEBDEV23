
mkdir certs
cd certs
openssl req -x509 -nodes -days 365 -newkey rsa:2048 -keyout nt-selfsigned-private.key  -out nt-selfsigned.crt

