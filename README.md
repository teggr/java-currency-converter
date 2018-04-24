# java-currency-converter
Command line Java currency converter

## Building with maven

	# build the jar
	mvn clean package
	
## Running the application
	
	# run the application
	java -jar target/java-currency-converter.jar -a 50.00 -s GBP -t AUD
	75.62 Australia Dollars
	
	# run the application with invalid or missing arguments
	java -jar target/java-currency-converter.jar
	...
	java -jar target/java-currency-converter.jar -a 3
	
	The following options are required: [-sourceCurrencyAmount | -a], [-targetCurrencyCode | -t], [-sourceCurrencyCode | -s]
	Usage: converter [options]
	  Options:
	  * -sourceCurrencyAmount, -a
	      A source currency amount in the format x.yy
	  * -sourceCurrencyCode, -s
	      A source ISO 4217 currency code
	  * -targetCurrencyCode, -t
	      A target ISO 4217 currency code
