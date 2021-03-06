function rechercherComptes(){
	console.log("rechercherComptes");
	var zoneNumClient = document.getElementById("numClient");
	var numClient = zoneNumClient.value;
	var url ="./rest/api-bank/compte" ;
	if(numClient != "")
	   url = "./rest/api-bank/compte?numClient=" + numClient;
    makeAjaxGetRequest(url , callbackListeCompte);
}


function virement(){
	var zoneMontant = document.getElementById("montant");
	var montant = zoneMontant.value;
	var zoneNumCptDeb = document.getElementById("numCptDeb");
	var numCptDeb = zoneNumCptDeb.value;
	var zoneNumCptCred = document.getElementById("numCptCred");
	var numCptCred = zoneNumCptCred.value;
	var demandeVirement = {
		montant : montant,
		numCptDeb : numCptDeb,
		numCptCred : numCptCred
	}
	var url ="./rest/api-bank/compte" ;
	makeAjaxPostRequest(url , JSON.stringify(demandeVirement),
	                    callbackSuccess , callbackError);
}

function callbackSuccess(){
	var zoneMessage = document.getElementById("message");
	zoneMessage.innerHTML="virement bien effectu&eacute;";
	rechercherComptes();
}

function callbackError(){
	var zoneMessage = document.getElementById("message");
	zoneMessage.innerHTML="virement pas bien effectu&eacute; (erreur)";
}

//function qui sera appelée automatiquement quand la réponse revient
function callbackListeCompte(data){
	console.log("data (reponse)="+data);
	var listeComptes = JSON.parse(data);  //conversion de JSON vers objet javascript
	
	var zoneTBody = document.getElementById("tbody");
	zoneTBody.innerHTML=""; //vider le tableau avant de le re-remplir
	
	for(let i=0;i<listeComptes.length;i++){
		var compte = listeComptes[i];
		
		var tr = document.createElement("tr");
		zoneTBody.appendChild(tr);
		tr.innerHTML="<td>"+compte.numero+"</td><td>" 
		                   + compte.label + "</td><td>"
                           +compte.solde+"</td>";
	}
}