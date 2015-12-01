var campuses = new Bloodhound({
	datumTokenizer: Bloodhound.tokenizers.obj.whitespace('name'),
	queryTokenizer: Bloodhound.tokenizers.whitespace,
	prefetch: 'api/campuses',
	identify: function(obj) {
		return obj.id;
	}
});

$('input[type="search"]').typeahead({
	minLength: 0,
	hint: true,
	highlight: true
}, {
	name: 'campuses',
	display: 'name',
	source: campuses
}).bind('typeahead:select', function() {
	$('.form-inline').submit();
});
