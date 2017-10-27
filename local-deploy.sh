DEPLOY_PATH="/home/integer/git/customer/target/"
WEBAPP_PATH="/opt/tomcat/webapps/"
WAR_NAME="customer.war"

#Clean Up
rm -r $DEPLOY_PATH
sudo rm $WEBAPP_PATH$WAR_NAME

#Build
mvn clean package

#Copy .war
sudo cp $DEPLOY_PATH$WAR_NAME $WEBAPP_PATH$WAR_NAME

#Restart Tomcat
sudo initctl restart tomcat
