function fillSelectOptionsWithNumberRange(id, selected, start, stop) {
  // Select dropdown menu
  var select = $("#" + id).select();
  // Fill it in with numbers
  for (var i = start; i <= stop; i++) {
    select.append("<option>" + i + "</option>");
  }
  // Set default to game's value
  select.val(selected);
};


$(document).ready(function () {
  // Populate drop-down menus
  window.fillSelectOptionsWithNumberRange("min-players", minPlayers, 1, 200)
  window.fillSelectOptionsWithNumberRange("max-players", maxPlayers, 1, 200)
  window.fillSelectOptionsWithNumberRange("age", minAge, 1, 18)

  // Populate drop-down menus
  // Generate category checkboxes
  var addedCategoriesRow = '';
  for (var key in categoryDict) {
    var catName = categoryDict[key];
    addedCategoriesRow += '<div class="form-check form-check-inline"><input class="form-check-input" type="checkbox" id="' + catName + '" value="' + key + '"><label class="form-check-label modal-label" for="' + catName + '">' + catName + '</label></div>';
  }
  $('#categoryModalBody').html(addedCategoriesRow);

  // Generate mechanic checkboxes
  var addedMechanicsRow = '';
  for (var key in mechanicDict) {
    var mechName = mechanicDict[key];
    addedMechanicsRow += '<div class="form-check form-check-inline"><input class="form-check-input" type="checkbox" id="' + mechName + '" value="' + key + '"><label class="form-check-label modal-label" for="' + mechName + '">' + mechName + '</label></div>';
  }
  $('#mechanicModalBody').html(addedMechanicsRow);

  // Set DELETE request if delete button pressed
  $("#confirmDelete").click(function () {
    $('input[name="_method"]').attr('value', 'delete');
    $('form').submit();
  });

});





// Form valdation
(function () {
  'use strict';
  window.addEventListener('load', function () {
    // Fetch all the forms we want to apply custom Bootstrap validation styles to
    var forms = document.getElementsByClassName('needs-validation');
    // Loop over them and prevent submission
    var validation = Array.prototype.filter.call(forms, function (form) {
      form.addEventListener('submit', function (event) {
        if (form.checkValidity() === false) {
          event.preventDefault();
          event.stopPropagation();
        }
        form.classList.add('was-validated');
      }, false);
    });
  }, false);
})();