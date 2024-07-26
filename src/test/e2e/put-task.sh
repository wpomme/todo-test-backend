#!/usr/bin/env bash

curl -X PUT \
     -H "Content-Type: application/json" \
     -d '{"title": "modified", "description": "modified"}' \
        http://localhost:8080/tasks/01