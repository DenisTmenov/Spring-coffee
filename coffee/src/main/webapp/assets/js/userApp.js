$(function() {
	switch (menu) {
	case 'Home':
		$('#home').addClass('active');
		break;
	case 'About':
		$('#about').addClass('active');
		break;
	case 'Contacts':
		$('#contacts').addClass('active');
		break;
	case 'Services':
		$('#services').addClass('active');
		break;
	case 'All Products':
		$('#allProducts').addClass('active');
		break;

	default:
		
		$('#allProducts').addClass('active');
		$('#a_' + menu).addClass('active');
		break;
	}
	
	
	// code for jquery dataTable
	var $table = $('#productListTable');
	
	// execute the below code only where we have this table
	if($table.length){
				
		var jsonUrl = '';
		
		if(window.categoryId == ''){
			jsonUrl = window.contextRoot + '/json/data/all/products';
		}
		else {
			jsonUrl = window.contextRoot + '/json/data/category/' + window.categoryId + '/products';
		}
		
		
		
		
		$table.DataTable({
			lengthMenu: [[3,5,10,-1], ['3 Records', '5 Records', '10 Records', 'ALL']],
			pageLength: 5,
			ajax: {
				url: jsonUrl,
				dataSrc: ''
			},
			columns:[
				
				{
					data: 'code',
					mRender: function(data, type, row){
						return '<img src="' + window.contextRoot + '/resources/images/' + data + '.jpg" class="dataTableImages"/>'
					}
				},
				{
					data: 'name'
					
				}, 
				{
					data: 'brand'
					
				},
				{
					data: 'unitPrice',
					mRender: function(data, type, row){
						return '&euro; ' + data
					}
					
				},
				{
					data: 'quantity'
					
				},
				{
					data: 'id',
					mRender: function(data, type, row){
						
						var str = '';
						
						str += '<a href= "' + window.contextRoot + '/show/' + data+ '/product" class="btn btn-primary"><span class="fa fa-eye "></span></a>';
						str += '<a href= "' + window.contextRoot + '/cart/add/' + data+ '/product" class=btn btn-success"><span class="fa fa-cart-plus fa-2x "></span></a>';
						
						return str;
					}
				}
			]
		})
		
	}
	
	
	
	
});