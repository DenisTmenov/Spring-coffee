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
});