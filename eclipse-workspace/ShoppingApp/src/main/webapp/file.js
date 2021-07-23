function addInsertDataCol(value) {
	var dataTh = document.getElementById('data');
	var righeTab = document.getElementsByClassName('riga');  //prende tutte le righe della tabella
	var righeData = document.getElementsByClassName('data');  //prende tutte le righe di data
	var saldi = document.getElementsByClassName('saldo');  //prende tutte le righe dei saldi
	var indice = value.getAttribute('id');   //prende l'id della select effettuata che corrisponde alla riga
	var valueSN = value.value;  // prende il value= S o N
	if (undefined != valueSN && null != valueSN && valueSN == 'S') {
		var rigaDataDaMostrareId = righeData[indice];
		rigaDataDaMostrareId.style.display = 'table-cell';
		dataTh.style.display = 'table-cell';
	} else if (undefined != valueSN && null != valueSN && valueSN == 'N') {
		var rigaDataDaMostrareId = righeData[indice];
		rigaDataDaMostrareId.style.display = 'none';
		dataTh.style.display = 'none';

	}
}
//	var righeTab = document.getElementsByClassName('riga');
//	var righeData = document.getElementsByClassName('data');
//	var dataTh = document.getElementById('data');
//	var contatoreN = 0;
//	var contatoreS = 0;
//	for (var i = 0; i < righeTab.length; i++) {
//
//		var rigaAttuale = righeTab[i];
//		var rigaDataAttuale = righeData[i];
//        var saldo= rigaAttuale.cells[5];
//         
//		if (undefined != saldo && null != saldo && saldo.lastChild.value == 'N') {
//			rigaDataAttuale.style.display = 'none';
//			dataTh.style.display = 'none';
//			contatoreN++;
//		} else if (undefined != saldo && null != saldo && saldo.lastChild.value == 'S') {
//			rigaDataAttuale.style.display = 'table-cell';
//			dataTh.style.display = 'table-cell';
//			contatoreS++;
////		}
//	}
//
//	if (contatoreN == righeTab.length) {
//		var righeData = document.getElementsByClassName('data');
//		for (var ii = 0; ii < righeData.length; ii++) {
//			var rigaDataAttuale = righeData[ii];
//			rigaDataAttuale.style.display = 'none';
//		}
//	} else if (contatoreS == righeTab.length) {
//		var righeData = document.getElementsByClassName('data');
//		for (var ii = 0; ii < righeData.length; ii++) {
//			var rigaDataAttuale = righeData[ii];
//			rigaDataAttuale.style.display = 'table-cell';
//		}
//
//	}}



//function addDataColumn(value) {
//	var saldo = document.getElementById("saldo").value;
//	if (saldo == "S") {
//		$('.data').each(function() {
//			this.style.display = "table-cell"
//		});
//	} else if (saldo == "N") {
//		$('.data').each(function() {
//			this.style.display = "none"
//		});
//	}
//}
// function that calculates new spesa on quantity change
$(document).ready(function() {
	$('.quantity').on('change, keyup', function() {
		var val = $(this).text();

		if (val == '' || isNaN(val) || val < 1) {
			return;
		}

		var tbvalue = $(this).prev().text();

		var result = parseInt(tbvalue) * parseInt(val);

		$(this).next().text(formatString(result));

	});
});
// function that calculates new spesa on price change
$(document).ready(function() {
	$('.price').on('change, keyup', function() {
		var val = $(this).text();
		formatString(val);
		var tbvalue = $(this).next().text();

		var result = parseInt(tbvalue) * parseInt(val);

		$(this).next().next().text(formatString(result));

	});
});

// funzione che formatta i numeri
function formatString(intero) {
	var spesa = "" + intero;
	var arr = spesa.split(".");
	var str = "";
	for (var i = arr[0].length; i > 0; i = i - 3) {
		if (i > 3) {
			str = "." + arr[0].slice(i - 3, i) + str;
		} else {
			str = arr[0].slice(0, i) + str;
		}
	}
	if (arr.length > 1) {
		if (arr[1].length == 1) {
			str = str + "," + arr[1] + "0";
		} else if (arr[1].length > 2) {
			str = str + "," + arr[1].slice(0, 2);
		} else {
			str = str + "," + arr[1];
		}
	} else {
		str += ",00";
	}
	return str;
}