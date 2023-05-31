# Test task*

## Part 1

Develop a SOAP service "Quadratic Equation Solver" of the form a*x^2+b*x+c=0 using the discriminant.
The variables a, b, c are passed in the request, for example:

	<request>
        <a>3</a>
        <b>4</b>
        <c>1</c>
	</request>

The service returns the general form of the equation and the roots found, for example:

	<response>
        <formula>3x^2+4x+1=0</formula>
        <D>0</D>
        <x1>0</x1>
        <x2>0</x2>
	</response>

In case the discriminant is less than zero, an exception is thrown.
The service should automatically generate a description in the wsdl format with xsd schemas.
The elements a, b, c in the request are mandatory.
The element "x2" may be absent in the response if the discriminant is equal to 0.
In case of an exception, the error response should contain, in addition to the error message, the elements "formula, D".

## Part 2

Develop a web service that, when accessed at url:

	http://localhost:port/api/calc/?a=3&b=4&c=1 обращается к первому сервису за решением.

A SOAP client for the service is created using the wsdl contract from the service in Part 1.
The response to the request is in JSON format.

Requirements:

    1 project = 2 modules

    maven/gradle

    Java8+, any application server WildFly, Tomcat, etc..

    build and run instructions

bonus:

    presence of tests, docker + docker-compose

*-grammar and description from the source


# Deployment

The deployment process is as simple as possible. The necessary software is:

    terminal for executing commands;

    docker;

    docker-compose

Building, running, and stopping the application is done using the make utility.

Goals:

    all - start the Soap and Rest services in docker compose;

    stop - stop the services running in docker compose;

    start - start the services(images) in docker compose;

    clean - remove containers in docker compose;

    all-local - build and start the services;

    stop-local - stop the services;

    clean-locl - clean the working directory of build files.

Executing goals from Makefile:

    $ make <goal>

That's all.