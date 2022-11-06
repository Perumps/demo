Demo Service
============

This Java spring-boot application supports the following services:

* Foobar service that prints each number from 1 to n on a new line. For each multiple of 3, print "Foo" instead of the number. For each multiple of 5, print "Bar" instead of the number. For numbers that are multiples of both 3 and 5, print "FooBar" instead of the number
* Top Array Elements service that accepts an integer array and returns top n elements
* Anagram service that checks if two strings are anagrams

## Foobar Service

This service prints each number from 1 to n on a new line. For each multiple of 3, print "Foo" instead of the number. For each multiple of 5, print "Bar" instead of the number. For numbers that are multiples of both 3 and 5, print "FooBar" instead of the number.

### Usage

Send a request to /foobar endpoint with n as a URL parameter. The parameter name to be used is 'count'. 

For example:

http://localhost:50000/foobar?count=100

Sample requests are available in test/resources/demo.postman_collection.json.

### Response

* Successful response - HTTP response code 200. Returns each number from 1 to n on a new line. For each multiple of 3, print "Foo" instead of the number. For each multiple of 5, print "Bar" instead of the number. For numbers that are multiples of both 3 and 5, print "FooBar" instead of the number.
* Invalid input - Returns an error message with HTTP response code of 400
* System errors - Returns error details with HTTP response code of 500

## Top Array Elements Service

This service sorts an integer array and returns the top n elements.

### Usage

Send a request to /sort endpoint with the integer array and number of top elements to return. The parameter name to be used are 'inputArray' and 'top' respectively.

For example:

http://localhost:50000/sort?inputArray=3,2,1,4&top=2

Sample requests are available in test/resources/demo.postman_collection.json.

### Response

* Successful response - Returns the top n elements with an HTTP response code of 200
* Invalid input - Returns an appropriate error message with an HTTP response code of 400
* System errors - Returns error details with HTTP response code of 500

## Anagram Service

This service checks if two strings are anagrams.

### Usage

Send a request to /anagram endpoint with the two strings as URL parameters. The parameter name to be used are string1 and string2.

For example:

http://localhost:50000/anagram?string1=ABC&string2=BAC

Sample requests are available in test/resources/demo.postman_collection.json.

### Response

* Successful response - Returns a message indicating whether the two strings are anagrams or not. HTTP response code of 200
* Invalid input - Returns an appropriate error message with an HTTP response code of 400
* System errors - Returns error details with HTTP response code of 500


