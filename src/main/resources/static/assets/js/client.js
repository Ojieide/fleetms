
$('document').ready(function() {
	
	$('.table .btn-primary').on('click',function(event){		
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(client){
			$('#idEdit').val(client.id);
			$('#nameEdit').val(client.name);
			$('#websiteEdit').val(client.website);
			$('#addressEdit').val(client.address);
			$('#stateEdit').val(client.stateid);
			$('#countryEdit').val(client.countryid);
			$('#cityEdit').val(client.city);
			$('#phoneEdit').val(client.phone);	
			$('#mobileEdit').val(client.mobile);			
			$('#emailEdit').val(client.email);	
		});			
		$('#editModal').modal();		
	});
	
	$('.table #detailsBtn').on('click',function(event) {
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(client){
			$('#idDetails').val(client.id);
			$('#nameDetails').val(client.name);
			$('#websiteDetails').val(client.website);
			$('#addressDetails').val(client.address);
			$('#stateDetails').val(client.stateid);
			$('#countryDetails').val(client.countryid);
			$('#cityDetails').val(client.city);
			$('#phoneDetails').val(client.phone);	
			$('#mobileDetails').val(client.mobile);			
			$('#emailDetails').val(client.email);
			$('#updatedbyDetails').val(client.updatedby);
			$('#updateddateDetails').val(client.updateddate.substr(0,19).replace("T", " "));
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