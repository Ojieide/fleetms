
$('document').ready(function() {
	
	$('.table .btn-primary').on('click',function(event){		
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(carmovement){
			$('#idEdit').val(carmovement.id);
			$('#carEdit').val(carmovement.carid);
			$('#location1Edit').val(carmovement.locationid1);
			$('#location2Edit').val(carmovement.locationid2);
			$('#date1Edit').val(carmovement.date1.substr(0,10));
			$('#date2Edit').val(carmovement.date2.substr(0,10));
			$('#remarksEdit').val(carmovement.remarks);
		});			
		$('#editModal').modal();		
	});
	
	$('.table #detailsBtn').on('click',function(event) {
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(carmovement){
			$('#idDetails').val(carmovement.id);
			$('#carDetails').val(carmovement.carid);
			$('#location1Details').val(carmovement.locationid1);
			$('#location2Details').val(carmovement.locationid2);
			$('#date1Details').val(carmovement.date1.substr(0,10));
			$('#date2Details').val(carmovement.date2.substr(0,10));
			$('#remarksDetails').val(carmovement.remarks);
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