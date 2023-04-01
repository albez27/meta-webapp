#!/usr/bin/env bash

mvn clean package

echo 'Copy files...'

scp -i id_rsa \
      out/artifacts/meta_webapp_jar/meta-webapp.jar \
      root@62.113.118.238:/home/albez

echo 'Restart server...'

ssh -i id_rsa root@62.113.118.238 << EOF

pgrep java | xargs kill -9
nohup java -jar meta-webapp.jar > log.txt &

EOF

echo 'Bye'