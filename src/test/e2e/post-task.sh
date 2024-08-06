#!/usr/bin/env bash

curl -X POST \
     -H "Content-Type: application/json" \
     -d '{"title":"create title","description":"create description"}' \
        http://localhost:8080/tasks
