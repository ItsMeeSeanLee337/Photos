<html>
<head>
<link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
<title>CS213 Spring 2023: Photos</title>
<style>
body { font: 14px sans-serif, Trebuchet MS; width: 96%; margin-left: 2%;}
a, a:visited { color: blue; }
tt, code { color: blue; }
</style>
</head><body><center>
<h2>Assignment 3</h2>
<h2>Photos</h2>
<h3>Posted Wed Mar 8
<p>GUI Storyboard Due (Bitbucket) <font color="red">Thu
Mar 23, 11 PM</font><br>
<p>Complete Implementation Due (Bitbucket) <font color="red">Fri Apr 14, 11 PM</font></h3>
<h3>Worth 225 points (22.5% of course grade)</h3>
</center>
<hr>
<p>For this assignment you will build a single-user photo application that allows storage 
and management of photos in one or more albums.

  <p>All user interaction must be implemented in Java FX,
and all UIs--except for standard Java FX dialogs such as Alert and
TextInputDialog--must be designed in FXML.  

<p>You may use multiple stages to show complex secondary windows, and 
switch multiple scenes within a stage.

    </p><p>You will continue working with your partner.
      Read the
      <a href="http://www.cs.rutgers.edu/academics/undergraduate/academic-integrity-policy/programming-assignments">
DCS Academic Integrity Policy for Programmming Assignments</a> - you are responsible
for this. 

</p>

<hr>

<h2>Contents</h2>

<ol>
<li><a href="#overview">Features</a>
<li><a href="#model">Model</a>
</li><li><a href="#storyboard">GUI Storyboard</a>
</li><li><a href="#gui">Complete Implementation</a>
</li><li><a href="#bitbucket">Bitbucket Contents</a>
</li><li><a href="#grading">Grading</a>
</li><li><a href="#faq">FAQs</a>
</li></ol>

<hr>

<a name="overview"></a><h2>Features</h2>

<p>Your application must implement the following features:

<p><b>Date of photo</b>

<p>Since we won't examine the contents of a photo file to get the date 
the photo was taken, we will instead use the last modification date of the photo 
file (as provided
via the Java API to the filesystem) as a proxy. (The user interface will still
refer to this as the date the photo was taken.)

<p>To store and manipulate dates and times, you have two options:
  <ul>
    <li>
You can use a <code>java.util.Calendar</code> instance. <br>In which case,
when you set a date and time on an instance, 
<font color="red">also make sure you set milliseconds to zero</font>, as in
<tt>cal.set(Calendar.MILLISECOND,0)</tt>,
otherwise your equality checks won't work correctly.
<li>
<p>Alternatively, you may
use the classes in the <tt>java.time</tt> package.
  </ul>
  
<p><b>Tags</b>

<p>Photos can be tagged with pretty much any attribute you think is useful to search
on, or group by. Examples are location where photo was taken, 
and names of people in a photo, so you can search for
photos by location and/or names.

<p>From the implementation point of view,
it may be useful to think of a tag as a combination of <b>tag name</b> and 
<b>tag value</b>, e.g. 
("location","New Brunswick"), or ("person","susan"). A photo may have
multiple tags (name+value pairs), but no two tags for the same
photo will have the same name and value combination. 

<p>Additional details:
<ul>
<li>You can set up some tag types beforehand for the user to pick from 
(e.g. location)
<li>Depending on the tag type, a user can either have a single value for it, 
or multiple values (e.g. for any photo, location can only have one value, 
but if there's a person tag, that can have multiple values, one per person 
that appears in the photo)
<li>A user can define their own tag type and add it to the list (so from that 
point on, that tag type will show up in the preset list of types the user 
can choose from)
</ul>

<p><b>Location of Photos - Stock photos and User photos</b>

<p>There are two sets of photos, <b>stock photos</b> that come pre-loaded with the
application, and <b>user photos</b> that are loaded/imported by a user when
they run the application. 

<ul>
<li>Stock photos are photos that you will keep in the application's
workspace.  <font color="red">You must have no fewer than 5 stock photos, 
and no more than 10</font>. 

<p>Create a special username called
"stock" (no password, or password="stock") and store the stock photos
under this user, in an album named "stock".

