#!/bin/bash

DOCKER_VERSION=1.0.0
DOCKER_NAME=erpfake
## build erpfake-client
buildClient () {
    echo "Buildando o erpfake client";
    cd erpfake-client && mvn clean install && cd ..

    if [[ "$?" -eq 0 ]]
    then
        echo "Ocorreu um erro ao tentar gerar a build do erp client"
        exit 1;
    fi
}

buildProduct() {
    echo "Buildando o erpfake product";
    cd erpfake-client && mvn clean install && cd ..

    if [[ "$?" -eq 0 ]]
    then
        echo "Ocorreu um erro ao tentar gerar a build do erp produto"
        exit 1;
    fi
}

buildEureka() {
    echo "Buildando o erpfake eureka register"
    cd erpfake-eureka && mvn clean install && cd ..

    if [[ "$?" -eq 0 ]]
    then
        echo "Ocorreu um erro ao tentar gerar a build do erp eureka register"
        exit 1;
    fi
}

buildStock() {
    echo "Buildando o erpfake stock"
    cd erpfake-stock && mvn clean install && cd ..

    if [[ "$?" -eq 0 ]]
    then
        echo "Ocorreu um erro ao tentar gerar a build do erp stock";
        exit 1;
    fi
}


case $1 in 
    build-all)
        buildClient;
        buildProduct;
        buildEureka;
        buildStock;
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
esac