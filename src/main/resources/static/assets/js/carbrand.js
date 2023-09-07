$('document').ready(function() {
	
	$('.table #submitBtn').on('click',function(event){		
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(carbrand){
			$('#idEdit').val(carbrand.id);
			$('#descriptionEdit').val(carbrand.description);
			$('#detailsEdit').val(carbrand.details);
		});			
		$('#editModal').modal();		
	});
	
	$('.table #detailsBtn').on('click',function(event) {
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(carbrand){
			$('#idDetails').val(carbrand.id);	
			$('#descriptionDetails').val(carbrand.description);
			$('#detailsDetails').val(carbrand.details);
			$('#updatedbyDetails').val(carbrand.updatedby);
			//$('#updateddateDetails').val(carbrand.updateddate.substr(0,19).replace("T", " "));
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