

mvn clean install -Dmaven.test.skip=true

docker build -t basic-spring25 .

echo docker run -p 8080:8080 -e APP_NAME=APP1 basic-spring25

