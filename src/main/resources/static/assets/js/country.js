
$('document').ready(function(){
	$('.table #editBtn').on('click',function(event){
		event.preventDefault();	
		var href= $(this).attr('href');	
		$.get(href, function(country){
			$('#idEdit').val(country.id);
			$('#nameEdit').val(country.name);
			$('#capitalEdit').val(country.capital);
			$('#codeEdit').val(country.code);
			$('#continentEdit').val(country.continent);
			$('#nationalityEdit').val(country.nationality);
		});
		$('#editModal').modal();
	});
	
	$('.table #deleteBtn').on('click',function(event){
		event.preventDefault();
		var href= $(this).attr('href');
		$('#confirmDeleteBtn').attr('href', href);
		$('#deleteModal').modal();
	});
});