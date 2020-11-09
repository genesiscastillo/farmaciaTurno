# springboot-sample-app

[![Build Status](https://travis-ci.org/codecentric/springboot-sample-app.svg?branch=master)](https://travis-ci.org/codecentric/springboot-sample-app)
[![Coverage Status](https://coveralls.io/repos/github/codecentric/springboot-sample-app/badge.svg?branch=master)](https://coveralls.io/github/codecentric/springboot-sample-app?branch=master)
[![License](http://img.shields.io/:license-apache-blue.svg)](http://www.apache.org/licenses/LICENSE-2.0.html)

Minimal [Spring Boot](http://projects.spring.io/spring-boot/) sample app.

## Requirements

For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `cl.genesiscastillo.farmaciaTurno.FarmaciaTurnoApplication` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```

## Deploying the application to GKE


```shell
docker build -t  genesiscastillo/farmaciaturno .

docker push genesiscastillo/farmaciaturno

docker pull genesiscastillo/farmaciaturno

docker run -it -p 8080:8080 genesiscastillo/farmaciaturno

docker tag genesiscastillo/farmaciaturno gcr.io/sing-in-dev-284714/farmaciaturno 

docker push gcr.io/sing-in-dev-284714/farmaciaturno 

gcloud container clusters get-credentials cluster-1 --zone us-central1-c --project sing-in-dev-284714

kubectl create deployment farmaciaturno --image=gcr.io/sing-in-dev-284714/farmaciaturno --dry-run=client -o=yaml > farmaciaturno-deployment.yaml

kubectl create service loadbalancer farmaciaturno --tcp=8080:8080 --dry-run=client -o=yaml > farmaciaturno-service.yaml


kubectl apply -f farmaciaturno-configmap.yaml
kubectl apply -f farmaciaturno-deployment.yaml
kubectl apply -f farmaciaturno-service.yaml

```


If you want to access to API Rest from outside. 

```shell
POST:  http://34.72.30.120:8080/api/farmacia/postListaFarmaciaEnTurno

{
    "comuna": "BUIN",
    "local": "AHUMADA"
}
```

## Copyright

Cesar Castillo <genesiscastillo@hotmail.com>