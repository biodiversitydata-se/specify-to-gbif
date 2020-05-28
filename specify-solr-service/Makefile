#!make

all: build

build:
	docker build -t dina/specify-gbif:v0.2 .

# docker login
release:
	docker push dina/specify-gbif:v0.2
