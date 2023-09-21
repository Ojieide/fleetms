$('document').ready(function() {
	
	$('.table .btn-primary').on('click',function(event){		
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(cartype){
			$('#idEdit').val(cartype.id);
			$('#descriptionEdit').val(cartype.description);
			$('#detailsEdit').val(cartype.details);
		});			
		$('#editModal').modal();		
	});
	
	$('.table #detailsBtn').on('click',function(event) {
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(cartype){
			$('#idDetails').val(cartype.id);	
			$('#descriptionDetails').val(cartype.description);
			$('#detailsDetails').val(cartype.details);
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