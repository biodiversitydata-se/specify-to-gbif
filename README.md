# specify-to-gbif
[![Build Status](https://travis-ci.com/Naturhistoriska/specify-to-gbif.svg?branch=master)](https://travis-ci.com/Naturhistoriska/specify-to-gbif)
[![codecov](https://codecov.io/gh/Naturhistoriska/specify-to-gbif/branch/master/graph/badge.svg)](https://codecov.io/gh/Naturhistoriska/specify-to-gbif)
[![License: AGPL v3](https://img.shields.io/badge/License-AGPL%20v3-blue.svg)](http://www.gnu.org/licenses/agpl-3.0)



Processing data from Solr to GBIF.


## Prerequisites

* docker
* java 8
* maven 3
* mysql
* solr8 (See repo specify-to-dwc)


## Project setup

* Clone this repo
* Setup database
  * Find database schemas from data directory, and import schemas into mysql
* Setup project-initdata.yml
  * In root directory, create project-initdata.yml.
  * Config project-initdata.yml file solr instance path and mysql database.


## Build image


In root directory, run:
```
mvn clean package
cd specify-solr-service
make build
```

# Start image


After build image, run:
```
docker-compose up -d
```

# Run image:

curl -X GET 'http://localhost:8080/run?inst={institutionCode}&coll={collectionCode}&from={fromDate}&to={toDate}'

Example: curl -X GET 'http://localhost:8080/run?inst=nrm&coll=NHRS&from=2018-02-14&to=2018-02-15'
