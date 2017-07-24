# TLV Processor

## This processes TLVs with the following format
  * Format: TYPE(6)-LENGTH(4)-VALUE
  * Type - fixed 6 chars length. Defines the type of processing required.
  * Length - fixed 4 chars (represented as text) length of the value.
  * Value - the actual data to be processed of length 'Length' above.

## Build
* To build do mvn clean install
* After building the project, the jar can be found in the target directory as tlvprocessor-<version>.jar

## Usage
### As a Standalone jar

* Run the jar using command line as: ```java -jar tlvprocessor-1.0.jar```
  * It does not take command line arguments

* The input is from STDIN
  * You can provide multiline input
  * All data must be in ascii
  * Data should always follow the format specified, i.e. no malformed TLVs  
  * Enter an empty line to mark end of input

## Development
* Import as a maven project in IDE
