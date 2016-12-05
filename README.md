# jboss-middleware-empowered
To create a project using the archetype
mvn archetype:generate -DarchetypeGroupId=com.redhat.empowered -DarchetypeArtifactId=fis-spring-archetype -DarchetypeVersion=6.3.0 -DgroupId=<YourGroup> -DartifactId=<YourArtifactID>

This is a full example of a set of components for collecting/correlating business events with JBoss Fuse and JBoss Data Grid
A realtime dashboard using Patternfly to follow metrics and Service Level aggreements.

To run the examples

1) compile and package 

mvn install

2) run apps with hawt-app packaging

./runApp.sh

3) open browser at 

http://localhost:8888

4) simulate events

./play.sh

5) stop events

./pause.sh

6) stop applications

./stopApp.sh



To deploy on Openshift  : 
1) go into folder openshift of this project

cd openshift

2) create fis image streams if needed

oc create -f fis-image-streams.json

3) create configMap to change app.properties

oc create configmap --from-file=app.properties sla-solution-config

4) create application template. 
/!\ Change maven MAVEN_ARGS : for faster builds it is recommended that you setup a nexus2 locally to avoid downloading maven artifacts each time 
change the value http://172.17.0.1:8081/nexus/content/groups/public/ to any local nexus instance that is configured to be mirror of centra and fuse repositories
Otherwise if you don't want to use change the maven settings.xml file in the root folder of this project.

oc create -f sla-solution.yaml

5) login to openshift and deploy the application template

6) to run the simulation simply acces the url 

http://<dashboard-URL>/sim/sim/20/5
