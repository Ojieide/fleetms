$('document').ready(function() {
	
	$('.table .btn-primary').on('click',function(event){		
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(state){
			$('#idEdit').val(state.id);
			$('#countryEdit').val(state.countryid);
			$('#capitalEdit').val(state.capital);
			$('#codeEdit').val(state.code);
			$('#nameEdit').val(state.name);
			$('#detailsEdit').val(state.details);
		});			
		$('#editModal').modal();		
	});
	
	$('.table #detailsBtn').on('click',function(event) {
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(state){
			$('#idDetails').val(state.id);
			$('#countryDetails').val(state.countryid);
			$('#capitalDetails').val(state.capital);
			$('#codeDetails').val(state.code);		
			$('#nameDetails').val(state.name);
			$('#detailsDetails').val(state.details);
			$('#updatedbyDetails').val(state.updatedby);
			//$('#updateddateDetails').val(state.updateddate.substr(0,19).replace("T", " "));
		});			
		$('#detailsModal').modal();		
	});	
	
	$('.table #deleteBtn').on('click',function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$('#deleteModal #confirmDeleteBtn').attr('href', href);
		$('#deleteModal').modal();		
	});	
});