<p>Leave the photos in the application's
workspace so the graders can test your application starting 
with your stock photos, then load other photos from their computer,
see "User photos" below. 

<p>Try to work with low/medium resolution pictures for the
stock photos because they will be on Bitbucket and downloaded by the
graders, and you don't want to bloat your project size.

<li>User photos are photos that your application can allow a user to
load from their computer, so they can be housed anywhere on the user's
machine. The actual photos must NOT be in your application's
workspace. Instead, your application should only store the location of
the photo on the user's machine.  User photo information must NOT be
in the released project in Bitbucket since each installation of your
application on a machine will have its own set of users.
</ul>

<p><b>Login</b>

<ul>
<li>When the application starts,
a user logs in with username. Password implementation is optional. It makes for
  a "real" scenario, but is irrelevant to the essence of the project. (There is
no credit for the password feature, if you choose to implement it.)
</ul>

<b>Admin Subsystem</b>

<ul>
<li>There must be a special username <b>admin</b> that will put
the application in an administration sub-system. The <b>admin</b> user can then do
any of the following:
  <ul>
    <li>List users</li>
    <li>Create a new user</li>
    <li>Delete an existing user</li>
  </ul>
  </li>
<p>Note: If you elect to implement passwords for users,
make "admin" the password for the <b>admin</b> user, so it's easier to grade.
Otherwise we will need to ask you, or look in some README file, etc, which
just turns out to be a needless hassle.
</ul>

<p><b>Non-admin User Subsystem</b>

<ul>
<li>Once the user logs in successfully, all albums and photo information for this user 
from a previous session (if any) are loaded from disk. 

<p>Initially, all the albums 
belonging to the user should be displayed. For each album, its name, the number of
photos in it, and the range of dates (earliest and
latest date) on which photos were taken must be displayed.
Use your discretion on how to show this additional information. 
</li><p></p>
<li>The user can then do the following:</li>
  <ul>
  <li>Create albums</li>
  <li>Delete albums</li>
  <li>Rename albums</li>
  <li>Open an album. Opening an album displays all photos, with their <em>thumbnail</em>
   images and
  captions, inside that album. Once an album is open the user can do the following:</li>
  <!-- Maybe split into two lists -->
  <ul>
    <li>Add a photo</li>
    <li>Remove a photo</li>
    <li>Caption/recaption a photo</li>
    <li>Display a photo in a separate display area. The photo display should also show 
    its caption, its date-time of capture (see <b>Date of photo</b> below), 
    and all its tags (see <b>Tags</b> below).
</li>
    <li>Add a tag to a photo</li>
    <li>Delete a tag from a photo</li>
    <li>Copy a photo from one album to another (multiple albums may have
        copies of the same photo)<p>
        <font color="red">Note: If a photo is in multiple albums, it is the same
physical photo, just referenced from multiple albums. This means any
changes you make to the photo (caption, tags) will be reflected in all the
albums in which the photo appears.</font></li>
    <li>Move a photo from one album (source) to another (the photo will be removed from
        the source album)</li>
    <li>Go through photos in an album in sequence forward or backward, one at a time, 
with user interaction (manual slideshow)</li>
  </ul>
  <li> Search for photos (Photos that match the search criteria should be
  displayed in a similar way to how photos in an album are displayed).
    Under this, you should provide the following specific features:
    <ol>
      <li>Search for photos by a date range. </li>
      <li>Search for photos by tag type-value pairs. The following types of
          tag-based searches should be implemented:
          <ul>
          <li>A single tag-value pair, e.g person=sesh 
          <li>Conjunctive combination of two tag-value pairs, e.g. person=sesh AND
              location=prague
          <li>Disjunctive combination of two tag-value pairs, e.g. person=sesh OR
               location=prague
          <li>For conjunctions and disjunctions, if a tag can have multiple values
              for a photo, it can appear on both arms of the conjunction/disjunction,
            e.g. person=andre OR person=maya, person=andre AND person=maya
          </ul>
          You are NOT required to do conjunctions/disjunctions on more than two
          tag-values pairs.<br>
          In other words, you are not required to do stuff like <tt>t1=v1 and t2=v3 and t3=v3</tt><br>
    </ol>
    <li>There should be functionality to create an album containing the search results.

