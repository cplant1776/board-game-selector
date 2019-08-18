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


 2abd96f2cc1848eed78ebfc7329c34a227541d92 v1.0.0 [prototype]
 a6d87caebfc6ced3dfe2896e007c5ffdb837a94e v1.1.0 [restructured db tags]
 6f88df77c2f8c73772560c0ff52af19e6b7ff892 v1.1.1 [added mechanics/category filters]
 

