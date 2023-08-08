SHELL = /bin/bash
.PHONY: build

build:
	cd erpfake-client/ && mvn clean install && cd ..