<p>As mentioned earlier (under Copy a photo from one album to another), 
a photo can be in multiple albums. Creating an album out of search results means
copying these photos to a new album, <em>without deleting them from the current 
album(s) to which they belong</em>.
</ul>
<p>Note: A single user may not have duplicate album names, but an
album name may be (coincidentally) duplicated across users. 

</ul>

<p><b>Logout</b>

<ul>

<li>The user (whether admin or non-admin)
logs out at the end of the session. All updates made by the user
are saved to disk.

<li>After a user logs out, the application is still running, allowing
another user to log in.
</ul>

<p><b>Quit Application</b>
<ul>
<li>There should be a way for the user to quit the application 
<b>safely</b> at any 
time, bypassing the logout step (e.g. by killing the main window). 
<b>Safely</b> means that all updates that were
made in the application in the user's session
are saved on disk.
<li>Unlike logout, the application stops running. The next user that wants to
use the application will need to restart it.
</ul>

<p><b>Errors</b>
<ul>
<li>In the application all errors and exceptions should be handled gracefully within
the GUI setup. The text console should NOT be used at all: not to report any error,
not to read input, not to print output.
</ul>



<hr>

<h2><a name="model"></a>Model</h2>

<p>The model should include all data objects, plus code to store and retrieve
photos for a user. The collection of classes that comprise the model should
be in its own package, separate from the view and controller.

<p><font color="red">You are required to use the 
<code>java.io.Serializable</code> interface, and the
<code>java.io.ObjectOutputStream</code>/<code>java.io.ObjectInputStream</code>
classes to store and retrieve data.</font>

<p>See <a href="serialization.pdf">Notes on Serialization and Versioning</a> to know 
how to implement serialization and deserialization.

<p>Note that your application will need to 
store content for multiple users, so it would be a good idea to separate
different user's contents from each other. 

<p>You need to think about what objects you want to have in your design,
with what attributes and operations. It is important to plan this out and 
come up with a good object-oriented design that clearly separates roles and
functions between objects, and can be cleanly extended to add more features
for future versions of the application.

<hr>

<p></p><h2><a name="storyboard"></a>GUI Storyboard</h2>

Your first task is to design the UI in the form of 
a <b>storyboard</b>.

<p>The storyboard is a sequence of
screen diagrams that shows all paths of flow through the interface.
Here's a <a href="storyboard.pdf">sample storyboard</a> for a 
calculator application that gives
you an idea of what you should do. This is an older version built
with Swing, so ignore the labels of the Swing widgets.
Also, this is not a complete storyboard in that it does not show all
possible screens that are in the UI it describes, nor does it
necessarily show all possible transitions between screens. What it
does show is how to draw screens, how to label screen components, how
to draw transitions between screens, and how to label transitions.

</p><p>It is important to have one or more overview diagrams
that show all screens and all transitions between them, without any
details of the components within the screens themselves. This is an
overview that can give the complete picture in
one shot. The rest of the storyboard will then draw each screen
in detail.

</p><p>Each screen must be drawn using some drawing package - <b>NO hand drawings!</b>. Or, you can
even include screenshots off SceneBuilder rendering of FXML UI layouts.
<font color="red">But Screenshots that you take off a Java program WILL NOT be
accepted.</font> In other words, there should be <b>no Java code</b> written at this
stage at all. 

</p><p>Each screen will represent one window of your GUI and will contain
all the widgets that go into that screen - text fields, buttons, etc. 
Be as precise as you can about the selection and 
layout of the components in a screen. <font color="red">While it is not necessary that
you label each Java FX component you will use (as in the sample storyboard),
it will help if you do because there is a smaller amount
of design issues to worry
about when you start coding the application logic.</font>

</p><p>Each screen will show transitions to other screens and the
events that trigger these transitions. When all is said and done, you
will have effectively drawn up a storyboard of your entire GUI that shows
all screens and all inter-screen transitions.

</p><p><b>Note</b>: The title for each screen should be descriptive of
what the screen does. The sample storyboard
says "Calculator" for all titles, but 
for your storyboard, name every screen with an
appropriate title. This can serve as the title to be displayed
in the titlebar when you implement these screens in code.

