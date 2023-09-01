
$('document').ready(function(){
	$('.table #editBtn').on('click',function(event){
		event.preventDefault();	
		var href= $(this).attr('href');	
		$.get(href, function(country){
			$('#idEdit').val(country.id);
			$('#nameEdit').val(country.name.replace(/,/g, ''));
			$('#capitalEdit').val(country.capital.replace(/,/g, ''));
			$('#codeEdit').val(country.code.replace(/,/g, ''));
			$('#continentEdit').val(country.continent.replace(/,/g, ''));
			$('#nationalityEdit').val(country.nationality.replace(/,/g, ''))
		});
		$('#editModal').modal();
	});
});