
$('document').ready(function() {
	
	$('.table .btn-primary').on('click',function(event){		
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(supplier){
			$('#idEdit').val(supplier.id);
			$('#nameEdit').val(supplier.name);
			$('#websiteEdit').val(supplier.website);
			$('#addressEdit').val(supplier.address);
			$('#stateEdit').val(supplier.stateid);
			$('#countryEdit').val(supplier.countryid);
			$('#cityEdit').val(supplier.city);
			$('#phoneEdit').val(supplier.phone);	
			$('#mobileEdit').val(supplier.mobile);			
			$('#emailEdit').val(supplier.email);	
		});			
		$('#editModal').modal();		
	});
	
	$('.table #detailsBtn').on('click',function(event) {
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(supplier){
			$('#idDetails').val(supplier.id);
			$('#nameDetails').val(supplier.name);
			$('#websiteDetails').val(supplier.website);
			$('#addressDetails').val(supplier.address);
			$('#stateDetails').val(supplier.stateid);
			$('#countryDetails').val(supplier.countryid);
			$('#cityDetails').val(supplier.city);
			$('#phoneDetails').val(supplier.phone);	
			$('#mobileDetails').val(supplier.mobile);			
			$('#emailDetails').val(supplier.email);
			$('#updatedbyDetails').val(supplier.updatedby);
			$('#updateddateDetails').val(supplier.updateddate.substr(0,19).replace("T", " "));
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