</p><p><b>Grade Credit</b>: Credit for the storyboard will be
based on how well it anticipates (and determines) the implementation
of the GUI. This portion of the grade for your storyboard will be
given <b>after</b> you finish the implementation, 
and we can look at how useful your storyboard has been
for your implementation. This means your storyboard is not set in stone,
as in you can make some changes to the UI when you build it because you
thought of some new/different elements. But the final result can't 
be too different from the original storyboard, which if it does, will
imply that you didn't think through the UI well enough to start with.

</p><hr>

<h2><a name="gui"></a>Complete Implementation</h2>

<p>Code your application using the standard installation of Java, using for
your GUI Java FX and FXML <b>only</b> (No Swing). 
<font color="red">No external vendor libraries.</font>
We will test with standard Java so if you use any external packages, your
program will not run, and you will not get credit.

</p><p>Document every class you implement with Javadoc tags, and be sure to
include authorship. 

</p><p>Represent the object-oriented design of the entire application
using a UML class diagram. This should include both the classes you have built,
as well as the Java FX classes. 
For the latter, just the class name will suffice--shade the class box so it's easy to
visually separate the Java FX classes from yours.
For each class built by your application, show
all public fields and methods in the UML representation.

</p><p>Keep in mind that you
will need classes that are not visually represented, but perform
data-management functions, as well as broker between the visual
classes and the backend. These should be in your UML as well.

<p>Finally, hand-drawn UML diagrams are NOT acceptable. You should use
drawing software to do the UML. (Google Slides is one option,
but if you find a UML drawing app, feel free..) The end product should
be a PDF file.

</p><hr>

<h2><a name="bitbucket"></a>Bitbucket Contents</h2>

<p>Your project should be named PhotosXX, where XX is your 2-digit group
number.

<p>The <b>docs</b> and <b>data</b> directories mentioned below should be created directly
under the project, NOT under <b>src</b> or under any of the packages.

<h3>By Thursday, Mar 23, 11 PM</h3>

<b>GUI Storyboard</b>: The final form of your storyboard should be a PDF file
called <b>storyboard.pdf</b>, which should be placed 
in the <b>docs</b> directory.

<h3>By Friday, Apr 14, 11 PM</h3>

<ul>
<li><b>Complete code</b>: There should be one class called <b>Photos</b> that
should have the <b>main</b> method, so it can be launched as an application. 
</li><li><b>UML</b>: The complete UML class diagram should be a PDF
file called <b>uml.pdf</b>, placed in the <b>docs</b> directory.
</li><li><b>Javadocs</b>: The complete Javadoc HTML documentation should be 
generated and placed in the <b>docs</b> directory. 
</li><li><b>Stock Photos</b>: For the <b>stock</b> username. These should be
    in the <b>data</b> directory.
</li></ul>

<hr>

<h2><a name="grading"></a>Grading</h2>

Your project will be graded on the following, for 225 points:

<p>
<table style="border-collapse:collapse;cellspacing:0px;border: 1px solid ; font-family: Trebuchet MS; font-style: normal; font-variant: normal; font-weight: normal; font-size: 14px; line-height: normal; font-size-adjust: none; font-stretch: normal; -x-system-font: none;margin-left:20px;">
<tbody>
<tr>
<td style="border-bottom: 1px solid;background:whitesmoke;">Category</td>
<td style="border-bottom: 1px solid;background:whitesmoke;">Points</td></tr>
<tr><td style="padding-right: 10px;">UI Design - Storyboard (Completeness)</td><td>20</td></tr>
<tr><td style="padding-right: 10px;">Object Design - UML (Separation of functionality,<br>
proper relationships between objects, extensibility)</td><td>15</td></tr>
<tr><td>Features</td><td>190</td></tr>
<tr><td>Total</td><td>225</td></tr>
</tbody></table>

<p><b>Penalties</b> (up to 25 points total) will be assessed on the
following:
</p><ul>
<li>Did not commit storyboard by Thu, Mar 23 11 PM.
<li>Not using FXML adequately/appropriately to design the UI
<li>Inadequate Javadoc tags/Javadoc HTML documentation not generated
<li>Project structure does not properly separate model, view, control classes
with appropriate package configuration
</li><li>Lacks scalability i.e. doesn't display large amounts of data 
(e.g. many tens of photos or more) in a
    easily navigable way</li>
</ul>

