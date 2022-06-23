<%@ page language="java"
    contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
	    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	    <title>Ajax - Servlets Integration Example</title>
	    
	    <!-- Load the scripts needed for the application. -->
	    <script type="text/javascript" src="resources/jquery-2.1.1.min.js"></script>
	    <script type="text/javascript" src="resources/buttonEventsInit.js"></script>
	    <script type="text/javascript" src="resources/resultsPrinter.js"></script>
	    <script type="text/javascript" src="resources/insertBandInfo.js"></script>
	</head>
	
	<body>
	    <h1>Ajax - Servlets Integration Example</h1>
	    <p>This is an example of how to use Ajax with a servlet backend.</p></br>
	    
	    <h3>Select a button to get the relevant information.</h3>
	    
	    <!-- Buttons that will call the servlet to retrieve the information. -->
	    <button id="bands" type="button">Show bands!</button>
	    <button id="bands-albums" type="button">Show bands and albums!</button>
	    
	    <!-- We need to have some empty divs in order to add the retrieved information to them. -->
	    <div id="band-results"></div></br></br>
	    <div id="bands-albums-results"></div></br></br>
	    
	    
	    <h3>Add the band information and press submit!</h3>
	    <h4>Band name: </h4><input type="text" id="band-name-input" value=""><br>
        <h4>Albums: </h4><input type="text" id="album-input" value="">(Separated by commas)<br>
        <input type="submit" id="submit-band-info" value="Submit">
	</body>
</html>