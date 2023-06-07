function addcart(id) {



	var qty = document.getElementById("qtyProduct").value;

	var sizeIds = document.getElementsByName("size");
	var sizeId;
	for (var i = 0; i < sizeIds.length; i++) {
		if (sizeIds[i].checked) {
			sizeId = sizeIds[i].value;

		}

	}

	var host = window.location.host;
	var url = "http://"+host+"/com.tulamweb/homeaddcart?productId=" + id + "&qty=" + qty + "&sizeId=" + sizeId;
	var request = new XMLHttpRequest();

	request.onreadystatechange = function() {
		if (this.readyState === 4 && this.status === 200) {

			var objcategory = JSON.parse(request.response).carts;

			var objc = JSON.parse(objcategory);

			var html = '<table class="table table-bordered text-center mb-0">';
			html += '<thead class="bg-secondary text-dark">< tr ><th>Products</th><th>Price</th><th>Quantity</th>	<th>Total</th><th>Remove</th></tr ></thead > ';
			html += '<tbody class="align-middle">';

			if (objc) {
				var count = 0;
				for (var i = 0; i < objc.length; i++) {

					html += "<tr>";
					html += " <td>" + objc[i].productName + "</td>";
					html += " <td>" + objc[i].price + "</td>";
					html += " <td>" + objc[i].qty + "</td>";
					html += " <td>" + objc[i].total + "</td>";
					html += " <td>" + "</td>";

					html += "</tr>";
					count++;
				}

				html += "</tbody></table>";
				document.getElementById("gentable").innerHTML = html;
			}


			

		}
	};

	request.open("GET", url, true);
	request.send();
}