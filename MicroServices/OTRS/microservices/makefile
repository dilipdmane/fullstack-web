install:
	mvn clean package -Dmaven.test.skip=true
	mvn docker:build

deploy:
	docker compose up -d

undeploy:
	docker compose down --remove-orphans

start-zuul:
	docker run  -d -p 8765:8765  --name zuul-server localhost:5000/dilipwork/zuul-server:0.0.1-zuul-server-SNAPSHOT

stop-zuul:
	docker container stop zuul-server
	docker container rm --volumes zuul-server

git:
	git pull
	git status
	git add .
	git commit -m "$m"
	git push
	git status
