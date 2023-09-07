
$('document').ready(function(){
	$('.table #editBtn').on('click',function(event){
		event.preventDefault();	
		var href= $(this).attr('href');	
		$.get(href, function(invoice){
			$('#idEdit').val(invoice.id);
			$('#clientEdit').val(invoice.clientid);		
			$('#invoiceDateEdit').val(invoice.invoiceDate.substr(0,10));
			$('#invoiceStatusEdit').val(invoice.invoicestatusid);
			$('#remarksEdit').val(invoice.remarks);
		});
		$('#editModal').modal();
	});
	
	$('.table #detailsBtn').on('click',function(event){
		event.preventDefault();	
		var href= $(this).attr('href');	
		$.get(href, function(invoice){
			$('#idDetails').val(invoice.id);
			$('#clientDetails').val(invoice.clientid);	
			$('#invoiceDateDetails').val(invoice.invoiceDate.substr(0,10));
			$('#invoiceStatusDetails').val(invoice.invoicestatusid);
			$('#remarksDetails').val(invoice.remarks);
		});
		$('#detailsModal').modal();
	});
	
	$('.table #deleteBtn').on('click',function(event){
		event.preventDefault();
		var href= $(this).attr('href');
		$('#confirmDeleteBtn').attr('href', href);
		$('#deleteModal').modal();
	});
});