function fillSelectOptionsWithNumberRange(id, start, stop) {
	var select = $("#" + id).select();
	for (var i=start; i <= stop; i++) {
		select.append("<option>" + i + "</option>");
	}
}

fillSelectOptionsWithNumberRange("min-players", 1, 200)
fillSelectOptionsWithNumberRange("max-players", 1, 200)
fillSelectOptionsWithNumberRange("age", 1, 100)
