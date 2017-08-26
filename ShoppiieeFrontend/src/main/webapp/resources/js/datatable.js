$(document).ready( function () {
	 var table = $('#categoryTable').DataTable({
			"sAjaxSource": "categorys",
			"sAjaxDataProp": "",
			"order": [[ 0, "asc" ]],
			"aoColumns": [
			    { "mData": "categoryId"},
		      { "mData": "categoryName" }
				  
			]
	 })
});


$(document).ready( function () {
	 var table = $('#supplierTable').DataTable({
			"sAjaxSource": "suppliers",
			"sAjaxDataProp": "",
			"order": [[ 0, "asc" ]],
			"aoColumns": [
			    { "mData": "supplierId"},
		      { "mData": "supplierName" }
				  
			]
	 })
});