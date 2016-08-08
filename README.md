# test-go-euro
This is a stand alone application which can be started from the command line.
Usage:

java -jar GoEuroTest.jar "CITY_NAME"

The program takes this string and queries with it our Location JSON API.
The API endpoint returns JSON documents which is then converted to a CSV file
named CITY_NAME.csv. The CSV file haa the form: _id, name, type, latitude, longitude.
