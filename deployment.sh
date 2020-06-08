# Build and Push images 
cd notification-service
mvn clean compile jib:build -Dimage=dthibau/notification-service
cd ../members-service
./mvnw clean compile jib:build -Dimage=dthibau/members-service
cd ../document-service
./mvnw clean compile jib:build -Dimage=dthibau/documents-service
cd ../autorization
./mvnw -Pkubernetes clean compile jib:build -Dimage=dthibau/authorization-service
cd ..



#!/bin/sh
# Suppression services
kubectl delete service fake-smtp
kubectl delete service zipkin
kubectl delete service notification-service 
kubectl delete service members-service 
kubectl delete service documents-service 
# Suppression deployment
kubectl delete deployment fake-smtp
kubectl delete deployment zipkin
kubectl delete deployment notification-service 
kubectl delete deployment members-service 
kubectl delete deployment documents-service 


# 
kubectl apply -f fake-smtp/deployment.yml
kubectl apply -f zipkin/deployment.yml
kubectl apply -f notification-service/k8s/deployment.yaml
kubectl apply -f members-service/k8s/deployment.yaml
kubectl apply -f document-service/k8s/deployment.yaml


