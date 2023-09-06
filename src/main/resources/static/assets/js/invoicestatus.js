$('document').ready(function() {
	
	$('.table .btn-primary').on('click',function(event){		
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(invoicestatus){
			$('#idEdit').val(invoicestatus.id);
			$('#descriptionEdit').val(invoicestatus.description);
			$('#detailsEdit').val(invoicestatus.details);
		});			
		$('#editModal').modal();		
	});
	
	$('.table #detailsBtn').on('click',function(event) {
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(invoicestatus){
			$('#idDetails').val(invoicestatus.id);	
			$('#descriptionDetails').val(invoicestatus.description);
			$('#detailsDetails').val(invoicestatus.details);
			$('#updatedbyDetails').val(invoicestatus.updatedby);
			//$('#updateddateDetails').val(invoicestatus.updateddate.substr(0,19).replace("T", " "));
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