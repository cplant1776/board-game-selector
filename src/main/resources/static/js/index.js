function formatBlogBody(str) {
	// Remove html tags
	var regExString = /(<([^>]+)>)/ig; //create reg ex and let it loop (g)
	contentString = str // get text from node (no longer an object but string.

	contentString = contentString.replace(regExString, "") //find all tags and delete them.

	// Truncate body
	if (contentString.length > 165)
		contentString = contentString.substring(0, 165);
	contentString += "..."

	return contentString;
};

$(document).ready(function() {


	const url = 'https://boardgamegeek.com/rss/blog/1'
	const year = new Date().getFullYear();
		feednami.load(url)
		.then(feed => {
			const limit = 3;
			var counter = 0;
			for(let entry of feed.entries){
				if (counter == limit)
					break;
				// console.log(entry.title);
				$('#blog-title-' + counter).html(entry.title);
				//   console.log(entry.author);
				var formattedDate = (entry['rss:pubdate']['#'].split(year)[0] + year).substring(4);
				$('#blog-info-' + counter).html(entry.author + ' - ' + formattedDate)
				//   console.log(entry.link);
				$('#blog-link-' + counter).attr("href", entry.link);
				$('#blog-title-link-' + counter).attr("href", entry.link);	
				$('#blog-body-' + counter).text(formatBlogBody(entry.description));			
				console.log(feed)
				counter++;
			}
		})
    
 });
 

