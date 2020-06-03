#!/bin/sh

kubectl delete rolebinding default:service-discovery-client
kubectl delete secret smtp-secret
kubectl delete configmap application-config 
kubectl delete configmap notification-config 
kubectl delete configmap members-config 

kubectl create rolebinding default:service-discovery-client --clusterrole service-discovery-client --serviceaccount default:default
kubectl create secret generic smtp-secret --from-literal=username=toto@titi.com --from-literal=password=secret
kubectl create configmap application-config --from-file=./src/main/resources/shared/application.yml
kubectl create configmap notification-config --from-file=./src/main/resources/shared/notification-service.yml
kubectl create configmap members-config --from-file=./src/main/resources/shared/members-service.yml


