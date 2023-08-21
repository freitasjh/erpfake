#!/bin/bash

DOCKER_VERSION=1.0.0
DOCKER_NAME=erpfake

## build erpfake-client
buildClient () {
    echo "Buildando o erpfake client";
    cd erpfake-client && mvn clean install 
    docker build -t $DOCKER_NAME/client:$DOCKER_VERSION . && cd ..

    if [[ "$?" -eq "1" ]]
    then
        echo "Ocorreu um erro ao tentar gerar a build do erp client"
        exit 1;
    fi
}

buildProduct() {
    echo "Buildando o erpfake product";
    cd erpfake-product && mvn clean install
    echo "criando a imagem do servico de produto"
    docker build -t $DOCKER_NAME/product:$DOCKER_VERSION . && cd ..

    if [[ "$?" -eq "1" ]]
    then
        echo "Ocorreu um erro ao tentar gerar a build do erp produto"
        exit 1;
    fi
}

buildEureka() {
    echo "Buildando o erpfake eureka register"
    cd erpfake-eureka && mvn clean install
    
    echo "criando a imagem do eureka server"
    docker build -t $DOCKER_NAME/eureka:$DOCKER_VERSION . && cd ..
    
    if [[ "$?" -eq "1" ]]
    then
        echo "Ocorreu um erro ao tentar gerar a build do erp eureka register"
        exit 1;
    fi
}

buildStock() {
    echo "Buildando o erpfake stock"
    cd erpfake-stock && mvn clean install
    echo "criando a imagem do servico de estoque"
    docker build -t $DOCKER_NAME/stock:$DOCKER_VERSION . && cd ..

    if [[ "$?" -eq "1" ]]
    then
        echo "Ocorreu um erro ao tentar gerar a build do erp stock";
        exit 1;
    fi
}

buildGateway() {
    echo "Buildando o erpfake gateway"
    cd erpfake-gateway && mvn clean install
    echo "criando a imagem do servico de gateway"
    docker build -t $DOCKER_NAME/gateway:$DOCKER_VERSION . && cd ..

    if [[ "$?" -eq "1" ]]
    then
        echo "Ocorreu um erro ao tentar gerar a build do erp gateway";
        exit 1;
    fi
}

buildFrontend() {
    echo "Ainda não implementado.... aguardando a vontade =)"   
}

case $1 in 
    build-all)
        buildClient;
        buildProduct;
        buildEureka;
        buildStock;
        buildGateway;
    ;;
    build-client)
        buildClient;
    ;;

    build-product)
        buildProduct;
    ;;
    build-eureka)
        buildEureka;
    ;;
    build-stock)
        buildStock;
    ;;
    build-gateway)
        buildGateway;
    ;;
esac