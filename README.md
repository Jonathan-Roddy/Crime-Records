# Crime Records
*****************************************************************
              Read_Me file for Assignment 5                
*****************************************************************
 
  #-----------------------------------------------------------#  
Title : Irish Crime \
Author : Jonathan Roddy \
Release Date : 12/02/2020 \
  #-----------------------------------------------------------#  
 
 
+   DESCRIPTION :                                                 
This file is to outline what I have done for assignment 5 for
Application Programming module.

Given:
	-An sql database called irish_crime 

ToDo:
	-Client - Server (multithreaded) application that provides services 
	to the connected cliens. 
	-Free to do make any changes or updates to 
	database.

Have done:
	-Multitheaded Server that handles any number of clients.
		-Server notes what options the client is doing 
		each time, ips and what client number they are.
	-Sever sends a list of all the records from the database as an
	object to the client.
	-The client recieves the objects and stores them in a list.
	-Write to file:
		Client writes all objects to 'CrimeRecord.txt'
		Client writes all inputs, has viewed into 
		'ClientInteractions.txt'

	which follows:
	-I have created a menu for the client that displays the following:

		**********************************************
 		Please Enter Your option below     
		Type '0' to exit the application 
		**********************************************
		 1 -> Display all Records  
		 2 -> Display Highest Record + 2nd 
		 3 -> Display Total Crimes Per Offence Type  
		 4 -> Display Most crimes per a region 
		 5 -> Display Total crimes per Year
		 6 -> Display Occurence of crime  
		 7 -> What is likely to happen in 2009 Q4 
		**********************************************

	The client is free to pick any that they wish.

	Options 4 displays a submenu : 

		**********************************************
 		1 -> Northern Region  
 		2 -> Western Region 
 		3 -> Southern Region  
 		4 -> Eastern Region
 		5 -> South Eastern Region  
 		6 -> Dublin Metropoltian Region 
		**********************************************
 		Please Enter the number for the region below 
 		Type '0' to exit this Menu 
	
	In both cases if an input is not asked default case asks user
	to please try again.

Errors:

	-Option too is using streams. I only have it set up to pick first record
	that matches Cavan. Like show on first monday practical after givine
	the assignment.

	-ClientInteractions.txt will overwrite each time a client connects a 
	client leaves menu with input = '0'.

Interesting Facts:

	-Occurence of crime is all 28 for each offence.

	-Regions might have more areas allocatied to them so some regions
	will have more crimes. 

	For Example in menu option 3:

	OFFENCES AGAINST GOVERNMENT/ JUSTICE PROCEDURES AN... ==> 0
	ATTEMPTS/THREATS TO MURDER/ASSAULTS/ HARASSMENTS A... ==> 0
	FRAUD/DECEPTION AND RELATED OFFENCES ==> 28
	SEXUAL OFFENCES ==> 56
	BURGLARY AND RELATED OFFENCES ==> 84
	DAMAGE TO PROPERTY AND ENVIRONMENT ==> 84
	KIDNAPPING AND RELATED OFFENCES ==> 84
	HOMICIDE OFFENCES ==> 112
	THEFT AND RELATED OFFENCES ==> 112
	CONTROLLED DRUG OFFENCES ==> 140
	WEAPONS AND EXPLOSIVES OFFENCES ==> 140
	ROBBERY/EXTORTION AND HIJACKING OFFENCES ==> 140
	PUBLIC ORDER AND OTHER SOCIAL CODE OFFENCES ==> 168
	DANGEROUS OR NEGLIGENT ACTS ==> 224 

	That total crime per region goes up in 28 if there is an increase.

Extra files:
	commons - dbutils-1.7
	commons - dbutils-1.7-javadoc
	commons - dbutils-1.7-sources
	commons - dbutils-1.7-tests
	commons - dbutils-1.7-tes-sources

Will uplaod within zip file as well as beside file on Moodle.
Not sure which way I should do it so will do both
