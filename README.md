# test-go-euro
This is a stand alone application which can be started from the command line.

Usage:

java -jar GoEuroTest.jar "CITY_NAME"

Where "CITY_NAME" is a name of a particualr city. The application accepts only one
argument, with no whitespace characters.

The program takes this string and queries with it our Location JSON API.
The API endpoint returns JSON documents which is then converted to a CSV file
named CITY_NAME.csv. The CSV file haa the form: _id, name, type, latitude, longitude.

#building
To build the application use maven command:
<b>mvn clean package</b>