<p><b>Lateness penalties (separate from penalties above)</b>:
  <ul>
<li>10 pts: Every time you ask us and we test another commit version in your
repository that is earlier than the last commit before the deadline.
<li>10 pts: For every 2 hours of lateness, in case there is nothing
in the repository for us to test as of the deadline of Apr 14, 11 PM.<br>
<font color="red">NOTE: This 2 hour block will be applied STRICTLY starting any time
after 11 PM (even if it is one second), in increments of 2 hours. NO EXCEPTIONS.</font>
</ul>

<hr>

<h3><a name="faq"></a>Frequently Asked Questions</h3>

<b>Q:</b> Can we draw the storyboard by hand on paper, then submit a picture?
<br><b>A:</b> No. It should be drawn on using software - we are aiming for a professional 
look!

<p><b>Q:</b> Are search criteria disjoint, user can search photo for EITHER date 
range or tag type-value pairs or can they search for a tag type-value pair within 
a certain date range?
<br><b>A:</b> Date range and tag-value pairs are disjoint for searches. So either 
date range or tag-value pairs, but not together.

<p><b>Q:</b> 
What photo formats are allowed?
<br><b>A: </b>BMP, GIF, JPEG, PNG. 
See <a href="https://www.tutorialspoint.com/how-to-display-an-image-in-javafx">
  https://www.tutorialspoint.com/how-to-display-an-image-in-javafx</a>

<p><b>Q:</b> 
Do we need to show standard dialogs (Alert, TextInputDialog) in our storyboard?
<br><b>A:</b>
You need not show error/confirmation dialogs. But you must show any dialog that
is getting user input, whether it is a standard dialog (boilerplate JavaFX), or
a dialog you designed with FXML.

<p><b>Q:</b> 
Should we preserve the aspect ratio of the image the user views?
<br><b>A:</b>
Not a requirement (i.e. you won't lose credit if you don't), but preserving the 
aspect ratio is encouraged.

<p><b>Q:</b> 
Does admin also have albums and everything else, like non-admin user? Or just 
edit/create/delete user?
<br><b>A:</b>
No. admin can only create/delete user, and list all users.

<p><b>Q:</b> 
If we have two tags like "person": "Alice" and "person": "Bob". Should we store 
them in two different tags? Or we should do it in a single tag "person":"Alice; Bob"? 
Or both are fine?
<br><b>A:</b>
You should store them in two different tags, one per person.

<p><b>Q:</b> 
Do we need to display photos/users/albums in sorted order?
<br><b>A:</b>
No.

<p><b>Q:</b> 
Is a user allowed to have duplicates of the same picture in the same album?
<br><b>A:</b>
No.

<p><b>Q:</b> 
Can a user edit the date of a photo?
<br><b>A:</b>
No. The date of the photo is basically the date of the photo file, 
it can't be modified in the app

<p><b>Q:</b> 
If you have already added a photo to one album, can you add it to another album 
(via importing the photo again) not copying or moving the photo? 
<br><b>A:</b>
Yes. But it is equivalent to copying.
And be sure to read the note in the assignment description (in red) on copying 
a photo from one album to another since the same rules apply in this situation.

<p><b>Q:</b> 
Are we allowed to have duplicate users? 
<br><b>A:</b>
No.

<p><b>Q:</b> 
Can there be photos that are not in an album?
<br><b>A:</b>
No, every photo must be in at least one album.

<p><b>Q:</b> 
When we delete an album are we also deleting all references to the photos 
that were in the now deleted album?
<br><b>A:</b>
When you delete an album, all the references to photos from that album will be 
deleted. But if a photo is in a different album as well, that album will still 
refer to the photo.

<p><b>Q:</b> 
Should the fields for JavaFX components in our classes need to be shown
in the UML diagram? 
<br><b>A:</b>
No, you don't need to include FX fields. 

<p><b>Q:</b> 
Should we include FX controller classes in the UML?
<br><b>A:</b>
Yes, because they contain logic that verifies user input, and to communicate data
to the non-UI logic in the app.

<p><b>Q:</b> 
Should stock be auto-generated every time the program is run, in case admin deletes
the "stock" user?
<br><b>A:</b>
No, you don't need to have functionality to recreate stock if deleted.

</body></html>
