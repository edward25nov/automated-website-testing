# automated-website-testing
Este repositorio tiene como objetivo la automatización de pruebas a websites utilizando Selenium, Cucumber, SerenityBDD, Java, Maven e IntelliJ

* Para ejecutar el proyecto usar:
  ```` mvn clean verify serenity:aggregate ````

## Setup Selenium Grid 4
* Official documentation [click here](https://github.com/SeleniumHQ/docker-selenium#quick-start)
* [Hub and Nodes](https://github.com/SeleniumHQ/docker-selenium#hub-and-nodes)
````  
$ docker network create grid 

$ docker run -d -p 4442-4444:4442-4444 --net grid --name selenium-hub selenium/hub:4.1.3-20220405

$ docker run -d --net grid -e SE_EVENT_BUS_HOST=selenium-hub --shm-size="2g" --name node-chrome -e SE_NODE_GRID_URL="http://localhost:4444" -e SE_NODE_MAX_SESSIONS=5 -e SE_NODE_OVERRIDE_MAX_SESSIONS=true -e SE_EVENT_BUS_PUBLISH_PORT=4442 -e SE_EVENT_BUS_SUBSCRIBE_PORT=4443 selenium/node-chrome:4.1.3-20220405

$ docker run -d --net grid -e SE_EVENT_BUS_HOST=selenium-hub --shm-size="2g" --name node-edge -e SE_NODE_GRID_URL="http://localhost:4444" -e SE_EVENT_BUS_PUBLISH_PORT=4442 -e SE_EVENT_BUS_SUBSCRIBE_PORT=4443 selenium/node-edge:4.1.3-20220405

$ docker run -d --net grid -e SE_EVENT_BUS_HOST=selenium-hub --shm-size="2g" --name node-firefox -e SE_NODE_GRID_URL="http://localhost:4444" -e SE_EVENT_BUS_PUBLISH_PORT=4442 -e SE_EVENT_BUS_SUBSCRIBE_PORT=4443 selenium/node-firefox:4.1.3-20220405
````

* When you are done using the Grid, and the containers have exited, the network can be removed with the following command:
```` 
  # Removes the grid network
  $ docker network rm grid
```` 

* Validate Status Grid at http://localhost:4444/status 
* Selenium Grid Page: http://localhost:4444/ui/index.html#/ 

### Update serenity.properties
* We need to add the following properties, and we can automatically run our tests on Selenium Grid 4.
```` 
webdriver.driver=remote
webdriver.remote.driver=chrome
webdriver.remote.url=http://localhost:4444/wd/hub
```` 

