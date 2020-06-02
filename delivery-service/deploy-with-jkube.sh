#!/bin/sh

./mvnw -DskipTests clean package

./mvnw k8s:build

./mvnw k8s:resource

./mvnw k8s:push

./mvnw -DskipTests k8s:deploy
