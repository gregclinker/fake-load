mvn clean install -DskipTests
docker build . -t gregclinker/fake-load:0.1
docker push gregclinker/fake-load:0.1