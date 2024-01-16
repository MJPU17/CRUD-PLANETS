let dataTable;
let dataTableIsInitialized=false;

const dataTableOptions={
	lengthMenu:[1,5,8],
	columnDefs:[
		{searchable: false, targets: [5]},
		{orderable:false,targets:[5]},
	],
	destroy:true,
	pageLength:8,
};

const initDataTable=()=>{
	if(dataTableIsInitialized){
		dataTable.destroy();
	}
	
	dataTable=$("#tablePlanet").DataTable(dataTableOptions);
	dataTableIsInitialized=true;
};

window.addEventListener("load",()=>{
	initDataTable();
});