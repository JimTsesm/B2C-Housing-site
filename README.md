# B2C-Housing-site

In this assignment I have developed from scratch a B2C site identical to Airbnb.

The project has been developed in Eclipse framework and they have been used the below technologies:

1)JSP/Servlets.


2)JPA for accessing, persisting, and managing data between Java objects / classes and a relational database.

3)MySQL Database.

4)Npm library of node.js to perform sentiment analysis of customers' reviews.

Short Description of the utilities:

A user of the application may be a host, a guest or he/she may remain anonymous. Each host manages several rooms (photos, availability, services), so that a guest that navigates the website can decide which one matches his/her preferences. A user needs to have a personal account so that he/she can rent a room.

In the application, there is also an administrator that manages the users' requests to become hosts and exports xml files that contain current statistics (houses, dates, users).

Furthermore, users can communicate through a chat with room’s hosts in order to ask them for more details.

Two recommendation algorithms have been implemented in order to make booking suggestions to the users. The first one is based on the the reviews. We have used a lsh data structure that contains review-vectors for every user of the application. The size of every vector is equal to the total number of rooms of the application. We calculate and assign to each position of these vector the value obtained by review sentiment analysis for the corresponding room for a given user. Finally each user has a “review-signature” which reflects his/her preferences. On the other hand, in our second recommendation approach the vectors are being dynamically constructed depending on the pages visited by the user. A new user is being initialized with a vector that contains zero values and every time he visits a room the number 1 is added to the corresponding position. In this case, the vector represents the users search behaviour taking into account the rooms he/she often visits. We save these vectors in memory by serializing lsh tables.

Every time a user logs in and depending on the method we want to apply, we run an efficient lsh knn search so we find the k nearest neighbours of the user and we make our final room-proposals.
