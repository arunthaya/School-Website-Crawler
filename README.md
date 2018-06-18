# School Site Crawler

Simple web app that takes school related websites, and retrieves important information from that website. This information may include:
- [x] About Me Page
- [x] Photos
- [ ] Location
- [ ] Programs
- [ ] Key Staff Members
- [ ] Departments

Requirements to run:
- Maven
- Node.js
- MongoDB

## Instructions

1. First install Maven as an application, and make sure you have the path environmental variable declared with your os.
    
        `cd React_page_parser`

2. Run mvn clean from the root folder:

        `mvn install`
    
3. Install MongoDB and run this command:
   
        `mongod`

4. Install Node.js, and install yarn via npm

        `npm install -g yarn`
    
5. Run mvn now that all the dependencies have installed:
   
        `mvn spring-boot:run`
 
6. CD into the example-frontend folder and run:

        `npm install`
    
7. Run yarn:

        `yarn start`

## Images

Adding a valid school url:

![screen shot 2018-06-17 at 10 09 15 pm](https://user-images.githubusercontent.com/25303677/41515491-2042a744-727d-11e8-80bf-7f27f889b96b.png)

Checking to see if it is a valid school url: 

![screen shot 2018-06-17 at 10 10 41 pm](https://user-images.githubusercontent.com/25303677/41515535-4f9a8c46-727d-11e8-98e4-f56c62fd3db8.png)

After parsing the university page: 

![screen shot 2018-06-17 at 10 16 25 pm](https://user-images.githubusercontent.com/25303677/41515606-c9a38268-727d-11e8-9a7e-0a7ee0eeed06.png)


Enjoy using the app!
    
  