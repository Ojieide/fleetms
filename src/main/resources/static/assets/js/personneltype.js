$('document').ready(function() {
	
	$('.table .btn-primary').on('click',function(event){		
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(personneltype){
			$('#idEdit').val(personneltype.id);
			$('#descriptionEdit').val(personneltype.description);
			$('#detailsEdit').val(personneltype.details);
		});			
		$('#editModal').modal();		
	});
	
	$('.table #detailsBtn').on('click',function(event) {
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(personneltype){
			$('#idDetails').val(personneltype.id);	
			$('#descriptionDetails').val(personneltype.description);
			$('#detailsDetails').val(personneltype.details);
			$('#updatedbyDetails').val(personneltype.updatedby);
			//$('#updateddateDetails').val(personneltype.updateddate.substr(0,19).replace("T", " "));
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