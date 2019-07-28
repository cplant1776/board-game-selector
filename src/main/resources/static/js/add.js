function fillSelectOptionsWithNumberRange(id, start, stop) {
	var select = $("#" + id).select();
	for (var i=start; i <= stop; i++) {
		select.append("<option>" + i + "</option>");
	}
}

fillSelectOptionsWithNumberRange("min-players", 1, 200)
fillSelectOptionsWithNumberRange("max-players", 1, 200)
fillSelectOptionsWithNumberRange("age", 1, 100)


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