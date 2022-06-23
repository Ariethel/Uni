$(document).ready(function() {
	
	// Add an event that triggers when the submit
	// button is pressed.
    $("#submit-band-info").click(function() {
    	
    	// Get the text from the two inputs.
    	var bandName = $("#band-name-input").val();
    	var albumName = $("#album-input").val();
    	
    	// Fail if one of the two inputs is empty, as we need
    	// both a band name and albums to make an insertion.
    	if (bandName === "" || albumName === "") {
    		alert("Not enough information for an insertion!");
    		return;
    	}
    	
    	// Ajax POST request, similar to the GET request.
    	$.post('DBInsertionServlet',{"bandName": bandName, "albumName": albumName},
                function() { // on success
                    alert("Insertion successful!");
                })
                .fail(function() { //on failure
                    alert("Insertion failed.");
                });
    });  
});