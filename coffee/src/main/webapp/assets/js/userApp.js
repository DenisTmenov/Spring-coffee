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
	case 'Manage Product':
		$('#manageProduct').addClass('active');
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
					data: 'quantity',
					mRender:function(data, type, row){
						if(data < 1){
							return '<span style="color:red:>Out of Stock!';
						}
						
						return data;
					}
					
				},
				{
					data: 'id',
					mRender: function(data, type, row){
						
						var str = '';
						
						str += '<a href= "' + window.contextRoot + '/show/' + data+ '/product" class="btn btn-primary"><span class="fa fa-eye "></span></a> ';
						
						if(row.quantity < 1){
							str += '<a href= "javascript:void(0)" class="btn btn-danger disabled"><span class="fa fa-cart-plus "></span></a>';
						}
						else{
						str += '<a href= "' + window.contextRoot + '/cart/add/' + data+ '/product" class="btn btn-success"><span class="fa fa-cart-plus "></span></a>';
						}
						return str;
					}
				}
			]
		});
		
	}
	
	
	// close the alert after 3 seconds
	var $alert = $('.alert');
	
	if($alert.length){
		setTimeout(function() {
			$alert.fadeOut('slow');
		}, 3000)
	}

	
	
	// NOT WORK!!!!!!!!
	// function for admin table in manage page
	$('.switch input[type="checkbox"]').on('change', function(){
		var checkbox = $(this); // jQuery
		var checked = checkbox.prop('checked');
		var dMsg = (checked)? 'You want to activate the product?' : 'You want to deactivate the product?';
		var value = checkbox.prop('value');
		bootbox.confirm({
			size: 'medium',
			title: 'Product Activation & Deactivation',
			message: dMsg,
			callback: function(confirmed){
				if(confirmed){
					console.log(value);
					bootbox.alert({
						size: 'medium',
						title: 'Information',
						message: 'You are going to perform operation on product' + value
					});
				} else {
					checkbox.prop('checked', !checked);
				}
			}
			
		});
		
		
		
	});
	
	
	
});		
