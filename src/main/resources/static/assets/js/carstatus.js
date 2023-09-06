$('document').ready(function() {
	
	$('.table .btn-primary').on('click',function(event){		
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(carstatus){
			$('#idEdit').val(carstatus.id);
			$('#descriptionEdit').val(carstatus.description);
			$('#detailsEdit').val(carstatus.details);
		});			
		$('#editModal').modal();		
	});
	
	$('.table #detailsBtn').on('click',function(event) {
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(carstatus){
			$('#idDetails').val(carstatus.id);	
			$('#descriptionDetails').val(carstatus.description);
			$('#detailsDetails').val(carstatus.details);
			$('#updatedbyDetails').val(carstatus.updatedby);
			//$('#updateddateDetails').val(carstatus.updateddate.substr(0,19).replace("T", " "));
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