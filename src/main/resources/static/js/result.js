function selectGame(id) {
   document.location.href = "/game/" + id;
};

function reloadSorted(obj) {
   // Remove current sort param from url if present
   currentUrl = stripCurrentSort(window.location.href);

   window.location.href = currentUrl + "&sort=" + obj.value;
};

function stripCurrentSort(currentUrl) {

   if (currentUrl.endsWith("&")) {
      return currentUrl.slice(0, -1)
   }
   else {
      const regex = /&sort=.*/gm;
      let m;
   
      while ((m = regex.exec(currentUrl)) !== null) {
         // This is necessary to avoid infinite loops with zero-width matches
         if (m.index === regex.lastIndex) {
            regex.lastIndex++;
         }
         
         // The result can be accessed through the `m`-variable.
         m.forEach((match, groupIndex) => {
            console.log(`Found match, group ${groupIndex}: ${match}`);
         });
         result = currentUrl.replace(m[0], "");
      }
      return result;
   }

}