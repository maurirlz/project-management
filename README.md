# Project management application
<p>This is a repo of my first project with spring framework and real use of postgreSQL database</p>
<p>It's intended to be a management tool for administrators where admins can have the possibility of 
assigning either projects to new employees, creating new employees and creating new projects.</p>


<p>I tried to research and utilize most of spring most used features like: AOP, Security
configuration's profiles when also utilizing my knowledge of html/css/js to implement a simple page.</p>

<h2>Features:</h2>
<ul>
    <li>Registering via Spring Security</li>
    <li>Roles/Authorities in the page (You can't create projects/employees unless marked as an admin</li>
    <li>Pie chart graph that shows a summarize of all the project's statuses. (Powered by Chart.js)</li>
    <li>CSRF protection</li>
    <li>PosgreSQL integration</li>
    <li>Logging (Springframework level = INFO, Unit/Controller level: DEBUG) (thanks to AOP with aspectj)</li>
    <li>Testing profile with H2-Console</li>
</ul>