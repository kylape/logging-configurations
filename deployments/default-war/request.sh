#!/bin/bash

curl -i -H "Content-Type: text/xml" -d @request.xml http://localhost:8080/logging-default/endpoint
