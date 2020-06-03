#!/bin/sh

kubectl delete rolebinding default:service-discovery-client
kubectl delete configmap application-config 
kubectl delete configmap notification-config 

kubectl create rolebinding default:service-discovery-client --clusterrole service-discovery-client --serviceaccount default:default
kubectl create configmap application-config --from-file=./src/main/resources/shared/application.yml
kubectl create configmap notification-config --from-file=./src/main/resources/shared/notification-service.yml
