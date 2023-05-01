# Datahouse Consulting - Compatability Predictor 
#### by Jenna Mansoor 

## Table of contents
* [Introduction](#introduction)
* [Technologies](#technologies)

## Introduction 
This project takes in two arrays, both of the object type: person. One array represents a list of potential hires (arrayHires) and another represents current employees (arrayOfEmp). 
The object type person has two formats:
* attributes: name, IQ, EQ
* attributes: name, IQ, EQ, compatiblity 

IQ respresents a person's intelligence and EQ represents a person's emotional intelligences

Sequence of Events 
1. Project invokes two functions to calculate the average IQ and EQ of the existing employees
2. IQ and EQ scores of potential hires are compared with the averages to determine their compatibility score
3. Potential hires' array is sorted using the insertion sort algorithm 
4. Sorted array is added to a new array

	
## Technologies
Project is created with:
* JavaSE - 18 
* Eclipse IDE
