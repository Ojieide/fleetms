$('document').ready(function() {
	
	$('.table .btn-primary').on('click',function(event){		
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(role){
			$('#idEdit').val(role.id);
			$('#descriptionEdit').val(role.description);
			$('#detailsEdit').val(role.details);
		});			
		$('#editModal').modal();		
	});
	
	$('.table #detailsBtn').on('click',function(event) {
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(role){
			$('#idDetails').val(role.id);	
			$('#descriptionDetails').val(role.description);
			$('#detailsDetails').val(role.details);
			$('#updatedbyDetails').val(role.updatedby);
			//$('#updateddateDetails').val(role.updateddate.substr(0,19).replace("T", " "));
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