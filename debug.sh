#!/bin/sh

echo "About to remove contents of target folder, press any key to continue (Ctrl + c to abort)"
read userInput
rm -fvR target/*

echo "Building the project now... press any key to continue (Ctrl + c to abort)"
read userInput
./compile-no-test.sh


echo "Running the project press any key to continue (Ctrl + c to abort)"
read userInput
java -jar target/RestTemplate-0.0.1.jar


