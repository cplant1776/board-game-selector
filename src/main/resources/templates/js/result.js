searchResultsList = [
  {"title": "TITLE 1", "desc": "DESC 1", "rating": "RATING 1", "votes": "VOTES 1"},
  {"title": "TITLE 2", "desc": "DESC 2", "rating": "RATING 2", "votes": "VOTES 2"},
  {"title": "TITLE 3", "desc": "DESC 3", "rating": "RATING 3", "votes": "VOTES 3"},
  {"title": "TITLE 4", "desc": "DESC 4", "rating": "RATING 4", "votes": "VOTES 4"},
  {"title": "TITLE 5", "desc": "DESC 5", "rating": "RATING 5", "votes": "VOTES 5"},
]


// Grab the template script
var theTemplateScript = $("#result-template").html();

// Compile the template
var theTemplate = Handlebars.compile(theTemplateScript);


searchResultsList.forEach(function(ph) {
  console.log(ph);
  var context={
    "title": ph["title"],
    "description": ph["desc"],
    "rating": ph["rating"],
    "votes": ph["votes"]
  };

    // Pass our data to the template
    var theCompiledHtml = theTemplate(context);


    // Add the compiled html to the page
    $('#search-results-table').append(theCompiledHtml);
});