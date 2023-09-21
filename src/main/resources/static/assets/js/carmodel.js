$('document').ready(function() {
	
	$('.table .btn-primary').on('click',function(event){		
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(carmodel){
			$('#idEdit').val(carmodel.id);
			$('#descriptionEdit').val(carmodel.description);
			$('#detailsEdit').val(carmodel.details);
		});			
		$('#editModal').modal();		
	});
	
	$('.table #detailsBtn').on('click',function(event) {
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(carmodel){
			$('#idDetails').val(carmodel.id);	
			$('#descriptionDetails').val(carmodel.description);
			$('#detailsDetails').val(carmodel.details);
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