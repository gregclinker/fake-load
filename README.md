# fake-load

An application to be used to create fake load for testing purposes. 

## Build
```commandline
mvn clean instal
```
## Build & Push a Docker Image
```commandline
mvn clean install -DskipTests
docker build . -t gregclinker/fake-load:0.1
docker push gregclinker/fake-load:0.1
```
## Deploy to Kubernetes
```commandline
kubectl create deployment fake-load-1 --image registry.hub.docker.com/gregclinker/fake-load:0.1 --replicas 0
kubectl set resources deployment fake-load-1 --requests cpu=250m,memory=256Mi --limits cpu=500m,memory=512Mi
kubectl set env deploy fake-load-1 --env RANDOM_STRING_LENGTH=10 --env THREADS_TO_RUN=2
kubectl scale deployment fake-load-1 --replicas 1
```

