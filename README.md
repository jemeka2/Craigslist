Craigslist RipOff

================
Security
================
For the Security I used to securityConfig to configure which pages people would be able to access
I used UserRepo and RoleRepo with resepective classes to create new users, assign them roles and then save them


=================
Controller
=================
In the Controller I create all of the mapping for each part of the website
I also use the controller to store the incoming job posts into an ArrayList
Also added glitchy features, the delete and update.
The delete button causes an error when it takes you to the next page but when you go back it shows that it deleted the proper post
because of the if statment on the home page.

The update button creates a copy of the post rather then changing the post. 
Don't know how to fix these issues

Lastly I try to make it so only the creator of the post can edit/delete a given post.
I attempted this by creating a custom role for each new user and then only authorizing that user to see the delete and update button.
Problem- I got the custom generated role to work but adding a variable into the hasRole field seems virtually impossible.

=================
html
=================
Design the website and get the user input for each post
Allow user to register