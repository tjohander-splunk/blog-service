#!/bin/bash

i="0"

while [ $i -lt 30 ]; do
  curl http://localhost:8085/blog/stitch
  sleep 2
done
