# Vending demo

[![Build Status](https://travis-ci.org/jproyo/grettings-dojo.svg?branch=master)](https://travis-ci.org/jproyo/grettings-dojo.svg?branch=master)

## Requirements

Write a program that loads a set of employee records from a flat file, and sends a greetings email to all employees whose birthday is today.

The flat file is a sequence of records, separated by newlines. These are the first few lines:

    last_name, first_name, date_of_birth, email
    Doe, John, 1982/10/08, john.doe@foobar.com
    Ann, Mary, 1975/09/11, mary.ann@foobar.com

The greetings email contains the following text:

    Subject: Happy birthday!

    Happy birthday, dear John!

The goal of this exercise is to come up with a solution that is:

- Testable: We should be able to test the internal application logic with no need to ever send a real email.
- Flexible: we anticipate that the data source in the future could change from a flat file to a relational database, or perhaps a web service. We also anticipate that the email service could soon be replaced with a service that sends greetings through Facebook or some other social network.
- Well-designed: separate clearly the business logic from the infrastructure.


## Prerequisites
    - JDK 8
    - Maven 3.0.4 or newer


## Run the solution

    To run the solution you should execute maven command as follow

    > mvn clean install

    Enjoy it!!!!!!!!!!!
