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

