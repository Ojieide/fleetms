
$('document').ready(function() {	
	$('.table #editBtn').on('click',function(event){		
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(carhire){
			$('#idEdit').val(carhire.id);
			$('#clientEdit').val(carhire.clientid);			
			$('#dateinEdit').val(carhire.dateIn.substr(0,10));
			$('#dateoutEdit').val(carhire.dateOut.substr(0,10));
			$('#timeinEdit').val(carhire.timeIn);
			$('#timeoutEdit').val(carhire.timeOut);
			$('#locationEdit').val(carhire.locationid);
			$('#priceEdit').val(carhire.price);
			$('#remarksEdit').val(carhire.remarks);
			$('#carEdit').val(carhire.carid);			
		});			
		$('#editModal').modal();		
	});
	
	$('.table #detailsBtn').on('click',function(event) {
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(carhire){
			$('#idDetails').val(carhire.id);
			$('#clientDetails').val(carhire.clientid);			
			$('#dateinDetails').val(carhire.dateIn.substr(0,10));
			$('#dateoutDetails').val(carhire.dateOut.substr(0,10));
			$('#timeinDetails').val(carhire.timeIn);
			$('#timeoutDetails').val(carhire.timeOut);
			$('#locationDetails').val(carhire.locationid);
			$('#priceDetails').val(carhire.price);
			$('#remarksDetails').val(carhire.remarks);
			$('#carDetails').val(carhire.carid);
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