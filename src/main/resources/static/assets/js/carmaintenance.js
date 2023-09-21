$('document').ready(function() {
	
	$('.table .btn-primary').on('click',function(event){		
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(carmaintenance){
			$('#idEdit').val(carmaintenance.id);
			$('#carEdit').val(carmaintenance.carid);
			$('#startDateEdit').val(carmaintenance.startDate.substr(0,10));
			$('#remarksEdit').val(carmaintenance.remarks);
			$('#endDateEdit').val(carmaintenance.endDate.substr(0,10));
			$('#supplierEdit').val(carmaintenance.supplierid);
			$('#priceEdit').val(carmaintenance.price);
		});			
		$('#editModal').modal();		
	});
	
	$('.table #detailsBtn').on('click',function(event) {
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(carmaintenance){
			$('#idDetails').val(carmaintenance.id);
			$('#carDetails').val(carmaintenance.carid);
			$('#startDateDetails').val(carmaintenance.startDate.substr(0,10));
			$('#remarksDetails').val(carmaintenance.remarks);
			$('#endDateDetails').val(carmaintenance.endDate.substr(0,10));
			$('#supplierDetails').val(carmaintenance.supplierid);
			$('#priceDetails').val(carmaintenance.price);
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