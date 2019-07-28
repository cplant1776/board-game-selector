function fillSelectOptionsWithNumberRange(id, selected, start, stop) {
  // Select dropdown menu
  var select = $("#" + id).select();
  // Fill it in with numbers
	for (var i=start; i <= stop; i++) {
		select.append("<option>" + i + "</option>");
  }
  // Set default to game's value
  select.val(selected);
};


$(document).ready(function() {
  window.fillSelectOptionsWithNumberRange("min-players", minPlayers, 1, 200)
  window.fillSelectOptionsWithNumberRange("max-players", maxPlayers, 1, 200)
  window.fillSelectOptionsWithNumberRange("age", minAge, 1, 18)
});



// Form valdation
(function() {
  'use strict';
  window.addEventListener('load', function() {
    // Fetch all the forms we want to apply custom Bootstrap validation styles to
    var forms = document.getElementsByClassName('needs-validation');
    // Loop over them and prevent submission
    var validation = Array.prototype.filter.call(forms, function(form) {
      form.addEventListener('submit', function(event) {
        if (form.checkValidity() === false) {
          event.preventDefault();
          event.stopPropagation();
        }
        form.classList.add('was-validated');
      }, false);
    });
  }, false);
})();