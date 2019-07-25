var placeHolderDescription = "<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. At auctor urna nunc id cursus. Ac ut consequat semper viverra nam libero. Bibendum neque egestas congue quisque. Adipiscing at in tellus integer feugiat. Enim sed faucibus turpis in eu mi. Habitant morbi tristique senectus et netus. In est ante in nibh mauris cursus mattis molestie a. Et ligula ullamcorper malesuada proin libero nunc. Volutpat sed cras ornare arcu dui vivamus arcu. Duis convallis convallis tellus id interdum velit laoreet. In egestas erat imperdiet sed euismod nisi porta. Natoque penatibus et magnis dis parturient montes nascetur ridiculus mus. Nunc sed id semper risus in hendrerit gravida rutrum quisque. Bibendum arcu vitae elementum curabitur vitae nunc. In tellus integer feugiat scelerisque varius morbi enim nunc faucibus. Eros in cursus turpis massa tincidunt dui. Aliquam id diam maecenas ultricies mi eget mauris.</p><p>Iaculis nunc sed augue lacus viverra vitae. Pharetra sit amet aliquam id diam maecenas ultricies mi eget. Et netus et malesuada fames ac turpis egestas integer eget. Venenatis tellus in metus vulputate eu scelerisque. Aenean euismod elementum nisi quis. Nec ullamcorper sit amet risus. Bibendum at varius vel pharetra vel turpis nunc eget. Pulvinar etiam non quam lacus suspendisse faucibus interdum. Faucibus scelerisque eleifend donec pretium vulputate sapien nec sagittis. Et tortor consequat id porta nibh venenatis cras sed. Phasellus egestas tellus rutrum tellus pellentesque eu tincidunt. Pretium viverra suspendisse potenti nullam ac. Imperdiet dui accumsan sit amet nulla facilisi morbi tempus iaculis.</p>"

gameData = {
    "title": "TITLE",
    "rank": "RANK",
    "numOfPlayersMin": "000",
    "numOfPlayersMax": "999",
    "playtimeAvg": "9999",
    "age": "99",
    "designer": "JOSH VLAD BROWN",
    "publisher": "PUBLISHER GUY INC",
    "bggURL": "www.whatisaurl.com/12345",
    "desc": placeHolderDescription
          };
  
  
// ============================================
//  METADATA ROW TEMPLATE
// ============================================
// Grab the template script
var theTemplateScript = $("#metadata-row-template").html();
// Compile the template
var theTemplate = Handlebars.compile(theTemplateScript);
var context={
    "title": gameData["title"],
    "rank": gameData["rank"],
    "numOfPlayersMin": gameData["numOfPlayersMin"],
    "numOfPlayersMax": gameData["numOfPlayersMax"],
    "playtimeAvg": gameData["playtimeAvg"],
    "age": gameData["age"],
    "designer": gameData["designer"],
    "publisher": gameData["publisher"],
    "bggURL": gameData["bggURL"],
}
// Pass our data to the template
var theCompiledHtml = theTemplate(context);
// Add the compiled html to the page
$('#game-metadata-placeholder').html(theCompiledHtml);


// ============================================
//  DESCRIPTION ROW TEMPLATE
// ============================================
// Grab the template script
var theTemplateScript = $("#description-row-template").html();
// Compile the template
var theTemplate = Handlebars.compile(theTemplateScript);
var context={
    "description": gameData["desc"],
}
// Pass our data to the template
var theCompiledHtml = theTemplate(context);
// Add the compiled html to the page
$('#game-description-placeholder').html(theCompiledHtml);



// ============================================
//  COMMENT TEMPLATE
// ============================================

aComment = {
  "imgURL": "assets/img/placeholder_sm.jpg",
  "title": "COMMENT TITLE HERE",
  "body": '<p>Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin. Cras purusodio, vestibulum in vulputate at, tempus viverra turpis. Fusce condimentum nunc ac nisi vulputatefringilla. Donec lacinia congue felis in faucibus.</p><p class="mb-0">Donec sed odio dui. Nullam quis risus eget urna mollis ornare vel eu leo. Cum sociis natoquepenatibus et magnis dis parturient montes, nascetur ridiculus mus.</p>'
  };

commentList = [aComment]

// Grab the template script
var theTemplateScript = $("#comment-template").html();
// Compile the template
var theTemplate = Handlebars.compile(theTemplateScript);

commentList.forEach(function(comment) {
  console.log(comment);

  var context={
    "imgURL": comment["imgURL"],
    "title": comment["title"],
    "body": comment["body"]
  };

    // Pass our data to the template
    var theCompiledHtml = theTemplate(context);
    // Add the compiled html to the page
    $('#comment-row').append(theCompiledHtml);
});
